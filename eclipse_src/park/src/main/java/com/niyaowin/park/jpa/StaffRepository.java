package com.niyaowin.park.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.niyaowin.park.jpa.entity.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{

    //List<Staff> findByLastName(String lastName);
    
    @Query("UPDATE Staff s SET s.nickname = :nickname WHERE s.staffId = :id")
    Integer updateNickname(@Param("nickname") String firstName, @Param("id") long id);   
  
    @Query("FROM Staff s WHERE s.isSuper = true AND s.staffId = :id")
    Staff findSuperByPasswordHash(@Param("id") long id);
    
    Long countByNickname(String nickname);
    
    Staff findFirstByIsSuper(boolean isSuper);
    
    @Modifying
    @Query("update Staff  set is_super=true")
    int update1();
    
}
