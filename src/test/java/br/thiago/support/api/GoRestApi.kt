package br.thiago.support.api

import br.thiago.configuration.properties.ApiTest
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.Response
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.logging.Logger

/**
 * This class is responsible to provide the API requests to the test
 *
 * @author Thiago Maciel
 * Date: 16/12/2022 13:21
 */
@Component
class GoRestApi {
    private val USERS_PATH = "/public/v2/users"
    private val log: Logger = Logger.getLogger(Test::class.java.name)

    @Autowired
    var properties: ApiTest? = null
    val allUsers: Response
        get() {
            log.warning("URL Base " + (properties?.urlBase ?: "Url Null"))
            val request = RestAssured.given().filter(AllureRestAssured())
                .contentType(ContentType.JSON)
                .baseUri(properties?.urlBase ?: "")
            val response = request[USERS_PATH]
            response.then().statusCode(HttpStatus.SC_OK)
            log.warning("Request has been finished.")
            return response
        }
}
