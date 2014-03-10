/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar.model;

import java.util.Map;

import org.mule.modules.google.api.model.BaseWrapper;


/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class ExtendedProperties extends BaseWrapper<com.google.api.services.calendar.model.Event.ExtendedProperties> {

	public ExtendedProperties() {
		this(new com.google.api.services.calendar.model.Event.ExtendedProperties());
	}
	
	public ExtendedProperties(com.google.api.services.calendar.model.Event.ExtendedProperties wrapped) {
		super(wrapped);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}

	public Map<String, String> getShared() {
		return wrapped.getShared();
	}

	public void setShared(Map<String, String> shared) {
		wrapped.setShared(shared);
	}

	public Map<String, String> getPrivate() {
		return wrapped.getPrivate();
	}

	public void setPrivate(Map<String, String> calendarPrivate) {
		wrapped.setPrivate(calendarPrivate);
	}
	
}
