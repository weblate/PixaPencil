package com.therealbluepandabear.pixapencil.activities.canvas

import android.graphics.Bitmap
import android.view.MenuItem
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.extensions.navigateTo
import com.therealbluepandabear.pixapencil.fragments.newcolorpalette.NewColorPaletteFragment
import com.therealbluepandabear.pixapencil.utility.IntConstants
import com.therealbluepandabear.pixapencil.utility.StringConstants

const val zoomIncrement = 0.2f

fun CanvasActivity.extendedOnOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {
        R.id.appMenu_zoom_out_item -> {
            zoomOut()
        }
        R.id.appMenu_zoom_in_item -> {
            zoomIn()
        }
        R.id.appMenu_save_project_item -> {
            extendedSaveProject()
        }

        R.id.appMenu_undo -> {
            extendedUndo()
        }

        R.id.appMenu_redo_item -> {
            extendedRedo()
        }

        R.id.appMenu_new_color_palette_item -> {
            newColorPaletteFragmentInstance = NewColorPaletteFragment.newInstance()
            currentFragmentInstance = newColorPaletteFragmentInstance
            navigateTo(supportFragmentManager, newColorPaletteFragmentInstance, R.id.activityCanvas_primaryFragmentHost, StringConstants.FragmentNewColorPaletteTitle, binding.activityCanvasPrimaryFragmentHost, binding.activityCanvasRootLayout)
            hideMenuItems()
        }

        R.id.appMenu_pixel_perfect_item -> {
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelPerfectMode = !outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelPerfectMode

            menu.findItem(R.id.appMenu_pixel_perfect_item).isChecked = outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelPerfectMode

            with (sharedPreferenceObject.edit()) {
                putBoolean(StringConstants.SharedPreferencePixelPerfectIdentifier, outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelPerfectMode)
                apply()
            }
        }

        R.id.appMenu_export_to_png_item -> {
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.saveAsImage(Bitmap.CompressFormat.PNG)
        }

        R.id.appMenu_export_to_jpg_item -> {
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.saveAsImage(Bitmap.CompressFormat.JPEG)
        }

        R.id.appMenu_rotate_90_degrees_clockwise_subItem -> {
            outerCanvasInstance.rotate()
        }

        R.id.appMenu_rotate_180_degrees_clockwise_subItem -> {
            outerCanvasInstance.rotate(IntConstants.DegreesOneEighty)
        }

        R.id.appMenu_rotate_90_degrees_anti_clockwise_subItem -> {
            outerCanvasInstance.rotate(IntConstants.DegreesNinety, animate = true, clockwise = false)
        }

        R.id.appMenu_reset_zoom_subItem -> {
            resetZoom()
        }
    }
    return true
}