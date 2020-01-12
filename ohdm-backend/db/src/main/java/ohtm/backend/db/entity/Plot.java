package ohtm.backend.db.entity;

import lombok.*;
import ohtm.backend.db.entity.converter.PointConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = Plot.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Plot implements BasicEntity {

    static final String TABLE_NAME = "plot";

    @Id
    @GeneratedValue(generator = "friendly-id-generator")
    @GenericGenerator(name = "friendly-id-generator", strategy = "ohtm.backend.db.entity.idgenerator.FriendlyIdGenerator")
    private String id;

    @Column(name = "location")
    @Builder.Default
    @Convert(converter = PointConverter.class)
    private Point location = Point.builder().build();

    @Column(name = "ref_number")
    private String refNumber;

    @OneToMany(mappedBy = "plot", fetch = FetchType.EAGER)
    @OrderBy("opened_at")
    private Set<Offer> offers;

}
