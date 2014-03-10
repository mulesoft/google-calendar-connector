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

import org.mule.modules.google.api.model.BaseWrapper;


/**
 * Wrapper for {@link com.google.api.services.calendar.model.AclRule.Scope}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Scope extends BaseWrapper<com.google.api.services.calendar.model.AclRule.Scope> {

	public Scope() {
		this(new com.google.api.services.calendar.model.AclRule.Scope());
	}
	
	public Scope(com.google.api.services.calendar.model.AclRule.Scope wrapped) {
		super(wrapped);
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public String getType() {
		return wrapped.getType();
	}

	public String getValue() {
		return wrapped.getValue();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setType(String type) {
		wrapped.setType(type);
	}

	public void setValue(String value) {
		wrapped.setValue(value);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
