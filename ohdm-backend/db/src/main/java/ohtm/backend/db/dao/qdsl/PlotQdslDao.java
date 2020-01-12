package ohtm.backend.db.dao.qdsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ohtm.backend.db.dao.PlotDao;
import ohtm.backend.db.entity.Plot;
import ohtm.backend.db.entity.QPlot;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.Optional;

public class PlotQdslDao extends AbstractBasicDao<Plot> implements PlotDao {

    private final JPAQueryFactory queryFactory;
    private final QPlot plot = QPlot.plot;

    @Inject
    PlotQdslDao(Provider<EntityManager> provider, JPAQueryFactory queryFactory) {
        super(provider);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Plot> find(String id) {
        if (null == id) {
            return Optional.empty();
        }
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(plot)
                        .where(plot.id.like(id))
                        .fetchOne()
        );
    }

    @Override
    public String save(Plot plot) {
        find(plot.getId()).ifPresentOrElse(
                dbEntity -> update(plot), () -> add(plot)
        );
        return plot.getId();
    }

}
