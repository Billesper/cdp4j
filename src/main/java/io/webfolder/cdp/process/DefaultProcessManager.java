/**
 * cdp4j Commercial License
 *
 * Copyright 2017, 2020 WebFolder OÜ
 *
 * Permission  is hereby  granted,  to "____" obtaining  a  copy of  this software  and
 * associated  documentation files  (the "Software"), to deal in  the Software  without
 * restriction, including without limitation  the rights  to use, copy, modify,  merge,
 * publish, distribute  and sublicense  of the Software,  and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  IMPLIED,
 * INCLUDING  BUT NOT  LIMITED  TO THE  WARRANTIES  OF  MERCHANTABILITY, FITNESS  FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL  THE AUTHORS  OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.webfolder.cdp.process;

import static java.lang.ProcessHandle.of;

import java.lang.ProcessHandle.Info;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class DefaultProcessManager implements ProcessManager {

    protected long pid;

    protected Instant startTime;

    protected String command;

    @Override
    public void setProcess(CdpProcess process) {
        ProcessHandle handle = ((Process) process.getProcess()).toHandle();
        Info info = handle.info();
        startTime = info.startInstant().get();
        command = info.command().get();
        pid = handle.pid();
    }

    @Override
    public boolean kill() {
        if (pid <= 0) {
            return false;
        }
        Optional<ProcessHandle> process = of(pid);
        if (process.isPresent()) {
            ProcessHandle handle = process.get();
            Info info = handle.info();
            if (handle.isAlive() &&
                    info.startInstant().isPresent() &&
                    info.startInstant().get().equals(startTime) &&
                    info.command().isPresent() &&
                    info.command().get().equals(command)) {
                try (Stream<ProcessHandle> descendants = handle.descendants()) {
                    descendants.forEach(ph -> {
                        try {
                            if (ph.isAlive()) {
                                ph.destroyForcibly();
                            }
                        } catch (Exception ignored) {
                            // no op
                        }
                    });
                }
                boolean success = handle.destroyForcibly();
                if (success) {
                    handle.onExit().join();
                }
                return success;
            }
        }
        return false;
    }
}
