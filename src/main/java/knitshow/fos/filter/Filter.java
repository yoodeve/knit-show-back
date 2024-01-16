package knitshow.fos.filter;

import knitshow.fos.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class Filter extends GenericFilter {
    private final JwtProvider jwtProvider;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    String bearerToken = httpServletRequest.getHeader("Authorization");
    String token = jwtProvider.getToken(bearerToken);
    Authentication authentication = jwtProvider.getAuthentication(token);
    if(authentication != null) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    chain.doFilter(request, response);
    }


}
