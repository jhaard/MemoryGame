package org.jhaard.memorygame.display

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Orientation {

    fun getScreenOrientation(): ScreenOrientation

    fun getScreenHeight(): Int
    fun getScreenWidth(): Int
    fun getScreenSize(): ScreenSize

}