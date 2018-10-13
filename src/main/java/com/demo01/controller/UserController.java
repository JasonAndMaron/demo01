package com.demo01.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.demo01.model.User;
import com.demo01.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/showUser.do",method= RequestMethod.GET)
    public void selectUser(HttpServletRequest request, HttpServletResponse response){

        System.out.println("HttpServletRequest request is : " + request);
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException ex : " + ex.getMessage());
        }
        response.setCharacterEncoding("UTF-8");
        System.out.println("request.getparameter >>>. : " + request.getParameter("id"));
        System.out.println("After encoding...httpServletRequest getServletPath is : " + request.getServletPath());
        System.out.println("After encoding...httpServletRequest getHeaderNames is : " + request.getHeaderNames());
        System.out.println("After encoding...httpServletRequest getAuthType is : " + request.getAuthType());
        System.out.println("After encoding...httpServletRequest getPathInfo is : " + request.getPathInfo());
        System.out.println("After encoding...httpServletRequest getRequestedSessionId is : " + request.getRequestedSessionId());
        System.out.println("After encoding...httpServletRequest getRequestURL is : " + request.getRequestURL());
        System.out.println("After encoding...httpServletRequest getSession is : " + request.getSession());
        int objectId = Integer.parseInt(request.getParameter("id"));
        System.out.println("objectId : " + objectId);
        User user = this.userService.selectUser(objectId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            response.getWriter().write(mapper.writeValueAsString(user));
        } catch (IOException e) {
            System.out.println("showUser.do...write exception e = " + e);
        }
        try {
            response.getWriter().close();
            System.out.println("HttpServletResponse response is : " + response);
        } catch (IOException ex) {
            System.out.println("showUser.do...write close exception ex = " + ex);
        }
    }

    /**
     * 测试获取请求头信息
     * return mv
     */
    @RequestMapping(value="/getHeader",method= RequestMethod.GET)
    @ResponseBody
    public JSONObject getHeader(
            @RequestHeader("Host") String host,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader("Accept") String accept,
            @RequestHeader("Accept-Language") String acceptLanguage,
            @RequestHeader("Accept-Encoding") String acceptEncoding,
            @RequestHeader("Cookie") String cookie,
            @RequestHeader("Connection") String conn,
            @RequestHeader("X-Requested-With") String xRequestWith
            /*,
            @CookieValue("JSESSIONID") String cookie2*/){
        //@RequestHeader将http请求头信息赋值给形参
        //@CookieValue直接将请求头中的cookie的值赋值给形参
        System.out.println("start to access /getHeader method!!");
        JSONObject mav=new JSONObject();
        mav.put("host", host);
        mav.put("userAgent", userAgent);
        mav.put("accept", accept);
        mav.put("acceptLanguage", acceptLanguage);
        mav.put("acceptEncoding", acceptEncoding);
        mav.put("cookie", cookie);
        mav.put("conn", conn);
        mav.put("xRequestWith",xRequestWith);
//        mav.addObject("cookie2", cookie2);
//        mav.setViewName("result");  //返回值是个字符串，就是视图名

        System.out.println("model and view : " + mav);
        System.out.println("end to exit /getHeader method!!");
        return mav;
    }

}