package chas.twitter.clone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import chas.twitter.clone.service.upload.StorageProperties;
import chas.twitter.clone.service.upload.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class TwitterCloneApplication {
	public static void main(String[] args) {
		SpringApplication.run(TwitterCloneApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
	//		storageService.deleteAll();
			storageService.init();
		};
	}
}
