package pl.albumweb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(4);
    }
    @Qualifier("userRepositoryUserDetailsService")

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/h2-console/**").permitAll();
        http.headers().frameOptions().disable()
            .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home.html", true)
         .and().csrf().ignoringAntMatchers("/h2-console/**");
    }

   // @Override
    protected void configure(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception{
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
        auth.jdbcAuthentication().dataSource(dataSource);

    }

}

