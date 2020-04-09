package com.zhongyi.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private static String character;

    @Override
    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub
        character = config.getInitParameter("character");
        if (character == null || character.equals("")) {
            character = "utf-8";
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        req.setCharacterEncoding(character);
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}
