package com.therealbluepandabear.pixapencil.activities.canvas

import android.content.Intent
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.onoptionsitemselected.onSaveProjectOptionsItemSelected
import com.therealbluepandabear.pixapencil.activities.main.MainActivity
import com.therealbluepandabear.pixapencil.extensions.showDialogWithNeutralButton

fun CanvasActivity.extendedOnBackPressed() {
    if (supportFragmentManager.backStackEntryCount > 0) {
        supportFragmentManager.popBackStackImmediate()

        binding.root.post {
            judgeUndoRedoStacks()
        }
    } else if (!saved) {
        showDialogWithNeutralButton(
            getString(R.string.dialog_unsaved_changes_title_in_code_str),
            getString(R.string.dialog_unsaved_changes_message_in_code_str, projectTitle),
            getString(R.string.generic_cancel_in_code_str),
            { _, _ -> },
            getString(R.string.dialog_unsaved_changes_negative_button_text_in_code_str),
            { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            },
            getString(R.string.activityCanvasTopAppMenu_save_text_str),
            { _, _ ->
                onSaveProjectOptionsItemSelected()
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            })
    } else {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}