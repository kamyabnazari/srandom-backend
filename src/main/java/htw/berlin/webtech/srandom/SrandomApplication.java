/**
 * Main Application Method, die eine Springboot-Anwendung aufruft
 */

package htw.berlin.webtech.srandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SrandomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrandomApplication.class, args);
    }

}
