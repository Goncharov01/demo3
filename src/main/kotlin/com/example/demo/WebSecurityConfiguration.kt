package com.example.demo


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
open class WebSecurityConfiguration()
 : WebSecurityConfigurerAdapter() {
// @Autowired
// lateinit var customLoginSuccessHandler: CustomAuthenticationSuccessHandler
 override fun configure(http: HttpSecurity) {
  http.csrf().disable()
  http.authorizeRequests()
    .antMatchers("/").permitAll()
//          .antMatchers("/comment").hasAnyRole("ADMIN","USER")
          .antMatchers("/comments").authenticated()
//          .antMatchers("/comments").hasRole("ADMIN")

 }
 @Autowired
 fun configureGlobal(auth: AuthenticationManagerBuilder): Unit {
  auth
          .inMemoryAuthentication()
          .withUser("user").password("user").roles("USER")
          .and()
          .withUser("admin").password("admin").roles("ADMIN")
 }
}
