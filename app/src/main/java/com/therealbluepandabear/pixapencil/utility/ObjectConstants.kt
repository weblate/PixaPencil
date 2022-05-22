package com.therealbluepandabear.pixapencil.utility

import androidx.lifecycle.LifecycleOwner
import com.therealbluepandabear.pixapencil.algorithms.AlgorithmInfoParameter
import com.therealbluepandabear.pixapencil.models.PixelArt

object ObjectConstants {
    lateinit var ObjectGlobalScopeLifecycleOwner: LifecycleOwner
    lateinit var PrimaryAlgorithmInfoParameter: AlgorithmInfoParameter
    lateinit var CurrentPixelArtObj: PixelArt
}