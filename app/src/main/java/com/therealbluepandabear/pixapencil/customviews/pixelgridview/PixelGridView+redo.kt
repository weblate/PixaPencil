package com.therealbluepandabear.pixapencil.customviews.pixelgridview

import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.menu
import com.therealbluepandabear.pixapencil.activities.canvas.outerCanvasInstance
import com.therealbluepandabear.pixapencil.extensions.enable

fun PixelGridView.extendedRedo() {
    /**
     * Added extra check here just to be safe that we're not operating on an empty data set.
     */

    if (undoStack.size > 0) {
        menu.findItem(R.id.appMenu_undo).enable()

        for (obj in undoStack.last().actionData.distinctBy { it.coordinates }) {
            pixelGridViewBitmap.setPixel(obj.coordinates.x, obj.coordinates.y, obj.colorSet)
        }

        invalidate()

        outerCanvasInstance.canvasFragment.myCanvasViewInstance.bitmapActionData.add(undoStack.last())
        undoStack.removeLast()

        caller.onRedoActionCompleted(undoStack)
    }
}