package com.therealbluepandabear.pixapencil.fragments.colorpicker.hex

import android.graphics.drawable.ColorDrawable
import android.os.Build
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.enums.OutputCode
import com.therealbluepandabear.pixapencil.enums.SnackbarDuration
import com.therealbluepandabear.pixapencil.extensions.copyToClipboard
import com.therealbluepandabear.pixapencil.extensions.showSnackbar
import com.therealbluepandabear.pixapencil.fragments.colorpicker.caller
import com.therealbluepandabear.pixapencil.fragments.colorpicker.colorPalette

fun HexadecimalColorPickerFragment.setOnClickListeners() {
    binding.fragmentHexadecimalColorPickerHexadecimalValueTextInputLayout.setEndIconOnClickListener {
        val code = this@setOnClickListeners.requireContext().copyToClipboard("hex_code", binding.fragmentHexadecimalColorPickerHexadecimalValueTextInputEditText.text.toString())

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            if (code == OutputCode.Success) {
                binding.fragmentHexadecimalColorPickerCoordinatorLayout.showSnackbar(
                    getString(R.string.fragmentHexadecimalColorPicker_successfully_copied_to_clipboard_in_code_str),
                    SnackbarDuration.Short
                )
            } else {
                binding.fragmentHexadecimalColorPickerCoordinatorLayout.showSnackbar(
                    getString(R.string.fragmentHexadecimalColorPicker_failed_to_copy_to_clipboard_in_code_str),
                    SnackbarDuration.Short
                )
            }
        }
    }

    binding.fragmentHexadecimalColorPickerDoneButton.setOnClickListener {
        try {
            caller.onDoneButtonPressed(
                (binding.fragmentHexadecimalColorPickerColorPreview.background as ColorDrawable).color,
                colorPalette
            )
        } catch (exception: Exception) { }
    }
}