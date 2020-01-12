package ohtm.backend.db.dao.qdsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ohtm.backend.db.dao.OfferDao;
import ohtm.backend.db.entity.Offer;
import ohtm.backend.db.entity.QOffer;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.Optional;

public class OfferQdslDao extends AbstractBasicDao<Offer> implements OfferDao {

    private final JPAQueryFactory queryFactory;
    private final QOffer offer = QOffer.offer;

    @Inject
    OfferQdslDao(Provider<EntityManager> provider, JPAQueryFactory queryFactory) {
        super(provider);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Offer> find(String id) {
        if (null == id) {
            return Optional.empty();
        }
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(offer)
                        .where(offer.id.like(id))
                        .fetchOne()
        );
    }

    @Override
    public String save(Offer offer) {
        find(offer.getId()).ifPresentOrElse(
                dbEntity -> update(offer), () -> add(offer)
        );
        return offer.getId();
    }

}
