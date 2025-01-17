package com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.algorithms.LineAlgorithm
import com.therealbluepandabear.pixapencil.models.Coordinates
import com.therealbluepandabear.pixapencil.utility.BinaryPreviewStateSwitcher

var firstLineDrawn = false

fun CanvasActivity.lineToolOnPixelTapped(coordinatesTapped: Coordinates) {
    val lineAlgorithmInstance = LineAlgorithm(primaryAlgorithmInfoParameter)

    if (!lineModeHasLetGo) {
        if (!first) {
            BinaryPreviewStateSwitcher.feedState(viewModel.currentBitmapAction!!)
            BinaryPreviewStateSwitcher.switch()
        }
        BinaryPreviewStateSwitcher.feedState(viewModel.currentBitmapAction!!)
        first = false

        if (firstLineDrawn) {
            viewModel.currentBitmapAction!!.actionData.clear()
        }
    } else {
        viewModel.currentBitmapAction = null
        lineModeHasLetGo = false
        first = true
    }

    if (lineOrigin == null) {
        lineOrigin = coordinatesTapped
    } else {
        lineAlgorithmInstance.compute(lineOrigin!!, coordinatesTapped)
        firstLineDrawn = true
    }
}