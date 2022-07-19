package com.therealbluepandabear.pixapencil.activities.canvas.oncreate

import android.content.res.Configuration
import androidx.core.view.OneShotPreDrawListener
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.converters.BitmapConverter
import com.therealbluepandabear.pixapencil.database.AppData
import com.therealbluepandabear.pixapencil.utility.compat.PaintCompat

fun CanvasActivity.calcCrucialViewDimensions() {
    /** We are using a OneShotPreDrawListener to ensure that the view is
     * laid out properly and that all of the dimensions have been calculated.
     * This helps avoid any NullPointerExceptions or simply invalid measurements **/

    // To avoid duplication throughout each 'when' block
    OneShotPreDrawListener.add(binding.activityCanvasTransparentBackgroundView) {
        binding.activityCanvasTransparentBackgroundView.setBitmapWidth(width)
        binding.activityCanvasTransparentBackgroundView.setBitmapHeight(height)
    }

    OneShotPreDrawListener.add(binding.activityCanvasPixelGridView) {
        binding.activityCanvasPixelGridView.setBitmapWidth(width)
        binding.activityCanvasPixelGridView.setBitmapHeight(height)
    }

    val orientationPortrait = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT ||
                              resources.configuration.orientation == Configuration.ORIENTATION_UNDEFINED
    val orientationLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (index != -1) {
        binding.activityCanvasPixelGridView.setExistingBitmap(BitmapConverter.convertStringToBitmap(AppData.pixelArtDB.dao().getAllNoLiveData()[index].bitmap)!!)
    }

    OneShotPreDrawListener.add(binding.activityCanvasDistanceContainer) {
        when {
            width == height && binding.activityCanvasDistanceContainer.height <= binding.activityCanvasDistanceContainer.width && orientationPortrait -> {
                // This inset is here to ensure that the drop shadow of the card layout is still visible
                val inset = 0.95
                val widthHeight = (binding.activityCanvasDistanceContainer.measuredHeight * inset).toInt()

                binding.activityCanvasTransparentBackgroundView.setViewWidth(widthHeight)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(widthHeight)

                binding.activityCanvasPixelGridView.setViewWidth(widthHeight)
                binding.activityCanvasPixelGridView.setViewHeight(widthHeight)
            }

            width == height && binding.activityCanvasDistanceContainer.height > binding.activityCanvasDistanceContainer.width && orientationPortrait -> {
                // An inset is not needed here since there is no overlap of any type
                val widthHeight = binding.activityCanvasDistanceContainer.measuredWidth

                binding.activityCanvasTransparentBackgroundView.setViewWidth(widthHeight)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(widthHeight)

                binding.activityCanvasPixelGridView.setViewWidth(widthHeight)
                binding.activityCanvasPixelGridView.setViewHeight(widthHeight)
            }

            width > height && orientationPortrait -> {
                val ratio = height.toDouble() / width.toDouble()

                var width = binding.activityCanvasDistanceContainer.width
                var height = (width * ratio).toInt()

                // We have this 'if' statement to ensure that there is no overlap
                if (height >= binding.activityCanvasDistanceContainer.measuredHeight) {
                    val inset = 0.95

                    width = (binding.activityCanvasDistanceContainer.measuredHeight * inset).toInt()
                    height = ((binding.activityCanvasDistanceContainer.measuredHeight * inset) * ratio).toInt()
                }

                binding.activityCanvasTransparentBackgroundView.setViewWidth(width)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(height)

                binding.activityCanvasPixelGridView.setViewWidth(width)
                binding.activityCanvasPixelGridView.setViewHeight(height)
            }

            width < height && orientationPortrait -> {
                val inset = 0.95
                val ratio = width.toDouble() / height.toDouble()

                val height = (binding.activityCanvasDistanceContainer.height * inset).toInt()
                val width = ((height * ratio) * inset).toInt()

                // We do not need to check for overlaps in this scenario

                binding.activityCanvasTransparentBackgroundView.setViewWidth(width)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(height)

                binding.activityCanvasPixelGridView.setViewWidth(width)
                binding.activityCanvasPixelGridView.setViewHeight(height)
            }

            width == height && orientationLandscape -> {
                binding.activityCanvasTransparentBackgroundView.setViewWidth(binding.root.measuredHeight)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(binding.root.measuredHeight)

                binding.activityCanvasPixelGridView.setViewWidth(binding.root.measuredHeight)
                binding.activityCanvasPixelGridView.setViewHeight(binding.root.measuredHeight)
            }

            width < height && orientationLandscape -> {
                val ratio = width.toDouble() / height.toDouble()

                val height = binding.activityCanvasDistanceContainer.height
                val width = (height * ratio).toInt()

                binding.activityCanvasTransparentBackgroundView.setViewWidth(width)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(height)

                binding.activityCanvasPixelGridView.setViewWidth(width)
                binding.activityCanvasPixelGridView.setViewHeight(height)
            }

            width > height && orientationLandscape -> {
                val ratio = height.toDouble() / width.toDouble()

                val inset = 0.95

                val width = (binding.activityCanvasDistanceContainer.width * inset).toInt()
                val height = ((width * ratio) * inset).toInt()

                binding.activityCanvasTransparentBackgroundView.setViewWidth(width)
                binding.activityCanvasTransparentBackgroundView.setViewHeight(height)

                binding.activityCanvasPixelGridView.setViewWidth(width)
                binding.activityCanvasPixelGridView.setViewHeight(height)
            }
        }
    }
}