package org.m88i.camel.component.wordpress.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag extends Classifier implements Serializable {

    private static final long serialVersionUID = 1999287860335998496L;

}