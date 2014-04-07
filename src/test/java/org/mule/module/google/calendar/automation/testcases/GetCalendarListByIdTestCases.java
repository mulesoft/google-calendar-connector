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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.*;

public class GetCalendarListByIdTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("getCalendarListById");

        // Create the calendar
        Calendar calendar = runFlowAndGetPayload("create-calendar");
        upsertOnTestRunMessage("calendar", calendar);
        upsertOnTestRunMessage("id", calendar.getId());

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetCalendarListById() {
        try {

            Calendar originalCalendar = getTestRunMessageValue("calendar");

            String createdCalendarId = getTestRunMessageValue("id");

            CalendarList returnedCalendarList = runFlowAndGetPayload("get-calendar-list-by-id");

            assertTrue(returnedCalendarList != null);
            assertTrue(returnedCalendarList.getId().equals(createdCalendarId));
            assertEquals(returnedCalendarList.getSummary(), originalCalendar.getSummary());

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
