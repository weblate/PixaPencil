package com.therealbluepandabear.pixapencil.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.converters.JsonConverter
import com.therealbluepandabear.pixapencil.dao.ColorPalettesDao
import com.therealbluepandabear.pixapencil.models.ColorPalette
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(entities = [ColorPalette::class], version = 3)
abstract class ColorPalettesDatabase: RoomDatabase() {
    abstract fun colorPalettesDao(): ColorPalettesDao
    companion object {
        private var instance: ColorPalettesDatabase? = null
        fun getDatabase(context: Context): ColorPalettesDatabase {
            if (instance == null) {
                synchronized(ColorPalettesDatabase::class) {
                    if (instance == null) instance = Room.databaseBuilder(context.applicationContext, ColorPalettesDatabase::class.java, AppData.colorPalettesDBFileName).fallbackToDestructiveMigration().addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Executors.newSingleThreadExecutor().execute {
                                CoroutineScope(Dispatchers.IO).launch {
                                    instance?.colorPalettesDao()?.insertColorPalette(ColorPalette(context.getString(R.string.defaultColorPalette_str), JsonConverter.convertListToJsonString(ColorDatabase.toList()), true))
                                }
                            }
                        }
                    }).allowMainThreadQueries().build()
                }
            }
            return instance!!
        }
    }
}