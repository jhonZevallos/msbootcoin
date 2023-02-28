package com.ntt.bootcoin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.ntt.bootcoin.entity.BootcoinEntity;
import com.ntt.bootcoin.service.BootcoinService;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BootcoinServiceImpl implements BootcoinService {

    @Override
    public Uni<List<BootcoinEntity>> getAll() {
        return BootcoinEntity.findAll().list();
    }

    @Override
    public Uni<BootcoinEntity> addBootcoin(BootcoinEntity bootcoinEntity) {

        return bootcoinEntity.persist();
    }

    @Override
    public Uni<BootcoinEntity> update(String id, BootcoinEntity bootcoinEntity) {
        Uni<BootcoinEntity> post = BootcoinEntity.findById(new ObjectId(id));
        return post.flatMap(obj -> {
            obj.setEmail(bootcoinEntity.getEmail());
            obj.setTelephone(bootcoinEntity.getTelephone());
            obj.setPassword(bootcoinEntity.getPassword());
            return obj.persistOrUpdate();
        });
    }

    @Override
    public Uni<BootcoinEntity> delete(String id) {
        Uni<BootcoinEntity> delete = BootcoinEntity.findById(new ObjectId(id));
        return delete.flatMap(obj -> {
            obj.setState("I");
            return obj.persistOrUpdate();
        });
    }

    @Override
    public Uni<BootcoinEntity> findByTelephone(String telephone) {
        Map<String, Object> params = new HashMap<>();
        params.put("state", "A");
        params.put("telephone", telephone);
        return BootcoinEntity.find("state=:state and telephone=:telephone", params).firstResult();
    }

}
