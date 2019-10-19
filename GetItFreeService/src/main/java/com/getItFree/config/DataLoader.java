package com.getItFree.config;

import com.getItFree.model.User;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();

    }
}
