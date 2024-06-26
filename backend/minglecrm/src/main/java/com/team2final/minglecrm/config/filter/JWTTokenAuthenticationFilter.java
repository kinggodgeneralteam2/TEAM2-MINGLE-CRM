package com.team2final.minglecrm.config.filter;

import com.team2final.minglecrm.service.jwt.JwtProvider;
import com.team2final.minglecrm.vo.Subject;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JWTTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JWTTokenAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("Authorization"); // 요청 헤더 중 Authorizaion: Bearer '토큰'

        if(authorization!=null) {
            String atk = authorization.substring(7); // Bearer 이후
            try {
                Subject subject = jwtProvider.getSubject(atk);
                String requestURI = request.getRequestURI();
                if (subject.getType().equals("RTK") && !requestURI.equals("/api/v1/auth/renew")) {
                    throw new JwtException("토큰을 확인하세요");
                }

                String username = subject.getEmail();
                String authorities = subject.getAuthority();
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (JwtException e) {
                request.setAttribute("exception", e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }


    /**
     * 로그인 시에는 해당 필터를 거치지 않도록 설정합니다. ( 로그인 시에는 토큰이 없는 상황입니다. )
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals("/user/signin");
    }
}