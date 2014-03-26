
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.module.google.calendar.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.module.google.calendar.processors.GetFreeTimeMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetFreeTimeDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(GetFreeTimeMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "timeMin", "timeMin");
        parseProperty(builder, element, "timeMax", "timeMax");
        parseListWithDefaultAndSetProperty(element, builder, "ids", "ids", "id", "#[payload]", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "timezone", "timezone");
        parseProperty(builder, element, "datetimeFormat", "datetimeFormat");
        parseProperty(builder, element, "maxCalendarExpansion", "maxCalendarExpansion");
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
