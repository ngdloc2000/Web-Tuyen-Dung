package com.example.web_tuyen_dung.repository;

import com.example.web_tuyen_dung.entity.Sns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnsRepository extends JpaRepository<Sns, Long> {
}
