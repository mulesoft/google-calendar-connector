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
import org.mule.module.google.calendar.ScopeRole;
import org.mule.module.google.calendar.model.AclRule;
import org.mule.module.google.calendar.model.Calendar;
import org.mule.modules.tests.ConnectorTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateAclRuleTestCases extends GoogleCalendarTestParent {

    @Before
    public void setUp() throws Exception {
        initializeTestRunMessage("updateAclRule");

        ScopeRole roleBefore = getTestRunMessageValue("roleBefore");
        upsertOnTestRunMessage("role", roleBefore.name());

        // Insert the ACL rule

        AclRule returnedAclRule = runFlowAndGetPayload("insert-acl-rule");
        upsertOnTestRunMessage("aclRule", returnedAclRule);
        upsertOnTestRunMessage("ruleId", returnedAclRule.getId());
    }

    @Category({RegressionTests.class})
    @Test
    public void testUpdateAclRule() {
        try {
            ScopeRole roleAfter = getTestRunMessageValue("roleAfter");

            AclRule aclRule = getTestRunMessageValue("aclRule");
            aclRule.setRole(roleAfter.name());
            upsertOnTestRunMessage("aclRuleRef", aclRule);

            aclRule = runFlowAndGetPayload("update-acl-rule");
            String roleAfterUpdate = aclRule.getRole();
            assertEquals(roleAfter.name(), roleAfterUpdate);
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
       runFlowAndGetPayload("delete-acl-rule");
    }
}
