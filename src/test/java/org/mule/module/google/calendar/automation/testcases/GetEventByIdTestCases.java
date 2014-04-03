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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetEventByIdTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        try {
            initializeTestRunMessage("getEventById");

            // Insert calendar and get reference to retrieved calendar
            Calendar calendar = runFlowAndGetPayload("create-calendar");

            // Replace old calendar instance with new instance
            upsertOnTestRunMessage("calendarRef", calendar);
            upsertOnTestRunMessage("calendarId", calendar.getId());

            // Place the returned event and its ID into testObjects for later access
            Event returnedEvent = runFlowAndGetPayload("insert-event");
            upsertOnTestRunMessage("event", returnedEvent);
            upsertOnTestRunMessage("eventId", returnedEvent.getId());
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetEventById() {
        try {
            Event originalEvent = getTestRunMessageValue("event");
            // No exceptions thrown means that the event was found
            // Perform assertions. Check that the returned event has the same id
            Event returnedEvent = runFlowAndGetPayload("get-event-by-id");
            assertTrue(returnedEvent.getId().equals(originalEvent.getId()));
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
