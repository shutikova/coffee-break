package com.coffee_break.coffee_break_backend.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Coffee implements EntityWithId {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private String currency;

}
