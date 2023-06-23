SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

do_install:append() {
    install -d ${D}/boot/openhd/
    touch ${D}/boot/openhd/air.txt
    install -m 0644 ${D}/boot/openhd/air.txt
}
