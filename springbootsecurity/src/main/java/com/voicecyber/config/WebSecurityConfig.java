package com.voicecyber.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Sean on 2018/8/2
 *
 * @author Sean
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用于用户认证
     * 可以使用  内存中的用户 ，jdbc中的用户（直接指定dataSource）自定义用户 。通过自当以实现UserDetailsService 接口
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new CustomUserService());
    }

    /**
     * 资源文件过滤
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 请求授权 通过匹配器来实现请求拦截
     * 定制登陆行为
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("")
                .antMatchers("").hasAnyRole("")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("")
                .defaultSuccessUrl("")
                .failureUrl("")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("")
                .logoutSuccessUrl("")
                .permitAll();
        //所有的请求都需要认证后才能访问
    }

}
