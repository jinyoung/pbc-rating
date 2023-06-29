package pbc.rating.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import pbc.rating.RatingApplication;

@Entity
@Table(name = "Rating_table")
@Data
public class Rating {

    public Rating(){
        sumOfRatings = 0L;
        countOfRatings = 0L;
        averageRate = 0;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String topicId;

    private Integer averageRate;

    private Long sumOfRatings;

    private Long countOfRatings;

    @PostPersist
    public void onPostPersist() {}

    public static RatingRepository repository() {
        RatingRepository ratingRepository = RatingApplication.applicationContext.getBean(
            RatingRepository.class
        );
        return ratingRepository;
    }

    public void rate(RateCommand rateCommand) {
        //implement business logic here:  create new Rating if there’s no topicId or load the existing entity with the topicId. and add the rate to the sumOfRatings and calculate the avarageRate
        this.sumOfRatings += rateCommand.getRate();
        this.countOfRatings += 1;
        this.averageRate = (int) (this.sumOfRatings / this.countOfRatings);
        // publish a RatingRated event
        RatingRated ratingRated = new RatingRated(this);
        ratingRated.publishAfterCommit();
    }
}
