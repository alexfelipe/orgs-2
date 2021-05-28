package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
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

        tentaCarregarProduto()
    }

    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(PRODUTO)?.let {
            this.produto = it
        }
        if (::produto.isInitialized) {
            preencheCampos()
        } else {
            finish()
            Toast.makeText(
                this,
                "Falha ao carregar o produto",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun preencheCampos() {
        binding.activityDetalhesProdutoNome.text = produto.nome
        binding.activityDetalhesProdutoDescricao.text = produto.descricao
        binding.activityDetalhesProdutoValor.text = produto.valor.formataParaMoedaBrasileira()
        binding.activityDetalhesProdutoImagem.load(produto.imagem) {
            placeholder(R.drawable.placeholder)
            error(R.drawable.erro)
        }
    }

}