# Dawnlight Android
An open source android client for [Apollo](https://github.com/ClassicOldSong/Apollo)/[Sunshine](https://github.com/LizardByte/Sunshine) based on [Artemis (moonlight-noir)](https://github.com/ClassicOldSong/moonlight-android).

Dawnlight Android will allow you to stream your collection of games from your Windows PC running Apollo/Sunshine to your Android device,
whether in your own home or over the internet.

# Features
Original features can be read in the old repo [Artemis](https://github.com/ClassicOldSong/moonlight-android)
1. Quick toggle between Keys/Gamepad Overlay
2. Real Auto-orientation based on device's sensor (not done)

## Building
* Install Android Studio and the Android NDK
* Run ‘git submodule update --init --recursive’ from within dawnlight-android/
* In dawnlight-android/, create a file called ‘local.properties’. Add an ‘ndk.dir=’ property to the local.properties file and set it equal to your NDK directory.
* Build the APK using Android Studio or gradle
