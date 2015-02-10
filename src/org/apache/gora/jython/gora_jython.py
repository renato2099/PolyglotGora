# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import sys
sys.path.append('/Users/renatomarroquin/Downloads/PolyglotGora.jar')
from org.apache.gora.jython.binding import SimpleBinding
from org.apache.gora.utils import GeneratedUtils

emp1 = GeneratedUtils.createEmployee("12345", "Jhon", 2000)
GeneratedUtils.pPrint(emp1)

h = SimpleBinding("cassandra", "java.lang.String", "org.apache.gora.examples.generated.Employee")
h.put("12345", emp1)
h.flush()

emp2 = h.get("12345")
print GeneratedUtils.pPrint(emp2)