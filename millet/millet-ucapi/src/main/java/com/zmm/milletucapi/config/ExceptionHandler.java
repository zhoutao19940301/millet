package com.zmm.milletucapi.config;

import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.common.TkResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @Classname ExceptionHandler
 * @Description 统一参数异常处理
 * @Date 2019/12/2 14:36
 * @Created by yc
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
//        /**设置validator模式为快速失败返回*/
//        postProcessor.setValidator(validator());
//        return postProcessor;
//    }
//
//    @Bean
//    public Validator validator(){
//        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
//                .configure()
//                .addProperty( "hibernate.validator.fail_fast", "true" )
//                .buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//
//        return validator;
//    }

    /**
     * json参数异常处理
     * @param cve
     * @param httpServletRequest
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public Response methodArgNotValidException(ConstraintViolationException cve, HttpServletRequest httpServletRequest) {
        log.error(cve.getMessage(),cve);
        Set<ConstraintViolation<?>> cves = cve.getConstraintViolations();
        StringBuffer errorMsg = new StringBuffer();
        cves.forEach(ex -> errorMsg.append(ex.getMessage()));
        Response response = new Response(HttpStatus.BAD_REQUEST.value()+"",errorMsg.toString());
        return response;
    }

    /**
     * param参数异常处理
     * @param ex
     * @param request
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public Response methodDtoNotValidException(Exception ex, HttpServletRequest request) {
        log.error(ex.getMessage(),ex);
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
        List<ObjectError> errors = c.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        errors.stream().forEach(x -> {

            errorMsg.append(x.getDefaultMessage()).append(";");
        });
        Response response = new Response(HttpStatus.BAD_REQUEST.value()+"",errorMsg.toString());
        return response;
    }

    /**
     * 400 - Bad Request
     */
    @org.springframework.web.bind.annotation.ExceptionHandler({ MissingServletRequestParameterException.class })
    public Response handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        Response response = new Response(HttpStatus.BAD_REQUEST.value()+"","缺少请求参数"+e.getParameterName());
        return response;
    }

    /**
     * 参数解析错误处理
     * @param e
     * @param req
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler ({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class })
    public Response httpMessageNotReadableException(Exception e, WebRequest req) {
        log.error(e.getMessage(),e);
        Response response = new Response(HttpStatus.BAD_REQUEST.toString(),"参数解析失败");
        return response;
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
//    public Map httpRequestMethodNotSupportedException(Exception e, WebRequest req) {
//        log.error(e.getMessage(),e);
//        Map<String, Object> respMap = new HashMap<>(4);
//        respMap.put("code",HttpStatus.BAD_REQUEST);
//        respMap.put("msg", "restful请求无法识别");
//        return respMap;
//    }

    /**
     * 获取其它异常。包括500
     * @param e
     * @return
     * @throws Exception
     */
    @org.springframework.web.bind.annotation.ExceptionHandler ({ Exception.class })
    public Response defaultErrorHandler(Exception e){
        log.error("其它异常Exception", e);
//        return "其它异常：" + e.getMessage();
        Response response = new Response(TkResponseCode.ERROR_NORMAL,"处理错误");
        return response;
    }

}