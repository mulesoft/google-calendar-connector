/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.model.batch;

import org.mule.module.google.calendar.model.Event;
import org.mule.modules.google.api.client.batch.BatchCallback;


/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class EventBatchCallback extends BatchCallback<Event, com.google.api.services.calendar.model.Event> {
	
	/**
	 * @see org.mule.modules.google.api.client.batch.BatchCallback#typeToWrapper(java.lang.Object)
	 */
	@Override
	protected Event typeToWrapper(com.google.api.services.calendar.model.Event object) {
		return new Event(object);
	}

}
