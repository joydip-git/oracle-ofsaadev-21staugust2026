package oracle.sprinbootapps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping(path = "/hello")
    public String get() {
        return "hello";
    }

    @Bean
    Reader reader() {
        return new Reader();
    }
}

class Reader {
    public String getData() {
        return "data";
    }
}
