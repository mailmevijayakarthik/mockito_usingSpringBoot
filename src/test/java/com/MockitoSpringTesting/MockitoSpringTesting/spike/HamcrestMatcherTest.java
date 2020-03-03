package com.MockitoSpringTesting.MockitoSpringTesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HamcrestMatcherTest {

    @Test
    public  void learningAssert(){
        List<Integer> numbers = Arrays.asList(12,15,20);
        assertThat(numbers,hasSize(3));
        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat("",isEmptyOrNullString());
        assertThat("ABC",startsWith("AB"));
        assertThat("ABC",endsWith("BC"));

    }
}
