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

package org.molasdin.wbase.batis.support;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.session.SqlSession;
import org.molasdin.wbase.transaction.Transactional;

/**
 * Created by dbersenev on 13.03.14.
 */
public interface BatisSupport<M> {
    SqlSession session();
    <U> U runSimple(Transactional<SqlSession, U> runner);
    <T, U> U runCommon(SqlSession session, T ctx, Transactional<T, U> runner);
    M mapper();
    Pair<SqlSession, M> sessionAndMapper();
    <F> F run(Transactional<BatisContext<M>, F> transactional);
}
