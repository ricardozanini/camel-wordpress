package org.m88i.camel.component.wordpress.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.util.IntrospectionSupport;

@UriParams
public class WordpressEndpointConfiguration extends WordpressConfiguration {

    @UriParam(description = "The entity ID. Should be passed when the operation performed requires a specific entity, e.g. deleting a post")
    private Integer id;

    @UriParam(description = "The operation name. Required when the component can't figure out the operation by itself.")
    private String operation;
    
    public WordpressEndpointConfiguration() {

    }

    /**
     * The entity id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * The operation name
     * @return
     */
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    /**
     * Return all configuration properties on a map.
     * @return
     */
    public Map<String, Object> asMap() {
        final Map<String, Object> map = new HashMap<>();
        IntrospectionSupport.getProperties(this, map, null);
        return map;
    }
    

}
