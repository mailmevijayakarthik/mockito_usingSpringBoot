package com.MockitoSpringTesting.MockitoSpringTesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessImpleTest {

    @Test
    public void checkSum_basic(){
        SomeBusinessImple business = new SomeBusinessImple();
        int actualvalue = business.calculateSum(new int[]{1,2,3});
        int expected = 6;
        assertEquals(expected,actualvalue);
    }


    @Test
    public void checkSum_emptylist(){
        SomeBusinessImple business = new SomeBusinessImple();
        int actualvalue = business.calculateSum(new int[]{});
        int expected = 0;
        assertEquals(expected,actualvalue);
    }
}
