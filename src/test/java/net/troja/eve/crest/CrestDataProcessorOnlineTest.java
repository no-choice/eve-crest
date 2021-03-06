package net.troja.eve.crest;

/*
 * ========================================================================
 * Library for the Eve Online CREST API
 * ------------------------------------------------------------------------
 * Copyright (C) 2014 - 2015 Jens Oberender <j.obi@troja.net>
 * ------------------------------------------------------------------------
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
 * ========================================================================
 */

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.processors.ItemTypeProcessor;

import org.junit.Test;

public class CrestDataProcessorOnlineTest {
    @Test
    public void testDownloadOfPagedData() {
        final CrestDataProcessor processor = new CrestDataProcessor();
        final CrestContainer<ItemType> data = processor.downloadAndProcessContainerData(new ItemTypeProcessor());
        assertThat(data, notNullValue());
        assertThat(data.getTotalCount(), equalTo(data.getEntries().size()));
    }
}
