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
import org.mule.module.google.calendar.automation.testcases.BatchDeleteCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.BatchDeleteEventTestCases;
import org.mule.module.google.calendar.automation.testcases.BatchInsertCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.BatchInsertEventTestCases;
import org.mule.module.google.calendar.automation.testcases.BatchUpdateCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.BatchUpdateEventTestCases;
import org.mule.module.google.calendar.automation.testcases.ClearCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.CreateCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.DeleteAclRuleTestCases;
import org.mule.module.google.calendar.automation.testcases.DeleteCalendarListTestCases;
import org.mule.module.google.calendar.automation.testcases.DeleteCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.DeleteEventTestCases;
import org.mule.module.google.calendar.automation.testcases.GetAclRuleByIdTestCases;
import org.mule.module.google.calendar.automation.testcases.GetAllAclRulesTestCases;
import org.mule.module.google.calendar.automation.testcases.GetCalendarByIdTestCases;
import org.mule.module.google.calendar.automation.testcases.GetCalendarListByIdTestCases;
import org.mule.module.google.calendar.automation.testcases.GetCalendarListTestCases;
import org.mule.module.google.calendar.automation.testcases.GetEventByIdTestCases;
import org.mule.module.google.calendar.automation.testcases.GetEventsTestCases;
import org.mule.module.google.calendar.automation.testcases.GetFreeTimeTestCases;
import org.mule.module.google.calendar.automation.testcases.GetInstancesTestCases;
import org.mule.module.google.calendar.automation.testcases.ImportEventTestCases;
import org.mule.module.google.calendar.automation.testcases.InsertAclRuleTestCases;
import org.mule.module.google.calendar.automation.testcases.InsertEventTestCases;
import org.mule.module.google.calendar.automation.testcases.MoveEventTestCases;
import org.mule.module.google.calendar.automation.testcases.QuickAddEventTestCases;
import org.mule.module.google.calendar.automation.testcases.SmokeTests;
import org.mule.module.google.calendar.automation.testcases.UpdateAclRuleTestCases;
import org.mule.module.google.calendar.automation.testcases.UpdateCalendarListTestCases;
import org.mule.module.google.calendar.automation.testcases.UpdateCalendarTestCases;
import org.mule.module.google.calendar.automation.testcases.UpdateEventTestCases;

@RunWith(Categories.class)
@IncludeCategory(SmokeTests.class)
@SuiteClasses({ BatchDeleteCalendarTestCases.class,
		BatchDeleteEventTestCases.class, 
		BatchInsertCalendarTestCases.class,
		BatchInsertEventTestCases.class,
		CreateCalendarTestCases.class, 
		DeleteAclRuleTestCases.class,
		DeleteCalendarTestCases.class, 
		DeleteEventTestCases.class,
		GetAclRuleByIdTestCases.class, 
		GetCalendarByIdTestCases.class,
		GetCalendarListByIdTestCases.class, 
		GetCalendarListTestCases.class,
		GetEventByIdTestCases.class, 
		GetEventsTestCases.class,
		InsertAclRuleTestCases.class, 
		InsertEventTestCases.class})
public class SmokeTestSuite {
}
