do_configure:prepend:raspberrypi4() {
    cat > ${S}/mkspecs/oe-device-extra.pri <<EOF
    QMAKE_LIBS_EGL         += -lEGL
    QMAKE_LIBS_OPENGL_ES2  += -lGLESv2 -lEGL

    QMAKE_CFLAGS            += -march=armv8-a -mtune=cortex-a72 -mfpu=crypto-neon-fp-armv8
    QMAKE_CXXFLAGS          = $$QMAKE_CFLAGS

    EGLFS_DEVICE_INTEGRATION = eglfs_kms
    EOF
}