package com.auto.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.solr.repository.SolrRepository;

import java.io.Serializable;

/**
 * Created by Roy on 2017/6/21.
 */
@NoRepositoryBean
public interface SolrCrudRepository<T, ID extends Serializable> extends SolrRepository<T, ID>, PagingAndSortingRepository<T, ID>  {
}