package br.com.alura.orgs

import android.app.Application
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class OrgsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ProdutosDao()
            .adiciona(
                Produto(
                    nome = "Salada de frutas",
                    descricao = "laranja, manga, mamão e maçã",
                    valor = BigDecimal("23.49"),
                    imagem = "https://images.pexels.com/photos/1092730/pexels-photo-1092730.jpeg"
                ),
                Produto(
                    nome = "Sucos naturais 500 ml",
                    descricao = "laranja, manga, mamão e maçã.",
                    valor = BigDecimal("8.49"),
                    imagem = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
                ),
            )
    }

}