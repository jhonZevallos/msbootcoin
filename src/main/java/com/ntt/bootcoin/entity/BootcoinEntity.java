package com.ntt.bootcoin.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MongoEntity(collection = "DWMBOOTCOIN")
public class BootcoinEntity extends ReactivePanacheMongoEntity {

    private String name;
    private String typeDocument;
    private String numDocument;
    private int password;
    private String telephone;
    private String email;
    private String state;
}
