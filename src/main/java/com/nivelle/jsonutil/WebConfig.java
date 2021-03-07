package com.nivelle.jsonutil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2021/03/03
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //字符串转换器
        List<MediaType> listString = new ArrayList<>();
        //字符串的消息类型为text/plain
        listString.add(MediaType.TEXT_PLAIN);
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setSupportedMediaTypes(listString);

//        //json转换器
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON);
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//
//        converters.add(mappingJackson2HttpMessageConverter);
        converters.add(stringHttpMessageConverter);
    }

}
