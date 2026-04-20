package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;

import org.matsim.contrib.dvrp.run.DvrpModule;
import org.matsim.contrib.taxi.run.MultiModeTaxiModule;

public class RunMatsimDvrpGrid {

    public static void main(String[] args) {

        Config config;
        config = ConfigUtils.loadConfig( "C:/Users/ti.tang/IdeaProjects/matsim-libs/examples/scenarios/dvrp-grid/one_taxi_config.xml" );
        config.controller().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists );

        Scenario scenario = ScenarioUtils.loadScenario(config) ;

        Controler controler = new Controler(scenario);
        controler.addOverridingModule(new DvrpModule());
        controler.addOverridingModule(new MultiModeTaxiModule());
        controler.run();
    }
}
