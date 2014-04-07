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
import org.mule.module.google.calendar.model.AclRule;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetAclRuleByIdTestCases extends GoogleCalendarTestParent {


    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("getAclRuleById");

        // Insert calendar and get reference to retrieved calendar
        Calendar calendar = runFlowAndGetPayload("create-calendar");

        // Replace old calendar instance with new instance
        upsertOnTestRunMessage("calendarRef", calendar);
        upsertOnTestRunMessage("calendarId", calendar.getId());

        // Insert the ACL rule
        AclRule returnedAclRule = runFlowAndGetPayload("insert-acl-rule");
        upsertOnTestRunMessage("aclRule", returnedAclRule);
        upsertOnTestRunMessage("ruleId", returnedAclRule.getId());

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testGetAclRuleById() {
        try {
            String ruleIdBefore = getTestRunMessageValue("ruleId");

            AclRule afterProc = runFlowAndGetPayload("get-acl-rule-by-id");
            String ruleIdAfter = afterProc.getId();

            assertEquals(ruleIdBefore, ruleIdAfter);

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
