package com.d3.omomo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
