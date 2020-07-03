package com.trang2k.demo.repositories;

import com.trang2k.demo.entities.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    List<Blog> findAllByOrderByIdDesc(Pageable pageable);

    Long countAllByStatus(Integer status);

    List<Blog> findAllByStatusOrderByIdDesc(Integer status, Pageable pageable);

    Blog findBlogById(Integer id);

    Boolean existsBlogByIdAndStatus(Integer id, Integer status);

}
