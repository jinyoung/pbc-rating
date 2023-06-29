package pbc.rating.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pbc.rating.domain.*;

@RepositoryRestResource(collectionResourceRel = "ratings", path = "ratings")
public interface RatingRepository
    extends PagingAndSortingRepository<Rating, String> {}
