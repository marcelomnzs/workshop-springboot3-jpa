package com.marcelomnzs.course.repositories;

import com.marcelomnzs.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
