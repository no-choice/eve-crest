package net.troja.eve.crest.industry.systems;

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

import java.util.HashMap;
import java.util.Map;

import net.troja.eve.crest.PublicContainerParser;

public class IndustrySystemsParser extends PublicContainerParser<IndustrySystems, IndustrySystem> {
    @Override
    protected String getPath() {
        return "/industry/systems/";
    }

    public Map<String, Map<Integer, Double>> getDataAsMap() {
        final IndustrySystems data = getData();
        final Map<String, Map<Integer, Double>> map = new HashMap<>();
        if (data == null) {
            return map;
        }
        for (final IndustrySystem team : data.getItems()) {
            final String solarSystem = team.getSolarSystem().getName();
            Map<Integer, Double> teams = map.get(solarSystem);
            if (teams == null) {
                teams = new HashMap<>();
                map.put(solarSystem, teams);
            }
            for (final CostIndex index : team.getSystemCostIndices()) {
                teams.put(index.getActivityID(), index.getCostIndex());
            }
        }
        return map;
    }
}
