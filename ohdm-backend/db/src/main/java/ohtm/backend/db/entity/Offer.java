package ohtm.backend.db.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = Offer.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Offer implements BasicEntity {

    static final String TABLE_NAME = "offer";

    @Id
    @GeneratedValue(generator = "friendly-id-generator")
    @GenericGenerator(name = "friendly-id-generator", strategy = "ohtm.backend.db.entity.idgenerator.FriendlyIdGenerator")
    private String id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "url")
    private String url;

    @Column(name = "opened_at")
    private Date openedAt;

    @Column(name = "closed_at")
    private Date closedAt;

    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    private Plot plot;

}
