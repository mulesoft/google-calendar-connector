
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.module.google.calendar.processors.GetInstancesMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetInstancesDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(GetInstancesMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "calendarId", "calendarId");
        parseProperty(builder, element, "eventId", "eventId");
        parseProperty(builder, element, "maxAttendess", "maxAttendess");
        parseProperty(builder, element, "maxResults", "maxResults");
        parseProperty(builder, element, "showDeleted", "showDeleted");
        parseProperty(builder, element, "timezone", "timezone");
        parseProperty(builder, element, "originalStart", "originalStart");
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
