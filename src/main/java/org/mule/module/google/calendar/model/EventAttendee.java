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
 * Wrapper for {@link com.google.api.services.calendar.model.EventAttendee}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class EventAttendee extends BaseWrapper<com.google.api.services.calendar.model.EventAttendee> {
	
	public EventAttendee() {
		this(new com.google.api.services.calendar.model.EventAttendee());
	}
	
	public EventAttendee(com.google.api.services.calendar.model.EventAttendee wrapped) {
		super(wrapped);
	}
	
	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public String getComment() {
		return wrapped.getComment();
	}

	public String getDisplayName() {
		return wrapped.getDisplayName();
	}

	public Boolean getSelf() {
		return wrapped.getSelf();
	}

	public Integer getAdditionalGuests() {
		return wrapped.getAdditionalGuests();
	}

	public Boolean getResource() {
		return wrapped.getResource();
	}

	public Boolean getOrganizer() {
		return wrapped.getOrganizer();
	}

	public Boolean getOptional() {
		return wrapped.getOptional();
	}

	public String getEmail() {
		return wrapped.getEmail();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setComment(String comment) {
		wrapped.setComment(comment);
	}

	public void setDisplayName(String displayName) {
		wrapped.setDisplayName(displayName);
	}

	public void setSelf(Boolean self) {
		wrapped.setSelf(self);
	}

	public void setAdditionalGuests(Integer additionalGuests) {
		wrapped.setAdditionalGuests(additionalGuests);
	}

	public void setResource(Boolean resource) {
		wrapped.setResource(resource);
	}

	public void setOrganizer(Boolean organizer) {
		wrapped.setOrganizer(organizer);
	}

	public void setOptional(Boolean optional) {
		wrapped.setOptional(optional);
	}

	public void setEmail(String email) {
		wrapped.setEmail(email);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
