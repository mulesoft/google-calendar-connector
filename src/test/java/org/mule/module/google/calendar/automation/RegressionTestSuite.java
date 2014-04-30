/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.automation;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.module.google.calendar.automation.testcases.*;

@RunWith(Categories.class)
@IncludeCategory(RegressionTests.class)
@SuiteClasses({
        BatchDeleteCalendarTestCases.class, BatchDeleteEventTestCases.class,
        BatchInsertCalendarTestCases.class, BatchInsertEventTestCases.class,
        BatchUpdateCalendarTestCases.class, BatchUpdateEventTestCases.class,
        ClearCalendarTestCases.class, DeleteAclRuleTestCases.class,
        DeleteCalendarListTestCases.class, DeleteCalendarTestCases.class,
        DeleteEventTestCases.class, GetAclRuleByIdTestCases.class,
        GetAllAclRulesTestCases.class, GetCalendarByIdTestCases.class,
        GetCalendarListByIdTestCases.class, GetCalendarListTestCases.class,
        GetEventByIdTestCases.class, GetEventsTestCases.class,
        GetFreeTimeTestCases.class, GetInstancesTestCases.class,
        ImportEventTestCases.class, InsertAclRuleTestCases.class,
        InsertEventTestCases.class, MoveEventTestCases.class,
        QuickAddEventTestCases.class, UpdateAclRuleTestCases.class,
        UpdateCalendarListTestCases.class, UpdateCalendarTestCases.class,
        UpdateEventTestCases.class, CreateCalendarTestCases.class
})
public class RegressionTestSuite {

}
