package com.talk_api.talk_api;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TalkApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalkApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SocketIOServer server) {
        return args -> {
            server.start();
            Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        };
    }

}
