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

import java.io.IOException;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.Event.Organizer}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Organizer extends BaseWrapper<com.google.api.services.calendar.model.Event.Organizer> {

	public Organizer() {
		this(new com.google.api.services.calendar.model.Event.Organizer());
	}
	
	public Organizer(com.google.api.services.calendar.model.Event.Organizer wrapped) {
		super(wrapped);
	}

	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public Boolean getSelf() {
		return wrapped.getSelf();
	}

	public String getDisplayName() {
		return wrapped.getDisplayName();
	}

	public String getEmail() {
		return wrapped.getEmail();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public com.google.api.services.calendar.model.Event.Organizer setSelf(Boolean self) {
		return wrapped.setSelf(self);
	}

	public void setDisplayName(String displayName) {
		wrapped.setDisplayName(displayName);
	}

	public void setEmail(String email) {
		wrapped.setEmail(email);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() throws IOException{
		return wrapped.toPrettyString();
	}
}
