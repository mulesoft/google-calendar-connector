
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/google-calendars</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-26T12:31:10-05:00", comments = "Build M4.1875.17b58a3")
public class GoogleCalendarsNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(GoogleCalendarsNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [google-calendars] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [google-calendars] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config-with-oauth", new GoogleCalendarConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("authorize", new AuthorizeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("authorize", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("authorize", new AuthorizeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("unauthorize", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-calendar", new CreateCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-calendar-list", new GetCalendarListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-calendar-list", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-calendar-list-by-id", new GetCalendarListByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-calendar-list-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-calendar-list", new DeleteCalendarListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-calendar-list", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-calendar-list", new UpdateCalendarListDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-calendar-list", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-calendar-by-id", new GetCalendarByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-calendar-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-calendar", new UpdateCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-calendar", new DeleteCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("clear-calendar", new ClearCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("clear-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-events", new GetEventsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-events", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("import-event", new ImportEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("import-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-event", new DeleteEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-event-by-id", new GetEventByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-event-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("insert-event", new InsertEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("insert-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-insert-event", new BatchInsertEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-insert-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-update-event", new BatchUpdateEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-update-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-delete-event", new BatchDeleteEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-delete-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-insert-calendar", new BatchInsertCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-insert-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-update-calendar", new BatchUpdateCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-update-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("batch-delete-calendar", new BatchDeleteCalendarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("batch-delete-calendar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-instances", new GetInstancesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-instances", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("move-event", new MoveEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("move-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("quick-add-event", new QuickAddEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("quick-add-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-event", new UpdateEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-free-time", new GetFreeTimeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-free-time", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("insert-acl-rule", new InsertAclRuleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("insert-acl-rule", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-acl-rule", new DeleteAclRuleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-acl-rule", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-acl-rule-by-id", new GetAclRuleByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-acl-rule-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-acl-rules", new GetAllAclRulesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-acl-rules", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-acl-rule", new UpdateAclRuleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-acl-rule", "@Processor", ex);
        }
    }

}
