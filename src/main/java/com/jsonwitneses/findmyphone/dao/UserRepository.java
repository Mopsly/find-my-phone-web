package com.jsonwitneses.findmyphone.dao;

import com.jsonwitneses.findmyphone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
