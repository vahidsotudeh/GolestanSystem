package ir.sbu.golestan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Created by Ali Asghar on 21/05/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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
//                    .permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                .and()
                    .csrf()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403");
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//        auth.inMemoryAuthentication().withUser("user").password("pass").roles("STUDENT");
    }



}
