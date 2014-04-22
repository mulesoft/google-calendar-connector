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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.google.calendar.model.AclRule;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.*;

public class InsertAclRuleTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("insertAclRule");
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testInsertAclRule() {
        try {

            AclRule returnedAclRule = runFlowAndGetPayload("insert-acl-rule");
            String ruleId = returnedAclRule.getId();

            upsertOnTestRunMessage("ruleId", ruleId);

            AclRule afterProc = runFlowAndGetPayload("get-acl-rule-by-id");
            String ruleIdAfter = afterProc.getId();

            assertEquals(ruleId, ruleIdAfter);
            assertTrue(EqualsBuilder.reflectionEquals(returnedAclRule, afterProc));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("delete-acl-rule");
    }
}
