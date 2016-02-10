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
package com.actian.spark_vector.loader

import org.apache.spark.sql.types.StructType

import com.actian.spark_vector.loader.command.ConstructVector
import com.actian.spark_vector.loader.options.UserOptions
import com.actian.spark_vector.loader.parsers.VectorParser

object Main extends App {
  val parser: scopt.OptionParser[UserOptions] = VectorParser
  //TODO: Phase2 - this should be pulled from a StructType JSON serialized file if passed from command line option.
  val schema: Option[StructType] = None

  parser.parse(args, UserOptions()) match {
    case Some(options) => ConstructVector.execute(options, schema)
    case None =>
  }
}
