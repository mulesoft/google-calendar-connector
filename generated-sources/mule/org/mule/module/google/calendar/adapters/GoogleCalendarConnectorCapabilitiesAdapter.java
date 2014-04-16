
package org.mule.module.google.calendar.adapters;

import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.module.google.calendar.GoogleCalendarConnector;


/**
 * A <code>GoogleCalendarConnectorCapabilitiesAdapter</code> is a wrapper around {@link GoogleCalendarConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T09:46:10-05:00", comments = "Build master.1915.dd1962d")
public class GoogleCalendarConnectorCapabilitiesAdapter
    extends GoogleCalendarConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.OAUTH2_CAPABLE) {
            return true;
        }
        return false;
    }

}
