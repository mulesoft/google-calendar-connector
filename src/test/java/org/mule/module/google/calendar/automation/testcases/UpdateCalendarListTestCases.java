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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.tests.ConnectorTestUtils;

public class UpdateCalendarListTestCases extends GoogleCalendarTestParent{
	
	
	@Before
	public void setUp() throws Exception {
			loadTestRunMessage("updateCalendarList");
	
			Calendar calendar = runFlowAndGetPayload("create-calendar");
						
			upsertOnTestRunMessage("calendar", calendar);
			upsertOnTestRunMessage("id", calendar.getId());
			
			//Get Calendar List 
			CalendarList returnedCalendarList = runFlowAndGetPayload("get-calendar-list-by-id");
			
			upsertOnTestRunMessage("calendarList", returnedCalendarList);

	}
	
	
	@Category({RegressionTests.class})
	@Test
	public void testUpdateCalendarList() {
		try {
			String colorAfter = getTestRunMessageValue("colorAfter");
			
			CalendarList returnedCalendarList = getTestRunMessageValue("calendarList");
			
			returnedCalendarList.setColorId(colorAfter);
			upsertOnTestRunMessage("calendarListRef", returnedCalendarList);
			
			CalendarList afterUpdate = runFlowAndGetPayload("update-calendar-list");
			String afterColorId = afterUpdate.getColorId();
			assertEquals(afterColorId, colorAfter);
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
	@After
	public void tearDown() throws Exception {
			String calendarId = getTestRunMessageValue("id");
			deleteCalendar(calendarId);

	}
	

}
