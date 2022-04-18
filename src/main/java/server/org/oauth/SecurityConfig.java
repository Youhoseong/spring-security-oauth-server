package server.org.oauth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final ClientDetailsServiceImpl clientDetailsService;


    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientDetailsUserDetailsService())
            .passwordEncoder(noOpPasswordEncoder());
        // todo :: Change To the BcryptEncoder
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/oauth/**").permitAll()
                .and().formLogin()
                .and().httpBasic();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public ClientDetailsUserDetailsService clientDetailsUserDetailsService() {
        return new ClientDetailsUserDetailsService(clientDetailsService);
    }

}
