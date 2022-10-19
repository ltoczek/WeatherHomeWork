package models;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    Map<String,Object> properties = new LinkedHashMap<>();

    @JsonAnySetter
    void setAppProperties(String key, Object value){
        properties.put(key, value);
    }

    public Map<String,Object> getAppProperties(){
        return properties;
    }

}
