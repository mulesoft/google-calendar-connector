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

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.automation.CalendarUtils;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.CalendarList;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestUtils;
import org.mule.streaming.ConsumerIterator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetCalendarListTestCases extends GoogleCalendarTestParent {

    protected List<Calendar> insertedCalendars = new ArrayList<Calendar>();

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getCalendarList");

        Integer numCalendars = getTestRunMessageValue("numCalendars");

        // Create calendar instances
        List<Calendar> calendars = new ArrayList<Calendar>();
        for (int i = 0; i < numCalendars; i++) {
            calendars.add(CalendarUtils.getCalendar("This is a title"));
        }

        // Insert calendars and record their IDs
        BatchResponse<Calendar> response = insertCalendars(calendars);

        for (Calendar calendar : response.getSuccessful()) {
            insertedCalendars.add(calendar);
        }

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetCalendarList() {
        try {

            ConsumerIterator<CalendarList> consumerIterator = runFlowAndGetPayload("get-calendar-list");
            List<CalendarList> calendarList = Lists.newArrayList(consumerIterator);
            for (Calendar insertedCalendar : insertedCalendars) {
                assertTrue(CalendarUtils.isCalendarInList(calendarList, insertedCalendar));
            }

        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {

        // Delete the calendars
        deleteCalendars(insertedCalendars);

    }
}
