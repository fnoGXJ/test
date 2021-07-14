package com.gxj.test.controller;

import com.gxj.test.utils.HttpRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@Controller
public class InfoController {
    @RequestMapping("/info")
    public String infoGet(HttpServletRequest httpServletRequest,
                          Model model){
        HttpRequestUtil.getMessage(httpServletRequest,model);
        LocalTime end = LocalTime.now();
        Duration time = Duration.between((Temporal) httpServletRequest.getAttribute("time"), end);
        httpServletRequest.setAttribute("time",time.toMillis());
        return "info";
    }
}
