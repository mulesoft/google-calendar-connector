
package org.mule.module.google.calendar.oauth;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.store.ObjectStoreException;
import org.mule.module.google.calendar.adapters.GoogleCalendarConnectorOAuth2Adapter;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-03-26T12:32:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GoogleCalendarConnectorOAuthClientFactory implements KeyedPoolableObjectFactory
{

    private GoogleCalendarConnectorOAuthManager oauthManager;

    public GoogleCalendarConnectorOAuthClientFactory(GoogleCalendarConnectorOAuthManager oauthManager) {
        this.oauthManager = oauthManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        GoogleCalendarConnectorOAuthState state = null;
        if (!oauthManager.getAccessTokenObjectStore().contains(((String) key))) {
            throw new RuntimeException((("There is no access token stored under the key "+((String) key))+". You need to call the <authorize> message processor. The key will be given to you via a flow variable after the OAuth dance is completed. You can extract it using flowVars['tokenId']."));
        }
        state = ((GoogleCalendarConnectorOAuthState) oauthManager.getAccessTokenObjectStore().retrieve(((String) key)));
        GoogleCalendarConnectorOAuth2Adapter connector = new GoogleCalendarConnectorOAuth2Adapter();
        connector.setConsumerKey(oauthManager.getConsumerKey());
        connector.setConsumerSecret(oauthManager.getConsumerSecret());
        connector.setApplicationName(oauthManager.getApplicationName());
        connector.setScope(oauthManager.getScope());
        connector.setIdentifierPolicy(oauthManager.getIdentifierPolicy());
        connector.setClientFactory(oauthManager.getClientFactory());
        connector.setAccessToken(state.getAccessToken());
        connector.setAuthorizationUrl(state.getAuthorizationUrl());
        connector.setAccessTokenUrl(state.getAccessTokenUrl());
        connector.setRefreshToken(state.getRefreshToken());
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(oauthManager.getMuleContext());
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        connector.postAuth();
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof GoogleCalendarConnectorOAuth2Adapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
        } catch (Exception e) {
            throw e;
        } finally {
            if (((GoogleCalendarConnectorOAuth2Adapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((GoogleCalendarConnectorOAuth2Adapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof GoogleCalendarConnectorOAuth2Adapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        GoogleCalendarConnectorOAuthState state = null;
        try {
            if (!oauthManager.getAccessTokenObjectStore().contains(((String) key))) {
                return false;
            }
            state = ((GoogleCalendarConnectorOAuthState) oauthManager.getAccessTokenObjectStore().retrieve(((String) key)));
            if (((GoogleCalendarConnectorOAuth2Adapter) obj).getAccessToken() == null) {
                return false;
            }
            if (!((GoogleCalendarConnectorOAuth2Adapter) obj).getAccessToken().equals(state.getAccessToken())) {
                return false;
            }
            if ((((GoogleCalendarConnectorOAuth2Adapter) obj).getRefreshToken() == null)&&(state.getRefreshToken()!= null)) {
                return false;
            }
            if ((((GoogleCalendarConnectorOAuth2Adapter) obj).getRefreshToken()!= null)&&(!((GoogleCalendarConnectorOAuth2Adapter) obj).getRefreshToken().equals(state.getRefreshToken()))) {
                return false;
            }
        } catch (ObjectStoreException _x) {
            return false;
        }
        return true;
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof GoogleCalendarConnectorOAuth2Adapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        GoogleCalendarConnectorOAuthState state = null;
        if (oauthManager.getAccessTokenObjectStore().contains(((String) key))) {
            state = ((GoogleCalendarConnectorOAuthState) oauthManager.getAccessTokenObjectStore().retrieve(((String) key)));
            oauthManager.getAccessTokenObjectStore().remove(((String) key));
        }
        if (state == null) {
            state = new GoogleCalendarConnectorOAuthState();
        }
        state.setAccessToken(((GoogleCalendarConnectorOAuth2Adapter) obj).getAccessToken());
        state.setAccessTokenUrl(((GoogleCalendarConnectorOAuth2Adapter) obj).getAccessTokenUrl());
        state.setAuthorizationUrl(((GoogleCalendarConnectorOAuth2Adapter) obj).getAuthorizationUrl());
        state.setRefreshToken(((GoogleCalendarConnectorOAuth2Adapter) obj).getRefreshToken());
        oauthManager.getAccessTokenObjectStore().store(((String) key), state);
    }

}
