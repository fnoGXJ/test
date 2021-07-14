package com.gxj.test.utils;

import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestUtil {
    public static Model getMessage(HttpServletRequest httpServletRequest
                                   ,Model model){
        String method = httpServletRequest.getMethod();
        Map<String,String> headers = getHeaders(httpServletRequest);
        Cookie[] cookies = httpServletRequest.getCookies();
        Map<String, String> postParams = null;
        if("POST".equals(method)){
            postParams = getPostParams(httpServletRequest);
        }
        model.addAttribute("postParams",postParams);
        model.addAttribute("cookies",cookies);
        model.addAttribute("headers",headers);
        model.addAttribute("method",method);
        return model;
    }
    private static Map<String,String> getHeaders(HttpServletRequest httpServletRequest){
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        Map<String,String> headers = new HashMap<>();
        while(headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            String header = httpServletRequest.getHeader(headName);
            headers.put(headName,header);
        }
        return headers;
    }
    private static Map<String,String> getPostParams(HttpServletRequest httpServletRequest){
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        Map<String,String> parameters = new HashMap<>();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameter = httpServletRequest.getParameter(parameterName);
            parameters.put(parameterName,parameter);
        }
        return parameters;
    }
}
