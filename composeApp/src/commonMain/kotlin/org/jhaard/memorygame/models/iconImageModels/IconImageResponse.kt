package org.jhaard.memorygame.models.iconImageModels

import kotlinx.serialization.Serializable

@Serializable
data class IconImageResponse(
    val icons: List<IconImage>?
)
