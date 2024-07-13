package com.shop.app.config.filters;

import com.shop.app.config.JwtTokenUtil;
import com.shop.app.helper.exceptions.JwtTokenException;
import com.shop.app.helper.uimodels.people.UserVM;
import com.shop.app.services.people.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Component
public class JwtRequestFilter implements Filter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
   @Autowired
    private UserService userService;

    private List<String> excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Filter.super.init(filterConfig);
        excludeUrls = new ArrayList<>();
        excludeUrls.add("/api/user/login");
        excludeUrls.add("/api/color/");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String url = ((HttpServletRequest) request).getRequestURI().toLowerCase();
            if (excludeUrls.stream().anyMatch(x -> url.equals(x))) {
                chain.doFilter(request, response);
                return;
            }


            String requestTokenHeader = ((HttpServletRequest) request).getHeader("Authorization");
            if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
                throw new JwtTokenException("request token header does not set!");
            }
            String token = requestTokenHeader.substring(7);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            if (username == null) {
                throw new JwtTokenException("username can not resolve");
            }
            UserVM userVM = new UserVM(userService.getByUsername(username));
            if (!jwtTokenUtil.validateToken(token, userVM)) {
                throw new JwtTokenException("Invalid token!");
            }
            chain.doFilter(request, response);
        } catch (JwtTokenException e) {
            ((HttpServletResponse) response)
                    .sendError(HttpServletResponse.SC_UNAUTHORIZED
                            , "unauthorized");
        } catch (Exception ex) {
            ((HttpServletResponse) response)
                    .sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR
                            , ex.getMessage());

        }
    }




    }


