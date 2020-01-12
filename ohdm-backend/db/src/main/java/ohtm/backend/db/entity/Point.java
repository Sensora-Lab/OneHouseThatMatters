package ohtm.backend.db.entity;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Point {
    String latitude;
    String longitude;
}
