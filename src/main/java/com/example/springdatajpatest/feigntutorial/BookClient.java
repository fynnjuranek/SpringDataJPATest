package com.example.springdatajpatest.feigntutorial;

import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("book")
public interface BookClient {
    // HTTP verb
    @RequestMapping(method = RequestMethod.GET, value = "/book/{isbn}")
    BookResource  findByIsbn(@Param("isbn") String isbn);

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    List<BookResource> findAll();

    @RequestMapping(method = RequestMethod.POST, value = "/books/{isbn}", consumes = "application/json")
    void create(Book book);
}
