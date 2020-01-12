package ohtm.backend.db.dao;

import com.google.inject.ImplementedBy;
import ohtm.backend.db.dao.qdsl.PlotQdslDao;
import ohtm.backend.db.entity.Plot;

@ImplementedBy(PlotQdslDao.class)
public interface PlotDao extends BasicDao<Plot> {
}
