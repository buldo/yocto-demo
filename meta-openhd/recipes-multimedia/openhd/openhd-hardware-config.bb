SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

SRC_URI = "\
    file://air.txt;unpack=0 \
"

FILES:${PN} += "/boot/openhd/air.txt"

do_install() {
    install -m 0755 -d ${D}/boot/openhd
    install -m 0755 ${WORKDIR}/air.txt ${D}/boot/openhd/air.txt
}

addtask deploy after do_install