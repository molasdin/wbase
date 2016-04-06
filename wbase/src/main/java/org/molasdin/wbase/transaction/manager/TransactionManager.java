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

package org.molasdin.wbase.transaction.manager;

import org.molasdin.wbase.transaction.TransactionDescriptors;
import org.molasdin.wbase.transaction.UserTransaction;
import org.molasdin.wbase.transaction.TransactionDescriptor;
import org.molasdin.wbase.transaction.TransactionIsolation;

/**
 * Created by dbersenev on 21.10.2014.
 */
public interface TransactionManager<T extends Engine> {
    default UserTransaction<T> createTransaction() {
        return createTransaction(TransactionDescriptors.INSTANCE.simple());
    }
    default UserTransaction<T> createTransaction(TransactionIsolation isolation) {
        return createTransaction(TransactionDescriptors.INSTANCE.isolated(isolation));
    }
    UserTransaction<T> createTransaction(TransactionDescriptor descriptor);
}