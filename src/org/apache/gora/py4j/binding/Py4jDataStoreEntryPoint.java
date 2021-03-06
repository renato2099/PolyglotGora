/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.gora.py4j.binding;

import org.apache.gora.examples.generated.Employee;
import org.apache.gora.persistency.Persistent;
import org.apache.gora.store.DataStore;
import org.apache.gora.util.GoraException;
import org.apache.gora.utils.GeneratedUtils;
import org.apache.gora.utils.GoraUtils;

import py4j.GatewayServer;

/**
 * Main entry point for data stores.
 *
 * @param <K>
 * @param <T>
 */
public class Py4jDataStoreEntryPoint<K, T extends Persistent> {

  /**
   * Data store
   */
  private DataStore<K, T> datastore;

  /**
   * Entry point for data stores usage.
   * 
   * @param type
   * @param keyClass
   * @param valClass
   * @throws ClassNotFoundException
   * @throws GoraException
   */
  public Py4jDataStoreEntryPoint(String type, String keyClass, String valClass)
      throws ClassNotFoundException, GoraException {
    initialize(type, keyClass, valClass);
  }

  public Py4jDataStoreEntryPoint() throws GoraException, ClassNotFoundException {
    initialize("cassandra", "java.lang.String",
        "org.apache.gora.examples.generated.Employee");
  }

  @SuppressWarnings("unchecked")
  public void initialize(String type, String keyClass, String valClass) 
      throws ClassNotFoundException, GoraException{
    Class<K> kClass = (Class<K>) Class.forName(keyClass);
    Class<T> vClass = (Class<T>) Class.forName(valClass);
    datastore = GoraUtils.createSpecificDataStore(type, kClass, vClass);
  }

  @SuppressWarnings({ "rawtypes"})
  public static void main(String[] args) {
    try {
      GatewayServer gatewayServer = new GatewayServer(new Py4jDataStoreEntryPoint());
      gatewayServer.start();
      System.out.println("Gateway Server Started");
    } catch (GoraException e) {
      System.err.println("Something went wrong.");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.err.println("Something went wrong.");
      e.printStackTrace();
    }
  }

  public Employee getEmployee(Integer iSal, String sName, String sSsn) {
    return GeneratedUtils.createEmployee(sSsn, sName, iSal);
  }

  public String pPrint(Employee emp1) {
    return GeneratedUtils.pPrint(emp1);
  }

  public DataStore<K, T> getDatastore() {
    return datastore;
  }
}
