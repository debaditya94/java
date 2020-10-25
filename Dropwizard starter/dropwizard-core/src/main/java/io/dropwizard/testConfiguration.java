package io.dropwizard;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

public class testConfiguration extends Configuration {
    @NotEmpty
    private String template;
    
    @NotEmpty
    private String defaultName = "Stranger";
    
    @JsonProperty
    public String getTemplate() {
    	return template;
    }
    
    @JsonProperty
    public void SetTemplate(String template) {
    	this.template = template;
    }
    
    @JsonProperty
    public String getDefaultName() {
    	return defaultName;
    }
    
    @JsonProperty
    public void SetDefaultName(String name) {
    	this.defaultName = template;
    }
    
    
}
