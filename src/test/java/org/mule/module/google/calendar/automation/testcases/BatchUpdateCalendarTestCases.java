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
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;

public class BatchUpdateCalendarTestCases extends GoogleCalendarTestParent {

	@Before
	public void setUp() throws Exception {
			loadTestRunMessage("batchUpdateCalendar");
			
			Integer numCalendars =getTestRunMessageValue("numCalendars");
			String summaryBefore = getTestRunMessageValue("summaryBefore");
			
			List<Calendar> calendars = new ArrayList<Calendar>();
			for (int i = 0; i < numCalendars; i++) {
				Calendar calendar = CalendarUtils.getCalendar(summaryBefore);
				calendars.add(calendar);
			}
			
			BatchResponse<Calendar> calendarBatchResponse = insertCalendars(calendars);
			List<Calendar> insertedCalendars = calendarBatchResponse.getSuccessful();
			
			upsertOnTestRunMessage("calendars", insertedCalendars);
	}
	
	@Category({ RegressionTests.class})	
	@Test
	public void testBatchUpdateCalendar() {
		try {
			List<Calendar> calendars = getTestRunMessageValue("calendars");
			String summaryAfter = getTestRunMessageValue("summaryAfter");
			
			for (Calendar calendar : calendars) {
				calendar.setSummary(summaryAfter);
			}
			
			upsertOnTestRunMessage("calendarsRef", calendars);
			BatchResponse<Calendar> updatedCalendars = runFlowAndGetPayload("batch-update-calendar");
			assertTrue(updatedCalendars.getErrors() == null || updatedCalendars.getErrors().size() == 0);

			List<Calendar> successful = updatedCalendars.getSuccessful();
			
			for (Calendar cal : successful) {
				cal.getSummary().equals(summaryAfter);
			}
			
			assertTrue(EqualsBuilder.reflectionEquals(successful, calendars));
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
	@After
	public void tearDown() throws Exception {
		List<Calendar> calendars = getTestRunMessageValue("calendarsRef");
		deleteCalendars(calendars);
	
	}
}
