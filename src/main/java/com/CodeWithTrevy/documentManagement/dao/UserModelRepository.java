package com.CodeWithTrevy.documentManagement.dao;

import com.CodeWithTrevy.documentManagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Long> {

}
