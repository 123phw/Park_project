package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//api요청 받음
@RestController
@RequestMapping("/parks")
public class ParkController {

    @Autowired
    private ParkService parkService;

    @GetMapping("/DB")//공원db데이터
    public List<Park> ParkDB(Sort sort){

        return parkService.ParkDB(sort);
    }//parkDB - http://localhost:9090/parks

    @GetMapping("/db")//공원db 페이징
    public Page<Park> ParkDBPage(Pageable pageable){
        return parkService.ParkDBPage(pageable);
    }

    @GetMapping("")//모든 공원 목록 출력
    public Page<ParkDto> getParkAll(Pageable pageable){

        return parkService.getParkAll(pageable);

    }//공원목록 - http://localhost:9090/parks?page=1&size=6
    //공원목록(별점순) - http://localhost:9090/parks?page=0&size=6&sort=pAvgRate,desc
    //공원목록(Best) - https://parkproj.herokuapp.com/parks?page=0&size=6&sort=pLikeCnt,desc

    @GetMapping("/pName")//공원명 검색시 해당 공원이 출력됨
    public Page<ParkDto> searchParkName(Pageable pageable,
                                        @RequestParam(name = "keyword",required = false) String pName){
        return parkService.searchParkName(pageable, pName);
    }//ex) http://localhost:9090/parks/pName?page=0&size=6&keyword=서울숲

    @GetMapping("/pArea")//지역구 검색시 해당 공원이 출력됨
    public Page<ParkDto> searchParkArea(Pageable pageable,
                                        @RequestParam(name = "area", required = false) String pArea){
        return parkService.searchParkArea(pageable, pArea);
    }//ex) http://localhost:9090/parks/pArea?page=0&size=6&area=성동구

    @GetMapping("/search")//공원명, 지역구(태그선택)입력후 검색
    //공원명검색 + 지역구 and조건
    public Page<ParkDto> searchPark(Pageable pageable,
                                    @RequestParam(name = "keyword",required = false) String pName,
                                    @RequestParam(name = "area", required = false) String pArea){
        return parkService.searchPark(pageable, pName, pArea);
    }// ex)http://localhost:9090/parks/search?page=0&size=6&keyword=근린&area=성동구

    @GetMapping("/{parkIdx}")//공원idx로 해당 공원상세보기
    public Park getReadMorePark(@PathVariable("parkIdx") Long pIdx){
        return parkService.getReadMorePark(pIdx);
    }
    //공원 상세보기 - http://localhost:9090/parks/3


}
