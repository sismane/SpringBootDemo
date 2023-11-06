package com.kagan.demo.application;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kagan.demo.model.Customer;

import jakarta.annotation.PostConstruct;
	

@SpringBootApplication
public class KaganListingExampleProjectApplication {

	private static final Logger logger = LoggerFactory.getLogger(KaganListingExampleProjectApplication.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		logger.info("Application starting!");
		SpringApplication.run(KaganListingExampleProjectApplication.class, args);
		logger.info("Application runned!");
	}
	
	@PostConstruct
	public void run() throws Exception {
        String sql = "SELECT * FROM Customer";
         
        List<Customer> customers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
         
        customers.forEach(customer -> logger.info(customer.toString()));
    }
}


