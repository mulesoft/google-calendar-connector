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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class BatchDeleteCalendarTestCases extends GoogleCalendarTestParent {

	protected List<Calendar> insertedCalendars = new ArrayList<Calendar>();

	@Before
	public void setUp() throws Exception {

		loadTestRunMessage("batchDeleteCalendar");
		
		Integer numCalendars = getTestRunMessageValue("numCalendars");
		
		// Create calendar instances
		List<Calendar> calendars = new ArrayList<Calendar>();
		for (int i = 0; i < numCalendars; i++) {
			calendars.add(CalendarUtils.getCalendar("This is a title"));
		}

		// Insert calendar
		BatchResponse<Calendar> response = insertCalendars(calendars);			
		
		// Add them to a global variable so that we can drop them in the tearDown method
		for (Calendar calendar : response.getSuccessful()) {
			insertedCalendars.add(calendar);
		}
		
	}
		
	@Ignore("Needs to be review")
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testBatchDeleteCalendar() {
		try {
			deleteCalendars(insertedCalendars);

			List<CalendarList> calendarList = runFlowAndGetPayload("get-calendar-list");
			for (Calendar calendar : insertedCalendars) {
				assertFalse(CalendarUtils.isCalendarInList(calendarList, calendar));
			}
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
}
