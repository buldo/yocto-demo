# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " \
    ffmpeg \
    packagegroup-openhd-ground \
    rtl8812au \
    systemd \
    "

IMAGE_FEATURES:append = " hwcodecs"