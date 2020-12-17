package com.geethu.employeesearch.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * To show snack bar.
 */
fun View.showSnackBar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}

/**
 * To add a delay.
 */
fun withDelay(delay: Long, block: () -> Unit) {
    Handler().postDelayed(Runnable(block), delay)
}

/**
 * To draw an icon on canvas.
 */
fun Canvas.drawIcon(iconBitmap: Bitmap, destRectF: RectF) {
    this.drawBitmap(iconBitmap, null, destRectF, null)
}

/**
 * To open an activity using intent.
 */
fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}
