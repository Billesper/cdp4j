/**
 * cdp4j Commercial License
 *
 * Copyright 2017, 2019 WebFolder OÜ
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
package io.webfolder.cdp.session;

import static java.net.URI.create;
import static java.net.http.HttpClient.newBuilder;
import static java.time.Duration.ofMillis;

import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;

class JreWebSocketChannelFactory implements ChannelFactory {

    private final SessionFactory factory;

    JreWebSocketChannelFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Channel createChannel(Connection connection, int connectionTimeout, MessageHandler handler) {
        CompletableFuture<WebSocket> future = newBuilder()
                                                .executor(factory.getWorkerThreadPool())
                                                .connectTimeout(ofMillis(connectionTimeout))
                                                .build()
                                                .newWebSocketBuilder()
                                                .buildAsync(create(((WebSocketConnection) connection).getWebSocketDebuggerUrl()),
                                                        new JreWebSocketMessageAdapter(factory, handler));
        return new JreWebSocketChannel(future);
    }
}
