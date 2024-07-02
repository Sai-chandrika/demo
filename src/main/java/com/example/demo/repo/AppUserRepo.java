package com.example.demo.repo;

import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,String> {
    AppUser findByEmail(String email);

    AppUser findByMobileNo(String mobileNo);


    AppUser findByFirstName(String userName);
}
