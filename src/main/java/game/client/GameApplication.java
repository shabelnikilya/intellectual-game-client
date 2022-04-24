package game.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class GameApplication {

	@Bean
	public ManagedChannel managedChannel(@Value("${grpc.server}") String serverPort) {
		return ManagedChannelBuilder.forTarget(serverPort).usePlaintext().build();
	}


	@Bean
	public Random getRandomClass() {
		return new Random();
	}


	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

}
