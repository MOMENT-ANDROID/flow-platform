/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.plugin.test.service;

import com.flow.platform.plugin.domain.Plugin;
import com.flow.platform.plugin.domain.PluginStatus;
import com.flow.platform.plugin.exception.PluginException;
import com.flow.platform.plugin.test.TestBase;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yh@firim
 */
public class PluginServiceTest extends TestBase {

    @Before
    public void init() throws IOException {
        Path dest = Paths.get("/tmp/test");
        if (!dest.toFile().exists()) {
            Files.createDirectories(dest);
        }
    }

    @Test
    public void should_get_plugins_success() {

        // when: get plugins list
        List<Plugin> pluginList = pluginService.list();

        // then: pluginList not null
        Assert.assertNotNull(pluginList);

        // then: pluginList size is not 0
        Assert.assertNotEquals(0, pluginList.size());

        // then: pluginList size is 2
        Assert.assertEquals(2, pluginList.size());
    }


    @Test
    public void should_update_success() {
        Plugin plugin = pluginService.find("fircli");
        plugin.setStatus(PluginStatus.INSTALLED);
        pluginService.update(plugin);

        plugin = pluginService.find(plugin.getName());
        Assert.assertEquals(PluginStatus.INSTALLED, plugin.getStatus());
    }
}
