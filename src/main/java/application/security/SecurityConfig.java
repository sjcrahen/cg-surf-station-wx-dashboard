package application.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                        .authorizeRequests()
                        .antMatchers("/h2/**").hasAuthority("ROLE_ADMIN")
                        .antMatchers("/signup*").permitAll()
                        .antMatchers("/**").authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .defaultSuccessUrl("/").permitAll()
                        .and()
                        .rememberMe()
                        .tokenValiditySeconds(2419200)
                        .key("s2wx")
                        .and()
                        .logout().logoutSuccessUrl("/login");
        http.csrf().ignoringAntMatchers("/h2/**");
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                        .authoritiesByUsernameQuery(
                                        "select username, authority from users where username=?")
                        .passwordEncoder(new BCryptPasswordEncoder());
    }

}
