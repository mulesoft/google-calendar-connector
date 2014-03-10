/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.model;

import org.mule.modules.google.api.datetime.DateTime;
import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.EventDateTime}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class EventDateTime extends BaseWrapper<com.google.api.services.calendar.model.EventDateTime> {
	
	public EventDateTime() {
		this(new com.google.api.services.calendar.model.EventDateTime());
	}
	
	public EventDateTime(com.google.api.services.calendar.model.EventDateTime wrapped) {
		super(wrapped != null ? wrapped : new com.google.api.services.calendar.model.EventDateTime());
	}

	public String getDate() {
		return wrapped.getDate();
	}

	public String getTimeZone() {
		return wrapped.getTimeZone();
	}

	public DateTime getDateTime() {
		return new DateTime(wrapped.getDateTime());
	}

	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setDate(String date) {
		wrapped.setDate(date);
	}

	public void setTimeZone(String timeZone) {
		wrapped.setTimeZone(timeZone);
	}

	public void setDateTime(DateTime dateTime) {
		wrapped.setDateTime(dateTime.getWrapped());
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
