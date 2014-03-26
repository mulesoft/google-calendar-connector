
package org.mule.module.google.calendar.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.processor.MessageProcessor;
import org.mule.common.DefaultResult;
import org.mule.common.Result;
import org.mule.common.metadata.DefaultListMetaDataModel;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.config.i18n.CoreMessages;
import org.mule.module.google.calendar.GoogleCalendarConnector;
import org.mule.module.google.calendar.model.Event;
import org.mule.module.google.calendar.oauth.GoogleCalendarConnectorOAuthManager;
import org.mule.module.google.calendar.process.ProcessAdapter;
import org.mule.module.google.calendar.process.ProcessCallback;
import org.mule.module.google.calendar.process.ProcessTemplate;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * GetEventsMessageProcessor invokes the {@link org.mule.module.google.calendar.GoogleCalendarConnector#getEvents(org.mule.api.MuleMessage, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link GoogleCalendarConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetEventsMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor, OperationMetaDataEnabled
{

    protected Object message;
    protected MuleMessage _messageType;
    protected Object calendarId;
    protected String _calendarIdType;
    protected Object icalUID;
    protected String _icalUIDType;
    protected Object maxAttendees;
    protected Integer _maxAttendeesType;
    protected Object maxResults;
    protected Integer _maxResultsType;
    protected Object orderBy;
    protected String _orderByType;
    protected Object pageToken;
    protected String _pageTokenType;
    protected Object query;
    protected String _queryType;
    protected Object showDeleted;
    protected boolean _showDeletedType;
    protected Object showHiddenInvitations;
    protected boolean _showHiddenInvitationsType;
    protected Object singleEvents;
    protected boolean _singleEventsType;
    protected Object timeMin;
    protected String _timeMinType;
    protected Object timeMax;
    protected String _timeMaxType;
    protected Object datetimeFormat;
    protected String _datetimeFormatType;
    protected Object timezone;
    protected String _timezoneType;
    protected Object lastUpdated;
    protected String _lastUpdatedType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    public void start()
        throws MuleException
    {
    }

    public void stop()
        throws MuleException
    {
    }

    public void dispose() {
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
    }

    /**
     * Sets calendarId
     * 
     * @param value Value to set
     */
    public void setCalendarId(Object value) {
        this.calendarId = value;
    }

    /**
     * Sets orderBy
     * 
     * @param value Value to set
     */
    public void setOrderBy(Object value) {
        this.orderBy = value;
    }

    /**
     * Sets icalUID
     * 
     * @param value Value to set
     */
    public void setIcalUID(Object value) {
        this.icalUID = value;
    }

    /**
     * Sets query
     * 
     * @param value Value to set
     */
    public void setQuery(Object value) {
        this.query = value;
    }

    /**
     * Sets datetimeFormat
     * 
     * @param value Value to set
     */
    public void setDatetimeFormat(Object value) {
        this.datetimeFormat = value;
    }

    /**
     * Sets lastUpdated
     * 
     * @param value Value to set
     */
    public void setLastUpdated(Object value) {
        this.lastUpdated = value;
    }

    /**
     * Sets pageToken
     * 
     * @param value Value to set
     */
    public void setPageToken(Object value) {
        this.pageToken = value;
    }

    /**
     * Sets singleEvents
     * 
     * @param value Value to set
     */
    public void setSingleEvents(Object value) {
        this.singleEvents = value;
    }

    /**
     * Sets showHiddenInvitations
     * 
     * @param value Value to set
     */
    public void setShowHiddenInvitations(Object value) {
        this.showHiddenInvitations = value;
    }

    /**
     * Sets maxResults
     * 
     * @param value Value to set
     */
    public void setMaxResults(Object value) {
        this.maxResults = value;
    }

    /**
     * Sets maxAttendees
     * 
     * @param value Value to set
     */
    public void setMaxAttendees(Object value) {
        this.maxAttendees = value;
    }

    /**
     * Sets message
     * 
     * @param value Value to set
     */
    public void setMessage(Object value) {
        this.message = value;
    }

    /**
     * Sets timezone
     * 
     * @param value Value to set
     */
    public void setTimezone(Object value) {
        this.timezone = value;
    }

    /**
     * Sets timeMin
     * 
     * @param value Value to set
     */
    public void setTimeMin(Object value) {
        this.timeMin = value;
    }

    /**
     * Sets showDeleted
     * 
     * @param value Value to set
     */
    public void setShowDeleted(Object value) {
        this.showDeleted = value;
    }

    /**
     * Sets timeMax
     * 
     * @param value Value to set
     */
    public void setTimeMax(Object value) {
        this.timeMax = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(final MuleEvent event)
        throws MuleException
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(GoogleCalendarConnectorOAuthManager.class, false, event);
            final String _transformedCalendarId = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_calendarIdType").getGenericType(), null, calendarId));
            final String _transformedIcalUID = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_icalUIDType").getGenericType(), null, icalUID));
            final Integer _transformedMaxAttendees = ((Integer) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_maxAttendeesType").getGenericType(), null, maxAttendees));
            final Integer _transformedMaxResults = ((Integer) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_maxResultsType").getGenericType(), null, maxResults));
            final String _transformedOrderBy = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_orderByType").getGenericType(), null, orderBy));
            final String _transformedPageToken = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_pageTokenType").getGenericType(), null, pageToken));
            final String _transformedQuery = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_queryType").getGenericType(), null, query));
            final Boolean _transformedShowDeleted = ((Boolean) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_showDeletedType").getGenericType(), null, showDeleted));
            final Boolean _transformedShowHiddenInvitations = ((Boolean) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_showHiddenInvitationsType").getGenericType(), null, showHiddenInvitations));
            final Boolean _transformedSingleEvents = ((Boolean) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_singleEventsType").getGenericType(), null, singleEvents));
            final String _transformedTimeMin = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_timeMinType").getGenericType(), null, timeMin));
            final String _transformedTimeMax = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_timeMaxType").getGenericType(), null, timeMax));
            final String _transformedDatetimeFormat = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_datetimeFormatType").getGenericType(), null, datetimeFormat));
            final String _transformedTimezone = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_timezoneType").getGenericType(), null, timezone));
            final String _transformedLastUpdated = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_lastUpdatedType").getGenericType(), null, lastUpdated));
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class> getManagedExceptions() {
                    return Arrays.asList(new Class[] {OAuthTokenExpiredException.class });
                }

                public boolean isProtected() {
                    return true;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((GoogleCalendarConnector) object).getEvents(event.getMessage(), _transformedCalendarId, _transformedIcalUID, _transformedMaxAttendees, _transformedMaxResults, _transformedOrderBy, _transformedPageToken, _transformedQuery, _transformedShowDeleted, _transformedShowHiddenInvitations, _transformedSingleEvents, _transformedTimeMin, _transformedTimeMax, _transformedDatetimeFormat, _transformedTimezone, _transformedLastUpdated);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("getEvents"), event, e);
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(getPojoOrSimpleModel(Event.class))));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

}
