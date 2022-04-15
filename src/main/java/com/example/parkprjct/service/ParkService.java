package com.example.parkprjct.service;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.repository.ParkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;

    public Page<ParkDto> getparkall(Pageable pageable){

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
