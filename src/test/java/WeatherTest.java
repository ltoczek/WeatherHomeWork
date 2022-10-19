import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class WeatherTest extends TestBase{

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    @Tag("WeatherTests")
    public void shouldGetWeatherForSpecifyCities(String city, String country, String id){
        given()
                .spec(TestBase.getRequestSpecification(id)).
        when().
                get().
        then().
                spec(TestBase.getResponceSpecification(city,country));
    }
}
