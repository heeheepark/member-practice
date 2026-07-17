package org.example.memberpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemberPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPracticeApplication.class, args);
    }

}
