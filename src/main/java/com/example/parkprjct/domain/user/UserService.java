package com.example.parkprjct.domain.user;

import com.example.parkprjct.controller.SignupDTO;
import com.example.parkprjct.entity.*;
import com.example.parkprjct.exception.CustomException;
import com.example.parkprjct.exception.ErrorCode;
//import com.google.cloud.storage.Bucket;
import com.example.parkprjct.repository.LikeRepository;
import com.example.parkprjct.repository.ReviewRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import com.example.parkprjct.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final FirebaseAuth firebaseAuth;

    private final LikeRepository likeRepository;
    private final ReviewRepository reviewRepository;
    //private final Bucket bucket;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findBygId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " 유저를 찾을 수 없습니다."));
    }

    @Transactional
    public Users signupMock(SignupDTO signupDTO, String token) {
        Users user = Users.builder().gId(token).uNickname(signupDTO.getUNickname()).build();
        userRepository.save(user);
        return user;
    }

    @Transactional
    public Users signup(SignupDTO signupDTO, String token) {
        try{
            FirebaseToken firebaseToken =  firebaseAuth.verifyIdToken(token);
            if(userRepository.findBygId(firebaseToken.getUid()).isPresent()) {
                throw new CustomException(ErrorCode.EXIST_MEMBER);
            }
            

    Users user = Users.builder().gId(firebaseToken.getUid()).uNickname(signupDTO.getUNickname()).build();
            userRepository.save(user);
            return user;
        } catch (FirebaseAuthException e) {
            throw new CustomException(ErrorCode.INVALID_AUTHORIZATION);
        }
    }

    @Transactional
    public Page<Park> likedPost(Authentication authentication, Pageable pageable) {
        Users user = (Users) authentication.getPrincipal();
        return likeRepository.findByuIdx(user, pageable)
                .map(like -> like.getPIdx());
    }

    @Transactional
    public Page<Review> postedReview(Authentication authentication, Pageable pageable) {
        Users user = (Users) authentication.getPrincipal();
        return reviewRepository.findByuIdx(user, pageable);

    }
}