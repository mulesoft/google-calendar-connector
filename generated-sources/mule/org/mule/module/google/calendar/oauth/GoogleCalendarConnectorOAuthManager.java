
package org.mule.module.google.calendar.oauth;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.expression.ExpressionManager;
import org.mule.api.store.ObjectStore;
import org.mule.module.google.calendar.GoogleCalendarClientFactory;
import org.mule.module.google.calendar.GoogleCalendarConnector;
import org.mule.module.google.calendar.adapters.GoogleCalendarConnectorOAuth2Adapter;
import org.mule.security.oauth.BaseOAuth2Manager;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;
import org.mule.security.oauth.OnNoTokenPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A {@code GoogleCalendarConnectorOAuthManager} is a wrapper around {@link GoogleCalendarConnector } that adds access token management capabilities to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-26T12:34:07-05:00", comments = "Build M4.1875.17b58a3")
public class GoogleCalendarConnectorOAuthManager
    extends BaseOAuth2Manager<OAuth2Adapter>
{

    private static Logger logger = LoggerFactory.getLogger(GoogleCalendarConnectorOAuthManager.class);
    private final static String MODULE_NAME = "Google Calendars";
    private final static String MODULE_VERSION = "2.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.5.0-M4";
    private final static String DEVKIT_BUILD = "M4.1875.17b58a3";

    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * Sets consumerKey
     * 
     * @param key to set
     */
    public void setConsumerKey(String value) {
        super.setConsumerKey(value);
    }

    /**
     * Sets consumerSecret
     * 
     * @param secret to set
     */
    public void setConsumerSecret(String value) {
        super.setConsumerSecret(value);
    }

    /**
     * Sets applicationName
     * 
     * @param scope to set
     */
    public void setApplicationName(String value) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        connector.setApplicationName(value);
    }

    /**
     * Retrieves applicationName
     * 
     */
    public String getApplicationName() {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return connector.getApplicationName();
    }

    /**
     * Sets scope
     * 
     * @param scope to set
     */
    public void setScope(String value) {
        super.setScope(value);
    }

    /**
     * Sets clientFactory
     * 
     * @param scope to set
     */
    public void setClientFactory(GoogleCalendarClientFactory value) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        connector.setClientFactory(value);
    }

    /**
     * Retrieves clientFactory
     * 
     */
    public GoogleCalendarClientFactory getClientFactory() {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return connector.getClientFactory();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    @Override
    protected OAuth2Adapter instantiateAdapter() {
        return new GoogleCalendarConnectorOAuth2Adapter(this);
    }

    @Override
    protected KeyedPoolableObjectFactory createPoolFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        return new GoogleCalendarConnectorOAuthClientFactory(oauthManager, objectStore);
    }

    @Override
    protected void setCustomProperties(OAuth2Adapter adapter) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) adapter);
        connector.setConsumerKey(getConsumerKey());
        connector.setConsumerSecret(getConsumerSecret());
        connector.setApplicationName(getApplicationName());
        connector.setScope(getScope());
        connector.setClientFactory(getClientFactory());
    }

    protected void fetchCallbackParameters(OAuth2Adapter adapter, String response) {
        GoogleCalendarConnectorOAuth2Adapter connector = ((GoogleCalendarConnectorOAuth2Adapter) adapter);
        ExpressionManager expressionManager = (muleContext.getExpressionManager());
        MuleMessage muleMessage = new DefaultMuleMessage(response, (muleContext));
    }

    public void setOnNoToken(OnNoTokenPolicy policy) {
        this.getDefaultUnauthorizedConnector().setOnNoTokenPolicy(policy);
    }

    @Override
    protected Set<Class<? extends Exception>> refreshAccessTokenOn() {
        Set<Class<? extends Exception>> types = new HashSet<Class<? extends Exception>>();
        types.add((org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException.class));
        return types;
    }

}
