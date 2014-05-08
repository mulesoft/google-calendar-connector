Google Calendar Connector Release Notes
==========================================

Date: 12-May-2014

Version: 2.0.0

Supported API versions: Google Calendar API v3 - https://developers.google.com/google-apps/calendar/v3/reference/

Supported Mule Runtime Versions: 3.5.0

Closed Issues in this release
------------------------------

 - Upgraded google api services calendar to v3-rev77-1.17.0-rc.
 - Upgraded Mule Devkit to 3.5.0.
 - Fixed Class Versioning Issue. [CLDCONNECT-1372]
 - Fixed Quick add events operation hung issue. [CLDCONNECT-1373]
 - Removed @Optional as it is redundant when used along @Default.
 - Removed deprecated @OAuthInvalidateAccessTokenOn and added @ReconnectOn on the Connector.
 - Fixed test cases
    - If a test is not functionally designed to test calendar creation or deletion, it just uses the default/primary calendar.
    - If a test is working on an event, it uses different test data to any other test that uses an event.
    - Added sleep time (10 sec) between each operation to slow down the hits to the google api.

Known Issues in this release
------------------------------

 - Avoid executing Regression/Smoke test suites multiple times in a single day in order to avoid "Calendar usage limits exceeded." error.