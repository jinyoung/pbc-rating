package pbc.rating.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import pbc.rating.domain.*;

@Component
public class RatingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Rating>> {

    @Override
    public EntityModel<Rating> process(EntityModel<Rating> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/rate")
                .withRel("rate")
        );

        return model;
    }
}
