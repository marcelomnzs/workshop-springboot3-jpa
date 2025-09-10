package com.marcelomnzs.course.repositories;

import com.marcelomnzs.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
