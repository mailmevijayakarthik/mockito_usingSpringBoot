package com.MockitoSpringTesting.MockitoSpringTesting.business;

import com.MockitoSpringTesting.MockitoSpringTesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomestubDataservice implements SomeDataService {


    @Override
    public int[] retriveallData() {
        return new int[]{1,2,3};
    }
}

class SomeEmptystubDataservice implements SomeDataService {


    @Override
    public int[] retriveallData() {
        return new int[]{};
    }
}

class SomeSingleItemstubDataservice implements SomeDataService {


    @Override
    public int[] retriveallData() {
        return new int[]{10};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void checkSumusingDataService_basic(){
        SomeBusinessImple business = new SomeBusinessImple();
        business.setSomeDataService(new SomestubDataservice());
        int actualvalue = business.calculateSumusingDataService();
        int expected = 6;
        assertEquals(expected,actualvalue);
    }


    @Test
    public void checkSumUsingDataServiceemptylist(){
        SomeBusinessImple business = new SomeBusinessImple();
        business.setSomeDataService(new SomeEmptystubDataservice());
        int actualvalue = business.calculateSumusingDataService();
        int expected = 0;
        assertEquals(expected,actualvalue);
    }

    @Test
    public void checkSumUsingDataServiceSingleitem(){
        SomeBusinessImple business = new SomeBusinessImple();
        business.setSomeDataService(new SomeSingleItemstubDataservice());
        int actualvalue = business.calculateSumusingDataService();
        int expected = 10;
        assertEquals(expected,actualvalue);
    }
}
