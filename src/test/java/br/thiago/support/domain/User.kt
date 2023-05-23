package br.thiago.support.domain

/**
 * This class is responsible to provide the object to deserialize or serialize body to requests
 *
 * @author Thiago Maciel
 * Date: 16/12/2022 13:21
 */

data class User(
    val id: String? = null,
    val name: String? = null,
    val email: String? = null,
    val gender: String? = null,
    val status: String? = null
)
