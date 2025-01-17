package com.therealbluepandabear.pixapencil.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.therealbluepandabear.pixapencil.utility.compat.DateTimeCompat

@Entity
data class PixelArt(
    @ColumnInfo(name = "item_cover_bitmap_file_path") var coverBitmapFilePath: String,
    @ColumnInfo(name = "item_bitmap") var bitmap: String,
    @ColumnInfo(name = "item_width") var width: Int,
    @ColumnInfo(name = "item_height") var height: Int,
    @ColumnInfo(name = "item_dimen_cw") var dimenCW: Int,
    @ColumnInfo(name = "item_dimen_ch") var dimenCH: Int,
    @ColumnInfo(name = "item_rotation") var rotation: Float,
    @ColumnInfo(name = "item_title") var title: String,
    @ColumnInfo(name = "item_starred") var starred: Boolean,
    @ColumnInfo(name = "item_date_created") var dateCreated: String = DateTimeCompat.getCompatibleCurrentDateTime()) {
    @PrimaryKey(autoGenerate = true) var objId = 0
}