package com.MockitoSpringTesting.MockitoSpringTesting.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/* Using mockito
* When --> dataservicemock --> retriveallData --> should return new int[]{1,2,3}
*
* 4 Changes by using Inbuilt Mockito Annotations
* Use @InjectMocks to the actual Business Implementation
* Use @Mock to define mock implementation
* Remove @before no need to set dataservice
* Use @RunWith(MockitoJUnitRunner.class) on the main class under test
* */

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest_UsingInbuiltMockAnnotations {

    @InjectMocks
    SomeBusinessImple business;
    @Mock
    SomestubDataservice dataservicemock;

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
