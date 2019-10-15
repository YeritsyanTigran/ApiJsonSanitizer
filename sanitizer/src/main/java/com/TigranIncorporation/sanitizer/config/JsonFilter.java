package com.TigranIncorporation.sanitizer.config;

import com.google.json.JsonSanitizer;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JsonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request,wrapper);
        if(response.getContentType() == null || response.getContentType().contains("application/json")) {
            String content = new String(wrapper.getDataStream());
            content = JsonSanitizer.sanitize(content);
            response.getOutputStream().write(content.getBytes());
        }
    }
}
