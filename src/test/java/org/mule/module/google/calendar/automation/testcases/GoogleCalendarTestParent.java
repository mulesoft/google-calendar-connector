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
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.mule.api.config.MuleProperties;
import org.mule.api.store.ObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.common.security.oauth.OAuthState;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.google.api.client.batch.BatchResponse;
import org.mule.modules.tests.ConnectorTestCase;

import java.util.List;

public class GoogleCalendarTestParent extends ConnectorTestCase {

    // Set global timeout of tests to 10minutes
    @Rule
    public Timeout globalTimeout = new Timeout(600000);


    @Before
    public void init() throws ObjectStoreException, Exception {
        ObjectStore objectStore = muleContext.getRegistry().lookupObject(MuleProperties.DEFAULT_USER_OBJECT_STORE_NAME);
        objectStore.store("accessTokenId", (OAuthState) getBeanFromContext("connectorOAuthState"));
    }

    protected <T> T runFlowAndGetPayload(String flowName) throws Exception {
        T messagePayload = super.runFlowAndGetPayload(flowName);
        // Slow down the calls to api to avoid Calendar usage limit exceeded.
        Thread.sleep(10000);
        return messagePayload;
    }

    protected <T> T runFlowAndGetPayload(String flowName, String beanId) throws Exception {
        T messagePayload = super.runFlowAndGetPayload(flowName, beanId);
        // Slow down the calls to api to avoid Calendar usage limit exceeded.
        Thread.sleep(10000);
        return messagePayload;
    }

	/*
     * Helper methods below
	 */

    protected BatchResponse<Calendar> insertCalendars(List<Calendar> calendars) throws Exception {
        upsertOnTestRunMessage("calendarsRef", calendars);
        return runFlowAndGetPayload("batch-insert-calendar");
    }

    protected void deleteCalendars(List<Calendar> calendars) throws Exception {
        upsertOnTestRunMessage("calendarsRef", calendars);
        runFlowAndGetPayload("batch-delete-calendar");
    }

    protected Event insertEvent(Event event) throws Exception {
        upsertOnTestRunMessage("calendarEventRef", event);
        return runFlowAndGetPayload("insert-event");
    }

    protected BatchResponse<Event> insertEvents(List<Event> events) throws Exception {
        upsertOnTestRunMessage("calendarEventsRef", events);
        return runFlowAndGetPayload("batch-insert-event");
    }

    protected void deleteEvents(List<Event> events) throws Exception {
        upsertOnTestRunMessage("calendarEventsRef", events);
        runFlowAndGetPayload("batch-delete-event");
    }
}
