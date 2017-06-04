package ir.sbu.golestan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Created by Ali Asghar on 21/05/2017.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

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
                    .antMatchers("/")
                    .access(AUTHORIZED_ROLES)
//                    .permitAll()
//                .and()
//                    .authorizeRequests()
//                    .antMatchers("resources/**")
//                    .access(AUTHORIZED_ROLES)
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .csrf().disable()
                    .exceptionHandling()
                    .accessDeniedPage("/403");
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("pass").roles("STUDENT");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/static/**");
    }
}
