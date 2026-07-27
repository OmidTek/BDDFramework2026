package utils;

import io.cucumber.java.Scenario;

public class ScenarioContext {


    private static final ThreadLocal<Scenario> scenario =
            new ThreadLocal<>();

    public static void setScenario(Scenario s) {
        scenario.set(s);
    }

    public static Scenario getScenario() {
        return scenario.get();
    }

    public static void removeScenario() {
        scenario.remove();
    }


}
