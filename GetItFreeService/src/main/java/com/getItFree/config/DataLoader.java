package com.getItFree.config;

import com.getItFree.model.Advert;
import com.getItFree.model.AdvertStatus;
import com.getItFree.model.User;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.repository.UserRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.getItFree.model.Authority.ROLE_USER;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;


    @Override
    public void run(ApplicationArguments args) {
        List<User> users = Lists.newArrayList();
        users.add(User.builder()
                .username("user")
                .password("pass")
                .email("asd@mail.com")
                .authority(Collections.singletonList(ROLE_USER))
                .build()
        );

        users.add(User.builder()
                .username("user2")
                .password("pass")
                .email("ewq@mail.com")
                .authority(Collections.singletonList(ROLE_USER))
                .build()
        );

        users.forEach(userRepository::save);

        //temporary initialization of db
        List<Advert> adverts = new ArrayList<>();
        adverts.add(Advert.builder()
                .head("Кружечка")
                .content("Урвал на хакатоне")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://i.postimg.cc/vT4hPVtC/krujka.jpg")
                .status(AdvertStatus.FREE)
                .price(2)
                .giver(users.get(0))
                .build()
        );

        adverts.add(Advert.builder()
                .head("Крест Торрето")
                .content("Снял с живого Доменика")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://i.postimg.cc/VkCTf3M2/krest.jpg")
                .status(AdvertStatus.FREE)
                .price(1)
                .giver(users.get(1))
                .build()

        );

        adverts.add(Advert.builder()
                .head("Штанцы")
                .content("Отрываю от души")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://i.postimg.cc/LXP4pyDT/shtanci.jpg")
                .status(AdvertStatus.FREE)
                .price(1)
                .giver(users.get(1))
                .build());

        adverts.add(Advert.builder()
                .head("Игра мафия")
                .content("Отдам игру в добрые руки")
                .date(Calendar.getInstance().getTime())
                .imageUrl("https://i.postimg.cc/zG8tNVzH/mafia.jpg")
                .status(AdvertStatus.FREE)
                .price(1)
                .giver(users.get(1))
                .build());



        adverts.forEach(advertRepository::save);


    }
}
