# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " \
    kernel-modules \
    packagegroup-openhd-air \
    libcamera \
    rtl8812au \
    systemd \
    userland \
    gstreamer1.0 \
    gstreamer1.0-plugins-good \ 
    gstreamer1.0-plugins-base \ 
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-meta-base \
    "

