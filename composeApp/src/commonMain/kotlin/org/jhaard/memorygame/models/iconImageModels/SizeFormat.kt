package org.jhaard.memorygame.models.iconImageModels

import kotlinx.serialization.Serializable

@Serializable
data class SizeFormat(
    val size: Int?,
    val formats: List<ImagePreview>?
)
