package br.edu.ufabc.ufabcrunner_ws;

import com.mongodb.Mongo;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by fcosta on 12/15/16.
 */
@Configuration
public class MongoTestConfig {
    @Bean
    public Mongo mongo() throws IOException {
        System.setProperty("DB.TRACE","true");
        return new EmbeddedMongoBuilder()
                .version("2.13.1")
                .bindIp("127.0.0.1")
                .port(27017)
                .build();
    }
}
