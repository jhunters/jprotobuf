/*
 * Copyright (c) Baidu Inc. All rights reserved.
 * 
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
package com.baidu.bjf.remoting.protobuf;

import java.util.Date;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * <pre>
 * A Timestamp represents a point in time independent of any time zone
 * or calendar, represented as seconds and fractions of seconds at
 * nanosecond resolution in UTC Epoch time. It is encoded using the
 * Proleptic Gregorian Calendar which extends the Gregorian calendar
 * backwards to year one. It is encoded assuming all minutes are 60
 * seconds long, i.e. leap seconds are "smeared" so that no leap second
 * table is needed for interpretation. Range is from
 * 0001-01-01T00:00:00Z to 9999-12-31T23:59:59.999999999Z.
 * By restricting to that range, we ensure that we can convert to
 * and from  RFC 3339 date strings.
 * See [https://www.ietf.org/rfc/rfc3339.txt](https://www.ietf.org/rfc/rfc3339.txt).
 * Example 1: Compute Timestamp from POSIX `time()`.
 *     Timestamp timestamp;
 *     timestamp.setSeconds(time(NULL));
 *     timestamp.setNanos(0);
 * Example 2: Compute Timestamp from POSIX `gettimeofday()`.
 *     struct timeval tv;
 *     gettimeofday(&amp;tv, NULL);
 *     Timestamp timestamp;
 *     timestamp.setSeconds(tv.tv_sec);
 *     timestamp.setNanos(tv.tv_usec * 1000);
 * Example 3: Compute Timestamp from Win32 `GetSystemTimeAsFileTime()`.
 *     FILETIME ft;
 *     GetSystemTimeAsFileTime(&amp;ft);
 *     UINT64 ticks = (((UINT64)ft.dwHighDateTime) &lt;&lt; 32) | ft.dwLowDateTime;
 *     // A Windows tick is 100 nanoseconds. Windows epoch 1601-01-01T00:00:00Z
 *     // is 11644473600 seconds before Unix epoch 1970-01-01T00:00:00Z.
 *     Timestamp timestamp;
 *     timestamp.setSeconds((INT64) ((ticks / 10000000) - 11644473600LL));
 *     timestamp.setNanos((INT32) ((ticks % 10000000) * 100));
 * Example 4: Compute Timestamp from Java `System.currentTimeMillis()`.
 *     long millis = System.currentTimeMillis();
 *     timestamp.setSeconds(millis / 1000);
 *     timestamp.setNanos((int) ((millis % 1000) * 1000000));
 * </pre>
 *
 * @author xiemalin
 * @since 2.3.0
 */
public class Timestamp {

    /** The seconds. */
    @Protobuf(fieldType = FieldType.INT64)
    private Long seconds;
    
    /** The nanos. */
    @Protobuf(fieldType = FieldType.INT32)
    private Integer nanos;
    

    /**
     * getter method for property seconds.
     *
     * @return the seconds
     */
    public Long getSeconds() {
        return seconds;
    }

    /**
     * setter method for property seconds.
     *
     * @param seconds the seconds to set
     */
    public void setSeconds(Long seconds) {
        this.seconds = seconds;
    }

    /**
     * getter method for property nanos.
     *
     * @return the nanos
     */
    public Integer getNanos() {
        return nanos;
    }

    /**
     * setter method for property nanos.
     *
     * @param nanos the nanos to set
     */
    public void setNanos(Integer nanos) {
        this.nanos = nanos;
    }
    
    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("param 'date' is null");
        }
        
        setSeconds(date.getTime() / 1000L);
        setNanos((int) (date.getTime() % 1000) * 1000000);
    }
    
    
    @Override
    public String toString() {
        return "Timestamp [seconds=" + seconds + ", nanos=" + nanos + "]";
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
        return new Date(getSeconds() * 1000);
    }
}
