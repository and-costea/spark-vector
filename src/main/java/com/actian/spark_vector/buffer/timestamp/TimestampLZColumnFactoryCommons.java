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
package com.actian.spark_vector.buffer.timestamp;

import static com.actian.spark_vector.buffer.timestamp.TimestampConversion.scaledTimestamp;

import java.math.BigInteger;

import com.actian.spark_vector.buffer.timestamp.TimestampConversion.TimestampConverter;

final class TimestampLZColumnFactoryCommons {
    private static final String TIMESTAMP_LZ_TYPE_ID = "timestamp with local time zone";

    private TimestampLZColumnFactoryCommons() {
        throw new IllegalStateException();
    }

    public static boolean isSupportedColumnType(String columnTypeName, int columnScale, int minScale, int maxScale) {
        return columnTypeName.equalsIgnoreCase(TIMESTAMP_LZ_TYPE_ID) && minScale <= columnScale && columnScale <= maxScale;
    }

    public static final class TimestampLZConverter implements TimestampConverter {
        @Override
        public BigInteger convert(long epochSeconds, long subsecNanos, int offsetSeconds, int scale) {
            return scaledTimestamp(epochSeconds, subsecNanos, 0, scale);
        }
    }
}