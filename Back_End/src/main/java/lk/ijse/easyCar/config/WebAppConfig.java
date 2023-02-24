package lk.ijse.easyCar.config;

import lk.ijse.easyCar.advisor.AppWideExceptionHandler;
import lk.ijse.easyCar.controller.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AdminController.class,HomePageController.class, RegisterController.class, DriverController.class, UserController.class,VehicleController.class,AppWideExceptionHandler.class})
public class WebAppConfig {


}
