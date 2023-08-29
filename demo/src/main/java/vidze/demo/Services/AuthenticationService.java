package vidze.demo.Services;

import java.util.Optional;

import vidze.demo.Models.Promoter;
import vidze.demo.Models.Role;
import vidze.demo.Models.User;
import vidze.demo.Repositories.AdminRepo;
import vidze.demo.Repositories.PromoterRepo;
import vidze.demo.Repositories.UserRepo;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vidze.demo.Configs.JWTService;
import vidze.demo.Forms.Requests.LoginAdminRequest;
import vidze.demo.Forms.Requests.LoginRequest;
import vidze.demo.Forms.Requests.RegisterPromoterRequest;
import vidze.demo.Forms.Requests.RegisterUserRequest;
import vidze.demo.Forms.Responses.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final UserRepo userRepo;
    private final PromoterRepo promoterRepo;
    private final AdminRepo adminRepo;

    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<AuthenticationResponse> register_user(RegisterUserRequest request){
        Optional<User> u = userRepo.findUserByEmail(request.getEmail());

        if(u.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(AuthenticationResponse.builder()
                                       .status("User already exists.")
                                       .build());
        
        var user = User.builder()
                       .name(request.getName())
                       .age(request.getAge())
                       .email(request.getEmail())
                       .password(passwordEncoder.encode(request.getPassword()))
                       .phone(request.getPhone())
                       .role(Role.USER)
                       .language("english").build();

        userRepo.save(user);

        var jwtToken = jwtService.generateToken(user);

        return ResponseEntity.ok(AuthenticationResponse.builder()
                             .status("ok")
                             .token(jwtToken)
                             .userType("User")
                             .build());
    }

    public ResponseEntity<AuthenticationResponse> register_promoter(RegisterPromoterRequest request){
    
        Optional<Promoter> p = promoterRepo.findPromoterByEmail(request.getEmail());
        if(p.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                               .body(AuthenticationResponse.builder()
                                               .status("Promoter already exists")
                                               .build());

        var promoter = Promoter.builder()
                       .name(request.getName())
                       .email(request.getEmail())
                       .password(request.getPassword())
                       .role(Role.PROMOTER)
                       .language("english").build();
        
        promoterRepo.save(promoter);
        var jwtToken = jwtService.generateToken(promoter);


        return ResponseEntity.ok(AuthenticationResponse.builder()
                             .status("ok")
                             .token(jwtToken)
                             .userType("Promoter")
                             .build());
    }

    public ResponseEntity<AuthenticationResponse> login_user(LoginRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );

        var user = userRepo.findUserByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user.get());
        return ResponseEntity.ok(AuthenticationResponse.builder()
                             .status("ok")
                             .token(jwtToken)
                             .userType("User")
                             .build());
    }

    public ResponseEntity<AuthenticationResponse> login_promoter(LoginRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );

        var promoter = promoterRepo.findPromoterByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(promoter.get());
        return ResponseEntity.ok(AuthenticationResponse.builder()
                             .status("ok")
                             .token(jwtToken)
                             .userType("Promoter")
                             .build());
    }

    public ResponseEntity<AuthenticationResponse> login_admin(LoginAdminRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword())
        );

        var admin = adminRepo.findAdminByEmail(request.getEmail());

        if(admin.isPresent() && admin.get().getId() == request.getId()){
            var jwtToken = jwtService.generateToken(admin.get());
            return ResponseEntity.ok(AuthenticationResponse.builder()
                                 .status("ok")
                                 .token(jwtToken)
                                 .userType("Admin")
                                 .build());
        }
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                 .body(AuthenticationResponse.builder()
                                 .status("Wrong Credentials.")
                                 .build());
        }
}
