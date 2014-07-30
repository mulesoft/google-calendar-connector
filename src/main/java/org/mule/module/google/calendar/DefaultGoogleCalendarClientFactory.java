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

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import org.apache.commons.lang.StringUtils;
import org.mule.modules.google.CommonsUtils;
import org.mule.modules.google.api.proxy.ProxyOptions;
import org.mule.modules.google.oauth.invalidation.InvalidationAwareCredential;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class DefaultGoogleCalendarClientFactory implements GoogleCalendarClientFactory {

	/**
	 * @see org.mule.module.google.calendar.GoogleCalendarClientFactory#newClient(java.lang.String, java.lang.String, org.mule.modules.google.api.proxy.ProxyOptions)
	 */
	@Override
	public Calendar newClient(String accessToken, String applicationName, ProxyOptions proxyOptions) {
		Credential credential = new InvalidationAwareCredential(BearerToken.authorizationHeaderAccessMethod());
		credential.setAccessToken(accessToken);

        NetHttpTransport.Builder httpTransportBuilder = new NetHttpTransport.Builder();

        if (StringUtils.isNotEmpty(proxyOptions.getHost())) {
            httpTransportBuilder.setProxy(CommonsUtils.createProxy(proxyOptions));
        }

        return new Calendar.Builder(httpTransportBuilder.build(), new JacksonFactory(), credential).setApplicationName(applicationName).build();
	}

}
