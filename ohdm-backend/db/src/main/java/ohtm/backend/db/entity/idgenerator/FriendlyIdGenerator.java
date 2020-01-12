package ohtm.backend.db.entity.idgenerator;

import com.devskiller.friendly_id.FriendlyId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

public class FriendlyIdGenerator extends UUIDGenerator {

    private String entityName;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        entityName = params.getProperty(ENTITY_NAME);
        super.configure(type, params, serviceRegistry);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Serializable id = session
                .getEntityPersister(entityName, object)
                .getIdentifier(object, session);

        return Objects.requireNonNullElseGet(id, () -> FriendlyId.toFriendlyId(UUID.randomUUID()));
    }
}

