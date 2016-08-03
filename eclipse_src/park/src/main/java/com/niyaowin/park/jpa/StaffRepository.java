package com.niyaowin.park.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.niyaowin.park.jpa.entity.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {

    List<Staff> findByLastName(String lastName);
    
    @Query("UPDATE Staff s SET s.nickname = :nackname WHERE s.staff_id = :id")
    Integer updateNickname(@Param("nickname") String firstName, @Param("id") long id);   
    
    Long countByNickname(String nickname);

}
