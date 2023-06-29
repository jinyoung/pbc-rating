package pbc.rating.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbc.rating.domain.*;

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
    public Rating rate(
        @PathVariable(value = "id") String id,
        @RequestBody RateCommand rateCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /rating/rate  called #####");
        Optional<Rating> optionalRating = ratingRepository.findById(id);

        optionalRating.orElseThrow(() -> new Exception("No Entity Found"));
        Rating rating = optionalRating.get();
        rating.rate(rateCommand);

        ratingRepository.save(rating);
        return rating;
    }
}
