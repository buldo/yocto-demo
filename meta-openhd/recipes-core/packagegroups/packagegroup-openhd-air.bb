DESCRIPTION = "OpenHD air Packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

COMPATIBLE_MACHINE = "^rpi$"

RDEPENDS:${PN} = "\
    raspi-gpio \
    rpio \
    rpi-gpio \
    wireless-regdb-static \
    bluez5 \
    openhd-app \
    openhd-air-marker \
    userland \
    libcamera \
    gstreamer1.0 \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    networkmanager \
    openhd-hardware-config \
"