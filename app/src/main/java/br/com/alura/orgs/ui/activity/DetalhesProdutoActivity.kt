package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.orgs.databinding.ActivityDetalhesProdutoBinding
import br.com.alura.orgs.extensions.formataParaMoedaBrasileira
import br.com.alura.orgs.model.Produto
import coil.load

class DetalhesProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater)
    }
    private lateinit var produto: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent.getParcelableExtra<Produto>("produto")?.let {
            this.produto = it
        }

        if (::produto.isInitialized) {
            binding.activityDetalhesProdutoNome.text = produto.nome
            binding.activityDetalhesProdutoDescricao.text = produto.descricao
            binding.activityDetalhesProdutoValor.text = produto.valor.formataParaMoedaBrasileira()
            binding.activityDetalhesProdutoImagem.load("https://picsum.photos/300/300")
        }
    }

}