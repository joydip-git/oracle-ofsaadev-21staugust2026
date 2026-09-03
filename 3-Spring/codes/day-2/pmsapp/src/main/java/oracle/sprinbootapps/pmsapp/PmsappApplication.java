package oracle.sprinbootapps.pmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
//import org.springframework.boot.security.autoconfigure.actuate.web.servlet.ManagementWebSecurityAutoConfiguration;

//
//@SpringBootApplication(exclude = {
//        SecurityAutoConfiguration.class,
//        ManagementWebSecurityAutoConfiguration.class
//})
@SpringBootApplication
public class PmsappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsappApplication.class, args);
    }

}
