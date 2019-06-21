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
package io.webfolder.cdp.type.domsnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Table of details of an element in the DOM tree with a LayoutObject
 */
public class LayoutTreeSnapshot {
    private List<Integer> nodeIndex = new ArrayList<>();

    private List<Double> bounds = new ArrayList<>();

    private List<Integer> text = new ArrayList<>();

    private RareBooleanData stackingContexts;

    private List<Double> offsetRects = new ArrayList<>();

    private List<Double> scrollRects = new ArrayList<>();

    private List<Double> clientRects = new ArrayList<>();

    /**
     * Index of the corresponding node in the <code>NodeTreeSnapshot</code> array returned by <code>captureSnapshot</code>.
     */
    public List<Integer> getNodeIndex() {
        return nodeIndex;
    }

    /**
     * Index of the corresponding node in the <code>NodeTreeSnapshot</code> array returned by <code>captureSnapshot</code>.
     */
    public void setNodeIndex(List<Integer> nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    /**
     * The absolute position bounding box.
     */
    public List<Double> getBounds() {
        return bounds;
    }

    /**
     * The absolute position bounding box.
     */
    public void setBounds(List<Double> bounds) {
        this.bounds = bounds;
    }

    /**
     * Contents of the LayoutText, if any.
     */
    public List<Integer> getText() {
        return text;
    }

    /**
     * Contents of the LayoutText, if any.
     */
    public void setText(List<Integer> text) {
        this.text = text;
    }

    /**
     * Stacking context information.
     */
    public RareBooleanData getStackingContexts() {
        return stackingContexts;
    }

    /**
     * Stacking context information.
     */
    public void setStackingContexts(RareBooleanData stackingContexts) {
        this.stackingContexts = stackingContexts;
    }

    /**
     * The offset rect of nodes. Only available when includeDOMRects is set to true
     */
    public List<Double> getOffsetRects() {
        return offsetRects;
    }

    /**
     * The offset rect of nodes. Only available when includeDOMRects is set to true
     */
    public void setOffsetRects(List<Double> offsetRects) {
        this.offsetRects = offsetRects;
    }

    /**
     * The scroll rect of nodes. Only available when includeDOMRects is set to true
     */
    public List<Double> getScrollRects() {
        return scrollRects;
    }

    /**
     * The scroll rect of nodes. Only available when includeDOMRects is set to true
     */
    public void setScrollRects(List<Double> scrollRects) {
        this.scrollRects = scrollRects;
    }

    /**
     * The client rect of nodes. Only available when includeDOMRects is set to true
     */
    public List<Double> getClientRects() {
        return clientRects;
    }

    /**
     * The client rect of nodes. Only available when includeDOMRects is set to true
     */
    public void setClientRects(List<Double> clientRects) {
        this.clientRects = clientRects;
    }
}
