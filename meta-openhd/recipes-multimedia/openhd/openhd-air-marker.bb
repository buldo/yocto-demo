SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

inherit deploy nopackages

FILES:${PN} += "/boot/openhd"

do_deploy() {
    install -d ${IMAGE_ROOTFS}/boot/openhd/
    touch ${IMAGE_ROOTFS}/boot/openhd/air.txt
    chmod 0644 ${IMAGE_ROOTFS}/boot/openhd/air.txt
}

addtask deploy before do_build after do_install
do_deploy[dirs] += "${IMAGE_ROOTFS}/boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"