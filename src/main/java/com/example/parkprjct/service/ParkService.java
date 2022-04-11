package com.example.parkprjct.service;

import com.example.parkprjct.entity.Park;
import com.example.parkprjct.repository.ParkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;

    public Page<Park> getParks(Pageable pageable, String pName){
        return parkRepository.findBySearchOption(pageable, pName);
    }

    public Park getReadMorePark(Long pIdx){
        return parkRepository.findById(pIdx)
                .orElseThrow(() ->{
                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
                });
    }


}
