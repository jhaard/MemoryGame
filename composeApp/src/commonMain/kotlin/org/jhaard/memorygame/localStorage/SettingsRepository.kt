package org.jhaard.memorygame.localStorage

import com.russhwolf.settings.Settings
import kotlinx.serialization.json.Json


/**
 * Local storage for icons. Currently made as easy as possible. And implemented to limit requests
 * in the future.
 *
 * @param settings The default Settings instance.
 */
class SettingsRepository(private val settings: Settings) {
    private val json = Json

    /**
     * Save url list locally.
     * @param icons The icon list.
     */
    fun saveUrlList(key: String, icons: List<String?>) {
        val jsonString = json.encodeToString(icons)
        settings.putString(key, jsonString)
    }

    /**
     * Save url list locally.
     * @return List of icons.
     */
    fun getUrlList(key: String): List<String> {
        val jsonString = settings.getStringOrNull(key) ?: return emptyList()
        return json.decodeFromString(jsonString)
    }

    /**
     * Delete icon list from local storage.
     */
    fun clear(key: String) {
        settings.remove(key)
    }
}