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
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateCalendarTestCases extends GoogleCalendarTestParent {


    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateCalendar");
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateCalendar() {
        try {
            Calendar calendar = runFlowAndGetPayload("get-calendar-by-id");
            String summaryBefore = calendar.getSummary();

            upsertOnTestRunMessage("calendarId", calendar.getId());
            upsertOnTestRunMessage("summaryBefore", summaryBefore != null ? summaryBefore : "");

            String summaryAfter = getTestRunMessageValue("summaryAfter");

            calendar.setSummary(summaryAfter);
            upsertOnTestRunMessage("calendarRef", calendar);

            Calendar afterUpdate = runFlowAndGetPayload("update-calendar");
            String afterText = afterUpdate.getSummary();
            assertEquals(afterText, summaryAfter);

            // Set the summary back to summaryBefore for tearDown.
            afterUpdate.setSummary(summaryBefore);
            upsertOnTestRunMessage("calendarRef", afterUpdate);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("update-calendar");
    }

}
