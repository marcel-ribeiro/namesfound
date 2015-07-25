
package com.namesfound.clients.bighugelabs.domain;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "syn",
    "ant"
})
public class Verb {

    @JsonProperty("syn")
    @Valid
    private List<String> syn = new ArrayList<String>();
    @JsonProperty("ant")
    @Valid
    private List<String> ant = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The syn
     */
    @JsonProperty("syn")
    public List<String> getSyn() {
        return syn;
    }

    /**
     * 
     * @param syn
     *     The syn
     */
    @JsonProperty("syn")
    public void setSyn(List<String> syn) {
        this.syn = syn;
    }

    /**
     * 
     * @return
     *     The ant
     */
    @JsonProperty("ant")
    public List<String> getAnt() {
        return ant;
    }

    /**
     * 
     * @param ant
     *     The ant
     */
    @JsonProperty("ant")
    public void setAnt(List<String> ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
