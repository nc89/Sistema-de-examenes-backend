package com.exams.system;

import com.exams.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SistemaExamenesBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     /* try{
			User usuario = new User();
			usuario.setName("Nicolas");
			usuario.setLastname("Cardenas");
			usuario.setUsername("nicolas");
			usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
			usuario.setEmail("nicolas@gmail.com");
			usuario.setCellphone("3187839866");
			usuario.setProfile("foto.png");

			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setNameRol("ADMIN");
			Set<UserRol> usuariosRoles = new HashSet<>();

			UserRol usuarioRol = new UserRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUser(usuario);
			usuariosRoles.add(usuarioRol);

			User usuarioGuardado = userService.saveUser(usuario,usuariosRoles);
			System.out.println(usuarioGuardado.getUsername());
		}catch (UserFoundException exception){
			exception.printStackTrace();
		}*/
    }
}
