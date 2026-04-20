package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;

public class RunMatsimBerlin {

    public static void main(String[] args) {

        Config config;
        config = ConfigUtils.loadConfig( "C:/Users/ti.tang/IdeaProjects/matsim-libs/examples/scenarios/berlin/config.xml" );
        config.controller().setOverwriteFileSetting(OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists );
        config.controller().setLastIteration(0);

        Scenario scenario = ScenarioUtils.loadScenario(config) ;

        Controler controler = new Controler(scenario);
        controler.run();

    }
}
