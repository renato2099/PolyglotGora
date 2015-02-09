package org.apache.gora.jython.binding;

import org.apache.gora.examples.generated.Employee;
import org.apache.gora.persistency.Persistent;
import org.apache.gora.store.DataStore;
import org.apache.gora.util.GoraException;
import org.apache.gora.utils.GeneratedUtils;
import org.apache.gora.utils.GoraUtils;

public class SimpleBinding<K, T extends Persistent> {

  private final DataStore<K, T> datastore;

  @SuppressWarnings("unchecked")
  public SimpleBinding(String type, String keyClass, String valClass)
      throws ClassNotFoundException, GoraException {
    Class<K> kClass = (Class<K>) Class.forName(keyClass);
    Class<T> vClass = (Class<T>) Class.forName(valClass);
    datastore = GoraUtils.createSpecificDataStore(type, kClass, vClass);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void main(String[] args) {
    try {
      SimpleBinding sb = new SimpleBinding("cassandra", "java.lang.String", "org.apache.gora.examples.generated.Employee");
      Employee old_emp = GeneratedUtils.createEmployee("12345", "Rreenato", 100);
      sb.put(old_emp.getSsn().toString(), old_emp);
      sb.flush();
      System.out.println(GeneratedUtils.pPrint(old_emp));
      Employee emp = (Employee) sb.get("12345");
      System.out.println(GeneratedUtils.pPrint(emp));
      sb.close();
    } catch (GoraException e) {
      System.err.println("Something went wrong.");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.err.println("Something went wrong while loading classes.");
      e.printStackTrace();
    }
  }

  public void put(K key, T value) {
    datastore.put(key, value);
  }

  public void flush() {
    datastore.flush();
  }

  public void close() {
    datastore.close();
  }

  public T get(K key) {
    return datastore.get(key);
  }

  public DataStore<K, T> getDatastore() {
    return datastore;
  }
}
