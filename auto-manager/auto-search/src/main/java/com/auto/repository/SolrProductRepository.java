package com.auto.repository;

import com.auto.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Distance;
import org.springframework.data.solr.core.geo.Point;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * Created by Roy on 2017/6/21.
 */

public interface SolrProductRepository extends SolrCrudRepository<Product, String> {

    //Derived Query will be "q=popularity:<popularity>&start=<page.number>&rows=<page.size>"
    Page<Product> findById(String id, Pageable page);

    Page<Product> findByEntIdBetween(String id1,String id2,Pageable pageable);
    Product findByEntId(long entId);

//    Product findByName(String name);

    Page<Product> findByName(String name, Pageable page);

//    //Will execute count prior to determine total number of elements
//    //Derived Query will be "q=name:<name>*&start=0&rows=<result of count query for q=name:<name>>"
//    List<Product> findByNameStartingWith(String name);
//
    //Derived Query will be "q=inStock:true&start=<page.number>&rows=<page.size>"
    @Query(value = "name:?0")
    Page<Product> findByAvailableTrue(String name,Pageable page);
//
//    //Derived Query will be "q=inStock:<inStock>&start=<page.number>&rows=<page.size>"
//    @Query("inStock:?0")
//    Page<Product> findByAvailableUsingAnnotatedQuery(boolean inStock, Pageable page);
//
//    //Will execute count prior to determine total number of elements
//    //Derived Query will be "q=inStock:false&start=0&rows=<result of count query for q=inStock:false>&sort=name desc"
//    List<Product> findByAvailableFalseOrderByNameDesc();
//
//    //Execute faceted search
//    //Query will be "q=name:<name>&facet=true&facet.field=cat&facet.limit=20&start=<page.number>&rows=<page.size>"
//    @Query(value = "name:?0")
//    @Facet(fields = { "cat" }, limit=20)
//    FacetPage<Product> findByNameAndFacetOnCategory(String name, Pageable page);
//
//    //Boosting criteria
//    //Query will be "q=name:<name>^2 OR description:<description>&start=<page.number>&rows=<page.size>"
//    Page<Product> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);
//
//    //Highlighting results
//    //Query will be "q=name:(<name...>)&hl=true&hl.fl=*"
//    @Highlight
//    HighlightPage<Product> findByNameIn(Collection<String> name, Pageable page);
//
//    //Spatial Search
//    //Query will be "q=location:[<bbox.start.latitude>,<bbox.start.longitude> TO <bbox.end.latitude>,<bbox.end.longitude>]"
//    Page<Product> findByLocationNear(Box bbox);
//
//    //Spatial Search
//    //Query will be "q={!geofilt pt=<location.latitude>,<location.longitude> sfield=location d=<distance.value>}"
//    Page<Product> findByLocationWithin(Point location, Distance distance);
//
//    List<Product> findByAuthorLike(String author);
}