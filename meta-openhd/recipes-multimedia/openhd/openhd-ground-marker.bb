SUMMARY = "OpenHD-ground"
DESCRIPTION = "OpenHD-ground"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

SRC_URI = "\
    file://ground.txt;unpack=0 \
"

FILES:${PN} += "/boot/openhd/ground.txt"

do_install() {
    install -m 0755 -d ${D}/boot/openhd
    install -m 0755 ${WORKDIR}/ground.txt ${D}/boot/openhd/ground.txt
}

addtask deploy after do_install