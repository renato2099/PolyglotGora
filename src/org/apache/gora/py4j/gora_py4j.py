from py4j.java_gateway import JavaGateway

gw = JavaGateway()
ds = gw.entry_point.getDatastore()

emp2 = gw.entry_point.getEmployee(100,"Doe","12345")
ds.put("12345",emp2)
ds.flush()

emp = ds.get("12345")
print gw.entry_point.pPrint(emp)