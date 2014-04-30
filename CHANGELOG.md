2.0.0
=====
 - Upgraded google api services calendar to v3-rev77-1.17.0-rc.
 - Upgraded Devkit to 3.5.0-SNAPSHOT.
 - Fixed Class Versioning Issue.
 - Fixed Quick add events operation hung issue.
 - Removed @Optional as it is redundant when used along @Default.
 - Removed deprecated @OAuthInvalidateAccessTokenOn and added @ReconnectOn on the Connector.
 - Fixed test cases
    - If a test is not functionally designed to test calendar creation or deletion, it just uses the default/primary calendar.
    - If a test is working on an event, it uses different test data to any other test that uses an event.
    - Added sleep time (10 sec) between each operation to slow down the hits to the google api.

 - Known Issues
    - Avoid executing Regression/Smoke test suites multiple times in a single day in order to avoid "Calendar usage limits exceeded." error.