package com.therealbluepandabear.pixapencil.activities.main

fun MainActivity.extendedOnCreate() {
    initSharedPreferencesObject()
    showWelcomeScreenIfApplicable()
    setVmPolicy()
    setBindings()
    setEventListeners()
    setTitle()
    initializeRoomDatabases()
    requestPermissions()
    applyShowLargeCanvasSizeWarningValueFromPreference()
    initView()
    observePixelArtData()
}