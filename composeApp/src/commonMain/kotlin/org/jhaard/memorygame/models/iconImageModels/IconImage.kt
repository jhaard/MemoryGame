package org.jhaard.memorygame.models.iconImageModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IconImage(
    @SerialName("icon_id") val iconId: Int?,
    @SerialName("raster_sizes") val rasterSizes: List<SizeFormat>?
)
