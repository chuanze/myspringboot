package com.chuanze.exception;

import com.chuanze.result.Result;
import com.chuanze.result.ResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@ControllerAdvice
public class Webception {
    @ExceptionHandler(value = Exception.class)
    //@ResponseBody
    public Object exceptionHandle(HttpServletRequest reqest, HttpServletResponse response, Exception e){
        //Result result=Result.createByErrorCodeMessage(ResultCode.ERROR.getCode(),e.getMessage());
        //log.info("捕获异常");
        //log.error(e.getMessage());
        //return result;
        if(isAjax(reqest)){
            return Result.createByErrorCodeMessage(ResultCode.ERROR.getCode(),e.getMessage());
        }else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("message", e.getMessage());
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName("/error");
            return mav;
        }
    }

    //@ExceptionHandler(value=Exception.class)
    //public Object exceptionWebHandle(HttpServletRequest request,HttpServletResponse response,Exception e){
    //    ModelAndView modelAndView=new ModelAndView();
    //    modelAndView.addObject("message",e.getMessage());
    //    modelAndView.setViewName("/error");
    //    return modelAndView;
    //}
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }

}
