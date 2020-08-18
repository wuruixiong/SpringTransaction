package wrx.sp.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class PTXApplication {

    public static void main(String[] args) {
        SpringApplication.run(PTXApplication.class, args);
    }

}
