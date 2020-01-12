package ohtm.backend.db.entity.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ohtm.backend.db.entity.Point;

import javax.persistence.AttributeConverter;

public class PointConverter implements AttributeConverter<Point, String> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Point attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            // silence the exception
        }
        return null;
    }

    @Override
    public Point convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, Point.class);
        } catch (JsonProcessingException e) {
            // silence the exception
        }
        return Point.builder().build();
    }
}
