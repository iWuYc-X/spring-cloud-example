package com.iwuyc.microservice.northbound.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerMapping;

public class RequestUtil
{
    public static final HttpHeaders POST_HEADERS;

    static
    {
        HttpHeaders tempPostHeaders = new HttpHeaders();
        tempPostHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        POST_HEADERS = HttpHeaders.readOnlyHttpHeaders(tempPostHeaders);
    }

    public static String getPathParameter(HttpServletRequest request)
    {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }

}
