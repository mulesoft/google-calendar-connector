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
 * Wrapper for {@link com.google.api.services.calendar.model.AclRule}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class AclRule extends BaseWrapper<com.google.api.services.calendar.model.AclRule> {

	public AclRule() {
		this(new com.google.api.services.calendar.model.AclRule());
	}
	
	public AclRule(com.google.api.services.calendar.model.AclRule wrapped) {
		super(wrapped);
	}

	public Scope getScope() {
		return new Scope(wrapped.getScope());
	}

	public String getRole() {
		return wrapped.getRole();
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public String getId() {
		return wrapped.getId();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public com.google.api.services.calendar.model.AclRule setScope(Scope scope) {
		return wrapped.setScope(scope.wrapped());
	}

	public com.google.api.services.calendar.model.AclRule setRole(String role) {
		return wrapped.setRole(role);
	}

	public com.google.api.services.calendar.model.AclRule setId(String id) {
		return wrapped.setId(id);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}

}
