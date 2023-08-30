package vidze.demo.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import vidze.demo.Repositories.AdminRepo;
import vidze.demo.Repositories.PromoterRepo;
import vidze.demo.Repositories.UserRepo;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepo userRepo;
    private final PromoterRepo promoterRepo;
    private final AdminRepo adminRepo;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
 
                if(userRepo.findUserByEmail(email).isPresent()){
                    return userRepo.findUserByEmail(email).get();
                }
                else if (promoterRepo.findPromoterByEmail(email).isPresent()){
                    return promoterRepo.findPromoterByEmail(email).get();
                }
                else if (adminRepo.findAdminByEmail(email).isPresent()){
                    return adminRepo.findAdminByEmail(email).get();
                }
                else{
                    throw new UsernameNotFoundException("User not found!");
                }
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        // Data access objet responsible to fetch user details, password...

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    
    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry reg) {
                reg.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
