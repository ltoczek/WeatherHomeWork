package configuration;

import models.App;

import java.util.Map;

public class AppProperties {

    YamlReader yamlReader = new YamlReader();
    private App app;

    public AppProperties() {
        setAppProperties();
    }

    public static AppProperties getInstance() {
        return AppPropertiesSingleton.INSTANCE;
    }

    private void setAppProperties() {
        app = yamlReader.getConfig().getApp();
        Map<String, Object> appProperties = app.getAppProperties();
        for (Map.Entry entry : appProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }

}
