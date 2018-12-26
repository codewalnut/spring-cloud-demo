package com.study.cloud;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class MonitorApplication {
    private final static Logger log = LoggerFactory.getLogger(MonitorApplication.class);

    public static void main(String[] args) {
        log.info("<<<<<<<<< Monitor Server booting >>>>>>>>>");
        SpringApplication.run(MonitorApplication.class, args);
        log.info("<<<<<<<<< Monitor Server booting finished >>>>>>>>>");
    }

    // tag::configuration-spring-security[]
    @Configuration
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
        private final String adminContextPath;

        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
            this.adminContextPath = adminServerProperties.getContextPath();
            log.info("MonitorServer context path: {}", adminContextPath);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
            successHandler.setTargetUrlParameter("redirectTo");
            successHandler.setDefaultTargetUrl(adminContextPath + "/");

            http.authorizeRequests()
                    .antMatchers(adminContextPath + "/assets/**").permitAll() // <1>Grants public access to all static assets and the login page.
                    .antMatchers(adminContextPath + "/login").permitAll()
                    .anyRequest().authenticated() // <2>Every other request must be authenticated.
                    .and()
                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and() // <3>Configures login and logout.
                    .logout().logoutUrl(adminContextPath + "/logout").and()
                    .httpBasic().and() // <4>Enables HTTP-Basic support. This is needed for the Spring Boot Admin Client to register.
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())  // <5>Enables CSRF-Protection using Cookies
                    .ignoringAntMatchers(
                            adminContextPath + "/instances",   // <6>Disables CRSF-Protection the endpoint the Spring Boot Admin Client uses to register.
                            adminContextPath + "/actuator/**"  // <7>Disables CRSF-Protection for the actuator endpoints.
                    );
        }
    }
    // end::configuration-spring-security[]

}