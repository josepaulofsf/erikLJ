/*package com.eriklj.lavajato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Permite uso de anotações como @PreAuthorize
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/webhooks/**").permitAll()
                
                // Clientes e visitantes podem ver os preços
                .requestMatchers(HttpMethod.GET, "/api/servicos/**").permitAll()
                
                // Apenas ADMIN pode cadastrar, editar ou deletar serviços e preços
                .requestMatchers(HttpMethod.POST, "/api/servicos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/servicos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/servicos/**").hasRole("ADMIN")
                
                // Rotas de agendamento e pagamento do cliente
                .requestMatchers("/api/agendamentos/**").hasRole("CLIENTE")
                
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/