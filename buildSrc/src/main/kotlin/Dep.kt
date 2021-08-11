object Version {

    const val v_kotlin = "1.5.10"
    const val v_gradle = "4.2.2"
    const val v_core_ktx = "1.5.0"
    const val v_appcompat = "1.3.0"
    const val v_constraintLayout = "2.0.4"
    const val v_material = "1.2.1"
    const val v_retrofit = "2.9.0"
    const val v_liveData = "2.2.0"
    const val v_extensions = "2.2.0"
    const val v_coroutines = "1.5.1"
    const val v_coil = "1.3.1"
    const val v_hilt = "2.28-alpha"
    const val v_navigation = "2.3.5"
    const val v_qiniu = "8.3.+"
}

object SystemLibs {
    const val dataBinding = "com.android.databinding:compiler:${Version.v_gradle}"
    const val material = "com.google.android.material:material:${Version.v_material}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.v_hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.v_hilt}"
}

object Kotlin {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.v_kotlin}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.v_coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.v_coroutines}"

}

object AndroidX {
    const val core_ktx = "androidx.core:core-ktx:${Version.v_core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.v_appcompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.v_constraintLayout}"
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.v_liveData}"
    const val extensions = "androidx.lifecycle:lifecycle-extensions:${Version.v_extensions}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.v_navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Version.v_navigation}"

}

object PartyLibs {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.v_retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.v_retrofit}"
    const val coil = "io.coil-kt:coil:${Version.v_coil}"
    const val qiniu = "com.qiniu:qiniu-android-sdk:${Version.v_qiniu}"
}


