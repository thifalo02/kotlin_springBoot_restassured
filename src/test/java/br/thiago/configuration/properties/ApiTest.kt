package br.thiago.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * This class is responsible to provide the application configuration
 *
 * @author Thiago Maciel
 * Date: 16/12/2022 13:21
 */
@Configuration
@ConfigurationProperties(prefix = "application")
open class ApiTest {
    var urlBase: String? = null
}
