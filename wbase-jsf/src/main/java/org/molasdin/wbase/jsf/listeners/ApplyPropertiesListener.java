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

package org.molasdin.wbase.jsf.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplyPropertiesListener implements ServletContextListener {

    private final static String PROP_COERCE = "org.apache.el.parser.COERCE_TO_ZERO";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.setProperty(PROP_COERCE, "false");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
