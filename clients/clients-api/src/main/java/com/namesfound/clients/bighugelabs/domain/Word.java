
package com.namesfound.clients.bighugelabs.domain;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "noun",
    "verb"
})
public class Word {

    @JsonProperty("noun")
    @Valid
    private Noun noun;
    @JsonProperty("verb")
    @Valid
    private Verb verb;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The noun
     */
    @JsonProperty("noun")
    public Noun getNoun() {
        return noun;
    }

    /**
     * 
     * @param noun
     *     The noun
     */
    @JsonProperty("noun")
    public void setNoun(Noun noun) {
        this.noun = noun;
    }

    /**
     * 
     * @return
     *     The verb
     */
    @JsonProperty("verb")
    public Verb getVerb() {
        return verb;
    }

    /**
     * 
     * @param verb
     *     The verb
     */
    @JsonProperty("verb")
    public void setVerb(Verb verb) {
        this.verb = verb;
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
