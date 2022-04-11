package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Park;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ParkRepositoryTest {


    @Autowired
    ParkRepository parkRepository;


//    public void save() throws Exception{
//        BigDecimal value = new BigDecimal("3.2");
//        BigDecimal xvalue = new BigDecimal("0.0");
//        BigDecimal yvalue = new BigDecimal("0.0");
//        Park park = new Park("서울숲공원", "서울시 성동구","dkjfwo.jpg", "성동구","httt://www...", "공원설명",xvalue,yvalue);
//        parkRepository.save(park);
//    }

   // @Test
    public void parkinfo_save() throws IOException {

        String result = "";
        //String line = "";

        try {

            URL url = new URL("http://openapi.seoul.go.kr:8088/78536a64773132333636456149614c/json/SearchParkInfoService/1/131/");

            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();
            //System.out.println(result);//받은 데이터 확인-ok

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            JSONObject SearchParkInfoService = (JSONObject) jsonObject.get("SearchParkInfoService");

            Long totalCount = (Long) SearchParkInfoService.get("list_total_count");

            JSONObject parkResult = (JSONObject) SearchParkInfoService.get("RESULT");
            JSONArray infoArr = (JSONArray) SearchParkInfoService.get("row");

            //Park park = new Park("서울숲공원", "서울시 성동구","dkjfwo.jpg", "성동구","httt://www...", "공원설명",xvalue,yvalue);
            String pName, pAddr, pImg, pArea, pSite, pDesc;
            BigDecimal pX, pY, pAvgRate;

            for (int i = 0; i < infoArr.size(); i++) {
                JSONObject tmp = (JSONObject) infoArr.get(i);

                pName = (String)tmp.get("P_PARK");  pAddr = (String)tmp.get("P_ADDR");  pImg = (String) tmp.get("P_IMG");
                pArea = (String)tmp.get("P_ZONE");  pSite = (String)tmp.get("TEMPLATE_URL");    pDesc = (String)tmp.get("P_LIST_CONTENT");
                pX = new BigDecimal((String)tmp.get("LONGITUDE"));  pY = new BigDecimal((String)tmp.get("LATITUDE"));

                Park parkObj = new Park(pName, pAddr, pImg, pArea, pSite, pDesc, pX, pY);
                parkRepository.save(parkObj);//DB에 파싱된 json데이터 넣기

                //api json이 잘 파싱되었는지 확인 및 출력 - ok:)
                //BigDecimal xtest = new BigDecimal(tmp.get("LATITUDE").toString());
                //String pnameTest = (String)tmp.get("P_LIST_CONTENT");
                //System.out.println(i+pnameTest);

            }
            bf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}