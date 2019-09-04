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
package io.webfolder.cdp.channel;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

import io.webfolder.cdp.session.MessageHandler;
import io.webfolder.cdp.session.SessionFactory;

@ClientEndpoint
public class StandardWebSocketListener extends Endpoint implements javax.websocket.MessageHandler.Partial<String> {

    private final SessionFactory factory;

    private final MessageHandler handler;

    private final StringBuilder buffer = new StringBuilder(0);

    public StandardWebSocketListener(SessionFactory factory, MessageHandler handler) {
        this.factory = factory;
        this.handler = handler;
    }

    @Override
    public void onMessage(String data, boolean last) {
        if (buffer.length() > 0 && last) {
            buffer.append(data);
            String message = buffer.toString();
            buffer.setLength(0);
            handler.process(message);
        } else if ( ! last ) {
            buffer.append(data);
        } else {
            handler.process(data.toString());
        }
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        factory.close();
        buffer.setLength(0);
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        // ignore
    }
}
