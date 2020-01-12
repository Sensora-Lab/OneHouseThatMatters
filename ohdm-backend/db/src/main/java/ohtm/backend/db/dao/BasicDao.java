package ohtm.backend.db.dao;

import ohtm.backend.db.entity.BasicEntity;

import java.util.Optional;

public interface BasicDao<T extends BasicEntity> {

    Optional<T> find(String id);

    String save(T entity);
}
