package io.webfolder.cdp.event.target;

import com.vimeo.stag.UseStag;

import io.webfolder.cdp.annotation.Domain;
import io.webfolder.cdp.annotation.EventName;
import io.webfolder.cdp.annotation.Experimental;

/**
 * Issued when detached from target for any reason (including <code>detachFromTarget</code> command)
 * Can be
 * issued multiple times per target if multiple sessions have been attached to it
 */
@Experimental
@Domain("Target")
@EventName("detachedFromTarget")
@UseStag
public class DetachedFromTarget {
    private String sessionId;

    private String targetId;

    /**
     * Detached session identifier.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Detached session identifier.
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Deprecated.
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Deprecated.
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
