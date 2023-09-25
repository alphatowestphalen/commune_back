package com.back.commune.config;

import com.back.commune.mapper.ActeDeDecesMapper;
import com.back.commune.mapper.ActeDeDecesMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    ActeDeDecesMapper getActeDeDecesMapper(){
        return new ActeDeDecesMapperImpl();
    }

}
