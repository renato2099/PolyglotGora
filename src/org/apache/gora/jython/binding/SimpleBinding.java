package org.apache.gora.jython.binding;

import org.apache.gora.persistency.Persistent;
import org.apache.gora.store.DataStore;
import org.apache.gora.util.GoraException;
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
