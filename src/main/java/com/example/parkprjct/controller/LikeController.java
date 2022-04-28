package com.example.parkprjct.controller;

import com.example.parkprjct.entity.Users;
import com.example.parkprjct.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks/{parkIdx}/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("")
    public void postLike(@PathVariable("parkIdx")Long pIdx,
                         Authentication authentication){
        Users user = (Users) authentication.getPrincipal();
        likeService.checkLike(user, pIdx);
    }

    @DeleteMapping("")
    public void deleteLike(@PathVariable("parkIdx")Long pIdx,
                           Authentication authentication){

        Users user = (Users) authentication.getPrincipal();
        likeService.checkLike(user, pIdx);
    }
}
