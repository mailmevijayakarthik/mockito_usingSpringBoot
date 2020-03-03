package com.MockitoSpringTesting.MockitoSpringTesting.business;

import com.MockitoSpringTesting.MockitoSpringTesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.configuration.IMockitoConfiguration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/* Using mockito
* When --> dataservicemock --> retriveallData --> should return new int[]{1,2,3}
* */
public class SomeBusinessMockTest {

    SomeBusinessImple business = new SomeBusinessImple();
    SomestubDataservice dataservicemock = mock(SomestubDataservice.class);


    @Before
    public void setDataService(){
        business.setSomeDataService(dataservicemock);
    }

    @Test
    public void checkSumusingDataService_basic(){

        // When --> dataservicemock --> retriveallData --> should return new int[]{1,2,3}
        when(dataservicemock.retriveallData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, business.calculateSumusingDataService());
    }


    @Test
    public void checkSumUsingDataServiceemptylist(){

        when(dataservicemock.retriveallData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumusingDataService());
    }

    @Test
    public void checkSumUsingDataServiceSingleitem(){

        when(dataservicemock.retriveallData()).thenReturn(new int[]{10});
        assertEquals(10, business.calculateSumusingDataService());
    }
}
