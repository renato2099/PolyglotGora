# PolyglotGora

Clojure
-------

To run the clojure example add the exported jar (PolyglotGora.jar in the repo or exported yourself)  to your classpath. Then execute a command similar to:

java -cp clojure-1.6.0.jar:PolyglotGora.jar clojure.main ../../../workspace/workspaceGoraBranches/GoraJython/src/org/apache/gora/clojure/gorai\_clj.clj

Jython
------

To run the clojure example add the exported jar (PolyglotGora.jar in the repo or exported yourself)  to your classpath. Then execute a command similar to:

java -jar jython.jar ../../workspace/workspaceGoraBranches/GoraJython/src/org/apache/gora/jython/gora\_jython.py 

Py4j
----
1. Make sure you installed Py4j. This was tried using Python2.7
2. Start the gateway server in {$PROJECT\_DIRECTORY}/src/org/apache/gora/py4j/binding/Py4jDataStoreEntryPoint.java
Check the file at src/org/apache/gora/py4j/gora\_py4j.py

python {$PROJECT\_DIRECTORY}/src/org/apache/gora/py4j/gora\_py4j.py
