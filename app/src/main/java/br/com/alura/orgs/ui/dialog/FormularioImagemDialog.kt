package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import coil.load

class FormularioImagemDialog(private val context: Context) {

    fun mostra(urlPadrao: String = "", quandoConfirma: (url: String) -> Unit) {
        FormularioImagemBinding.inflate(LayoutInflater.from(context)).apply {

            if(urlPadrao.isBlank()) {
                formularioImagemImageview.tentaCarregarImagem(R.drawable.imagem_padrao)
            } else {
                formularioImagemImageview.tentaCarregarImagem(urlPadrao)
            }

            formularioImagemBotaoCarregar.setOnClickListener {
                val url = formularioImagemUrl.text.toString()
                formularioImagemImageview.tentaCarregarImagem(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton(
                    "confirmar"
                ) { _, _ ->
                    val url = formularioImagemUrl.text.toString()
                    quandoConfirma(url)
                }
                .setNegativeButton("cancelar") { _, _ -> }
                .show()
        }
    }

}