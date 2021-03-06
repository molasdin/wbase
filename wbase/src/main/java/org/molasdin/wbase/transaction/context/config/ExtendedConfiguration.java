/*
 * Copyright 2016 Bersenev Dmitry molasdin@outlook.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.molasdin.wbase.transaction.context.config;

import org.molasdin.wbase.transaction.context.TransactionResource;
import org.molasdin.wbase.transaction.context.interceptors.ExtendedInterception;
import org.molasdin.wbase.transaction.context.interceptors.Interception;
import org.molasdin.wbase.transaction.context.interceptors.InterceptionMode;

import java.util.Map;
import java.util.Set;

/**
 * Created by dbersenev on 06.04.2016.
 */
public interface ExtendedConfiguration extends TransactionConfiguration {
    /**
     * Transaction manager key
     * @return
     */
    Object key();

    /**
     * All resources associated with this configuration
     * @return
     */
    Map<Object, TransactionResource<?>> resources();

    /**
     * New or changed resource keys
     * @return
     */
    Set<Object> freshResources();

    /**
     * If configuration was modified
     * @return
     */
    boolean changed();

    /**
     * Transaction implementation
     * @return
     */
    Object underline();

    /**
     * Resource key on which synchronization is going to be preformed
     * or null
     * @return
     */
    Object syncOnResource();

    @Override
    ExtendedInterception interception();

    Map<InterceptionMode, ExtendedInterception> interceptions();
}
