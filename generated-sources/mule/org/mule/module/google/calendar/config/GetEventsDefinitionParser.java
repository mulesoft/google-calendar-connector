
package org.mule.module.google.calendar.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.google.calendar.processors.GetEventsMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T09:46:10-05:00", comments = "Build master.1915.dd1962d")
public class GetEventsDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(GetEventsDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(GetEventsMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [get-events] within the connector [google-calendars] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [get-events] within the connector [google-calendars] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("getEvents");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "calendarId", "calendarId");
        parseProperty(builder, element, "icalUID", "icalUID");
        parseProperty(builder, element, "maxAttendees", "maxAttendees");
        parseProperty(builder, element, "orderBy", "orderBy");
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
        parseProperty(builder, element, "fetchSize", "fetchSize");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
