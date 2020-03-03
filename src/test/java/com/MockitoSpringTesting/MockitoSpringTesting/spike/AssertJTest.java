package com.MockitoSpringTesting.MockitoSpringTesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public  void learningAssert(){
        List<Integer> numbers = Arrays.asList(12,15,20);

        assertThat(numbers).hasSize(3);
        assertThat("ABC").isNotEmpty().startsWith("AB").endsWith("BC");

        assertThat(numbers).contains(12,15)
                .allMatch(x->x>10)
                .allMatch(x->x<100);

        /*assertThat(numbers,everyItem(greaterThan(10)));
        assertThat("",isEmptyOrNullString());
        assertThat("ABC",startsWith("AB"));
        assertThat("ABC",endsWith("BC"));*/

    }
}
