SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

inherit deploy nopackages

FILES:${PN} += "/boot/openhd"

do_install:append() {
    install -d ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/
    touch ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/air.txt
    chmod 0644 ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/air.txt
}

do_deploy[dirs] += "${DEPLOYDIR}/${BOOTFILES_DIR_NAME}"