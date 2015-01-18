import sys 
sys.path.append('/Users/renatomarroquin/Downloads/GoraJython.jar')
from org.apache.gora.jython.test import SimpleBinding
h = SimpleBinding('cassandra', 'String', 'Employee')