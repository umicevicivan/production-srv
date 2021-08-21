package com.fpis.productionsrv;

import com.fpis.productionsrv.entity.Product;
import com.fpis.productionsrv.entity.User;
import com.fpis.productionsrv.repository.ProductRepository;
import com.fpis.productionsrv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProductionSrvApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
//    public void initData() {
//        List<User> users = Stream.of(
//                new User(101L, "user1", "user1", "user1@user1.com"),
//                new User(102L, "user2", "user2", "user2@user2.com")
//        ).collect(Collectors.toList());
//        userRepository.saveAll(users);
//
//        List<Product> products = Stream.of(
//                new Product(101L, "Product1", "Product - 1", "bocica", "...Lorem ipsum...", "...Lorem ipsum...", 123L),
//                new Product(102L, "Product2", "Product - 2", "tableta", "...Lorem ipsum...", "...Lorem ipsum...", 123L),
//                new Product(103L, "Product3", "Product - 3", "kapsula", "...Lorem ipsum...", "...Lorem ipsum...", 123L),
//                new Product(104L, "Product4", "Product - 4", "tableta", "...Lorem ipsum...", "...Lorem ipsum...", 123L)
//        ).collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductionSrvApplication.class, args);
    }

}
