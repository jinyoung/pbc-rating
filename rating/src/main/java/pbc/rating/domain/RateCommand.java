package pbc.rating.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class RateCommand {

    private String topicId;
    private Integer rate;
}
