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
package com.actian.spark_vectorh.buffer.time;

import static com.actian.spark_vectorh.buffer.time.TimeLZColumnFactoryCommons.isSupportedColumnType;

import com.actian.spark_vectorh.buffer.time.TimeConversion.TimeConverter;
import com.actian.spark_vectorh.buffer.time.TimeLZColumnFactoryCommons.TimeLZConverter;

public final class TimeLZIntColumnBufferFactory extends TimeIntColumnBufferFactory {
    private static final int MIN_TIME_INT_LZ_SCALE = 0;
    private static final int MAX_TIME_INT_LZ_SCALE = 4;

    @Override
    public boolean adjustToUTC() {
        return false;
    }

    @Override
    public boolean supportsColumnType(String type, int precision, int scale, boolean nullable) {
        return isSupportedColumnType(type, scale, MIN_TIME_INT_LZ_SCALE, MAX_TIME_INT_LZ_SCALE);
    }

    @Override
    protected TimeConverter createConverter() {
        return new TimeLZConverter();
    }
}
