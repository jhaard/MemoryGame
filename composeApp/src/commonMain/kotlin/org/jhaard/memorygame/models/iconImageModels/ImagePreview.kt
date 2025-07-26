package org.jhaard.memorygame.models.iconImageModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagePreview(
    val format: String?,
    @SerialName("preview_url") val previewUrl: String?
)
