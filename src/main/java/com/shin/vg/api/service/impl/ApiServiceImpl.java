package com.shin.vg.api.service.impl;

import com.shin.common.dao.CommonDAO;
import com.shin.vg.api.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 0. Project  : 화산재해대응시스템
 * 1. Package : com.enjoybt.scenario.service.impl
 * 2. Comment :
 * 3. Auth  : aiden_shin
 * 4. Date  : 2018-05-29 오전 9:50
 * 5. History :
 * 이름     : 일자          : 근거자료   : 변경내용
 * ------------------------------------------------------
 * aiden_shin : 2018-05-29 :            : 신규 개발.
 *
 */
@Service
public class ApiServiceImpl implements ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Autowired
    CommonDAO commonDAO;

    public void test(){
        String t = null;
        try {
            t = (String) commonDAO.selectObject("api.test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info(t);
    }


}


