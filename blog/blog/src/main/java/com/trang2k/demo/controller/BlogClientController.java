package com.trang2k.demo.controller;

import com.trang2k.demo.entities.Blog;
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
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cli")
public class BlogClientController {

    @Autowired
    BlogService blogService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(BlogService.class);
    private String logMs;

    @GetMapping("/blog/get_all")
    public ResponseListBlog getAllByStatus(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        ResponseListBlog response = new ResponseListBlog();
        try {
            logMs = "---------- BlogClientController/getAll/start ---------->";
            logger.info(logMs);
            logMs = String.format("[%s]. Get All", SuccessType.READ_SUCCESS);
            logger.info(logMs);

            Long count = blogService.countAllByStatus();
            Integer lastPage = count.intValue()/5;
            if(count > lastPage*5) {
                lastPage++;
            }

            List<BlogModel> lstBlogModel = new ArrayList<>();
            List<Blog> listBlog = blogService.getAllByStatus(page - 1);

            for (Blog blog : listBlog) {
                BlogModel blogModel = new BlogModel();
                blogModel.setId(blog.getId());
                blogModel.setTitle(blog.getTitle());
                blogModel.setDescription(blog.getDescription());
                blogModel.setContent(blog.getContent());
                blogModel.setCreatedBy(blog.getCreatedBy());
                blogModel.setCreatedDate(blog.getCreatedDate());
                lstBlogModel.add(blogModel);
            }

            ResponseListBlogResult result = new ResponseListBlogResult();
            result.setCount(count.intValue());
            result.setCurrentPage(page);
            result.setLastPage(lastPage);
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
            logMs = "<---------- BlogClientController/getAll/end ----------";
            logger.info(logMs);
        }
    }

    @GetMapping("/blog/{id}")
    public ResponseBlog getById(@PathVariable("id") Integer id) {
        ResponseBlog response = new ResponseBlog();
        try {
            logMs = "---------- BlogClientController/getById/start ---------->";
            logger.info(logMs);
            if (blogService.existsByIdAndStatus(id)) {
                logMs = String.format("[%s]. Id = [%s]", SuccessType.READ_SUCCESS, id);
                logger.info(logMs);

                BlogModel blogModel = new BlogModel();
                Blog blog = blogService.getById(id);
                blogModel.setId(blog.getId());
                blogModel.setTitle(blog.getTitle());
                blogModel.setDescription(blog.getDescription());
                blogModel.setContent(blog.getContent());
                blogModel.setCreatedBy(blog.getCreatedBy());
                blogModel.setCreatedDate(blog.getCreatedDate());

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
            logMs = "<---------- BlogClientController/getById/end ----------";
            logger.info(logMs);
        }
    }

}
