@echo off
echo [1/3] Running JJTree...
call jjtree MiniLang.jjt
if %errorlevel% neq 0 exit /b %errorlevel%

echo [2/3] Running JavaCC...
call javacc src\MiniLang.jj
if %errorlevel% neq 0 exit /b %errorlevel%

echo [3/3] Compiling Java files...
javac src\*.java
if %errorlevel% neq 0 exit /b %errorlevel%


