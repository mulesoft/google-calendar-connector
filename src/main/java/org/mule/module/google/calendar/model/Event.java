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

import java.util.List;

import org.mule.modules.google.api.datetime.DateTime;
import org.mule.modules.google.api.model.BaseWrapper;

import com.google.api.services.calendar.model.EventAttendee;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.Event}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Event extends BaseWrapper<com.google.api.services.calendar.model.Event> {

	public Event() {
		this(new com.google.api.services.calendar.model.Event());
	}
	
	public Event(com.google.api.services.calendar.model.Event wrapped) {
		super(wrapped);
		if (wrapped.getExtendedProperties() == null) {
			this.setExtendedProperties(new ExtendedProperties());
		} else {
			this.setExtendedProperties(new ExtendedProperties(wrapped.getExtendedProperties()));
		}
	}
	
	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public org.mule.module.google.calendar.model.Creator getCreator() {
		return new org.mule.module.google.calendar.model.Creator(wrapped.getCreator());
	}

	public org.mule.module.google.calendar.model.Organizer getOrganizer() {
		return new org.mule.module.google.calendar.model.Organizer(wrapped.getOrganizer());
	}

	public String getId() {
		return wrapped.getId();
	}

	public List<org.mule.module.google.calendar.model.EventAttendee> getAttendees() {
		return org.mule.module.google.calendar.model.EventAttendee.valueOf(wrapped.getAttendees(), org.mule.module.google.calendar.model.EventAttendee.class);
	}

	public String getHtmlLink() {
		return wrapped.getHtmlLink();
	}

	public List<String> getRecurrence() {
		return wrapped.getRecurrence();
	}

	public org.mule.module.google.calendar.model.EventDateTime getStart() {
		return new org.mule.module.google.calendar.model.EventDateTime(wrapped.getStart());
	}

	public String getLocation() {
		return wrapped.getLocation();
	}

	public String getRecurringEventId() {
		return wrapped.getRecurringEventId();
	}

	public org.mule.module.google.calendar.model.EventDateTime getOriginalStartTime() {
		return new org.mule.module.google.calendar.model.EventDateTime(wrapped.getOriginalStartTime());
	}

	public String getStatus() {
		return wrapped.getStatus();
	}

	public DateTime getUpdated() {
		return new DateTime(wrapped.getUpdated());
	}

	public String getDescription() {
		return wrapped.getDescription();
	}

	public String getICalUID() {
		return wrapped.getICalUID();
	}

	public Integer getSequence() {
		return wrapped.getSequence();
	}

	public String getVisibility() {
		return wrapped.getVisibility();
	}

	public Boolean getGuestsCanModify() {
		return wrapped.getGuestsCanModify();
	}

	public org.mule.module.google.calendar.model.EventDateTime getEnd() {
		return new org.mule.module.google.calendar.model.EventDateTime(wrapped.getEnd());
	}

	public Boolean getAttendeesOmitted() {
		return wrapped.getAttendeesOmitted();
	}

	public DateTime getCreated() {
		return new DateTime(wrapped.getCreated());
	}

	public String getColorId() {
		return wrapped.getColorId();
	}

	public Boolean getAnyoneCanAddSelf() {
		return wrapped.getAnyoneCanAddSelf();
	}

	public org.mule.module.google.calendar.model.Reminders getReminders() {
		return new org.mule.module.google.calendar.model.Reminders(wrapped.getReminders());
	}

	public Boolean getGuestsCanSeeOtherGuests() {
		return wrapped.getGuestsCanSeeOtherGuests();
	}

	public String getSummary() {
		return wrapped.getSummary();
	}

	public Boolean getGuestsCanInviteOthers() {
		return wrapped.getGuestsCanInviteOthers();
	}

	public String getTransparency() {
		return wrapped.getTransparency();
	}

	public Boolean getPrivateCopy() {
		return wrapped.getPrivateCopy();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setCreator(org.mule.module.google.calendar.model.Creator creator) {
		wrapped.setCreator(creator.wrapped());
	}

	public void setOrganizer(org.mule.module.google.calendar.model.Organizer organizer) {
		wrapped.setOrganizer(organizer.wrapped());
	}

	public void setId(String id) {
		wrapped.setId(id);
	}

	public void setAttendees(List<org.mule.module.google.calendar.model.EventAttendee> attendees) {
		wrapped.setAttendees(org.mule.module.google.calendar.model.EventAttendee.unwrapp(attendees, EventAttendee.class));
	}

	public void setHtmlLink(String htmlLink) {
		wrapped.setHtmlLink(htmlLink);
	}

	public void setRecurrence(List<String> recurrence) {
		wrapped.setRecurrence(recurrence);
	}

	public void setStart(org.mule.module.google.calendar.model.EventDateTime start) {
		wrapped.setStart(start.wrapped());
	}

	public void setEtag(String etag) {
		wrapped.setEtag(etag);
	}

	public void setLocation(String location) {
		wrapped.setLocation(location);
	}

	public void setRecurringEventId(String recurringEventId) {
		wrapped.setRecurringEventId(recurringEventId);
	}

	public void setOriginalStartTime(org.mule.module.google.calendar.model.EventDateTime originalStartTime) {
		wrapped.setOriginalStartTime(originalStartTime.wrapped());
	}

	public void setStatus(String status) {
		wrapped.setStatus(status);
	}

	public void setUpdated(DateTime updated) {
		wrapped.setUpdated(updated.getWrapped());
	}

	public void setDescription(String description) {
		wrapped.setDescription(description);
	}

	public void setICalUID(String iCalUID) {
		wrapped.setICalUID(iCalUID);
	}

	public void setSequence(Integer sequence) {
		wrapped.setSequence(sequence);
	}

	public void setVisibility(String visibility) {
		wrapped.setVisibility(visibility);
	}

	public void setGuestsCanModify(Boolean guestsCanModify) {
		wrapped.setGuestsCanModify(guestsCanModify);
	}

	public void setEnd(org.mule.module.google.calendar.model.EventDateTime end) {
		wrapped.setEnd(end.wrapped());
	}

	public com.google.api.services.calendar.model.Event setAttendeesOmitted(Boolean attendeesOmitted) {
		return wrapped.setAttendeesOmitted(attendeesOmitted);
	}

	public void setCreated(DateTime created) {
		wrapped.setCreated(created.getWrapped());
	}

	public void setColorId(String colorId) {
		wrapped.setColorId(colorId);
	}

	public void setAnyoneCanAddSelf(Boolean anyoneCanAddSelf) {
		wrapped.setAnyoneCanAddSelf(anyoneCanAddSelf);
	}

	public void setReminders(org.mule.module.google.calendar.model.Reminders reminders) {
		wrapped.setReminders(reminders.wrapped());
	}

	public void setGuestsCanSeeOtherGuests(Boolean guestsCanSeeOtherGuests) {
		wrapped.setGuestsCanSeeOtherGuests(guestsCanSeeOtherGuests);
	}

	public void setSummary(String summary) {
		wrapped.setSummary(summary);
	}

	public void setGuestsCanInviteOthers(Boolean guestsCanInviteOthers) {
		wrapped.setGuestsCanInviteOthers(guestsCanInviteOthers);
	}

	public void setTransparency(String transparency) {
		wrapped.setTransparency(transparency);
	}

	public void setPrivateCopy(Boolean privateCopy) {
		wrapped.setPrivateCopy(privateCopy);
	}
	
	public ExtendedProperties getExtendedProperties() {
		return new ExtendedProperties(this.wrapped.getExtendedProperties());
	}
	
	public void setExtendedProperties(ExtendedProperties extended) {
		this.wrapped.setExtendedProperties(extended.wrapped());
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
