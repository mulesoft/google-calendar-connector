
package org.mule.module.google.calendar.adapters;

import javax.annotation.Generated;
import org.mule.module.google.calendar.GoogleCalendarConnector;
import org.mule.module.google.calendar.basic.MetadataAware;


/**
 * A <code>GoogleCalendarConnectorMetadataAdapater</code> is a wrapper around {@link GoogleCalendarConnector } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GoogleCalendarConnectorMetadataAdapater
    extends GoogleCalendarConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Google Calendars";
    private final static String MODULE_VERSION = "1.5.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.4.3";
    private final static String DEVKIT_BUILD = "3.4.3.1620.30ea288";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
