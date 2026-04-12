package com.coffee_break.coffee_break_backend.data.model;

import com.coffee_break.coffee_break_backend.data.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class AppUser implements EntityWithId{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @NonNull
    private String realName;
    @NonNull
    private String userName;
    @NonNull
    private String password;

}
