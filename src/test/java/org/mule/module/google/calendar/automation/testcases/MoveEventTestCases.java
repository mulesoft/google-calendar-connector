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
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MoveEventTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("moveEvent");

        // Insert the target calendar
        upsertOnTestRunMessage("calendarRef", getTestRunMessageValue("targetCalendarRef"));
        Calendar targetCalendar = runFlowAndGetPayload("create-calendar");

        // Place updated calendars and their IDs into testObjects
        upsertOnTestRunMessage("targetCalendarRef", targetCalendar);
        upsertOnTestRunMessage("targetCalendarId", targetCalendar.getId());

        Event event = insertEvent((Event) getTestRunMessageValue("event"));
        upsertOnTestRunMessage("event", event);
        upsertOnTestRunMessage("eventId", event.getId());

    }

    @Category({RegressionTests.class})
    @Test
    public void testMoveEvent() {
        try {
            Calendar targetCalendar = getTestRunMessageValue("targetCalendarRef");

            // Move the event from the source calendar to the target calendar
            Event movedEvent = runFlowAndGetPayload("move-event");

            // Perform assertions on the returned event
            assertTrue(movedEvent.getStatus().equals("cancelled")); // Default return status when moving an event
            assertTrue(movedEvent.getOrganizer().getDisplayName().equals(targetCalendar.getSummary()));
            assertTrue(movedEvent.getOrganizer().getEmail().equals(targetCalendar.getId()));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        try{
            // Clean the event on the source calendar if move-event fails.
            runFlowAndGetPayload("delete-event");
        } catch(Exception e){
            // Cleans the event on the source in case of error during execution. if no event found simply ignore.
        }
        Calendar targetCalendar = getTestRunMessageValue("targetCalendarRef");
        upsertOnTestRunMessage("calendarId", targetCalendar.getId());

        runFlowAndGetPayload("delete-calendar");
    }
}
