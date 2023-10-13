package vn.fpt.fap.seven.auth;


import vn.fpt.fap.seven.config.JwtService;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.entity.Teacher;
import vn.fpt.fap.seven.repository.StudentRepository;
import vn.fpt.fap.seven.repository.TeacherRepository;
import vn.fpt.fap.seven.user.Role;
import vn.fpt.fap.seven.user.User;
import vn.fpt.fap.seven.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("request" + request.toString());

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        if (request.getRole().name().equals("STUDENT")) {
            var student = Student.builder()
                    .name(request.getFirstname() + request.getLastname())
                    .email(request.getEmail())
                    .studentCode(request.getEmail().substring(0, 6))
                    .build();
            studentRepository.save(student);
        }

        if (request.getRole().name().equals("TEACHER")) {
            var teacher = Teacher.builder()
                    .name(request.getFirstname() + request.getLastname())
                    .email(request.getEmail())
                    .build();
            teacherRepository.save(teacher);
        }


        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();

    }
}

