package br.thiago.stepDefinitions

import br.thiago.support.api.GoRestApi
import br.thiago.support.domain.User
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Então
import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

/**
 * This class is responsible to provide the relation between cucumber and test steps
 *
 * @author Thiago Maciel
 * Date: 16/12/2022 13:21
 */
class Test {
    var users: List<User> = ArrayList()

    @Autowired
    var goRestApi: GoRestApi? = null

    @get:Dado("que o usuário realiza uma requisição")
    val allUsers: Unit
        get() {
            val response = goRestApi!!.allUsers
            users = listOf(
                *response.body.`as`(
                    Array<User>::class.java
                )
            )
        }

    @Então("o resultado esperado deverá estar correto")
    fun validateRequestResult() {
        Assert.assertTrue(users.isNotEmpty())
    }
}
