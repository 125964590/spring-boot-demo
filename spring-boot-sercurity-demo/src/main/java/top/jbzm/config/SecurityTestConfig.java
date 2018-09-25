package top.jbzm.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import top.jbzm.filter.BeforeLoginFilter;

/**
 * @author zhengyi
 * @date 2018/8/30 3:11 PM
 **/
@EnableWebSecurity
public class SecurityTestConfig extends WebSecurityConfigurerAdapter {

    /**
     * Allow all request from /
     * Authentication request from /user/**
     * The login request path is /login success redirect page is /login/success
     * The same logout is like before login
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/login/success").failureForwardUrl("/login/fail")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login/success");
        http.addFilterBefore(new BeforeLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(new BeforeLoginFilter.AfterCsrfFilter(), CsrfFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }
}