
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.module.google.calendar.processors.GetEventsMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetEventsDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(GetEventsMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "calendarId", "calendarId");
        parseProperty(builder, element, "icalUID", "icalUID");
        parseProperty(builder, element, "maxAttendees", "maxAttendees");
        parseProperty(builder, element, "maxResults", "maxResults");
        parseProperty(builder, element, "orderBy", "orderBy");
        parseProperty(builder, element, "pageToken", "pageToken");
        parseProperty(builder, element, "query", "query");
        parseProperty(builder, element, "showDeleted", "showDeleted");
        parseProperty(builder, element, "showHiddenInvitations", "showHiddenInvitations");
        parseProperty(builder, element, "singleEvents", "singleEvents");
        parseProperty(builder, element, "timeMin", "timeMin");
        parseProperty(builder, element, "timeMax", "timeMax");
        parseProperty(builder, element, "datetimeFormat", "datetimeFormat");
        parseProperty(builder, element, "timezone", "timezone");
        parseProperty(builder, element, "lastUpdated", "lastUpdated");
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
