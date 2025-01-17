package com.therealbluepandabear.pixapencil.activities.canvas.onactionup

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.coordinates
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.ellipseOrigin
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.first
import com.therealbluepandabear.pixapencil.algorithms.EllipseAlgorithm
import com.therealbluepandabear.pixapencil.enums.Tool

fun CanvasActivity.ellipseToolOnActionUp() {
    if (viewModel.currentTool == Tool.EllipseTool && viewModel.currentTool.outlined == false) {
        val circleAlgorithmInstance = EllipseAlgorithm(primaryAlgorithmInfoParameter, true)

        if (ellipseOrigin != null && coordinates != null) {
            if (ellipseOrigin!!.x > coordinates!!.x) {
                circleAlgorithmInstance.compute(coordinates!!, ellipseOrigin!!)
            } else {
                circleAlgorithmInstance.compute(ellipseOrigin!!, coordinates!!)
            }
        }
    }

    viewModel.bitmapActionData.add(viewModel.currentBitmapAction!!)

    coordinates = null
    ellipseOrigin = null
    ellipseModeHasLetGo = false
    first = true
}