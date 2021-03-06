/*
 * Copyright 2014 Bersenev Dmitry molasdin@outlook.com
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

package org.molasdin.wbase.transaction;

/**
 * Created by dbersenev on 10.12.2014.
 */
public enum TransactionDescriptors implements TransactionDescriptor{

    SIMPLE(new BasicTransactionDescriptor()),
    ALWAYS_NEW(createdWithRequirement(Requirement.ALWAYS_NEW)),
    ALWAYS_NEW_LINKED(createdWithRequirement(Requirement.ALWAYS_NEW_LINKED)),
    NEW_OR_PROPAGATED(createdWithRequirement(Requirement.NEW_OR_PROPAGATED)),
    PROPAGATED_ONLY(createdWithRequirement(Requirement.PROPAGATED_ONLY));


    private TransactionDescriptor desc;

    TransactionDescriptors(TransactionDescriptor desc) {
        this.desc = desc;
    }

    @Override
    public TransactionIsolation isolation() {
        return desc.isolation();
    }

    @Override
    public Requirement requirement() {
        return desc.requirement();
    }

    public static TransactionDescriptor isolated(TransactionIsolation isolation){
        return new BasicTransactionDescriptor(isolation);
    }

    public static TransactionDescriptor of(Requirement requirement, TransactionIsolation isolation){
        BasicTransactionDescriptor descr = new BasicTransactionDescriptor();
        descr.setRequirement(requirement);
        descr.setIsolation(isolation);
        return descr;
    }

    private static TransactionDescriptor createdWithRequirement(Requirement requirement){
        BasicTransactionDescriptor descr = new BasicTransactionDescriptor();
        descr.setRequirement(requirement);
        return descr;
    }
}
