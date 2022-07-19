package com.therealbluepandabear.pixapencil.listeners

import android.view.View
import com.therealbluepandabear.pixapencil.models.ColorPalette

interface ColorPaletteColorPickerListener {
    fun onColorTapped(colorTapped: Int)
    fun onColorLongTapped(colorPalette: ColorPalette, colorIndex: Int)
    fun onColorAdded(colorPalette: ColorPalette)
}