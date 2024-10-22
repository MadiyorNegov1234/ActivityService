package uz.tripshare.activityservice.service;

import uz.tripshare.activityservice.entity.BaseEntity;
import uz.tripshare.domain.BaseClass;

import java.util.List;

public interface BaseService<E extends BaseEntity, Resp extends BaseClass, Req> {
    Resp save(Req entity);

    Resp update(Integer id, Req request);

    Resp findById(Integer id);

    E findEntityById(Integer id);

    List<Resp> findAll();

    void delete(Integer id);

    Resp mapEntityToResponse(E entity);
}
