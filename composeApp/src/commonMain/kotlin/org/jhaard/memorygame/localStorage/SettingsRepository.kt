package org.jhaard.memorygame.localStorage

import com.russhwolf.settings.Settings
import kotlinx.serialization.json.Json

class SettingsRepository(
    private val settings: Settings = Settings()
) {
    private val json = Json

    fun saveUrlList(icons: List<String?>) {
        val jsonString = json.encodeToString(icons)
        settings.putString("icon_list", jsonString)
    }

    fun getUrlList(): List<String> {
        val jsonString = settings.getStringOrNull("icon_list") ?: return emptyList()
        return json.decodeFromString(jsonString)
    }

    fun clear() {
        settings.remove("icon_list")
    }
}