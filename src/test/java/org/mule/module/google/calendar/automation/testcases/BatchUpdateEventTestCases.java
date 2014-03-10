/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.automation.CalendarUtils;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.Event;
import org.mule.module.google.calendar.model.EventDateTime;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;

public class BatchUpdateEventTestCases extends GoogleCalendarTestParent {

	@Before
	public void setUp() throws Exception {
		
			loadTestRunMessage("batchUpdateEvent");
			
			Calendar calendar = runFlowAndGetPayload("create-calendar");
			upsertOnTestRunMessage("calendar", calendar);
			upsertOnTestRunMessage("calendarId", calendar.getId());

			EventDateTime eventTimeStart = getTestRunMessageValue("eventStart");
			EventDateTime eventTimeEnd = getTestRunMessageValue("eventEnd");
			String summaryBefore = getTestRunMessageValue("summaryBefore");
			Integer numEvents =getTestRunMessageValue("numEvents");
			
			List<Event> events = new ArrayList<Event>();
			for (int i = 0; i < numEvents; i++) {
				Event event = CalendarUtils.getEvent(summaryBefore, eventTimeStart, eventTimeEnd);
				events.add(event);
			}
			
			BatchResponse<Event> batchEvents = insertEvents(calendar, events);
			List<Event> successfulEvents = batchEvents.getSuccessful();
			
			upsertOnTestRunMessage("events", successfulEvents);
			
	}
	
	@Category({ RegressionTests.class})	
	@Test
	public void testBatchUpdateEvent() {
		try {
			
			String summaryAfter = getTestRunMessageValue("summaryAfter");
			List<Event> events = (List<Event>) getTestRunMessageValue("events");
			
			for (Event event : events) {
				event.setSummary(summaryAfter);
			}
			
			upsertOnTestRunMessage("calendarEventsRef", events);
			BatchResponse<Event> returnedEvents = runFlowAndGetPayload("batch-update-event");
			assertTrue(returnedEvents.getErrors() == null || returnedEvents.getErrors().size() == 0);
			
			List<Event> successfulEvents = returnedEvents.getSuccessful();
			assertTrue(successfulEvents.size() == events.size());
			for (Event successfulEvent : successfulEvents) {
				assertTrue(CalendarUtils.isEventInList(events, successfulEvent));
			}
			
			assertTrue(EqualsBuilder.reflectionEquals(successfulEvents, events));
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}

	@After
	public void tearDown() throws Exception {

		Calendar calendar = getTestRunMessageValue("calendar");
		deleteCalendar(calendar);

	}
	
}
