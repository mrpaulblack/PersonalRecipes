package com.github.mrpaulblack.personalrecipes.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ILocaleStorage {
    fun setData(key: String, value: String)
    fun getData(key: String): Flow<String?>
}

class LocaleStorage(private val context: Context): ILocaleStorage {
    companion object {
        private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("tools")
    }

    override fun setData(keyString: String, valueString: String) {
        val key = stringPreferencesKey(keyString)
        context.dataStoree.edit { preferences ->
            preferences[key] = valueString
        }
    }

    override fun getData(keyString: String): Flow<String?> {
        val key = stringPreferencesKey(keyString)
        val valueFlow: Flow<String?> = context.dataStoree.data
            .map { preferences ->
                preferences[key] ?: "FirstLast@gmail.com"
            }
        return valueFlow
    }
}