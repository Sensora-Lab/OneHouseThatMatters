package ohtm.backend.db.dao.qdsl;

import com.google.inject.persist.Transactional;
import ohtm.backend.db.dao.BasicDao;
import ohtm.backend.db.entity.BasicEntity;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.Optional;

@Transactional
public abstract class AbstractBasicDao<T extends BasicEntity> implements BasicDao<T> {

    private final Provider<EntityManager> provider;

    AbstractBasicDao(Provider<EntityManager> provider) {
        this.provider = provider;
    }

    @Override
    public String save(T entity) {
        throw new UnsupportedOperationException();
    }

    protected void add(T entity) {
        provider.get().persist(entity);
        provider.get().flush();
    }

    protected void update(T entity) {
        provider.get().merge(entity);
        provider.get().flush();
    }

    @Override
    public Optional<T> find(String id) {
        throw new UnsupportedOperationException();
    }

}
