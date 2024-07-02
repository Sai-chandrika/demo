package com.example.demo.repo;

import com.example.demo.entity.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookImageRepo extends JpaRepository<BookImage,String> {
}
