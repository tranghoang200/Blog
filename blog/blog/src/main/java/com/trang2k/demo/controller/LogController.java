package com.trang2k.demo.controller;

import com.trang2k.demo.entities.Log;
import com.trang2k.demo.enums.ErrorType;
import com.trang2k.demo.enums.JSONReturn;
import com.trang2k.demo.enums.SuccessType;
import com.trang2k.demo.models.LogModel;
import com.trang2k.demo.response.*;
import com.trang2k.demo.services.BlogService;
import com.trang2k.demo.services.LogService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class LogController {

    @Autowired
    LogService logService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(BlogService.class);
    private String logMs;

    @GetMapping("/log/get_all")
    public ResponseListLog getAll(@RequestParam(value = "page", required = false, defaultValue = "1") final Integer page) {
        ResponseListLog response = new ResponseListLog();
        try {
            logMs = "---------- LogController/getAll/start ---------->";
            logger.info(logMs);
            logMs = String.format("[%s]. Get All", SuccessType.READ_SUCCESS);
            logger.info(logMs);

            List<LogModel> lstLogModel = new ArrayList<>();
            List<Log> listLog = logService.getAll(page - 1);

            for (Log log : listLog) {
                LogModel logModel = new LogModel();
                logModel.setContent(log.getContent());
                logModel.setCreatedBy(log.getCreatedBy());
                lstLogModel.add(logModel);
            }

            ResponseListLogResult result = new ResponseListLogResult();
            result.setLstLogModel(lstLogModel);
            response.setErrorMessage(JSONReturn.SUCCESS.toString());
            response.setResponseLogResult(result);

            return response;
        } catch (Exception e) {
            logMs = String.format("[%s]. Get All", ErrorType.READ_ERROR);
            logger.error(logMs, e);

            response.setErrorMessage(JSONReturn.FAIL.toString());

            return response;
        } finally {
            logMs = "<---------- LogController/getAll/end ----------";
            logger.info(logMs);
        }
    }

}
