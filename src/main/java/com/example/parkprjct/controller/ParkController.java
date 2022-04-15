package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.repository.ParkRepository;
import com.example.parkprjct.service.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

//api요청 받음
@RestController
@RequestMapping("/parks")
public class ParkController {

    @Autowired
    private ParkService parkService;

    @GetMapping("")//모든 공원 목록 출력
    public Page<ParkDto> getParkall(Pageable pageable){

        return parkService.getparkall(pageable);

    }////ex(페이지0, 사이즈6, pAvgRate(default오름차순)내림차순 정렬 - http://localhost:9090/parks?page=0&size=6&sort=pAvgRate,desc

    @GetMapping("/pName")//공원명 검색시 해당 공원이 출력됨
    public Page<ParkDto> searchParkName(Pageable pageable,
                               @RequestParam(name = "keyword",required = false) String pName){
        return parkService.searchParkName(pageable, pName);
    }//ex) http://localhost:9090/parks/pName?keyword=서울숲

    @GetMapping("/pArea")//공원 지역구 검색시 해당 공원이 출력됨
    public Page<ParkDto> searchParkArea(Pageable pageable,
                                        @RequestParam(name = "area", required = false) String pArea){
        return parkService.searchParkArea(pageable, pArea);
    }//ex) http://localhost:9090/parks/pArea?area=성동구

    @GetMapping("/search")//공원명, 지역구(태그선택)입력후 검색
    //공원명, 지역구 and조건
    public Page<ParkDto> searchPark(Pageable pageable,
                                 @RequestParam(name = "keyword",required = false) String pName,
                                @RequestParam(name = "area", required = false) String pArea){
        return parkService.searchPark(pageable, pName, pArea);
    }

    @GetMapping("/{parkIdx}")//공원idx로 해당 공원상세보기
    public Park getReadMorePark(@PathVariable("parkIdx") Long pIdx){
        return parkService.getReadMorePark(pIdx);
    }





}
