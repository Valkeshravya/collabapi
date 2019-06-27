package com.shravya.collabapi.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@EnableWebMvc
@ComponentScan(basePackages="com.shravya")
public class AppConfig extends WebMvcConfigurerAdapter
{

}
