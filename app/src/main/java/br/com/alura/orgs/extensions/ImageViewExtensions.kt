package br.com.alura.orgs.extensions

import android.widget.ImageView
import br.com.alura.orgs.R
import coil.load

fun ImageView.tentaCarregarImagem(url: String) {
    load(url) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.error)
    }
}

fun ImageView.tentaCarregarImagem(drawableIdRes: Int) {
    load(drawable) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.error)
    }
}
