package com.therealbluepandabear.pixapencil.activities.canvas.ontapped

import androidx.fragment.app.commit
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.*
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.cindx
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.polygonCoordinates
import com.therealbluepandabear.pixapencil.activities.canvas.tooltips.showDitherToolTip
import com.therealbluepandabear.pixapencil.activities.canvas.tooltips.showShadingToolTip
import com.therealbluepandabear.pixapencil.activities.canvas.tooltips.showSprayToolTip
import com.therealbluepandabear.pixapencil.enums.SnackbarDuration
import com.therealbluepandabear.pixapencil.enums.Tool
import com.therealbluepandabear.pixapencil.extensions.showSnackbar
import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.fragments.dithertoolsettings.DitherToolSettingsFragment
import com.therealbluepandabear.pixapencil.fragments.spraytoolsettings.SprayToolSettingsFragment
import com.therealbluepandabear.pixapencil.utility.constants.Flags
import com.therealbluepandabear.pixapencil.utility.constants.StringConstants

fun CanvasActivity.extendedOnToolTapped(toolName: String) {
    if (viewModel.currentTool == Tool.ShadingTool && toolName != StringConstants.Identifiers.ShadingToolIdentifier) {
        pixelGridViewInstance.shadingMode = false
    }

    if (viewModel.currentTool == Tool.PolygonTool && toolName != StringConstants.Identifiers.PolygonToolIdentifier) {
        Flags.DisableActionMove = false
        polygonCoordinates.clear()
        cindx = 0
    }

    val showSprayToolTip = (
                    toolName == StringConstants.Identifiers.SprayToolIdentifier &&
                            viewModel.currentTool != Tool.SprayTool &&
                            sharedPreferenceShowSprayToolTip
    )

    if (showSprayToolTip) {
        showSprayToolTip()
    }

    val showShadingToolTip = (
            toolName == StringConstants.Identifiers.ShadingToolIdentifier &&
                    viewModel.currentTool != Tool.ShadingTool &&
                    sharedPreferenceShowShadingToolTip
            )

    if (showShadingToolTip) {
        showShadingToolTip()
    }

    val showDitherToolTip = (
            toolName == StringConstants.Identifiers.DitherToolIdentifier &&
                    viewModel.currentTool != Tool.DitherTool &&
                    sharedPreferenceShowDitherToolTip
            )

    if (showDitherToolTip) {
        showDitherToolTip()
    }

    if (toolName == StringConstants.Identifiers.SprayToolIdentifier && viewModel.currentTool == Tool.SprayTool) {
        if (viewModel.currentTool == Tool.SprayTool) {
            supportFragmentManager.commit {
                replace(R.id.activityCanvas_primaryFragmentHost, SprayToolSettingsFragment.newInstance(sharedPreferenceObject))
                addToBackStack(null)
            }
        }
    }

    if (toolName == StringConstants.Identifiers.DitherToolIdentifier && viewModel.currentTool == Tool.DitherTool) {
        if (viewModel.currentTool == Tool.DitherTool) {
            supportFragmentManager.commit {
                replace(R.id.activityCanvas_primaryFragmentHost, DitherToolSettingsFragment.newInstance())
                addToBackStack(null)
            }
        }
    }

    if (toolName == StringConstants.Identifiers.ShadingToolIdentifier && viewModel.currentTool == Tool.ShadingTool) {
        val snackbarText: String = if (shadingToolMode == StringConstants.ShadingToolModes.LightenShadingToolMode) {
            getString(R.string.generic_darken_mode_tooltip_in_code_str).also {
                shadingToolMode = StringConstants.ShadingToolModes.DarkenShadingToolMode
            }
        } else {
            getString(R.string.generic_lighten_mode_tooltip_in_code_str).also {
                shadingToolMode = StringConstants.ShadingToolModes.LightenShadingToolMode
            }
        }

        binding.clayout?.showSnackbar(snackbarText, SnackbarDuration.Short)
    }

    if (toolName == StringConstants.Identifiers.PolygonToolIdentifier && viewModel.currentTool == Tool.PolygonTool) {
        viewModel.currentBitmapAction = null

        polygonCoordinates.clear()
        cindx = 0
    }

    if (toolName == StringConstants.Identifiers.MoveToolIdentifier) {
        outerCanvasInstance.setOnTouchListener()
    } else {
        outerCanvasInstance.removeOnTouchListener()
    }

    viewModel.currentTool = Tool.values().firstOrNull {
        it.toolName == toolName
    } ?: Tool.defaultTool
}