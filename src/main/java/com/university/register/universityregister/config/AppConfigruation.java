package com.university.register.universityregister.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigruation {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
