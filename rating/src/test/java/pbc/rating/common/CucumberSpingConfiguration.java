package pbc.rating.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import pbc.rating.RatingApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { RatingApplication.class })
public class CucumberSpingConfiguration {}
