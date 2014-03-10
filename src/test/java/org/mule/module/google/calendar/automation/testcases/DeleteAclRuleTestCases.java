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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.model.AclRule;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.modules.tests.ConnectorTestUtils;


public class DeleteAclRuleTestCases extends GoogleCalendarTestParent {
	
	@Before
	public void setUp() throws Exception {

			loadTestRunMessage("deleteAclRule");
			
			// Insert calendar and get reference to retrieved calendar
			Calendar calendar = runFlowAndGetPayload("create-calendar");
			
			// Replace old calendar instance with new instance
			upsertOnTestRunMessage("calendarRef", calendar);
			upsertOnTestRunMessage("calendarId", calendar.getId());
			
			// Insert the ACL rule
			AclRule aclRule = runFlowAndGetPayload("insert-acl-rule");
						
			upsertOnTestRunMessage("aclRule", aclRule);	
			upsertOnTestRunMessage("ruleId", aclRule.getId());

	}
	
	@Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testDeleteAclRule() {
		try {
			
			runFlowAndGetPayload("delete-acl-rule");
			AclRule afterDel = runFlowAndGetPayload("get-acl-rule-by-id");
			String ruleIdAfter = afterDel.getId();
			
			assertEquals(getTestRunMessageValue("ruleId").toString(),ruleIdAfter);
			assertFalse(EqualsBuilder.reflectionEquals(getTestRunMessageValue("aclRule"), afterDel));
			assertTrue(afterDel.getRole().equals("none"));
				
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
