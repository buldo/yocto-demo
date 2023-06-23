SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

inherit deploy nopackages

FILES:${PN} += "/boot/openhd"

do_deploy() {
    install -d ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/
    touch ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/air.txt
    chmod 0644 ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/openhd/air.txt
}

addtask deploy before do_build after do_install
do_deploy[dirs] += "${DEPLOYDIR}/${BOOTFILES_DIR_NAME}"

PACKAGE_ARCH = "${MACHINE_ARCH}"