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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.*;

public class QuickAddEventTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("quickAddEvent");

        // Insert calendar and get reference to retrieved calendar
        Calendar calendar = runFlowAndGetPayload("create-calendar");

        // Replace old calendar instance with new instance
        upsertOnTestRunMessage("calendarRef", calendar);
        upsertOnTestRunMessage("calendarId", calendar.getId());
    }

    @Category({RegressionTests.class})
    @Test
    public void testQuickAddEvent() {
        try {
            String text = getTestRunMessageValue("text");

            // Perform assertions on the event
            Event createdEvent = runFlowAndGetPayload("quick-add-event");
            assertNotNull(createdEvent);
            assertTrue(createdEvent.getSummary().equals(text));
            assertTrue(createdEvent.getStatus().equals("confirmed"));

            upsertOnTestRunMessage("event", createdEvent);
            upsertOnTestRunMessage("eventId", createdEvent.getId());

            // Verify that the event was added on Google Calendars
            Event returnedEvent = runFlowAndGetPayload("get-event-by-id");

            // Assert that the created event and the returned are identical
            assertTrue(EqualsBuilder.reflectionEquals(createdEvent, returnedEvent));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        // Drop the calendar
        String calendarId = getTestRunMessageValue("calendarId");
        deleteCalendar(calendarId);

    }

}
