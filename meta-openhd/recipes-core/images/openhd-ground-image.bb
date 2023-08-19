# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " \
    qopenhd-app \
    openhd-app \
    openhd-ground-marker \
    openhd-hardware-config \
    kernel-modules \
    rtl8812au \
    "