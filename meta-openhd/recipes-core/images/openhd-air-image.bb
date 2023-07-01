# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " packagegroup-openhd-air rtl8812au systemd userland libcamera"
EXTRA_IMAGE_FEATURES += " ssh-server-openssh"

# RPI_SDIMG_EXTRA_DEPENDS += " \
#     openhd-air-marker:do_deploy \
# "
RDEPENDS:${PN} = "\
    libcamera \
"