package ir.sbu.golestan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Ali Asghar on 21/05/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final String AUTHORIZED_ROLES = "hasRole(\'STUDENT\') or hasRole(\'MASTER\') or hasRole(\'GROUP_MANAGER\')";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/static/**")
                .permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers("/home/**")
                    .access(AUTHORIZED_ROLES)
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/home")
                    .permitAll()
                .and()
                    .csrf()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403");

    }

}
