package com.soprabanking.dxp.authserver.initilizer;

import com.soprabanking.dxp.authserver.model.entity.UserInfo;
import com.soprabanking.dxp.authserver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * class to initialize data on application start up
 */
@Component
public class UserInfoDataInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initialDataSetUp();
    }

    private void initialDataSetUp() {
        repository.deleteAll()
                    .thenMany(Flux.fromIterable(getData()))
                    .flatMap(repository::save)
                    .thenMany((repository.findAll()))
                    .subscribe(user -> System.out.println("User inserted from command line Runner"));

    }

    public List<UserInfo> getData(){
        return Arrays.asList(new UserInfo(null,  "john", "john-pass" ),
                             new UserInfo(null,  "eric", "eric-pass" ));
    }
}
