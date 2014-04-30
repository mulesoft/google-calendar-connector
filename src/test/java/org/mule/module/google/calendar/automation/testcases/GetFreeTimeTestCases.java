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

import com.google.api.services.calendar.model.FreeBusyCalendar;
import com.google.api.services.calendar.model.TimePeriod;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.Event;
import org.mule.module.google.calendar.model.FreeBusy;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetFreeTimeTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("getFreeTime");

        Calendar calendar = runFlowAndGetPayload("get-calendar-by-id");
        upsertOnTestRunMessage("calendarId", calendar.getId());

        Event event = insertEvent((Event) getTestRunMessageValue("event"));

        upsertOnTestRunMessage("eventId", event.getId());
    }

    @Category({RegressionTests.class})
    @Test
    public void testGetFreeTime() {
        try {
            String calendarId = getTestRunMessageValue("calendarId");
            Event event = getTestRunMessageValue("event");

            List<String> calendarIds = new ArrayList<String>();
            calendarIds.add(calendarId);

            upsertOnTestRunMessage("ids", calendarIds);

            FreeBusy freeBusy = runFlowAndGetPayload("get-free-time");

            // We should only be working with the calendar created specifically for this test
            FreeBusyCalendar freeBusyCalendar = freeBusy.getCalendars().get(calendarId);

            List<TimePeriod> busyTimePeriods = freeBusyCalendar.getBusy();
            assertTrue(busyTimePeriods.size() == 1);

            TimePeriod busyTimePeriod = busyTimePeriods.get(0);
            assertTrue(busyTimePeriod.getStart().equals(event.getStart().getDateTime().getWrapped()));
            assertTrue(busyTimePeriod.getEnd().equals(event.getEnd().getDateTime().getWrapped()));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("delete-event");
    }

}
