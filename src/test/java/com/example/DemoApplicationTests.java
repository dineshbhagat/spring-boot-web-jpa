package com.example;

import com.example.entity.Article;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

	final static ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Test
	public void noParamGetShouldReturnDefaultMessage() throws Exception {

		Map<String, String> map = Maps.newHashMap();
		map.put("a", "Hello World!");
		String resp = this.mockMvc.perform(get("/abcd")).andDo(print()).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Assert.assertEquals(MAPPER.writeValueAsString(map), resp);
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		String resp = this.mockMvc.perform(get("/1"))
				.andDo(print()).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("hello worlds:" + resp);
//        Assert.assertEquals(MAPPER.writeValueAsString(map), resp);
	}

	@Test
	public void testHibernate() {
		SessionFactory sf = entityManagerFactory.unwrap(SessionFactory.class);
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);

        Session session = sf.openSession();
		session.beginTransaction();

		Article article = new Article();
		article.setArticleText("HEllo");

		session.save(article);

		session.getTransaction().commit();
		//todo this is not working, need to figure out how to do this?, i.e. get result set and iterate over it
		//List resultSet = session.createQuery("FROM com.example.entity.Article").list();
       // System.out.println(resultSet);
		session.close();


	}

}
