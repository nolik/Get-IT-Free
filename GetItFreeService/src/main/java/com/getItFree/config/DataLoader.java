package com.getItFree.config;

import com.getItFree.model.Advert;
import com.getItFree.model.User;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.repository.UserRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.getItFree.model.Authority.ROLE_USER;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //temporary initialization of db
        List<Advert> adverts = new ArrayList<>();
        adverts.add(Advert.builder()
                .head("пивко")
                .content("забирай добрый люд пивко")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg")
                .ordered(false)
                .build()
        );

        adverts.add(Advert.builder()
                .head("пивко2")
                .content("забирай добрый люд пивко")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg")
                .ordered(false)
                .build()

        );
        adverts.add(Advert.builder()
                .head("пивко3")
                .content("забирай добрый люд пивко")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://thumb9.shutterstock.com/display_pic_with_logo/3521228/391005625/stock-photo-glasses-of-light-and-dark-beer-on-a-pub-background-391005625.jpg")
                .ordered(false)
                .build());

        //adverts.forEach(advertRepository::save);


        List<User> users = Lists.newArrayList();
        users.add(User.builder()
                .username("user")
                .password("pass")
                .email("asd@mail.com")
                .authority(Arrays.asList(ROLE_USER))
                .adverts(Arrays.asList(adverts.get(0)))
                .build()
        );

        users.add(User.builder()
                .username("user2")
                .password("pass")
                .email("ewq@mail.com")
                .authority(Arrays.asList(ROLE_USER))
                .adverts(Arrays.asList(adverts.get(1), adverts.get(2)))
                .build()
        );

        users.forEach(userRepository::save);


    }
}
