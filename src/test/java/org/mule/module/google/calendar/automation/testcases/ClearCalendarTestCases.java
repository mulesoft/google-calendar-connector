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


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.automation.CalendarUtils;
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;
import org.mule.streaming.ConsumerIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class ClearCalendarTestCases extends GoogleCalendarTestParent {

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("clearCalendar");

        Event sampleEvent = getTestRunMessageValue("sampleEvent");
        Integer numEvents = getTestRunMessageValue("numEvents");

        // Instantiate the event objects
        List<Event> events = new ArrayList<Event>();
        for (int i = 0; i < numEvents; i++) {
            events.add(CalendarUtils.getEvent(sampleEvent.getSummary(), sampleEvent.getStart(), sampleEvent.getEnd()));
        }

        // Batch insert the events
        BatchResponse<Event> batchResponse = insertEvents(events);
        List<Event> successfulEvents = batchResponse.getSuccessful();

        upsertOnTestRunMessage("events", successfulEvents);

    }

    @Category({RegressionTests.class})
    @Test
    public void testClearCalendar() {
        try {
            // Clear the calendar
            runFlowAndGetPayload("clear-calendar");

            // get-all-events returns a ConsumerIterator that can only be consumed as an iterator
            // Therefore, if the iterator has any element, it means that at least one event has been fetched.
            Iterator<Event> returnedEvents = runFlowAndGetPayload("get-all-events");

            // Assert that no events are returned
            assertFalse(returnedEvents.hasNext());

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}

