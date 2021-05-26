package br.com.alura.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formataParaMoedaBrasileira(): String =
    NumberFormat.getCurrencyInstance(
        Locale("pt", "br")
    ).format(this)