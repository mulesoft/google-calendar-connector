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

import java.io.IOException;
import java.util.List;

import org.mule.modules.google.api.model.BaseWrapper;


/**
 * Wrapper for {@link com.google.api.services.calendar.model.Event.Reminders}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Reminders extends BaseWrapper<com.google.api.services.calendar.model.Event.Reminders> {
	
	public Reminders() {
		this(new com.google.api.services.calendar.model.Event.Reminders());
	}
	
	public Reminders(com.google.api.services.calendar.model.Event.Reminders wrapped) {
		super(wrapped);
	}

	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public List<EventReminder> getOverrides() {
		return EventReminder.valueOf(wrapped.getOverrides(), EventReminder.class);
	}

	public Boolean getUseDefault() {
		return wrapped.getUseDefault();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setOverrides(List<EventReminder> overrides) {
		wrapped.setOverrides(EventReminder.unwrapp(overrides, com.google.api.services.calendar.model.EventReminder.class));
	}

	public void setUseDefault(Boolean useDefault) {
		wrapped.setUseDefault(useDefault);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() throws IOException{
		return wrapped.toPrettyString();
	}
}
