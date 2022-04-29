package com.example.parkprjct.service;

import com.example.parkprjct.entity.*;
import com.example.parkprjct.exception.ForbiddenException;
import com.example.parkprjct.repository.GoodRepository;
import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public void checkGood(Users user, Long rIdx){

        Optional<Good> good = goodRepository.findGoodUser(rIdx, user.getUIdx());
        //좋아요 한적이 있으면 idx가 일치하는 good테이블의 데이터를 불러옴, 아니면 빈값

        if(good.isPresent()){//이미 good을 누른경우
            deleteGood(good.get().getGIdx(), rIdx);//good취소
            userMatchCheck(user, good.get());//사용자와 uidx가 일치하는지 확인
        }
        else{
            postGood(user, rIdx);
        }
    }

    private void postGood(Users user, Long rIdx){
        Review review = reviewNotFoundException(rIdx);

        Good good = new Good(user, review);
        goodRepository.save(good);//good추가

        review.Good();//리뷰 좋아요 수 증가
    }

    @Transactional
    public void deleteGood(Long gIdx, Long rIdx){
        Review review = reviewNotFoundException(rIdx);

        goodRepository.deleteById(gIdx);//해당하는 gidx삭제

        review.decreaseGood();//리뷰 좋아요 수 감소
    }

    private Review reviewNotFoundException(Long rIdx){//해당하는 ridx가 존재하는지 확인
        return reviewRepository.findById(rIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 리뷰가 없습니다.");
                });
    }


    private void userMatchCheck(Users user, Good good) {//forbidden예외처리
        if (!user.getUIdx().equals(good.getUIdx().getUIdx())) {
            throw new ForbiddenException("사용자가 일치하지않습니다");
        }
    }
}
