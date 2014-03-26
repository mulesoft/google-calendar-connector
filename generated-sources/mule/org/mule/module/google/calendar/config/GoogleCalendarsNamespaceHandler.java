
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/google-calendars</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GoogleCalendarsNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config-with-oauth", new GoogleCalendarConnectorConfigDefinitionParser());
        registerBeanDefinitionParser("authorize", new AuthorizeDefinitionParser());
        registerBeanDefinitionParser("unauthorize", new UnauthorizeDefinitionParser());
        registerBeanDefinitionParser("create-calendar", new CreateCalendarDefinitionParser());
        registerBeanDefinitionParser("get-calendar-list", new GetCalendarListDefinitionParser());
        registerBeanDefinitionParser("get-calendar-list-by-id", new GetCalendarListByIdDefinitionParser());
        registerBeanDefinitionParser("delete-calendar-list", new DeleteCalendarListDefinitionParser());
        registerBeanDefinitionParser("update-calendar-list", new UpdateCalendarListDefinitionParser());
        registerBeanDefinitionParser("get-calendar-by-id", new GetCalendarByIdDefinitionParser());
        registerBeanDefinitionParser("update-calendar", new UpdateCalendarDefinitionParser());
        registerBeanDefinitionParser("delete-calendar", new DeleteCalendarDefinitionParser());
        registerBeanDefinitionParser("clear-calendar", new ClearCalendarDefinitionParser());
        registerBeanDefinitionParser("get-events", new GetEventsDefinitionParser());
        registerBeanDefinitionParser("import-event", new ImportEventDefinitionParser());
        registerBeanDefinitionParser("delete-event", new DeleteEventDefinitionParser());
        registerBeanDefinitionParser("get-event-by-id", new GetEventByIdDefinitionParser());
        registerBeanDefinitionParser("insert-event", new InsertEventDefinitionParser());
        registerBeanDefinitionParser("batch-insert-event", new BatchInsertEventDefinitionParser());
        registerBeanDefinitionParser("batch-update-event", new BatchUpdateEventDefinitionParser());
        registerBeanDefinitionParser("batch-delete-event", new BatchDeleteEventDefinitionParser());
        registerBeanDefinitionParser("batch-insert-calendar", new BatchInsertCalendarDefinitionParser());
        registerBeanDefinitionParser("batch-update-calendar", new BatchUpdateCalendarDefinitionParser());
        registerBeanDefinitionParser("batch-delete-calendar", new BatchDeleteCalendarDefinitionParser());
        registerBeanDefinitionParser("get-instances", new GetInstancesDefinitionParser());
        registerBeanDefinitionParser("move-event", new MoveEventDefinitionParser());
        registerBeanDefinitionParser("quick-add-event", new QuickAddEventDefinitionParser());
        registerBeanDefinitionParser("update-event", new UpdateEventDefinitionParser());
        registerBeanDefinitionParser("get-free-time", new GetFreeTimeDefinitionParser());
        registerBeanDefinitionParser("insert-acl-rule", new InsertAclRuleDefinitionParser());
        registerBeanDefinitionParser("delete-acl-rule", new DeleteAclRuleDefinitionParser());
        registerBeanDefinitionParser("get-acl-rule-by-id", new GetAclRuleByIdDefinitionParser());
        registerBeanDefinitionParser("get-all-acl-rules", new GetAllAclRulesDefinitionParser());
        registerBeanDefinitionParser("update-acl-rule", new UpdateAclRuleDefinitionParser());
    }

}
