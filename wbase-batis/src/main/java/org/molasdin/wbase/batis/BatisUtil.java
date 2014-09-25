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

package org.molasdin.wbase.batis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.molasdin.wbase.registry.Registry;
import org.molasdin.wbase.registry.RegistryManager;

/**
 * Created by dbersenev on 17.02.14.
 */
public class BatisUtil {
    public static void initializeBatis(String configLocation, Registry registry){
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(configLocation));
            registry.attach(Constants.SQL_SESSION_FACTORY.name(), factory);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
