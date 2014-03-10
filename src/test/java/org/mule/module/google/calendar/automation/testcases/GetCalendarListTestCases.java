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

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.automation.CalendarUtils;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;

public class GetCalendarListTestCases extends GoogleCalendarTestParent {

	protected List<Calendar> insertedCalendars = new ArrayList<Calendar>();
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
			loadTestRunMessage("getCalendarList");
			
			Integer numCalendars = getTestRunMessageValue("numCalendars");
			
			// Create calendar instances
			List<Calendar> calendars = new ArrayList<Calendar>();
			for (int i = 0; i < numCalendars; i++) {
				calendars.add(CalendarUtils.getCalendar("This is a title"));
			}

			// Insert calendars and record their IDs
			BatchResponse<Calendar> response = insertCalendars(calendars);	
			
			for (Calendar calendar : response.getSuccessful()) {
				insertedCalendars.add(calendar);
			}					

	}
	
	@Ignore("Needs to be review")
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testGetCalendarList() {
		try {
			
			List<CalendarList> calendarList = runFlowAndGetPayload("get-calendar-list");
			
			for (Calendar insertedCalendar : insertedCalendars) {
				assertTrue(CalendarUtils.isCalendarInList(calendarList, insertedCalendar));
			}
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
	@After
	public void tearDown() throws Exception {

			// Delete the calendars
			deleteCalendars(insertedCalendars);			

	}
}
