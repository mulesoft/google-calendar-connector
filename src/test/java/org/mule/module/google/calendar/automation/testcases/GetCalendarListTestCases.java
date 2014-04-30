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

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetCalendarListTestCases extends GoogleCalendarTestParent {

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetCalendarList() {
        try {
            // get-calendar-list returns a ConsumerIterator that can only be consumed as an iterator
            // Therefore, if the iterator has any element, it means that at least one calendar has been fetched.
            Iterator<CalendarList> returnedCalendars = runFlowAndGetPayload("get-calendar-list");

            // Assert that atleast one (expected default primary) calendar is returned
            assertTrue(returnedCalendars.hasNext());

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
}
