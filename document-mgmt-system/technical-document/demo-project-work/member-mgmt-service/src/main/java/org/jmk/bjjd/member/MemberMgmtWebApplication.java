package org.jmk.bjjd.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = { "io.swagger", "org.jmk.bjjd.member" })
public class MemberMgmtWebApplication {

      public static void main(String[] args) throws Exception {
        SpringApplication.run(MemberMgmtWebApplication.class,args);
    }
    
}
