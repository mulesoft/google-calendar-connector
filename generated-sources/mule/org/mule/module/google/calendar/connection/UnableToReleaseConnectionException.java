
package org.mule.module.google.calendar.connection;

import javax.annotation.Generated;


/**
 * Exception thrown when the release connection operation of the
 *  connection manager fails.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-22T09:01:45-03:00", comments = "Build M4.1875.17b58a3")
public class UnableToReleaseConnectionException
    extends Exception
{

     /**
     * Create a new exception
     *
     * @param throwable Inner exception
     */
    public UnableToReleaseConnectionException(Throwable throwable) {
        super(throwable);
    }
}
