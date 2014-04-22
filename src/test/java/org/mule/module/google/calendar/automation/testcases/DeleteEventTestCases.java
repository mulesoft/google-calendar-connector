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
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DeleteEventTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("deleteEvent");

        // Place the returned event and its ID into testObjects for later access
        Event returnedEvent = runFlowAndGetPayload("insert-event");
        upsertOnTestRunMessage("event", returnedEvent);
        upsertOnTestRunMessage("eventId", returnedEvent.getId());

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testDeleteEvent() {
        try {
            // Delete the event
            runFlowAndGetPayload("delete-event");
            // Try and look for the event after cancelling it
            Event returnedEvent = runFlowAndGetPayload("get-event-by-id");
            assertTrue(returnedEvent.getStatus().equals("cancelled"));

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
