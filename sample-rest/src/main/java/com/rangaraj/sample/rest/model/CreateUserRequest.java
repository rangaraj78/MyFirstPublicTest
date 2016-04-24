
package com.rangaraj.sample.rest.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * User
 * <p>
 * User attributes
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "userId",
    "welcomeMessage"
})
public class CreateUserRequest {

    /**
     * unique user id for the user in the system
     * (Required)
     * 
     */
    @JsonProperty("userId")
    private String userId;
    /**
     * welcome message for the user
     * (Required)
     * 
     */
    @JsonProperty("welcomeMessage")
    private String welcomeMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * unique user id for the user in the system
     * (Required)
     * 
     * @return
     *     The userId
     */
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    /**
     * unique user id for the user in the system
     * (Required)
     * 
     * @param userId
     *     The userId
     */
    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CreateUserRequest withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * welcome message for the user
     * (Required)
     * 
     * @return
     *     The welcomeMessage
     */
    @JsonProperty("welcomeMessage")
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * welcome message for the user
     * (Required)
     * 
     * @param welcomeMessage
     *     The welcomeMessage
     */
    @JsonProperty("welcomeMessage")
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public CreateUserRequest withWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CreateUserRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
