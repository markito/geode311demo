/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.example;

import java.util.logging.Logger;

import com.example.model.ServiceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexerController {

  Logger logger = Logger.getAnonymousLogger();
  java.util.logging.Level logLevel = java.util.logging.Level.INFO;

  @RequestMapping(value = { "/index" })
  public String indexDocument(@RequestBody ServiceRequest document) {
    logger.log(logLevel, String.format("Document: %s", document));

    //TODO: implement indexing to GEM (over rest)

    return "";
  }

  }
