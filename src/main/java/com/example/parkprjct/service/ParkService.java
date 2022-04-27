package com.example.parkprjct.service;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;

    //park db정보
    public List<Park> ParkDB(Sort sort){
        List<Park> parkList = parkRepository.findAll(sort);
        return parkList;
    }

    public Page<Park> ParkDBPage(Pageable pageable){
        return parkRepository.park(pageable);
    }

    //    public List<ParkDto> getParkAll(Sort sort){
//        List<Park> parkList = parkRepository.findAll(sort);
//        return parkList.stream().map(ParkDto::new).collect(Collectors.toList());
//    }
    public Page<ParkDto> getParkAll(Pageable pageable){

        return parkRepository.parkList(pageable);
    }

    public Page<ParkDto> searchParkName(Pageable pageable, String pName){
        return parkRepository.findByName(pageable, pName);
    }

    public Page<ParkDto> searchParkArea(Pageable pageable, String pArea){
        return parkRepository.findByArea(pageable, pArea);
    }

    public Page<ParkDto> searchPark(Pageable pageable, String pName, String pArea){
        return parkRepository.findByAllOptions(pageable, pName, pArea);
    }

    public Park getReadMorePark(Long pIdx){
        return parkRepository.findById(pIdx)
                .orElseThrow(() ->{
                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
                });
    }





}
