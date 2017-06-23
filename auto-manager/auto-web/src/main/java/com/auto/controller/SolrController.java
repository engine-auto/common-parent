package com.auto.controller;

import java.io.IOException;
import java.util.List;

import com.auto.RedisClient;
import com.auto.entity.Product;
import com.auto.repository.SolrProductRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolrController {

    @Autowired
    private SolrProductRepository productRepository;

    @RequestMapping("/testSolr")
    public String showUsers(Model model, @PageableDefault(page = 1,size = 20,value = 30) Pageable pageable) {
//        Product product = productRepository.findOne("1");
//        Product product = productRepository.findByEntId(904073);
        Page<Product> product = productRepository.findByName("店",pageable);
        System.out.print(product);
        return "users";
    }

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    public String set(String key, String value) throws Exception{
        redisClient.set(key, value);
        return "success";
    }

    @RequestMapping("/get")
    public String get(String key) throws Exception {
        return redisClient.get(key);
    }
}