package com.demojwt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private AuthenticationProvider authenticationProvider;
        // private final UserAuthEntryPoint userAuthEntryPoint;

        private static final String[] WHITE_LIST_URL = { "/api/v1/auth/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**",
                        "/swagger-ui.html" };

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .csrf(csrf -> csrf.disable())
                                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(req -> {
                                        req.requestMatchers(HttpMethod.POST, "/api/v1/auth/**").permitAll();
                                        req.anyRequest().authenticated();
                                })
                                .addFilterBefore(
                                                jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
                // http
                // .csrf(AbstractHttpConfigurer::disable)
                // .authorizeHttpRequests(req ->req
                // .requestMatchers(WHITE_LIST_URL)
                // .permitAll()
                // .requestMatchers("/api/v1/management/**")
                // .authenticated().anyRequest().authenticated()
                // )
                // .sessionManagement(session ->
                // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // .authenticationProvider(authenticationProvider)
                // .addFilterBefore(jwtAuthenticationFilter,
                // UsernamePasswordAuthenticationFilter.class)
                // ;

                // // http
                // // // .exceptionHandling(customizer ->
                // customizer.authenticationEntryPoint(userAuthEntryPoint))
                // // .csrf(c -> c.disable())
                // // .sessionManagement(customizer ->
                // customizer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                // // .authorizeHttpRequests(
                // // (authorize) -> authorize
                // // .requestMatchers(
                // // WHITE_LIST_URL).permitAll()
                // // // .requestMatchers(HttpMethod.GET, "/csrf/token").permitAll()
                // // // .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // // .anyRequest().authenticated())
                // // .addFilterBefore(jwtAuthenticationFilter,
                // UsernamePasswordAuthenticationFilter.class);

                // return http.build();

        }
}
