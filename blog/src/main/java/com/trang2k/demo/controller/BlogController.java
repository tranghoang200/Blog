package com.trang2k.demo.controller;

import com.trang2k.demo.entities.Blog;
import com.trang2k.demo.services.BlogService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cli")
public class BlogController {

    @Autowired
    BlogService blogService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(BlogService.class);
    private String logMs;

    @GetMapping("/blog/get_all")
    public List<Blog> getAll() {
        try {
            logMs = "-- blogController/getAll/start -->";
            logger.info(logMs);
            logMs = String.format("[%s]. Get All", "SUCCESS");
            logger.info(logMs);
            return blogService.getAll();
        } catch (Exception e) {
            logMs = String.format("[%s]. Get All", "FAIL");
            logger.error(logMs, e);
            return null;
        } finally {
            logMs = "<-- blogController/getAll/end --";
            logger.info(logMs);
        }
    }

    @GetMapping("/blog/{id}")
    public Blog getById(@PathVariable("id") Integer id) {
        try {
            logMs = "-- blogController/getById/start -->";
            logger.info(logMs);
            if(blogService.existsById(id)) {
                logMs = String.format("[%s]. Id = [%s]", "SUCCESS", id);
                logger.info(logMs);
                return blogService.getById(id);
            } else {
                logMs = String.format("[%s]. Id = [%s]", "NOT FOUND", id);
                logger.info(logMs);
                return null;
            }
        } catch (Exception e) {
            logMs = String.format("[%s]. Id = [%s]", "FAIL", id);
            logger.error(logMs, e);
            return null;
        } finally {
            logMs = "<-- blogController/getById/end --";
            logger.info(logMs);
        }
    }

    @PutMapping("/blog/save")
    public Blog save(@RequestBody Blog blog) {
        try {
            logMs = "-- blogController/save/start -->";
            logger.info(logMs);
            logMs = String.format("[%s]. Blog = [%s]", "SUCCESS", blog);
            logger.info(logMs);
            return blogService.save(blog);
        } catch (Exception e) {
            logMs = String.format("[%s]. Blog = [%s]", "FAIL", blog);
            logger.error(logMs, e);
            return null;
        } finally {
            logMs = "<-- blogController/save/end --";
            logger.info(logMs);
        }
    }

    @PostMapping("/blog/update")
    public boolean update(@RequestBody Blog blog) {
        try {
            logMs = "-- blogController/update/start -->";
            logger.info(logMs);
            logMs = String.format("[%s]. Blog = [%s]", "SUCCESS", blog);
            logger.info(logMs);
            blogService.update(blog);
            return true;
        } catch (Exception e) {
            logMs = String.format("[%s]. Blog = [%s]", "FAIL", blog);
            logger.error(logMs, e);
            return false;
        } finally {
            logMs = "<-- blogController/update/end --";
            logger.info(logMs);
        }
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        try {
            logMs = "-- blogController/delete/start -->";
            logger.info(logMs);
            if(blogService.existsById(id)) {
                logMs = String.format("[%s]. Id = [%s]", "SUCCESS", id);
                logger.info(logMs);
                blogService.delete(id);
                return true;
            } else {
                logMs = String.format("[%s]. Id = [%s]", "NOT FOUND", id);
                logger.info(logMs);
                return false;
            }
        } catch (Exception e) {
            logMs = String.format("[%s]. Id = [%s]", "FAIL", id);
            logger.error(logMs, e);
            return false;
        } finally {
            logMs = "<-- blogController/delete/end --";
            logger.info(logMs);
        }
    }

}
