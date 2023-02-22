package lk.ijse.easyCar.config;

import lk.ijse.easyCar.repo.CarRepo;
import lk.ijse.easyCar.repo.UserRepo;
import lk.ijse.easyCar.service.impl.CarServiceImpl;
import lk.ijse.easyCar.service.impl.DriverServiceImpl;
import lk.ijse.easyCar.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {UserServiceImpl.class, CarServiceImpl.class, DriverServiceImpl.class})
public class WebRootConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
