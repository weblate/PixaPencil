package com.therealbluepandabear.pixapencil.activities.canvas.onoptionsitemselected

import android.view.Menu
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.enums.SymmetryMode
import com.therealbluepandabear.pixapencil.extensions.disable
import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.utility.constants.Flags

fun CanvasActivity.extendedOnCreateOptionsMenu(_menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.activity_canvas_top_app_menu, _menu)

    if (_menu != null) {
        menu = _menu
        menu.findItem(R.id.activityCanvasTopAppMenu_pixel_perfect_item).isChecked = pixelGridViewInstance.pixelPerfectMode
        menu.findItem(R.id.activityCanvasTopAppMenu_grid_item).isChecked = pixelGridViewInstance.gridEnabled
        menu.findItem(R.id.appMenu_symmetry_none_subItem).isChecked = true

        if (pixelGridViewInstance.canvasWidth != pixelGridViewInstance.canvasHeight) {
            menu.findItem(R.id.appMenu_symmetry_octal_subItem).isEnabled = false
        }

        if (pixelGridViewInstance.canvasWidth > 500 || pixelGridViewInstance.canvasWidth > 500) {
            menu.findItem(R.id.activityCanvasTopAppMenu_grid_item).isEnabled = false
            menu.findItem(R.id.activityCanvasTopAppMenu_grid_item).isChecked = false

            pixelGridViewInstance.gridEnabled = false
            pixelGridViewInstance.invalidate()

            Flags.DisableGridSharedPreferenceChanges = true
        }

        menu.findItem(R.id.activityCanvasTopAppMenu_undo).disable()
        menu.findItem(R.id.activityCanvasTopAppMenu_redo_item).disable()

        when (viewModel.currentSymmetryMode) {
            SymmetryMode.Horizontal -> {
                menu.findItem(R.id.appMenu_symmetry_horizontal_subItem).isChecked = true
            }

            SymmetryMode.Vertical -> {
                menu.findItem(R.id.appMenu_symmetry_vertical_subItem).isChecked = true
            }

            SymmetryMode.Quad -> {
                menu.findItem(R.id.appMenu_symmetry_quad_subItem).isChecked = true
            }

            SymmetryMode.Octal -> {
                menu.findItem(R.id.appMenu_symmetry_octal_subItem).isChecked = true
            }

            else -> {}
        }
    }

    return true
}