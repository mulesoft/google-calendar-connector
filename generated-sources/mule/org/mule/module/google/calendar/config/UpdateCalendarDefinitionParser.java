
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.module.google.calendar.processors.UpdateCalendarMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateCalendarDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateCalendarMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "id", "id");
        if (hasAttribute(element, "calendar-ref")) {
            if (element.getAttribute("calendar-ref").startsWith("#")) {
                builder.addPropertyValue("calendar", element.getAttribute("calendar-ref"));
            } else {
                builder.addPropertyValue("calendar", (("#[registry:"+ element.getAttribute("calendar-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
