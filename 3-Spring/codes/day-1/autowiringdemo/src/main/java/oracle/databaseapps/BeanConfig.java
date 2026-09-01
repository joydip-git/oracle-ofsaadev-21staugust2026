package oracle.databaseapps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Indicates that a class declares one or more @Bean methods and may be processed
// by the Spring container to generate bean definitions and service requests
// for those beans at runtime
@Configuration
@ComponentScan("oracle.databaseapps")
public class BeanConfig {

//    @Bean
//    public FileReader fileReader() {
//        return new FileReader();
//    }
//
//    @Bean
//    public DbReader dbReader() {
//        return new DbReader();
//    }
//
//    @Bean
//    public FileManager fileManager() {
//        return new FileManager(fileReader());
//    }
//
//    @Bean
//    public DbManager dbManager() {
//        return new DbManager();
//    }
}
