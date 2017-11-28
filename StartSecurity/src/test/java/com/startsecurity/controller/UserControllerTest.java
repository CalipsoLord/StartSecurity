package com.startsecurity.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
    public void getHello() throws Exception {
		String body = this.template.getForObject("/StartSecurity", String.class);
		assertThat(body).isEqualTo("Hola mundo");
        
    }

}
