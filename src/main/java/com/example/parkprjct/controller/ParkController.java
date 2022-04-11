package com.example.parkprjct.controller;

import com.example.parkprjct.entity.Park;
import com.example.parkprjct.repository.ParkRepository;
import com.example.parkprjct.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

//api요청 받음
@RestController
@RequestMapping("/parks")
public class ParkController {

    @Autowired
    private ParkService parkService;



    @GetMapping("")//공원명 검색시 해당 공원이 출력됨//sort오류?
    public Page<Park> getParks(Pageable pageable,
                               @RequestParam(required = false) String pName){
        return parkService.getParks(pageable, pName);
    }

    @GetMapping("/{parkIdx}")//질문:
    public Park getReadMorePark(@RequestParam Long pIdx){
        Park parkData = parkService.getReadMorePark(pIdx);
        return parkData;
    }





}
