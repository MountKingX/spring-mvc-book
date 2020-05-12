package com.book.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeLogInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterceptor.class);

    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) {
        final long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        final String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();
        final String path = request.getRequestURL() + queryString;
        final long startTime = (Long) request.getAttribute("startTime");
        final long endTime = System.currentTimeMillis();
        if (!path.contains("resources") && !path.contains("webjars")) {
            LOGGER.info(String.format("%s millisecond taken to process the request %s.",(endTime - startTime), path));
        }
    }

    public void afterCompletion(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Object handler,
                                final Exception exceptionIfAny){
            // NO operation.
    }
}
