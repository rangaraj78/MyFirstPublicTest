
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
    "dbUserId",
    "userId",
    "message"
})
public class CreateUserResponse {

    /**
     * unique user id for the user in the database
     * (Required)
     * 
     */
    @JsonProperty("dbUserId")
    private String dbUserId;
    /**
     * unique user id for the user in the system
     * (Required)
     * 
     */
    @JsonProperty("userId")
    private String userId;
    /**
     * Response message from the server
     * (Required)
     * 
     */
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * unique user id for the user in the database
     * (Required)
     * 
     * @return
     *     The dbUserId
     */
    @JsonProperty("dbUserId")
    public String getDbUserId() {
        return dbUserId;
    }

    /**
     * unique user id for the user in the database
     * (Required)
     * 
     * @param dbUserId
     *     The dbUserId
     */
    @JsonProperty("dbUserId")
    public void setDbUserId(String dbUserId) {
        this.dbUserId = dbUserId;
    }

    public CreateUserResponse withDbUserId(String dbUserId) {
        this.dbUserId = dbUserId;
        return this;
    }

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

    public CreateUserResponse withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Response message from the server
     * (Required)
     * 
     * @return
     *     The message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Response message from the server
     * (Required)
     * 
     * @param message
     *     The message
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public CreateUserResponse withMessage(String message) {
        this.message = message;
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

    public CreateUserResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
