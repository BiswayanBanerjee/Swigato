// package com.example.demo.filter;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Component
// public class JwtFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws ServletException, IOException {
//         final String authorizationHeader = request.getHeader("Authorization");

//         String username = null;
//         String jwt = null;

//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             jwt = authorizationHeader.substring(7);
//             Claims claims = Jwts.parser()
//                     .setSigningKey("secret_key")
//                     .parseClaimsJws(jwt)
//                     .getBody();
//             username = claims.getSubject();
//             String role = claims.get("role", String.class);

//             if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                 JwtAuthenticationToken authentication = new JwtAuthenticationToken(username, null, role);
//                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authentication);
//             }
//         }
//         chain.doFilter(request, response);
//     }
// }