package com.realtomjoney.pyxlmoose.extensions

import android.app.Activity
import android.content.DialogInterface
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.realtomjoney.pyxlmoose.R

fun Activity.showDialog(
    dialogTitle: String,
    dialogMessage: String,
    dialogPositiveButtonText: String,
    dialogPositiveButtonAction: DialogInterface.OnClickListener,
    dialogNegativeButtonText: String?,
    dialogNegativeButtonAction: DialogInterface.OnClickListener?,
    view: View?) {
    MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
        .setTitle(dialogTitle.replaceFirstChar { it.titlecase() })
        .setMessage(dialogMessage.replaceFirstChar { it.titlecase() })
        .setView(view)
        .setPositiveButton(dialogPositiveButtonText.replaceFirstChar { it.titlecase() }, dialogPositiveButtonAction)
        .setNegativeButton(dialogNegativeButtonText?.replaceFirstChar { it.titlecase() }, dialogNegativeButtonAction)
        .show()
}