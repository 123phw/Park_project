<<<<<<< HEAD:src/main/java/com/example/parkprjct/domain/user/UserService.java
package com.example.parkprjct.domain.user;
=======
package com.project.parkproject.domain.user;
<<<<<<< HEAD:src/main/java/com/example/parkprjct/domain/user/UserService.java
>>>>>>> 7f0aa39 (Build: 로그인):src/main/java/com/project/parkproject/domain/user/UserService.java

import java.io.IOException;
=======
>>>>>>> 2da38b6 (Fix: 로그인):src/main/java/com/project/parkproject/domain/user/UserService.java
import com.project.parkproject.controller.SignupDTO;
import com.project.parkproject.exception.CustomException;
import com.project.parkproject.exception.ErrorCode;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.project.parkproject.domain.user.UserRepository;
import com.project.parkproject.entity.Users;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findBygId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " 유저를 찾을 수 없습니다."));
    }

    @Transactional
    public Users signupMock(SignupDTO signupDTO, String token) {
        Users user = Users.builder().gId(token).uNickname(signupDTO.getName()).build();
        userRepository.save(user);
        return user;
    }

    @Transactional
    public Users signup(SignupDTO signupDTO, String token) {
        String uid = verifyToken(token);
        if(userRepository.findBygId(uid).isPresent()) {
            throw new CustomException(ErrorCode.EXIST_MEMBER);
        }
        Users user = Users.builder().gId(uid).uNickname(signupDTO.getName()).build();
        userRepository.save(user);
        return user;
    }

    public String verifyToken(String token) {
        try {
            FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(token);
            return firebaseToken.getUid();
        } catch (FirebaseAuthException e) {
            log.error("invalid token", e);
            throw new CustomException(ErrorCode.INVALID_AUTHORIZATION);
        }
    }



}