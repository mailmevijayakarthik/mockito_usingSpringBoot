package com.MockitoSpringTesting.MockitoSpringTesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockitoSpringTestingIT {
	@Autowired
	private TestRestTemplate restTemplate;

	/*
	* We can mock out any layer by using @MockBear Annotation to the local variable
	*
	* */
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-database",String.class);
		JSONAssert.assertEquals("[{id:1000},{id:1001},{id:1002},{id:1003},{id:1004}]",response,false);
	}

}
