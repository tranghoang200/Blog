package com.trang2k.demo.services;

import com.trang2k.demo.entities.Blog;
import com.trang2k.demo.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public long countAll() {
        return blogRepository.count();
    }

    public List<Blog> getAll(Integer index) {
        Pageable pageable = PageRequest.of(index, 5);
        return blogRepository.findAllByOrderByIdDesc(pageable);
    }

    public long countAllByStatus() {
        return blogRepository.countAllByStatus(1);
    }

    public List<Blog> getAllByStatus(Integer index) {
        Pageable pageable = PageRequest.of(index, 5);
        return blogRepository.findAllByStatusOrderByIdDesc(1, pageable);
    }

    public Blog getById(Integer id) {
        return blogRepository.findBlogById(id);
    }

    public Boolean existsById(Integer id) {
        return blogRepository.existsById(id);
    }

    public Boolean existsByIdAndStatus(Integer id) {
        return blogRepository.existsBlogByIdAndStatus(id, 1);
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    public void lock(Blog blog) {
        blog.setStatus(0);
        blogRepository.save(blog);
    }

    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

}
