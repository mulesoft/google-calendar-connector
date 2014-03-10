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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.automation.CalendarUtils;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;

public class BatchInsertCalendarTestCases extends GoogleCalendarTestParent {

	protected List<Calendar> insertedCalendars = new ArrayList<Calendar>();
	
	@Ignore("Needs to be review")
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testBatchInsertCalendar() {
		try {
			loadTestRunMessage("batchInsertCalendar");
			
			Integer numCalendars = getTestRunMessageValue("numCalendars");
			
			// Create calendar instances
			List<Calendar> calendars = new ArrayList<Calendar>();
			for (int i = 0; i < numCalendars; i++) {
				calendars.add(CalendarUtils.getCalendar("This is a title"));
			}
	
			// Insert calendars
			BatchResponse<Calendar> response = insertCalendars(calendars);			
			
			// Assert that no errors exist in the response
			assertTrue(response.getErrors() == null || response.getErrors().size() == 0);
			assertTrue(response.getSuccessful().size() == numCalendars);
			
			// Add them to a global variable so that we can drop them in the tearDown method
			for (Calendar calendar : response.getSuccessful()) {
				insertedCalendars.add(calendar);
			}
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
		
	@After
	public void tearDown() throws Exception {
		deleteCalendars(insertedCalendars);			
	}
	
}
