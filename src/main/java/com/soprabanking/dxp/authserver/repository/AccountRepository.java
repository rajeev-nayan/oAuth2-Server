package com.soprabanking.dxp.authserver.repository;

import com.soprabanking.dxp.authserver.model.entity.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<UserInfo,String> {


}
