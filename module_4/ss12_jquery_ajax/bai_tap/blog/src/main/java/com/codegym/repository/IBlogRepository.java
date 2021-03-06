package com.codegym.repository;



import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = " select * from blog ", nativeQuery = true)
    Page<Blog> displayAllBlog(Pageable pageable);


//
//    @Query(value = " select * from blog where content_blog like :keyword ", nativeQuery = true,
//            countQuery = " select count(*)  from ( select * from blog  where content_blog like :keyword ) temp")
//    Page<Blog> searchAllByContentBlog(@Param("keyword") String name, Pageable pageable);


    Page<Blog> findAllByContentBlogContaining(String nameSearch, Pageable pageable);

}
