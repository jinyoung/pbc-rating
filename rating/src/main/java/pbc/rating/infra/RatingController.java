package pbc.rating.infra;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbc.rating.domain.*;
import rx.Completable;

@RestController
// @RequestMapping(value="/ratings")
@Transactional
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @RequestMapping(
        value = "ratings/{id}/rate",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ArrayList<Rating> rate(
        @PathVariable(value = "id") String id,
        @RequestBody RateCommand rateCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rating/rate  called #####");

        //Rating rating = null;
        final ArrayList<Rating> ratingContainer = new ArrayList<Rating>();

        ratingRepository
            .findById(id)
            .ifPresentOrElse(rating -> {
                rating.rate(rateCommand);

                ratingRepository.save(rating);
                ratingContainer.add(rating);
            
            },()->{

                Rating rating = new Rating();

                // topicId가 입력되지 않았을 경우에만 topicId를 설정
                if (rating.getTopicId() == null) {
                    rating.setTopicId(id);
                }
            
                rating.rate(rateCommand);

                ratingRepository.save(rating);

                ratingContainer.add(rating);
            });

        return ratingContainer;
    }
}
