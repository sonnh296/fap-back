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
        var user = User.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);
        if(user.getRole().name() == "STUDENT"){
            var student = Student.builder()
                    .name(user.getFirstname() + " " + user.getLastname())
                    .email(user.getEmail())
                    .user(user)
                    .build();
            studentRepository.save(student);
        }

        if(user.getRole().name() == "TEACHER"){
            var teacher = Teacher.builder()
                    .name(user.getFirstname() + " " + user.getLastname())
                    .email(user.getEmail())
                    .user(user)
                    .build();
            teacherRepository.save(teacher);
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .id(user.getId())
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

        String id;
        if(user.getRole().name() == "TEACHER"){
            Teacher teacher = teacherRepository.findFirstByUser_Id(user.getId());
            id = teacher.getId()  + "";
        } else {
            Student student = studentRepository.findStudentByUser_Id(user.getId());
            id = student.getId()  + "";
        }
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .id(id)
                .build();

    }
}

