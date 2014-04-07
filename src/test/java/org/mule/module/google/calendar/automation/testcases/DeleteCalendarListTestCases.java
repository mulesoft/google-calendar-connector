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

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DeleteCalendarListTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        try {
            initializeTestRunMessage("deleteCalendarList");

            Calendar calendar = runFlowAndGetPayload("create-calendar");

            upsertOnTestRunMessage("calendar", calendar);
            upsertOnTestRunMessage("id", calendar.getId());

            //Get Calendar List
            CalendarList returnedCalendarList = runFlowAndGetPayload("get-calendar-list-by-id");

            upsertOnTestRunMessage("calendarList", returnedCalendarList);
            upsertOnTestRunMessage("color", returnedCalendarList.getColorId());

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }


    @Category({RegressionTests.class})
    @Test
    public void testDeleteCalendarList() {
        try {
            runFlowAndGetPayload("delete-calendar-list");
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }

        // Get the calendar list, should throw an exception
        try {
            runFlowAndGetPayload("get-calendar-list-by-id");
        } catch (Exception e) {
            if (e.getCause() instanceof GoogleJsonResponseException) {
                GoogleJsonResponseException googleException = (GoogleJsonResponseException) e.getCause();
                // Not found
                assertTrue(googleException.getStatusCode() == 404);
                assertTrue(googleException.getStatusMessage().equals("Not Found"));
            } else fail(ConnectorTestUtils.getStackTrace(e));
            ;
        }
    }

    @After
    public void tearDown() throws Exception {
        String calendarId = getTestRunMessageValue("id");
        deleteCalendar(calendarId);

    }

}
