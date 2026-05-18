# Don't obfuscate code
-dontobfuscate

# Our code
-keep class com.dawnlight.binding.input.evdev.* {*;}

# KeyMapper - keep all VK_* fields for reflection
-keep class com.dawnlight.utils.KeyMapper {*;}

# KeyConfigHelper - keep classes and fields for Gson
-keep class com.dawnlight.utils.KeyConfigHelper {*;}
-keep class com.dawnlight.utils.KeyConfigHelper$ShortcutFile {*;}
-keep class com.dawnlight.utils.KeyConfigHelper$Shortcut {*;}

# Profiles
-keep class com.dawnlight.profiles.ProfilesManager$ProfilesData {*;}
-keep class com.dawnlight.profiles.SettingsProfile {*;}

# Moonlight common
-keep class com.dawnlight.nvstream.jni.* {*;}

# Okio
-keep class sun.misc.Unsafe {*;}
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

# BouncyCastle
-keep class org.bouncycastle.jcajce.provider.asymmetric.* {*;}
-keep class org.bouncycastle.jcajce.provider.asymmetric.util.* {*;}
-keep class org.bouncycastle.jcajce.provider.asymmetric.rsa.* {*;}
-keep class org.bouncycastle.jcajce.provider.digest.** {*;}
-keep class org.bouncycastle.jcajce.provider.symmetric.** {*;}
-keep class org.bouncycastle.jcajce.spec.* {*;}
-keep class org.bouncycastle.jce.** {*;}
-dontwarn javax.naming.**

# jMDNS
-dontwarn javax.jmdns.impl.DNSCache
-dontwarn org.slf4j.**
