package com.therealbluepandabear.pixapencil.activities.canvas.oncreate

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.databinding.ActivityCanvasBinding

fun CanvasActivity.setBindings() {
    binding = ActivityCanvasBinding.inflate(layoutInflater)
    setContentView(binding.root)
}