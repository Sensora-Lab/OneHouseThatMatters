package ohtm.backend.db.dao;

import com.google.inject.ImplementedBy;
import ohtm.backend.db.dao.qdsl.OfferQdslDao;
import ohtm.backend.db.entity.Offer;

@ImplementedBy(OfferQdslDao.class)
public interface OfferDao extends BasicDao<Offer> {
}
