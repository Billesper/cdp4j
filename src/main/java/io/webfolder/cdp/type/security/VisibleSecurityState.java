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
package io.webfolder.cdp.type.security;

import java.util.List;

import com.vimeo.stag.UseStag;

import io.webfolder.cdp.annotation.Experimental;

/**
 * Security state information about the page
 */
@Experimental
@UseStag
public class VisibleSecurityState {
    private SecurityState securityState;

    private CertificateSecurityState certificateSecurityState;

    private SafetyTipInfo safetyTipInfo;

    private List<String> securityStateIssueIds;

    /**
     * The security level of the page.
     */
    public SecurityState getSecurityState() {
        return securityState;
    }

    /**
     * The security level of the page.
     */
    public void setSecurityState(SecurityState securityState) {
        this.securityState = securityState;
    }

    /**
     * Security state details about the page certificate.
     */
    public CertificateSecurityState getCertificateSecurityState() {
        return certificateSecurityState;
    }

    /**
     * Security state details about the page certificate.
     */
    public void setCertificateSecurityState(CertificateSecurityState certificateSecurityState) {
        this.certificateSecurityState = certificateSecurityState;
    }

    /**
     * The type of Safety Tip triggered on the page. Note that this field will be set even if the Safety Tip UI was not actually shown.
     */
    public SafetyTipInfo getSafetyTipInfo() {
        return safetyTipInfo;
    }

    /**
     * The type of Safety Tip triggered on the page. Note that this field will be set even if the Safety Tip UI was not actually shown.
     */
    public void setSafetyTipInfo(SafetyTipInfo safetyTipInfo) {
        this.safetyTipInfo = safetyTipInfo;
    }

    /**
     * Array of security state issues ids.
     */
    public List<String> getSecurityStateIssueIds() {
        return securityStateIssueIds;
    }

    /**
     * Array of security state issues ids.
     */
    public void setSecurityStateIssueIds(List<String> securityStateIssueIds) {
        this.securityStateIssueIds = securityStateIssueIds;
    }
}
