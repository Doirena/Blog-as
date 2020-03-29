package com.dovile.userlogin.repos;


import org.springframework.data.jpa.repository.JpaRepository;


import com.dovile.userlogin.entities.Records;

public interface RecordRepository extends JpaRepository<Records, Long> {
	
	


}
