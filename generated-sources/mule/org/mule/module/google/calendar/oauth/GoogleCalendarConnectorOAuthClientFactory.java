
package org.mule.module.google.calendar.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.mule.api.store.ObjectStore;
import org.mule.common.security.oauth.OAuthState;
import org.mule.module.google.calendar.adapters.GoogleCalendarConnectorOAuth2Adapter;
import org.mule.security.oauth.BaseOAuthClientFactory;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-08T10:25:26-05:00", comments = "Build M4.1875.17b58a3")
public class GoogleCalendarConnectorOAuthClientFactory
    extends BaseOAuthClientFactory
{

    private GoogleCalendarConnectorOAuthManager oauthManager;

    public GoogleCalendarConnectorOAuthClientFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        super(oauthManager, objectStore);
        this.oauthManager = (GoogleCalendarConnectorOAuthManager) oauthManager;
    }

    @Override
    protected Class<? extends OAuth2Adapter> getAdapterClass() {
        return GoogleCalendarConnectorOAuth2Adapter.class;
    }

    @Override
    protected void setCustomAdapterProperties(OAuth2Adapter adapter, OAuthState state) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) adapter);
        connector.setApplicationName(oauthManager.getApplicationName());
        connector.setScope(oauthManager.getScope());
        connector.setClientFactory(oauthManager.getClientFactory());
    }

    @Override
    protected void setCustomStateProperties(OAuth2Adapter adapter, OAuthState state) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) adapter);
    }

}
