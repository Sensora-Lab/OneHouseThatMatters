package ohtm.backend.db.dao

import ohtm.backend.db.entity.Offer
import ohtm.backend.db.entity.Plot
import ohtm.backend.db.entity.Point
import org.testcontainers.spock.Testcontainers

import javax.inject.Inject
import java.sql.Date

@Testcontainers
class OfferDaoTest extends AbstractDaoTest {

    @Inject
    OfferDao offerDao;

    @Inject
    PlotDao plotDao;

    def "save new entity"() {
        given:
        Plot plot = Plot
                .builder()
                .refNumber("ref-number")
                .location(Point
                        .builder()
                        .longitude("123")
                        .latitude("345")
                        .build())
                .build()

        plotDao.save(plot)

        Offer offer = Offer.builder()
                .plot(plot)
                .price(new BigDecimal("450000.00"))
                .url("http://example.com")
                .openedAt(new Date(2020, 01, 10))
                .closedAt(new Date(2020, 01, 11))
                .build()
        when:
        def id = offerDao.save(offer)
        def dbOffer = offerDao.find(id)

        then:
        dbOffer.isPresent()
        dbOffer.get().id == id
        dbOffer.get().plot.id == plot.getId()
        dbOffer.get().url == "http://example.com"
        dbOffer.get().price == new BigDecimal("450000.00")
        dbOffer.get().openedAt == new Date(2020, 01, 10)
        dbOffer.get().closedAt == new Date(2020, 01, 11)
    }
}
