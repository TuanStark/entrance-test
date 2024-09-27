package com.example.ENTRANCE.TEST.repository;

import com.example.ENTRANCE.TEST.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StyleRepository extends JpaRepository<Style,Long> {
}
