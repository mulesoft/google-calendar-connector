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

import java.util.Map;

import org.mule.modules.google.api.datetime.DateTime;
import org.mule.modules.google.api.model.BaseWrapper;

import com.google.api.services.calendar.model.FreeBusyCalendar;
import com.google.api.services.calendar.model.FreeBusyGroup;
import com.google.api.services.calendar.model.FreeBusyResponse;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.FreeBusyResponse}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class FreeBusy extends BaseWrapper<FreeBusyResponse> {

	public FreeBusy() {
		this(new FreeBusyResponse());
	}
	
	public FreeBusy(FreeBusyResponse wrapped) {
		super(wrapped);
	}
	
	public DateTime getTimeMax() {
		return new DateTime(wrapped.getTimeMax());
	}

	public DateTime getTimeMin() {
		return new DateTime(wrapped.getTimeMin());
	}

	public Map<String, FreeBusyGroup> getGroups() {
		return wrapped.getGroups();
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public Map<String, FreeBusyCalendar> getCalendars() {
		return wrapped.getCalendars();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setTimeMax(DateTime timeMax) {
		wrapped.setTimeMax(timeMax.getWrapped());
	}

	public void setCalendars(Map<String, FreeBusyCalendar> calendars) {
		wrapped.setCalendars(calendars);
	}

	public void setTimeMin(DateTime timeMin) {
		wrapped.setTimeMin(timeMin.getWrapped());
	}

	public void setGroups(Map<String, FreeBusyGroup> groups) {
		wrapped.setGroups(groups);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
