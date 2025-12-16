### Compiler javacc

$ javacc MonFichier.jj
$ javac ast\*.java MiniLangParser.java
$ java MiniLangParser < MonProgramme.txt # Sur Linux/Mac
$ Get-Content .\MonProgramme.txt | java MiniLangParser # Sur Windows