package com.geca.alumniCircle.SecurityConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	private UserDetailsService adminDetailsService;


	private UserDetailsService alumniDetailsService;

	private UserDetailsService studentDetailsService;

	private PasswordEncoder passwordEncoder;

	@Autowired
	JwtFilter jwtFilter;

    private  List<UserDetailsService> userDetailsServices;


    public SecurityConfig(List<UserDetailsService> userDetailsServices) {
        this.userDetailsServices = userDetailsServices;
    }
	
	public SecurityConfig(UserDetailsService adminDetailsService, UserDetailsService alumniDetailsService,
			UserDetailsService studentDetailsService, PasswordEncoder passwordEncoder) {
		
		this.adminDetailsService = adminDetailsService;
		this.alumniDetailsService = alumniDetailsService;
		this.studentDetailsService = studentDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
	
	

	@Autowired
    public SecurityConfig(@Qualifier("adminDetailsService") UserDetailsService adminDetailsService,
                          @Qualifier("alumniDetailsService") UserDetailsService alumniDetailsService,
                          @Qualifier("studentDetailsService") UserDetailsService studentDetailsService) {
        this.userDetailsServices = null;
		this.adminDetailsService = adminDetailsService;
        this.alumniDetailsService = alumniDetailsService;
        this.studentDetailsService = studentDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/api/admin/login").permitAll()
						.requestMatchers("/api/student/login").permitAll()
						.requestMatchers("/api/admin").permitAll()
						.requestMatchers("/api/alumni/login").permitAll()
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();

	}

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("kiran")
//                .password("k@123")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("harsh")
//                .password("h@123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(userDetailsService);
//
//
//        return provider;
//    }

	
    @Bean(name = "customAuthManager")
    public AuthenticationManager customAuthManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    

    @Bean
    public DaoAuthenticationProvider adminAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(adminDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider alumniAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(alumniDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider studentAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(studentDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

//    @Bean(name = "customAuthManager")
//    public AuthenticationManager customAuthManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

	// Create an AuthenticationManager with all the DaoAuthenticationProviders
//	@Bean
//	public AuthenticationManager customAuthManager(AuthenticationConfiguration authConfig) throws Exception {
//		AuthenticationManagerBuilder authManagerBuilder = authConfig.getBuilder();
//		authManagerBuilder.authenticationProvider(adminAuthProvider());
//		authManagerBuilder.authenticationProvider(alumniAuthProvider());
//		authManagerBuilder.authenticationProvider(studentAuthProvider());
//		return authManagerBuilder.build();
//	}

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//
//    }

//    @Bean
//    public AuthenticationManager customAuthManager() {
//        return new ProviderManager(Arrays.asList(
//            new DaoAuthenticationProvider( adminDetailsService),
//            new DaoAuthenticationProvider( alumniDetailsService),
//            new DaoAuthenticationProvider( studentDetailsService)
//        ));
//    }

}