package com.disney.studios.controller

import org.junit.*
import org.junit.runner.*

import org.springframework.boot.test.context.web.*
import org.springframework.boot.test.web.client.*
import org.springframework.test.context.junit4.*

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.beans.factory.annotation.Autowired

import static org.assertj.core.api.Assertions.*

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class DogControllerVotingIntTest {

    @Autowired
    private TestRestTemplate restTemplate

    @Test
    public void testVoteUp() {
        String body = this.restTemplate.getForObject("/dogs/vote/up/{id}/joseph", String.class, "1");
        String expected = """{"message":"vote successfull","success":true}"""

        assertThat(body).isEqualTo(expected)
    }

    @Test
    public void testVoteDown() {
        String body = this.restTemplate.getForObject("/dogs/vote/down/{id}/joseph", String.class, "2");
        String expected = """{"message":"vote successfull","success":true}"""

        assertThat(body).isEqualTo(expected)
    }

    @Test
    public void testVoteUpTwice() {
        String body = this.restTemplate.getForObject("/dogs/vote/up/{id}/joseph", String.class, "3");
        String expected = """{"message":"vote successfull","success":true}"""

        assertThat(body).isEqualTo(expected)

        body = this.restTemplate.getForObject("/dogs/vote/up/{id}/joseph", String.class, "3");
        expected = """{"message":"client has already tried","success":false}"""
        assertThat(body).isEqualTo(expected)
    }

    @Test
    public void testVoteDownTwice() {
        String body = this.restTemplate.getForObject("/dogs/vote/up/{id}/joseph", String.class, "4");
        String expected = """{"message":"vote successfull","success":true}"""

        assertThat(body).isEqualTo(expected)

        body = this.restTemplate.getForObject("/dogs/vote/down/{id}/joseph", String.class, "4");
        expected = """{"message":"client has already tried","success":false}"""
        assertThat(body).isEqualTo(expected)
    }
}
