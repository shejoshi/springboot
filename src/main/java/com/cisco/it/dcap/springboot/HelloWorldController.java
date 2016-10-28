package com.cisco.it.dcap.springboot;


import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@ComponentScan("com.cisco.it.dcap.springboot") 
public class HelloWorldController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	 
	@RequestMapping("/")
	String handlerHome() {
		logger.info("/");
		return "Helllooooo World";
	}
	
	@RequestMapping("/getA")
	public void handlerA() throws InterruptedException {
		logger.info("/getA");
		Thread.sleep(RandomUtils.nextInt(100));
	}
	
	@RequestMapping("/getB")
	public void handlerB() throws InterruptedException {
		logger.info("/getB");
		Thread.sleep(RandomUtils.nextInt(100));
	}
	
	@RequestMapping("/getAway")
	String handlerAway() throws InterruptedException {
		logger.info("/getB");
		Thread.sleep(RandomUtils.nextInt(100));
		return "You crazy guys although you rock, getAway, its Diwali time go celebrate !!!!!!";
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(HelloWorldController.class, args);
        
    }
}
