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

import org.mule.modules.google.api.model.BaseWrapper;


/**
 * Wrapper for {@link com.google.api.services.calendar.model.EventReminder}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class EventReminder extends BaseWrapper<com.google.api.services.calendar.model.EventReminder> {

	public EventReminder() {
		this(new com.google.api.services.calendar.model.EventReminder());
	}
	
	public EventReminder(com.google.api.services.calendar.model.EventReminder wrapped) {
		super(wrapped);
	}

	public Integer getMinutes() {
		return wrapped.getMinutes();
	}

	public String getMethod() {
		return wrapped.getMethod();
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setMinutes(Integer minutes) {
		wrapped.setMinutes(minutes);
	}

	public void setMethod(String method) {
		wrapped.setMethod(method);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
