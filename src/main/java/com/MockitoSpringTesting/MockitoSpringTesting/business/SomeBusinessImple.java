package com.MockitoSpringTesting.MockitoSpringTesting.business;

import com.MockitoSpringTesting.MockitoSpringTesting.data.SomeDataService;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class SomeBusinessImple {

    private SomeDataService someDataService;

    public SomeDataService getSomeDataService() {
        return someDataService;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }


    /*
    * Can reduce the below code to the below
    * int sum=0;
        for(int value :data){
            sum=sum+value;
        }

        return sum;  =====> as below
        * OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
        * number.orElse(0);
        * ==>
        * return Arrays.stream(data).reduce(Integer::sum).orElse(0);
        *
    *
    *
    * */
    public int calculateSum(int[] data){


        int sum=0;
        for(int value :data){
            sum=sum+value;
        }

        return sum;

    }

    /*Implementing using Data service
    *
    *
    * */
    public int calculateSumusingDataService(){
        int sum=0;
        int[] data = someDataService.retriveallData();
        for(int value :data){
            sum=sum+value;
        }

        return sum;

    }
}
