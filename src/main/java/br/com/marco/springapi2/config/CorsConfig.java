package br.com.marco.springapi2.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CorsConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(CorsConfig.class);
	
	public static String[] PUBLIC_RESOURCES = {
			"/aluno/**",
			"/aluno"
	};
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration conf = new CorsConfiguration().applyPermitDefaultValues();
        conf.setAllowedMethods(
        		Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS")
        );
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf);
        
        LOG.info("CORS Configurado");
        
        return source;
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().anyRequest().permitAll();
		
		http.sessionManagement().sessionCreationPolicy(
				SessionCreationPolicy.STATELESS
		);
	}
	
	
}
