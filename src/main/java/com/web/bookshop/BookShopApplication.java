package com.web.bookshop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bookshop/controller")
@SpringBootApplication(scanBasePackages = "com.web.bookshop")
public class BookShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }
}
