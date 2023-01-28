package com.example.flowtestapp.app.model.settings

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesAppSettings @Inject constructor(
    @ApplicationContext appContext: Context
) : AppSettings {

    private val sharedPreferences =
        appContext.getSharedPreferences("settings", Context.MODE_PRIVATE)

    override fun setCurrentNumber(number: Int) {
        sharedPreferences.edit()
            .putInt(PREF_CURRENT_NUMBER, number)
            .apply()
    }

    override fun getCurrentNumber(): Int =
        sharedPreferences.getInt(PREF_CURRENT_NUMBER, -1)

    companion object {
        private const val PREF_CURRENT_NUMBER = "CURRENT_NUMBER"
    }
}