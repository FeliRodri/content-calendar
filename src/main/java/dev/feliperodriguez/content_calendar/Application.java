package dev.feliperodriguez.content_calendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import dev.feliperodriguez.content_calendar.config.ContentCalendarProperties;
import dev.feliperodriguez.content_calendar.model.Content;
import dev.feliperodriguez.content_calendar.model.Status;
import dev.feliperodriguez.content_calendar.model.Type;
import dev.feliperodriguez.content_calendar.repository.ContentRepository;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
