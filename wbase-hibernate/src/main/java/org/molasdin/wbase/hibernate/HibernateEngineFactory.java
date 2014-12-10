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

package org.molasdin.wbase.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.molasdin.wbase.hibernate.HibernateEngine;
import org.molasdin.wbase.transaction.EngineFactory;

/**
 * Created by molasdin on 10/30/14.
 */
public class HibernateEngineFactory implements EngineFactory<HibernateEngine> {

    private Session session;
    private SessionFactory sessionFactory;

    public HibernateEngineFactory(Session session) {
        this.session = session;
    }

    public HibernateEngineFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public HibernateEngine create() {
        return new BasicHibernateEngine(session != null?session:sessionFactory.getCurrentSession());
    }
}