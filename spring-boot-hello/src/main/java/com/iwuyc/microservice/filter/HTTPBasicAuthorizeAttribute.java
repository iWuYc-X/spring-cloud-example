package com.iwuyc.microservice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPBasicAuthorizeAttribute implements Filter
{

    private static final Logger LOG = LoggerFactory.getLogger(HTTPBasicAuthorizeAttribute.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        LOG.info("local addr", request.getLocalAddr());
        LOG.info("local addr", request.getLocalAddr());
        LOG.info("local addr", request.getLocalAddr());
        return;
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub

    }

}
