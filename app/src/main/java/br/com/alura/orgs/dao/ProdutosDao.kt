package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutosDao {

    fun adiciona(produto: Produto){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf(Produto(
            nome = "Cesta de frutas",
            "Laranja, Manga e Maçã",
            BigDecimal(12.99)
        ))
    }

}