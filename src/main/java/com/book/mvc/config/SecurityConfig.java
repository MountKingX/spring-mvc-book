package com.book.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Import({
        PasswordConfig.class,
})
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobalSecurity(final AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(passwordEncoder.encode("pa55word"))
                .roles("USER");

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("root123"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin().loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password");

        httpSecurity.formLogin().defaultSuccessUrl("/market/products")
                .failureUrl("/login?error");

        httpSecurity.logout().logoutSuccessUrl("/login?logout");

        httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/index", "/login", "/register").permitAll()
                .antMatchers("/**/add").permitAll()
                .antMatchers("/**/market/**").permitAll()
                .antMatchers("/**").permitAll();

        httpSecurity.csrf().disable();
    }
}
