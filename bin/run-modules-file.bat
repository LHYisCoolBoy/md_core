@echo off
echo.
echo [信息] 运行modules-file工程。
echo.

cd %~dp0
cd ../jeethink-modules/jeethink-file/target

set JAVA_OPTS=-Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -Dfile.encoding=utf-8 -jar %JAVA_OPTS% jeethink-modules-file.jar

cd bin
pause