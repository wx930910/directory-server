/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.directory.server.xdbm;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Tests the {@link IndexNotFoundException} class.
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
@Execution(ExecutionMode.SAME_THREAD)
public class IndexNotFoundExceptionTest
{
    @Test
    public void testConstructor1()
    {
        IndexNotFoundException exception = new IndexNotFoundException( null );
        assertNull( exception.getIndexName() );

        exception = new IndexNotFoundException( "cn" );
        assertEquals( "cn", exception.getIndexName() );
    }


    @Test
    public void testConstructor2()
    {
        IndexNotFoundException exception = new IndexNotFoundException( null, null );
        assertNull( exception.getMessage() );
        assertNull( exception.getIndexName() );

        exception = new IndexNotFoundException( "message", "cn" );
        assertEquals( "message", exception.getMessage() );
        assertEquals( "cn", exception.getIndexName() );
    }


    @Test
    public void testConstructor3()
    {
        IndexNotFoundException exception = new IndexNotFoundException( null, null, null );
        assertNull( exception.getMessage() );
        assertNull( exception.getIndexName() );
        assertNull( exception.getCause() );

        exception = new IndexNotFoundException( "message", "cn", new Exception() );
        assertEquals( "message", exception.getMessage() );
        assertEquals( "cn", exception.getIndexName() );
        assertNotNull( exception.getCause() );
    }

}
