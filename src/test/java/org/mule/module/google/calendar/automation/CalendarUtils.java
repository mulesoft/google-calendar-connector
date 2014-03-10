/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.automation;

import java.util.Date;
import java.util.List;

import org.mule.module.google.calendar.model.AclRule;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.module.google.calendar.model.Event;
import org.mule.module.google.calendar.model.EventDateTime;
import org.mule.modules.google.api.datetime.DateTime;

public class CalendarUtils {

	public static Calendar getCalendar(String summary) {
		Calendar calendar = new Calendar();
		calendar.setSummary(summary);
		return calendar;
	}
	
	public static Event getEvent(String title) {
		Event event = new Event();
		event.setSummary(title);
		return event;
	}

	public static Event getEvent(String title, Date startTime, Date endTime) {
		Event event = getEvent(title);
		
		EventDateTime start = new EventDateTime();
		start.setDateTime(new DateTime(startTime));
		
		EventDateTime end = new EventDateTime();
		end.setDateTime(new DateTime(endTime));
		
		event.setStart(start);
		event.setEnd(end);
		return event;
	}
	
	public static Event getEvent(String title, String startTime, String endTime) {
		Event event = getEvent(title);
		
		EventDateTime start = new EventDateTime();
		start.setDate(startTime);
		
		EventDateTime end = new EventDateTime();
		end.setDate(endTime);
		
		event.setStart(start);
		event.setEnd(end);
		return event;
	}
	
	public static Event getEvent(String title, EventDateTime startTime, EventDateTime endTime) {
		Event event = getEvent(title);
		event.setStart(startTime);
		event.setEnd(endTime);
		return event;
	}
	
	public static boolean isCalendarInList(List<CalendarList> list, Calendar toSearch) {
		for (CalendarList calendar : list) {
			if (calendar.getId().equals(toSearch.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAclRuleInList(List<AclRule> list, AclRule toSearch) {
		for (AclRule aclRule : list) {
			if (aclRule.getId().equals(toSearch.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isEventInList(List<Event> events, Event event) {
		for (Event e : events) {
			if (event.getId().equals(e.getId())) {
				return true;
			}
		}
		return false;
	}
	
}
