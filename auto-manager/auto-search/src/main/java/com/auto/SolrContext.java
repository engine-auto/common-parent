package com.auto;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import javax.annotation.Resource;

/**
 * Created by Roy on 2017/6/21.
 */
@Configuration
@EnableSolrRepositories(basePackages = {"com.auto.entity", "com.auto.repository"})

public class SolrContext {

    @Resource
    private Environment env;

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient(env.getRequiredProperty("spring.data.solr.host"));
    }

    @Bean
    public SolrOperations solrTemplate() {
        return new SolrTemplate(solrClient());
    }
}