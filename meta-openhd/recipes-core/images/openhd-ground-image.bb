# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " \
    packagegroup-openhd-ground \
    rtl8812au \
    systemd \
    "