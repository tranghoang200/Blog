package com.trang2k.demo.services;

import com.trang2k.demo.entities.Blog;
import com.trang2k.demo.repositories.BlogRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BlogService.class);

    public List<Blog> getAll() {
        return  blogRepository.findAll();
    }

    public Blog getById(Integer id) {
        return blogRepository.findBlogById(id);
    }

    public Boolean existsById(Integer id) {
        return blogRepository.existsById(id);
    }

    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }
}
