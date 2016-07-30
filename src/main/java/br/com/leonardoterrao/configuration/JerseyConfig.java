package br.com.leonardoterrao.configuration;

import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.packages("br.com.leonardoterrao.rest");
    }

}
