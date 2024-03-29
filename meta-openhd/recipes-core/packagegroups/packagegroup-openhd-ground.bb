DESCRIPTION = "OpenHD ground Packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

COMPATIBLE_MACHINE = "^rpi$"

RDEPENDS:${PN} = "\
    openhd-hardware-config \
    openhd-ground-marker \
    qopenhd-app \
"

#RDEPENDS:${PN} = "\
#    openhd-hardware-config \
#    openhd-ground-marker \
#    openhd-app \
#    qopenhd-app \
#"