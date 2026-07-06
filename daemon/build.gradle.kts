plugins {
    id("application")
}

application {
    mainClass.set("io.jatinjindal.daemon.Main")
}

dependencies {
    implementation("net.java.dev.jna:jna:5.19.0")
    implementation("net.java.dev.jna:jna-platform:5.19.0")
}

