@echo off

REM Enlève les .class dans le dossier ast
del ast\*.class 
del *.class
del *.java

echo Les fichiers .class et .java sont enlevés.
echo.

echo Compilation de jj et des fichiers java.
REM Compile jj et javac les .java 
javacc ./lanage.jj
javac ast\*.java MiniLangParser.java

echo.
echo Compilation fini.
