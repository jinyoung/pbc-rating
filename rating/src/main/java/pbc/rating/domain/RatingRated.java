package pbc.rating.domain;

import java.util.*;
import lombok.*;
import pbc.rating.domain.*;
import pbc.rating.infra.AbstractEvent;

@Data
@ToString
public class RatingRated extends AbstractEvent {

    private String topicId;
    private Integer averageRate;
    private Long sumOfRatings;
    private Long countOfRatings;

    public RatingRated(Rating aggregate) {
        super(aggregate);
    }

    public RatingRated() {
        super();
    }
}
