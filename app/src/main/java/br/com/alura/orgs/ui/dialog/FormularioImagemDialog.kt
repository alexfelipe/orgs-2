package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.FormImagemBinding
import coil.load
import com.google.android.material.textfield.TextInputEditText

class FormularioImagemDialog(
    private val context: Context
) {

    private val bindingFormImagem = FormImagemBinding
        .inflate(LayoutInflater.from(context))
    private val campoUrl = bindingFormImagem.formImagemUrl

    fun mostra(
        urlPadrao: String = "",
        cliqueSalvar: (url: String) -> Unit
    ) {
        campoUrl.setText(urlPadrao)
        configuraBotaoCarregar(campoUrl)
        AlertDialog.Builder(context)
            .setView(bindingFormImagem.root)
            .setPositiveButton("Salvar") { _, _ ->
                cliqueSalvar(campoUrl.text.toString())
            }
            .setNegativeButton("Cancelar") { _: DialogInterface, _: Int ->

            }
            .show()
    }

    private fun configuraBotaoCarregar(
        campoUrl: TextInputEditText
    ) {
        bindingFormImagem.formImagemBotaoCarregar.setOnClickListener {
            bindingFormImagem.formImagemImageview.load(campoUrl.text.toString()) {
                placeholder(R.drawable.placeholder)
                error(R.drawable.erro)
            }
        }
    }

}