/*
 * Copyright 2016 Actian Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.actian.spark_vectorh.writer

import com.actian.spark_vectorh.vector.VectorJDBC

/** Configuration for writing, one entry for each Vector end point expecting data */
case class WriteConf(vectorEndPoints: IndexedSeq[VectorEndPoint]) extends Serializable

object WriteConf {
  def apply(jdbc: VectorJDBC): WriteConf = {
    WriteConf(VectorEndPoint.fromDataStreamsTable(jdbc))
  }
}
