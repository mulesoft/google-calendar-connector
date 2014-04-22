
package org.mule.module.google.calendar.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.google.calendar.GoogleCalendarConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>GoogleCalendarConnectorProcessAdapter</code> is a wrapper around {@link GoogleCalendarConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-22T09:01:45-03:00", comments = "Build M4.1875.17b58a3")
public class GoogleCalendarConnectorProcessAdapter
    extends GoogleCalendarConnectorLifecycleAdapter
    implements ProcessAdapter<GoogleCalendarConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, GoogleCalendarConnectorCapabilitiesAdapter> getProcessTemplate() {
        final GoogleCalendarConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,GoogleCalendarConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, GoogleCalendarConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, GoogleCalendarConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
