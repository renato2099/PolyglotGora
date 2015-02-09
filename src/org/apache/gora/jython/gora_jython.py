import sys 
sys.path.append('/Users/renatomarroquin/Downloads/GoraJython.jar')
from org.apache.gora.jython.binding import SimpleBinding
from org.apache.gora.utils import GeneratedUtils

emp1 = GeneratedUtils.createEmployee("12345", "Jhon", 2000)
GeneratedUtils.pPrint(emp1)

h = SimpleBinding("cassandra", "java.lang.String", "org.apache.gora.examples.generated.Employee")
h.put("12345", emp1)
h.flush()

emp2 = h.get("12345")
print GeneratedUtils.pPrint(emp2)