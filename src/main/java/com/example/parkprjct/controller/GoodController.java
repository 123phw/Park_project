package com.example.parkprjct.controller;

import com.example.parkprjct.entity.Users;
import com.example.parkprjct.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks/{reviewIdx}/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("")
    public void postGood(@PathVariable("reviewIdx")Long rIdx,
                         Authentication authentication){
        Users user = (Users) authentication.getPrincipal();
        goodService.checkGood(user, rIdx);
    }

    @DeleteMapping("")
    public void deleteGood(@PathVariable("reviewIdx")Long rIdx,
                         Authentication authentication){
        Users user = (Users) authentication.getPrincipal();
        goodService.checkGood(user, rIdx);
    }//

}
