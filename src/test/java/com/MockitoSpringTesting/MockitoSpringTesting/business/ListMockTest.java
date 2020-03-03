package com.MockitoSpringTesting.MockitoSpringTesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/*
* To Mock the List Interface
* */
public class ListMockTest {
    List<String> mock = mock(List.class);
    @Test
    public void basic_list(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returningMultipleValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returningForParameter(){
        when(mock.get(0)).thenReturn("Karthik");
        assertEquals("Karthik",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void genericParameter(){
        when(mock.get(anyInt())).thenReturn("Karthik");
        assertEquals("Karthik",mock.get(0));
        assertEquals("Karthik",mock.get(1));
    }

    /*
    * Verification in Mock to verify whether a specific method is called or not
    *
    * */

    @Test
    public void verificationwithMock(){
        String value1 = mock.get(0);
        String value2 = mock.get(1);
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,never()).get(2);
        verify(mock,atLeastOnce()).get(anyInt());

    }

    @Test
    public void argumentCapturing(){
        mock.add("Something");

        /*
        *  To verify what value was passed as an argument we need to use ArgumentCaptor function
        * */

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("Something",captor.getValue());

    }

    /*
     *  To verify what value was passed as an argument we need to use ArgumentCaptor function
     * */
    @Test
    public void multipleArgumentCapturing(){
        mock.add("Something1");
        mock.add("Something2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> allvalues = captor.getAllValues();
        assertEquals("Something1",allvalues.get(0));
        assertEquals("Something2",allvalues.get(1));

    }

    @Test
    public void mocking(){
        ArrayList<String> arraylistmock = mock(ArrayList.class);
        arraylistmock.add("Test0");
        System.out.println(arraylistmock.get(0));
        System.out.println(arraylistmock.size());
        arraylistmock.add("Test1");
        System.out.println(arraylistmock.size());
        when(arraylistmock.size()).thenReturn(5);
        System.out.println(arraylistmock.size());
        System.out.println(arraylistmock.get(0));
        when(arraylistmock.get(0)).thenReturn("I am Karthik");
        System.out.println(arraylistmock.get(0));

    }

    /*
    * Spying : It has the real behaviour of the business implementation , but as soon we use "when" to mock it .
    * we can take control of the object and it can be mocked as needed
    *
    * Let the action to happen and mocking on it when its needed
    * */
    @Test
    public void Spying(){
        ArrayList<String> arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test1");
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
        System.out.println(arrayListSpy.get(0));
        when(arrayListSpy.get(0)).thenReturn("I am Karthik");
        System.out.println(arrayListSpy.get(0));

    }

}
