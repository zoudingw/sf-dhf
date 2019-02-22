package com.infinova.sfdhf.authConfig;

import com.infinova.sfdhf.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityAdaptConfig extends WebSecurityConfigurerAdapter {


    @Resource(name="myAuthenticationProvider")
    private MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    private EncodePassword encodePassword;

    @Autowired
    MyUserDetailService detailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
        auth.userDetailsService(detailService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//定义哪些url需要被保护  哪些不需要保护
                .antMatchers("/oauth/token" , "oauth/check_token").permitAll()//定义这两个链接不需要登录可访问
                //.antMatchers("/**").permitAll() //定义所有的都不需要登录  目前是测试需要
                .anyRequest().authenticated() //其他的都需要登录
                //.antMatchers("/sys/**").hasRole("admin")///sys/**下的请求 需要有admin的角色
                .and()
                .formLogin().loginPage("/login")//如果未登录则跳转登录的页面   这儿可以控制登录成功和登录失败跳转的页面
                .usernameParameter("username").passwordParameter("password").permitAll()//定义号码与密码的parameter
                .and()
                .csrf().disable();//防止跨站请求  spring security中默认开启

    }
}
