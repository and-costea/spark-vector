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
package com.actian.spark_vector.colbuffer.string

import com.actian.spark_vector.colbuffer._
import com.actian.spark_vector.colbuffer.util.StringConversion

private class ConstantLengthSingleByteStringColumnBuffer(maxValueCount: Int, name: String, precision: Int, scale: Int, nullable: Boolean) extends
  IntegerEncodedStringColumnBuffer(maxValueCount, name, precision, scale, nullable) {

  override protected def encode(value: String): Int = if (StringConversion.truncateToUTF8Bytes(value, 1).length == 0) {
    IntegerEncodedStringColumnBuffer.Whitespace
  } else {
    value.codePointAt(0)
  }
}

/** `ColumnBuffer` object for `char` types (with precision = 1). */
object ConstantLengthSingleByteStringColumnBuffer extends ColumnBufferInstance {

  private[colbuffer] override def getNewInstance(name: String, precision: Int, scale: Int, nullable: Boolean, maxValueCount: Int): ColumnBuffer[_] =
    new ConstantLengthSingleByteStringColumnBuffer(maxValueCount, name, precision, scale, nullable)

  private[colbuffer] override def supportsColumnType(tpe: String, precision: Int, scale: Int, nullable: Boolean): Boolean =
    tpe.equalsIgnoreCase(CharTypeId) && precision == 1
}