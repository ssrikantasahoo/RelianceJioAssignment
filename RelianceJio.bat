@echo off

echo %1

if "%1" == "WEB" (set suite=SuiteWebConfig.xml)

if "%1" == "ANDROIDWEB" (set suite=SuiteAndroidMobileWebConfig.xml)
if "%1"=="ANDROIDAPP" (set  suite=SuiteAndroidAPPConfig.xml)
if "%1"=="IOSWEB" (set suite=SuiteIOSMobileWebConfig.xml)
if "%1"=="IOSAPP" (set suite=SuiteIOSAPPConfig.xml)

@echo off
cd runner
ant -DTestSuiteDir = "/testConfigs" -DTestSuiteName = "%suite%" -DTestResultPath = %1
exit /b