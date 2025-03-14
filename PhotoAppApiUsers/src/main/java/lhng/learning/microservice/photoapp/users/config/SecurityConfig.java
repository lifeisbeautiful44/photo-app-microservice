package lhng.learning.microservice.photoapp.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf ->csrf.disable());

        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/users"))
                        .access(new WebExpressionAuthorizationManager("hasIpAddress('"+environment.getProperty("gateway.ipaddress")+"')"))
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.headers((headers) ->headers.frameOptions((frameOptionsConfig -> frameOptionsConfig.sameOrigin())));

        return http.build();


    }
}
