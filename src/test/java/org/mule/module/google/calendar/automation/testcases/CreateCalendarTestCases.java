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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CreateCalendarTestCases extends GoogleCalendarTestParent {

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("createCalendar");

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateCalendar() {
        try {

            Calendar originalCalendar = getTestRunMessageValue("calendarRef");
            Calendar createdCalendar = runFlowAndGetPayload("create-calendar");

            assertTrue(createdCalendar != null);
            assertTrue(createdCalendar.getSummary().equals(originalCalendar.getSummary()));

            upsertOnTestRunMessage("id", createdCalendar.getId());

            Calendar returnedCalendar = runFlowAndGetPayload("get-calendar-by-id");
            assertTrue(returnedCalendar != null);
            assertTrue(returnedCalendar.getId().equals(createdCalendar.getId()));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {

        runFlowAndGetPayload("delete-calendar");

    }

}
