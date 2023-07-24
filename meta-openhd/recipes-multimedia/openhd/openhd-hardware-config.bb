SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

SRC_URI = "\
    file://hardware.config;unpack=0 \
"

FILES:${PN} += "/boot/openhd/hardware.config"

do_install() {
    install -m 0755 -d ${D}/boot/openhd
    install -m 0755 ${WORKDIR}/hardware.config ${D}/boot/openhd/hardware.config
}

addtask deploy after do_install