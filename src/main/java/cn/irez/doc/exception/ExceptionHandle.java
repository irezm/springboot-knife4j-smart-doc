package cn.irez.doc.exception;

import cn.irez.doc.api.Result;
import cn.irez.doc.constant.HttpState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义全局异常处理
 * @author crg
 */
@SuppressWarnings("SpellCheckingInspection")
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    //HTTP参数异常
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result<?> handleHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException exception) {
        return createApiResponse(HttpState.INTERNAL_SERVER_ERROR.getCode(),"传入参数有误",request,exception);
    }

    //hutool 断言异常
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result<?>  handleBusinessException(HttpServletRequest request, IllegalArgumentException exception) {
        return createApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),request,exception);
    }

    //全局异常拦截
    @ExceptionHandler(value = Exception.class)
    public Result<?> handle(HttpServletRequest request, Exception exception) {
        log.error("全局异常拦截----requestUrl :{} method:{} message:{} exception:{}" ,request.getRequestURI(), request.getMethod() , exception.getMessage(), exception);
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    //统一返回格式
    private Result<?> createApiResponse(int code,String msg,HttpServletRequest request, Exception exception){
        log.error("hutool 断言异常----requestUrl :{} method:{} message:{} " ,request.getRequestURI(), request.getMethod() , exception.getMessage());
        return new Result<>(code,false,msg);
    }
}
