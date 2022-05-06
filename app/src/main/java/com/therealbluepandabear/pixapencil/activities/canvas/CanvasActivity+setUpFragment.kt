package com.therealbluepandabear.pixapencil.activities.canvas

import androidx.fragment.app.commit
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.fragments.outercanvas.OuterCanvasFragment

fun CanvasActivity.setUpFragment() {
    outerCanvasInstance = OuterCanvasFragment.newInstance(width, height, projectTitle)

    supportFragmentManager.commit {
        add(
            R.id.activityCanvas_outerCanvasFragmentHost,
            outerCanvasInstance)
    }
0}