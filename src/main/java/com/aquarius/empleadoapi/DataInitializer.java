package com.aquarius.empleadoapi;

import com.aquarius.empleadoapi.model.Usuario;
import com.aquarius.empleadoapi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario("admin", passwordEncoder.encode("123456"));
                usuarioRepository.save(admin);
                System.out.println("Usuario admin creado con contraseña 123456");
            }
        };
    }
}
