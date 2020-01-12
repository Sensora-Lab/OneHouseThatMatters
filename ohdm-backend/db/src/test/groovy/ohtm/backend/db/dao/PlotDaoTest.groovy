package ohtm.backend.db.dao

import groovy.util.logging.Slf4j
import ohtm.backend.db.entity.Plot
import ohtm.backend.db.entity.Point
import org.testcontainers.spock.Testcontainers

import javax.inject.Inject

@Testcontainers
@Slf4j
class PlotDaoTest extends AbstractDaoTest {

    @Inject
    PlotDao plotDao;

    def "save new entity"() {
        given:
        Plot plot = Plot.builder()
                .refNumber("ref-number")
                .location(
                        Point
                                .builder()
                                .latitude("12.34")
                                .longitude("43.21")
                                .build()
                ).build()
        when:
        def id = plotDao.save(plot)
        def dbPlot = plotDao.find(id)

        then:
        dbPlot.isPresent()
        dbPlot.get().id == id
        dbPlot.get().refNumber == "ref-number"
        dbPlot.get().location.latitude == "12.34"
        dbPlot.get().location.longitude == "43.21"
    }
}
