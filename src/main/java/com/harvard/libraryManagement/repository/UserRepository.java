package com.harvard.libraryManagement.repository;

import com.harvard.libraryManagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

    //here hibernate will generate the query for us
    List<UserEntity> findByName(String name);
    List<UserEntity> findByNameContains(String name);
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByEmailContains(String email);
    List<UserEntity> findByPhoneNo(String phoneNo);
    List<UserEntity> findByPhoneNoContains(String phoneNo);

    @Query(value= "select u from UserEntity u where name=:name" , nativeQuery= false)
    List<UserEntity> retrieveUserViaName(String name);

    @Query(value= "select * from user where name=:name" , nativeQuery= true)
    List<UserEntity> retrieveUserViaNameNative(String name);

}
