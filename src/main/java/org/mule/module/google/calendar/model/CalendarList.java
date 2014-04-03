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

import java.io.IOException;
import java.util.List;

import org.mule.modules.google.api.model.BaseWrapper;

import com.google.api.services.calendar.model.CalendarListEntry;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.CalendarListEntry}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class CalendarList extends BaseWrapper<CalendarListEntry> {

	public CalendarList() {
		this(new com.google.api.services.calendar.model.CalendarListEntry());
	}
	
	public CalendarList(com.google.api.services.calendar.model.CalendarListEntry wrapped) {
		super(wrapped);
	}

	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public List<EventReminder> getDefaultReminders() {
		return EventReminder.valueOf(wrapped.getDefaultReminders(), EventReminder.class);
	}

	public String getDescription() {
		return wrapped.getDescription();
	}

	public String getColorId() {
		return wrapped.getColorId();
	}

	public Boolean getSelected() {
		return wrapped.getSelected();
	}

	public String getSummary() {
		return wrapped.getSummary();
	}

	public String getLocation() {
		return wrapped.getLocation();
	}

	public String getSummaryOverride() {
		return wrapped.getSummaryOverride();
	}

	public String getTimeZone() {
		return wrapped.getTimeZone();
	}

	public Boolean getHidden() {
		return wrapped.getHidden();
	}

	public String getAccessRole() {
		return wrapped.getAccessRole();
	}

	public String getId() {
		return wrapped.getId();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setDescription(String description) {
		wrapped.setDescription(description);
	}

	public CalendarListEntry setColorId(String colorId) {
		return wrapped.setColorId(colorId);
	}

	public void setSelected(Boolean selected) {
		wrapped.setSelected(selected);
	}

	public void setSummary(String summary) {
		wrapped.setSummary(summary);
	}

	public void setLocation(String location) {
		wrapped.setLocation(location);
	}

	public void setSummaryOverride(String summaryOverride) {
		wrapped.setSummaryOverride(summaryOverride);
	}

	public void setTimeZone(String timeZone) {
		wrapped.setTimeZone(timeZone);
	}

	public void setHidden(Boolean hidden) {
		wrapped.setHidden(hidden);
	}

	public void setAccessRole(String accessRole) {
		wrapped.setAccessRole(accessRole);
	}

	public void setId(String id) {
		wrapped.setId(id);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() throws IOException{
		return wrapped.toPrettyString();
	}

    public CalendarListEntry setNotificationSettings(CalendarListEntry.NotificationSettings notificationSettings) {
        return wrapped.setNotificationSettings(notificationSettings);
    }

    public CalendarListEntry.NotificationSettings getNotificationSettings() {
        return wrapped.getNotificationSettings();
    }

    public String getKind() {
        return wrapped.getKind();
    }

    public String getEtag() {
        return wrapped.getEtag();
    }

    public CalendarListEntry setEtag(String etag) {
        return wrapped.setEtag(etag);
    }

    public String getForegroundColor() {
        return wrapped.getForegroundColor();
    }

    public String getBackgroundColor() {
        return wrapped.getBackgroundColor();
    }

    public Boolean getPrimary() {
        return wrapped.getPrimary();
    }

    public CalendarListEntry setKind(String kind) {
        return wrapped.setKind(kind);
    }

    public CalendarListEntry setDefaultReminders(List<com.google.api.services.calendar.model.EventReminder> defaultReminders) {
        return wrapped.setDefaultReminders(defaultReminders);
    }

    public CalendarListEntry setForegroundColor(String foregroundColor) {
        return wrapped.setForegroundColor(foregroundColor);
    }

    public CalendarListEntry setPrimary(Boolean primary) {
        return wrapped.setPrimary(primary);
    }

    public CalendarListEntry setBackgroundColor(String backgroundColor) {
        return wrapped.setBackgroundColor(backgroundColor);
    }
}
