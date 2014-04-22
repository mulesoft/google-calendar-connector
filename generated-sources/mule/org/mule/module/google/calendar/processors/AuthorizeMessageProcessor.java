
package org.mule.module.google.calendar.processors;

import java.util.regex.Pattern;
import javax.annotation.Generated;
import org.mule.module.google.calendar.oauth.GoogleCalendarConnectorOAuthManager;
import org.mule.modules.google.AccessType;
import org.mule.modules.google.ForcePrompt;
import org.mule.security.oauth.processor.BaseOAuth2AuthorizeMessageProcessor;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-22T09:04:09-03:00", comments = "Build M4.1875.17b58a3")
public class AuthorizeMessageProcessor
    extends BaseOAuth2AuthorizeMessageProcessor<GoogleCalendarConnectorOAuthManager>
{

    private final static Pattern AUTH_CODE_PATTERN = Pattern.compile("code=([^&]+)");
    private Object access_type;
    private AccessType _access_typeType;
    private Object force_prompt;
    private ForcePrompt _force_promptType;

    /**
     * Sets access_type
     * 
     * @param value Value to set
     */
    public void setAccess_type(Object value) {
        this.access_type = value;
    }

    /**
     * Sets force_prompt
     * 
     * @param value Value to set
     */
    public void setForce_prompt(Object value) {
        this.force_prompt = value;
    }

    @Override
    protected String getAuthCodeRegex() {
        return AUTH_CODE_PATTERN.pattern();
    }

    @Override
    protected Class<GoogleCalendarConnectorOAuthManager> getOAuthManagerClass() {
        return GoogleCalendarConnectorOAuthManager.class;
    }

}
