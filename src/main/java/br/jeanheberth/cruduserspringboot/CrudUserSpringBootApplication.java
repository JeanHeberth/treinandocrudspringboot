package br.jeanheberth.cruduserspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("testando")
public class CrudUserSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudUserSpringBootApplication.class, args);
    }

    @GetMapping("/teste")
    public String index(){
        return  "Ola Mundo!";
    }

}
