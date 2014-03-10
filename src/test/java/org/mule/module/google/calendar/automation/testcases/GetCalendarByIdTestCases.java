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

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.modules.tests.ConnectorTestUtils;

public class GetCalendarByIdTestCases extends GoogleCalendarTestParent {

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {

			loadTestRunMessage("getCalendarById");

			// Create the calendar		
			Calendar calendar = runFlowAndGetPayload("create-calendar");
			upsertOnTestRunMessage("id", calendar.getId());

	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testGetCalendarById() {
		try {
			
			String createdCalendarId = getTestRunMessageValue("id");

			// Assertions on equality
			Calendar returnedCalendar = runFlowAndGetPayload("get-calendar-by-id");
			assertTrue(returnedCalendar != null);
			assertTrue(returnedCalendar.getId().equals(createdCalendarId));
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
	@After
	public void tearDown() throws Exception {
			// Delete the calendar
			runFlowAndGetPayload("delete-calendar");

	}
}
