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
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateEventTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("updateEvent");

        // Insert the calendar
        Calendar calendar = runFlowAndGetPayload("create-calendar");

        // Update test objects
        upsertOnTestRunMessage("calendar", calendar);
        upsertOnTestRunMessage("calendarId", calendar.getId());

        String beforeText = getTestRunMessageValue("summaryBefore");
        upsertOnTestRunMessage("text", beforeText);

        Event event = runFlowAndGetPayload("quick-add-event");
        upsertOnTestRunMessage("event", event);
        upsertOnTestRunMessage("eventId", event.getId());

    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateEvent() {
        try {
            String summaryAfter = getTestRunMessageValue("summaryAfter");
            Event event = getTestRunMessageValue("event");
            event.setSummary(summaryAfter);
            upsertOnTestRunMessage("calendarEventRef", event);

            Event afterEvent = runFlowAndGetPayload("update-event");
            String afterText = afterEvent.getSummary();
            assertEquals(afterText, summaryAfter);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        String calendarId = getTestRunMessageValue("calendarId");
        deleteCalendar(calendarId);

    }

}
