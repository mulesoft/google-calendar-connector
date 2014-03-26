
package org.mule.module.google.calendar.oauth;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.google.calendar.adapters.GoogleCalendarConnectorCapabilitiesAdapter;
import org.mule.module.google.calendar.process.ProcessCallback;
import org.mule.module.google.calendar.process.ProcessTemplate;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class OAuthProcessTemplate<P >implements ProcessTemplate<P, GoogleCalendarConnectorCapabilitiesAdapter>
{

    private final GoogleCalendarConnectorCapabilitiesAdapter object;

    public OAuthProcessTemplate(GoogleCalendarConnectorCapabilitiesAdapter object) {
        this.object = object;
    }

    public P execute(ProcessCallback<P, GoogleCalendarConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        if (processCallback.isProtected()) {
            ((OAuthAdapter) object).hasBeenAuthorized();
        }
        return processCallback.process(object);
    }

    public P execute(ProcessCallback<P, GoogleCalendarConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        if (processCallback.isProtected()) {
            ((OAuthAdapter) object).hasBeenAuthorized();
        }
        return processCallback.process(object);
    }

}
