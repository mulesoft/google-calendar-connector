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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.ClassInfo;

/**
 * Wrapper for {@link com.google.api.services.calendar.model.Calendar}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Calendar extends BaseWrapper<com.google.api.services.calendar.model.Calendar> {
	
	public Calendar() {
		this(new com.google.api.services.calendar.model.Calendar());
	}
	
	public Calendar(com.google.api.services.calendar.model.Calendar wrapped) {
		super(wrapped);
	}

	public String getKind() {
		return wrapped.getKind();
	}

	public String getSummary() {
		return wrapped.getSummary();
	}

	public String getEtag() {
		return wrapped.getEtag();
	}

	public String getLocation() {
		return wrapped.getLocation();
	}

	public String getTimeZone() {
		return wrapped.getTimeZone();
	}

	public String getId() {
		return wrapped.getId();
	}

	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public void getDescription() {
		wrapped.getDescription();
	}

	public final Map<String, Object> getUnknownKeys() {
		return wrapped.getUnknownKeys();
	}

	public HttpHeaders getResponseHeaders() {
		return wrapped.getResponseHeaders();
	}

	public final ClassInfo getClassInfo() {
		return wrapped.getClassInfo();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setKind(String kind) {
		wrapped.setKind(kind);
	}

	public void setDescription(String description) {
		wrapped.setDescription(description);
	}

	public void setSummary(String summary) {
		wrapped.setSummary(summary);
	}

	public void setEtag(String etag) {
		wrapped.setEtag(etag);
	}

	public void setLocation(String location) {
		wrapped.setLocation(location);
	}
	
	public void setTimeZone(String timeZone) {
		wrapped.setTimeZone(timeZone);
	}

	public void setId(String id) {
		wrapped.setId(id);
	}

	public void setResponseHeaders(HttpHeaders responseHeaders) {
		wrapped.setResponseHeaders(responseHeaders);
	}

	public final void setUnknownKeys(Map<String, Object> unknownFields) {
		wrapped.setUnknownKeys(unknownFields);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
