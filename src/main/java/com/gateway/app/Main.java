/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gateway.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        createWebhooksNotificationsFolder();
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/")
    ModelAndView index() {
        return new ModelAndView("redirect:/authorize");
    }

    private static void createWebhooksNotificationsFolder() {
        File webhooksNotificationsFolder = new File(Config.WEBHOOKS_NOTIFICATION_FOLDER);
        if (!webhooksNotificationsFolder.exists()) {
            System.out.println("Creating Webhooks Notifications folder... ");
            webhooksNotificationsFolder.mkdir();
        } else {
            System.out.println("Webhooks Notifications folder already exists!");
        }
    }
}
