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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.module.google.calendar.model.Event;
import org.mule.modules.tests.ConnectorTestUtils;

public class GetInstancesTestCases extends GoogleCalendarTestParent {

	@Before
	public void setUp() throws Exception {

			loadTestRunMessage("getInstances");

			Calendar calendar = runFlowAndGetPayload("create-calendar");
			
			upsertOnTestRunMessage("calendarRef", calendar);
			upsertOnTestRunMessage("calendarId", calendar.getId());
			
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
//			List<Event> returnedEvent = runFlowAndGetPayload("get-instances");
//			
//			for (Event event : returnedEvent) {
//				assertEquals(event.getId(), eventId);
//			}
			
			//  getInstances returns a ConsumerIterator that
			// can only be consumed as an iterator
			Iterator<Event> returnedEvent = runFlowAndGetPayload("get-instances");
			
			while(returnedEvent.hasNext()){
				Event event = returnedEvent.next();
				assertEquals(event.getId(), eventId);
			}
				
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
