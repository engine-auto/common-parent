package com.auto.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

/**
 * Created by Roy on 2017/6/21.
 */
@SolrDocument(solrCoreName = "core1")
public class Product {

    @Id
    String id;
    @Indexed(type = "long",name="ent_id")
    long entId;
    @Indexed(type = "String[]",name="name")
    String[] name;

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEntId() {
        return entId;
    }

    public void setEntId(long entId) {
        this.entId = entId;
    }


}