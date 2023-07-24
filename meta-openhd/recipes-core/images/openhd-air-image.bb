# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " \
        kernel-modules \
        xkeyboard-config \
"

IMAGE_INSTALL:append = " \
    packagegroup-openhd-air \
    rtl8812au \
    systemd \
    userland \
    openhd-libcamera \
    gstreamer1.0 \
    gstreamer1.0-plugins-good \ 
    gstreamer1.0-plugins-base \ 
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-meta-base \
    v4l-utils \
    valgrind \
    libcamera-apps \
    openhd-hardware-config \
    "
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
DEBUG_BUILD = "1"

EXTRA_IMAGE_FEATURES = " debug-tweaks tools-debug dbg-pkgs"