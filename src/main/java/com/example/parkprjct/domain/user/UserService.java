<<<<<<< HEAD:src/main/java/com/example/parkprjct/domain/user/UserService.java
package com.example.parkprjct.domain.user;
=======
package com.project.parkproject.domain.user;
>>>>>>> 7f0aa39 (Build: 로그인):src/main/java/com/project/parkproject/domain/user/UserService.java

import java.io.IOException;
import com.project.parkproject.controller.SignupDTO;
import com.project.parkproject.exception.CustomException;
import com.project.parkproject.exception.ErrorCode;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import com.project.parkproject.domain.user.User;
import com.project.parkproject.domain.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final FirebaseAuth firebaseAuth;
    private final Bucket bucket;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " 유저를 찾을 수 없습니다."));
    }

    @Transactional
    public User signupMock(SignupDTO signupDTO, String token) {
        User user = User.builder().uid(token).name(signupDTO.getName()).build();
        userRepository.save(user);
        return user;
    }


}