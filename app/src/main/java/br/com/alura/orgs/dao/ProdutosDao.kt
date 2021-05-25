package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutosDao {

    fun adiciona(vararg produtos: Produto){
        Companion.produtos.addAll(produtos)
    }

    fun buscaTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}