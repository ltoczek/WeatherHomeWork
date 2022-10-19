import configuration.AppProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.is;

public class TestBase {

    private static AppProperties appProperties;

    @BeforeAll
    static void setUp() {
        appProperties = AppProperties.getInstance();
    }

    public static RequestSpecification getRequestSpecification(String id) {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("baseUri"))
                .setBasePath(System.getProperty("basePath"))
                .addParam("appid",System.getProperty("appID"))
                .addParam("id", id)
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static ResponseSpecification getResponceSpecification(String city, String country){
        return new ResponseSpecBuilder()
                .build()
                .statusCode(200)
                .body("name",is(city))
                .body("sys.country", is(country));
        }
}

