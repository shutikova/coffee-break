package com.coffee_break.coffee_break_backend;

import com.coffee_break.coffee_break_backend.data.model.*;
import com.coffee_break.coffee_break_backend.data.model.enums.UserRole;
import com.coffee_break.coffee_break_backend.data.repository.UserRepository;
import com.coffee_break.coffee_break_backend.data.repository.CafeRepository;
import com.coffee_break.coffee_break_backend.data.repository.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepo,
            CafeRepository cafeRepo,
            CoffeeRepository coffeeRepo
    ) {
        return args -> {

            // prevent duplicate inserts on restart
            if (userRepo.count() > 0) return;

            // ===== USERS (IDs 1–5) =====
            userRepo.save(new AppUser(UserRole.CUSTOMER, "Alice Customer", "alice", "pass"));
            userRepo.save(new AppUser(UserRole.CUSTOMER, "Bob Customer", "bob", "pass"));
            userRepo.save(new AppUser(UserRole.CAFE_EMPLOYEE, "Charlie Employee", "charlie", "pass"));
            userRepo.save(new AppUser(UserRole.CAFE_EMPLOYEE, "Diana Employee", "diana", "pass"));
            userRepo.save(new AppUser(UserRole.CUSTOMER, "Eve Customer", "eve", "pass"));

            // ===== CAFES =====
            cafeRepo.save(new Cafe("Kavárna PEF", "Jen vyběhnout do patra!", "V Patře 123"));
            cafeRepo.save(new Cafe("Kavárna TF", "Otevřeno do čtyř", "V přízemí 456"));
            cafeRepo.save(new Cafe("Kavárna Centrum", "Nejlepší káva ve městě", "Náměstí 1"));

            // ===== COFFEES =====
            coffeeRepo.save(new Coffee("Espresso", 2.5, "EUR"));
            coffeeRepo.save(new Coffee("Cappuccino", 3.0, "EUR"));
            coffeeRepo.save(new Coffee("Latte", 3.5, "EUR"));
        };
    }
}