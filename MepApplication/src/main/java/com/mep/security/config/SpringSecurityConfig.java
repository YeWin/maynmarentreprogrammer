package com.mep.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.mep.security.service.AdminDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    
    public void configure(WebSecurity web) throws Exception{
		
		web.ignoring().antMatchers("/admin/administrator/insert");
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	 http.csrf().disable()
         .authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
				.anyRequest().authenticated()
         .and()
         
         .headers().defaultsDisabled()
         .xssProtection().xssProtectionEnabled(false)
         .and()
         .and()
         .formLogin()
         	.loginProcessingUrl("/auth")
				.loginPage("/login")
				.failureForwardUrl("/login-error")								
				.defaultSuccessUrl("/login-success", true)						
				.usernameParameter("adminEmail")										
				.passwordParameter("adminPassword")									
				.permitAll()
				.and()
         .logout()
				.permitAll()
				.and()
         .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }*/
    
    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        AdminDetailsServiceImpl adminDetailsServiceImpl;

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            
            auth.userDetailsService(adminDetailsServiceImpl)
            
            .passwordEncoder(passwordEncoder());
        }
    }
}