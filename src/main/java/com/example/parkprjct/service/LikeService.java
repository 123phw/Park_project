package com.example.parkprjct.service;

import com.example.parkprjct.entity.Like;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.entity.Users;
import com.example.parkprjct.exception.ForbiddenException;
import com.example.parkprjct.repository.LikeRepository;
import com.example.parkprjct.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ParkRepository parkRepository;

    @Transactional
    public void checkLike(Users user, Long pIdx){

        Optional<Like> like = likeRepository.findLikedUser(pIdx, user.getUIdx());
        //좋아요한 uidx와 pidx가 일치하는 값을 like데이터에서 불러옴

        if(like.isPresent()){//이미 like를 누른경우
            deleteLike(like.get().getLIdx(),pIdx);//like 튜플 삭제
            userMatchCheck(user, like.get());//사용자와 uidx가 일치하는지 확인
        }
        else{//like를 누르지 않은 경우
            postLike(user, pIdx);
        }
    }

    private void postLike(Users user, Long pIdx){
        Park park = parkNotFoundException(pIdx);

        Like like = new Like(user, park);
        likeRepository.save(like);//like튜플추가

        park.like();
        //공원 좋아요 수 증가
    }
    @Transactional
    public void deleteLike(Long lIdx, Long pIdx){
        Park park = parkNotFoundException(pIdx);

        likeRepository.deleteById(lIdx);//해당하는 lidx삭제

        park.cancelLike();//공원 좋아요 수 감소
    }

    private Park parkNotFoundException(Long pIdx){//해당하는 pidx가 존재하는지 확인
        return parkRepository.findById(pIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
                });
    }

    private void userMatchCheck(Users user, Like like) {//forbidden예외처리
        if (!user.getUIdx().equals(like.getUIdx().getUIdx())) {
            throw new ForbiddenException("사용자가 일치하지않습니다");
        }
    }
}
