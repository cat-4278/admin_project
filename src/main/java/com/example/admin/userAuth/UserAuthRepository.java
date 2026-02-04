package com.example.admin.userAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.userAuth.UserAuth.UserAuthId;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, UserAuthId> {
	
}
