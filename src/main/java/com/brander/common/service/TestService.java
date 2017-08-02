package com.brander.common.service;

import com.brander.common.enums.JsonResultEnum;
import com.brander.common.exception.JsonException;
import org.springframework.stereotype.Service;

/**
 * 测试事务
 */
@Service
public class TestService {

    /*
    * 根据ID查询对应信息
    * */
    public void testResult(Integer age) throws Exception{
        if(age < 12) {
            throw new JsonException(JsonResultEnum.PRIMARY_SCHOOL);
        }
    }

}
