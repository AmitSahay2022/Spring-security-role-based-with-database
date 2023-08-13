package com.sahay.springbootsecuritytutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Step 3: Enabling basic security
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		//enabling only basic security
		security.csrf().disable()
		    .authorizeHttpRequests((autherize)->autherize
		    		.anyRequest()
		    		.authenticated())
		            .httpBasic(Customizer.withDefaults()); //basic security enabled
		
		return security.build();
	}
	
	//Step 4: Creating user in-memory with roles and commenting application.propertise file Step 2
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails amit=User.builder()
				             .username("amit")
				             .password(passwordEncoder().encode("kum")) //it does not accept plain password. it requires password encoder
				             .roles("USER")
				             .build();
		UserDetails admin=User.builder()
				              .username("admin")
				              .password(passwordEncoder().encode("admin"))  //requires password encoder
				              .roles("ADMIN")
				              .build();
		
		return new InMemoryUserDetailsManager(amit,admin);
	}
}
