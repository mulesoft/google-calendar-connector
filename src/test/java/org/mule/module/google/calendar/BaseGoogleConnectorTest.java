/**
 * Mule Google Calendars Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.calendar;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import junit.framework.TestCase;

import org.mockito.Mockito;
import org.mule.api.MuleMessage;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuthInvalidateAccessTokenOn;
import org.mule.api.annotations.oauth.OAuthProtected;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public abstract class BaseGoogleConnectorTest<T> extends TestCase {

	protected static final String pageToken = "blah";
	
	protected T connector;
	protected MuleMessage message;
	
	public void testOAuthProtected() {
		for (Method method : this.getConnectorClass().getMethods()) {
			if (method.getAnnotation(Processor.class) != null) {
				assertNotNull("Not OAuth protected", method.getAnnotation(OAuthProtected.class));
				
				OAuthInvalidateAccessTokenOn inv = method.getAnnotation(OAuthInvalidateAccessTokenOn.class);
				assertNotNull("No invalidation annotation", inv);
				assertEquals(inv.exception(), OAuthTokenExpiredException.class);
			}
		}
	}
	
	@Override
	protected final void setUp() throws Exception {
		this.connector = this.getConnectorClass().newInstance();
		this.message = Mockito.mock(MuleMessage.class);
		this.doSetUp();
	}
	
	protected abstract void doSetUp();
	
	@SuppressWarnings("unchecked")
	protected Class<T> getConnectorClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected abstract String getNextPageTokenKey();
	
	protected void assertPagination() {
		Mockito.verify(this.message, Mockito.times(1)).setInvocationProperty(Mockito.eq(this.getNextPageTokenKey()), Mockito.any());
	}
	
}
