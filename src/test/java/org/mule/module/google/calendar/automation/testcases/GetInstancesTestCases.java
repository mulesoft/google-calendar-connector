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
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetInstancesTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("getInstances");

        // Insert the event
        Event returnedEvent = runFlowAndGetPayload("insert-event");
        upsertOnTestRunMessage("event", returnedEvent);
        upsertOnTestRunMessage("eventId", returnedEvent.getId());
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetInstances() {
        try {

            String eventId = getTestRunMessageValue("eventId");

            // get-instances returns a ConsumerIterator that can only be consumed as an iterator
            // Therefore, if the iterator has any element, it means that at least one event has been fetched.
            Iterator<Event> returnedEvent = runFlowAndGetPayload("get-instances");

            while (returnedEvent.hasNext()) {
                Event event = returnedEvent.next();
                assertEquals(event.getId(), eventId);
            }

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }


    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("delete-event");
    }
}
