package com.cbms.commons.rest;

import java.util.Map;

import javax.validation.ConstraintViolationException;

import com.cbms.commons.beanvalidator.BeanValidators;
import com.cbms.commons.mapper.JsonMapper;
import com.cbms.commons.web.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 自定义ExceptionHandler，专门处理Restful异常
 *
 * Created by Administrator on 2015/3/19.
 */

// 会被Spring-MVC自动扫描，但又不属于Controller的annotation。
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 处理RestException.
     */
    @ExceptionHandler(value = { RestException.class })
    public final ResponseEntity<?> handleException(RestException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaTypes.TEXT_PLAIN_UTF_8));
        return handleExceptionInternal(ex, ex.getMessage(), headers, ex.status, request);
    }

    /**
     * 处理JSR311 Validation异常.
     */
    @ExceptionHandler(value = { ConstraintViolationException.class })
    public final ResponseEntity<?> handleException(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = BeanValidators.extractPropertyAndMessage(ex.getConstraintViolations());
        String body = jsonMapper.toJson(errors);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaTypes.TEXT_PLAIN_UTF_8));
        return handleExceptionInternal(ex, body, headers, HttpStatus.BAD_REQUEST, request);
    }

}
