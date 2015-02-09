(import '(org.apache.gora.jython.binding SimpleBinding))
(import '(org.apache.gora.utils GeneratedUtils))

(def emp1 (GeneratedUtils/createEmployee "12345" "Jhon" (Integer. 2000)))
(GeneratedUtils/pPrint emp1)
(println (GeneratedUtils/pPrint emp1))

(def h (new SimpleBinding "cassandra", "java.lang.String", "org.apache.gora.examples.generated.Employee"))
(. h put "12345" emp1)
(. h flush)

(def emp2 (. h get "12345"))
(println (GeneratedUtils/pPrint emp2))

(. h close)