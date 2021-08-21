package com.fpis.productionsrv.repository;

import com.fpis.productionsrv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
