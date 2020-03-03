package com.MockitoSpringTesting.MockitoSpringTesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    @Test
    public  void learningAssert(){
        String responseFromService = "[{\"id\":1000,\"name\":\"VK\",\"age\":30},{\"id\":1001,\"name\":\"AVK\",\"age\":31},{\"id\":1002,\"name\":\"AAVK\",\"age\":33}]";

       DocumentContext context = JsonPath.parse(responseFromService);
       int leng = context.read("$.length()");
       assertThat(leng).isEqualTo(3);
       // To print all the id's
        System.out.println(context.read("$..id").toString());
        System.out.println(context.read("$.[?(@.name=='VK')]").toString());

        /*
        * context.read("$.[1]").toString()
        * context.read("$.[0:2]").toString()
        * context.read("$.[?(@.name=='VK']").toString()
        * context.read("$.[1]").toString()
        *
        * */

    }
}
