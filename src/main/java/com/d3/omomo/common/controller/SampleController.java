package com.d3.omomo.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController implements ErrorController {
//  @RequestMapping("/error")
//  public String handleError() {
//    return "/index.html";
//  }
//
//  @RequestMapping("/")
//  public String handleError1() {
//    return "/index.html";
//  }

  @RequestMapping("/")
  public String index(){
    return "index.html";
  }

  @RequestMapping("/error")
  public String errorPage(){
    return "index.html";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }

}
