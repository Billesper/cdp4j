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

import java.net.URI;
import java.net.URISyntaxException;

import io.webfolder.cdp.exception.CdpException;
import io.webfolder.cdp.session.MessageHandler;
import io.webfolder.cdp.session.SessionFactory;

public class TooTallNateWebSocketFactory implements ChannelFactory, AutoCloseable {

    private TooTallNateWebSocketListener webSocket;

    @Override
    public Channel createChannel(Connection connection, SessionFactory factory, MessageHandler handler) {
        if ( webSocket != null ) {
            throw new IllegalStateException();
        }
        String url = ((WebSocketConnection) connection).getUrl();
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new CdpException(e);
        }
        webSocket = new TooTallNateWebSocketListener(uri, factory, handler);
        TooTallNateWebSocketChannel channel = new TooTallNateWebSocketChannel(webSocket);
        return channel;
    }

    @Override
    public void close() {
        if ( webSocket != null && webSocket.isOpen() ) {
            webSocket.close();
        }
    }
}
