package com.ntt.bootcoin.resource;

import java.util.List;

import org.jboss.logging.Logger;

import com.ntt.bootcoin.entity.BootcoinEntity;
import com.ntt.bootcoin.service.BootcoinService;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/bootcoin")
public class BootcoinResource {

    @Inject
    BootcoinService service;

    @Inject
    Logger log;

    @GET
    public Uni<List<BootcoinEntity>> getAllBootcoin() {
        log.info("Iniciando el metodo getAllBootcoin - Resource");
        return service.getAll();
    }

    @GET
    @Path("{telephone}")
    public Uni<BootcoinEntity> findByTelephone(@PathParam("telephone") String telephone) {
        log.info("iniciando el metodo findByTelephone - Resource");
        return service.findByTelephone(telephone);
    }

    @POST
    public Uni<BootcoinEntity> addBootcoin(BootcoinEntity bootcoinEntity) {
        log.info("Iniciando metodo addBootcoin -  resource");
        return service.addBootcoin(bootcoinEntity);
    }

    @PUT
    @Path("{id}")
    public Uni<BootcoinEntity> updateBootcoin(@PathParam("id") String id, BootcoinEntity bootcoinEntity) {
        log.info("iniciando metodo updateBootcoin - resource");
        return service.update(id, bootcoinEntity);
    }

    @DELETE
    @Path("{id}")
    public Uni<BootcoinEntity> deleteBootcoin(@PathParam("id") String id) {
        log.info("iniciando metodo deleteBootcoind - resource");
        return service.delete(id);
    }
}
