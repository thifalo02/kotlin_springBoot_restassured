package br.thiago.support.utils

import org.springframework.stereotype.Component

/**
 * This class is responsible to provide utilities to the project
 *
 * @author Thiago Maciel
 * Date: 16/12/2022 13:21
 */
@Component
class Utils {
    // Method to generate mock email
    fun generateMockEmail(): String {
        val timestamp = System.currentTimeMillis()
        val EMAIL_PREFIX = "th-"
        val EMAIL_SUFFIX_MOCK = "@test.com"
        return EMAIL_PREFIX + timestamp + EMAIL_SUFFIX_MOCK
    }

    // Method to generate random size
    private fun randomSize(n: Int): Int {
        return (Math.random() * n).toInt()
    }

    // Method to generate a CPF
    private fun generateCPF(): String {
        var base = System.currentTimeMillis().toString()
        base = base.substring(base.length - 9)
        var d1 = 0
        var d2 = 0
        val digit1: Int
        val digit2: Int
        var mod = 0
        val digits = base.toCharArray()
        for (i in digits.indices) {
            val idDigit = digits[i].code - 48
            d1 += (11 - (i + 1)) * idDigit
            d2 += (12 - (i + 1)) * idDigit
        }
        mod = d1 % 11
        digit1 = if (mod < 2) 0 else 11 - mod
        d2 += 2 * digit1
        mod = d2 % 11
        digit2 = if (mod < 2) 0 else 11 - mod
        return base + digit1 + digit2
    }
}
