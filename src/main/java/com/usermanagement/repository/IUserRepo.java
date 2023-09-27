package com.usermanagement.repository;

import com.usermanagement.model.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<UserModels,Integer> {
}
