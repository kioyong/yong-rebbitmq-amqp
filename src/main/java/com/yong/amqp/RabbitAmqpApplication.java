package com.yong.amqp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
@EnableScheduling
public class RabbitAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitAmqpApplication.class, args);
	}

    @Profile("usage_message")
    @Bean
	public CommandLineRunner usage(){
	    return new CommandLineRunner(){
	        @Override
	        public void run(String... arg0) throws Exception{
                System.out.println("This app uses Spring Profiles to control its behavior.\n");
                System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
                new SimpleDateFormat("dd/mm/yyyy/ HH:mm:ss", Locale.CHINESE).format(new Date());
            }
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitAmqpTutorialsRunner();
    }

}
