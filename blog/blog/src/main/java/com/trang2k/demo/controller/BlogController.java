package com.trang2k.demo.controller;

import com.trang2k.demo.entities.Blog;
import com.trang2k.demo.entities.Log;
import com.trang2k.demo.enums.ErrorType;
import com.trang2k.demo.enums.ExceptionType;
import com.trang2k.demo.enums.JSONReturn;
import com.trang2k.demo.enums.SuccessType;
import com.trang2k.demo.models.BlogModel;
import com.trang2k.demo.response.ResponseBlog;
import com.trang2k.demo.response.ResponseBlogResult;
import com.trang2k.demo.response.ResponseListBlog;
import com.trang2k.demo.response.ResponseListBlogResult;
import com.trang2k.demo.services.BlogService;
import com.trang2k.demo.services.LogService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    LogService logService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(BlogService.class);
    private String logMs;

    @GetMapping("/blog/get_all")
    public ResponseListBlog getAll(@RequestParam(value = "page", required = false, defaultValue = "1") final Integer page) {
        ResponseListBlog response = new ResponseListBlog();
        try {
            logMs = "---------- BlogController/getAll/start ---------->";
            logger.info(logMs);
            logMs = String.format("[%s]. Get All", SuccessType.READ_SUCCESS);
            logger.info(logMs);

            List<BlogModel> lstBlogModel = new ArrayList<>();
            List<Blog> listBlog = blogService.getAll(page - 1);

            for (Blog blog : listBlog) {
                BlogModel blogModel = new BlogModel();
                blogModel.setId(blog.getId());
                blogModel.setTitle(blog.getTitle());
                blogModel.setDescription(blog.getDescription());
                blogModel.setContent(blog.getContent());
                blogModel.setCreatedBy(blog.getCreatedBy());
                lstBlogModel.add(blogModel);
            }

            ResponseListBlogResult result = new ResponseListBlogResult();
            result.setLstBlogModel(lstBlogModel);
            response.setErrorMessage(JSONReturn.SUCCESS.toString());
            response.setResponseListBlogResult(result);

            return response;
        } catch (Exception e) {
            logMs = String.format("[%s]. Get All", ErrorType.READ_ERROR);
            logger.error(logMs, e);

            response.setErrorMessage(JSONReturn.FAIL.toString());

            return response;
        } finally {
            logMs = "<---------- BlogController/getAll/end ----------";
            logger.info(logMs);
        }
    }

    @GetMapping("/blog/{id}")
    public ResponseBlog getById(@PathVariable("id") Integer id) {
        ResponseBlog response = new ResponseBlog();
        try {
            logMs = "---------- BlogController/getById/start ---------->";
            logger.info(logMs);
            if (blogService.existsById(id)) {
                logMs = String.format("[%s]. Id = [%s]", SuccessType.READ_SUCCESS, id);
                logger.info(logMs);

                BlogModel blogModel = new BlogModel();
                Blog blog = blogService.getById(id);
                blogModel.setId(blog.getId());
                blogModel.setTitle(blog.getTitle());
                blogModel.setDescription(blog.getDescription());
                blogModel.setContent(blog.getContent());
                blogModel.setCreatedBy(blog.getCreatedBy());

                ResponseBlogResult result = new ResponseBlogResult();
                result.setBlogModel(blogModel);
                response.setErrorMessage(JSONReturn.SUCCESS.toString());
                response.setResponseBlogResult(result);

                return response;
            } else {
                logMs = String.format("[%s]. Id = [%s]", ExceptionType.NOT_FOUND, id);
                logger.info(logMs);

                response.setErrorMessage(JSONReturn.NOT_FOUND.toString());

                return response;
            }
        } catch (Exception e) {
            logMs = String.format("[%s]. Id = [%s]", ErrorType.READ_ERROR, id);
            logger.error(logMs, e);

            response.setErrorMessage(ErrorType.READ_ERROR.toString());

            return response;
        } finally {
            logMs = "<---------- BlogController/getById/end ----------";
            logger.info(logMs);
        }
    }

    @PutMapping("/blog/save")
    public ResponseBlog save(@RequestBody Blog blog) {
        ResponseBlog response = new ResponseBlog();
        try {
            logMs = "---------- BlogController/save/start ---------->";
            logger.info(logMs);
            logMs = String.format("[%s]. Object = [%s]", SuccessType.CREATE_SUCCESS, blog);
            logger.info(logMs);
            blogService.save(blog);

            Log log = new Log();
            log.setContent(logMs);
            logService.save(log);

            response.setErrorMessage(JSONReturn.SUCCESS.toString());

            return response;
        } catch (Exception e) {
            logMs = String.format("[%s]. Object = [%s]", ErrorType.CREATE_ERROR, blog);
            logger.error(logMs, e);

            response.setErrorMessage(JSONReturn.FAIL.toString());

            return response;
        } finally {
            logMs = "<---------- BlogController/save/end ----------";
            logger.info(logMs);
        }
    }

    @PostMapping("/blog/update")
    public ResponseBlog update(@RequestBody Blog blog) {
        ResponseBlog response = new ResponseBlog();
        try {
            logMs = "---------- BlogController/update/start ---------->";
            logger.info(logMs);
            logMs = String.format("[%s]. Object = [%s]", SuccessType.UPDATE_SUCCESS, blog);
            logger.info(logMs);
            blogService.update(blog);

            Log log = new Log();
            log.setContent(logMs);
            logService.save(log);

            response.setErrorMessage(JSONReturn.SUCCESS.toString());

            return response;
        } catch (Exception e) {
            logMs = String.format("[%s]. Add Blog = [%s]", ErrorType.CREATE_ERROR, blog);
            logger.error(logMs, e);

            response.setErrorMessage(JSONReturn.FAIL.toString());

            return response;
        } finally {
            logMs = "<---------- BlogController/update/end ----------";
            logger.info(logMs);
        }
    }

    @DeleteMapping("/blog/{id}")
    @Transactional
    public ResponseBlog delete(@PathVariable("id") Integer id) {
        ResponseBlog response = new ResponseBlog();
        try {
            logMs = "---------- BlogController/delete/start ---------->";
            logger.info(logMs);
            if (blogService.existsById(id)) {
                BlogModel blogModel = new BlogModel();
                Blog blog = blogService.getById(id);
                blogModel.setId(blog.getId());
                blogModel.setTitle(blog.getTitle());
                blogModel.setDescription(blog.getDescription());
                blogModel.setContent(blog.getContent());
                blogModel.setCreatedBy(blog.getCreatedBy());

                logMs = String.format("[%s]. Object = [%s]", SuccessType.DELETE_SUCCESS, blog);
                logger.info(logMs);

                blogService.delete(id);

                Log log = new Log();
                log.setContent(logMs);
                log.setCreatedBy("ADMIN");
                logService.save(log);

                ResponseBlogResult result = new ResponseBlogResult();
                result.setBlogModel(blogModel);
                response.setResponseBlogResult(result);
                response.setErrorMessage(JSONReturn.SUCCESS.toString());

                return response;
            } else {
                logMs = String.format("[%s]. Id = [%s]", ExceptionType.NOT_FOUND, id);
                logger.info(logMs);

                response.setErrorMessage(JSONReturn.NOT_FOUND.toString());;

                return response;
            }
        } catch (Exception e) {
            logMs = String.format("[%s]. Id = [%s]", ErrorType.DELETE_ERROR, id);
            logger.error(logMs, e);

            response.setErrorMessage(JSONReturn.FAIL.toString());

            return response;
        } finally {
            logMs = "<---------- BlogController/delete/end ----------";
            logger.info(logMs);
        }
    }

}
