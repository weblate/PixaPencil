package com.therealbluepandabear.pixapencil.activities.canvas

import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.extensions.disable
import com.therealbluepandabear.pixapencil.extensions.enable

fun CanvasActivity.judgeUndoRedoStacks() {
    if (viewModel.bitmapActionData.isNotEmpty()) {
        menu.findItem(R.id.activityCanvasTopAppMenu_undo).enable()
    } else {
        menu.findItem(R.id.activityCanvasTopAppMenu_undo).disable()
    }

    if (viewModel.undoStack.isEmpty()) {
        menu.findItem(R.id.activityCanvasTopAppMenu_redo_item).disable()
    } else {
        menu.findItem(R.id.activityCanvasTopAppMenu_redo_item).enable()
    }
}