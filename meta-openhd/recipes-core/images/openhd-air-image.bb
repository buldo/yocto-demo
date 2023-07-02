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
    libcamera \
    gstreamer1.0 \
    gstreamer1.0-plugins-good \ 
    gstreamer1.0-plugins-base \ 
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-meta-base \
    "

EXTRA_IMAGE_FEATURES += " ssh-server-openssh"
