package org.apache.gora.utils;

import org.apache.avro.util.Utf8;
import org.apache.gora.examples.generated.Employee;
import org.apache.gora.store.DataStore;
import org.apache.gora.util.GoraException;

/**
 * Class used to create necessary objects to be tested.
 */
public class GeneratedUtils {

  public static Employee createEmployee(String sSsn, String sName, Integer iSal) {
    Employee emp1 = Employee.newBuilder().build();
    emp1.setSsn(sSsn);
    emp1.setName(new Utf8(sName));
    emp1.setSalary(iSal);
    return emp1;
  }

  public static String pPrint(Employee emp) {
    StringBuilder sb = new StringBuilder();
    if (emp != null) {
      sb.append("SSN: ").append(emp.getSsn());
      sb.append(" NAME: ").append(emp.getName());
      sb.append(" SALARY: ").append(emp.getSalary());
    }
    else
      sb.append("NULL");
    return sb.toString();
  }

  public static void main(String[] args) {
    try {
      DataStore<String, Employee> ds = GoraUtils.createSpecificDataStore(
          "cassandra", String.class, Employee.class);
      Employee old_emp = createEmployee("43024255", "Renato", 100);
      ds.put(old_emp.getSsn().toString(), old_emp);
      ds.flush();
      System.out.println(pPrint(old_emp));
      Employee emp = ds.get("43024255");
      System.out.println(pPrint(emp));
      ds.close();
    } catch (GoraException e) {
      System.err.println("Something went wrong.");
      e.printStackTrace();
    }
  }
}
