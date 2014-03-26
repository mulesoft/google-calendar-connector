
package org.mule.module.google.calendar.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
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
import org.mule.module.google.calendar.model.FreeBusy;
import org.mule.module.google.calendar.oauth.GoogleCalendarConnectorOAuthManager;
import org.mule.module.google.calendar.process.ProcessAdapter;
import org.mule.module.google.calendar.process.ProcessCallback;
import org.mule.module.google.calendar.process.ProcessTemplate;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * GetFreeTimeMessageProcessor invokes the {@link org.mule.module.google.calendar.GoogleCalendarConnector#getFreeTime(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Integer)} method in {@link GoogleCalendarConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetFreeTimeMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor, OperationMetaDataEnabled
{

    protected Object timeMin;
    protected String _timeMinType;
    protected Object timeMax;
    protected String _timeMaxType;
    protected Object ids;
    protected List<String> _idsType;
    protected Object timezone;
    protected String _timezoneType;
    protected Object datetimeFormat;
    protected String _datetimeFormatType;
    protected Object maxCalendarExpansion;
    protected Integer _maxCalendarExpansionType;

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
     * Sets ids
     * 
     * @param value Value to set
     */
    public void setIds(Object value) {
        this.ids = value;
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
     * Sets timeMax
     * 
     * @param value Value to set
     */
    public void setTimeMax(Object value) {
        this.timeMax = value;
    }

    /**
     * Sets maxCalendarExpansion
     * 
     * @param value Value to set
     */
    public void setMaxCalendarExpansion(Object value) {
        this.maxCalendarExpansion = value;
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
            final String _transformedTimeMin = ((String) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_timeMinType").getGenericType(), null, timeMin));
            final String _transformedTimeMax = ((String) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_timeMaxType").getGenericType(), null, timeMax));
            final List<String> _transformedIds = ((List<String> ) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_idsType").getGenericType(), null, ids));
            final String _transformedTimezone = ((String) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_timezoneType").getGenericType(), null, timezone));
            final String _transformedDatetimeFormat = ((String) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_datetimeFormatType").getGenericType(), null, datetimeFormat));
            final Integer _transformedMaxCalendarExpansion = ((Integer) evaluateAndTransform(getMuleContext(), event, GetFreeTimeMessageProcessor.class.getDeclaredField("_maxCalendarExpansionType").getGenericType(), null, maxCalendarExpansion));
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
                    return ((GoogleCalendarConnector) object).getFreeTime(_transformedTimeMin, _transformedTimeMax, _transformedIds, _transformedTimezone, _transformedDatetimeFormat, _transformedMaxCalendarExpansion);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("getFreeTime"), event, e);
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(getPojoOrSimpleModel(String.class))));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(FreeBusy.class)));
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
