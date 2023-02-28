package com.ntt.bootcoin.service;

import java.util.List;

import com.ntt.bootcoin.entity.BootcoinEntity;

import io.smallrye.mutiny.Uni;

public interface BootcoinService {

    public Uni<List<BootcoinEntity>> getAll();

    public Uni<BootcoinEntity> addBootcoin(BootcoinEntity bootcoinEntity);

    public Uni<BootcoinEntity> update(String id, BootcoinEntity bootcoinEntity);

    public Uni<BootcoinEntity> delete(String id);

    public Uni<BootcoinEntity> findByTelephone(String telephone);

}
