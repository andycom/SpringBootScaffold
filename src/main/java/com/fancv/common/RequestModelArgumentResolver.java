package com.fancv.common;

import com.alibaba.fastjson.JSON;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * @author hamish-wu
 */
@Log4j2
public class RequestModelArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String JSON_REQUEST_BODY = "JSON_REQUEST_BODY";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestModel.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final String parameterJson = webRequest.getParameter(parameter.getParameterName());
        Iterator<String> names = webRequest.getParameterNames();
        String body = getRequestBody(webRequest);
        log.info("参数打印parameterNames:{}:{}", JSON.toJSONString(names), body);
        //parameter.getGenericParameterType() 返回参数的完整类型（带泛型）
        final Type type = parameter.getGenericParameterType();
        final Object o = JSON.parseObject(body.replaceAll("\\}", "").split(":")[1], type);
        return o;
    }

    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) servletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getInputStream());
                servletRequest.setAttribute(JSON_REQUEST_BODY, jsonBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonBody;

    }
}
