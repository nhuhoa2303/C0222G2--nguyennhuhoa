package com.codegym.service;



import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> displayAll();

    void save(Blog blog);

    void update(Blog blog);

    Blog displayAllById(Integer id);

    void delete(Integer id);

//    Page<Blog> displayAllBlog(Pageable pageable);

    Blog searchByContentBlog(String name);
//
    Page<Blog> displayAllByContentBlog(String name, Pageable pageable);

}
