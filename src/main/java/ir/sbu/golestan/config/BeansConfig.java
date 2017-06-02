package ir.sbu.golestan.config;

import ir.sbu.golestan.repository.UserRepository;
import ir.sbu.golestan.service.MySimpleUrlAuthenticationSuccessHandler;
import ir.sbu.golestan.service.MyUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 * Created by Ali Asghar on 15/05/2017.
 */
@Configuration
public class BeansConfig {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    @Bean("passwordEncoder")
//    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean("userDetailsService")
    public UserDetailsService getUserDetailsService(){
        return new MyUserDetailsService(userRepository);
    }

    @Bean
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }


    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}