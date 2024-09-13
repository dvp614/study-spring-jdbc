package org.zerock.myapp;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@AutoConfigureMockMvc

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class StudySpringJdbcAppTests {
	@Autowired(required = false)
	private DataSource dataSource;

	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;

//	@Disabled
	@Order(1)
	@Test
//	@RepeatedTest(1)
	@DisplayName("1. contextLoads")
	@Timeout(value = 1L, unit = TimeUnit.MINUTES)
	void contextLoads() {
		log.trace("contextLoads() invoked.");
		Objects.requireNonNull(this.dataSource);

		log.info("\t+ this.dataSource : {}", this.dataSource);

		assertNotNull(this.jdbcTemplate);

		log.info("\t+ this.jdbcTemplate : {}", this.jdbcTemplate);
	} // contextLoads

} // end class
