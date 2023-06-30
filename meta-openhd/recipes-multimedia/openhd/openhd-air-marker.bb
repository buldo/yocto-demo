SUMMARY = "OpenHD-air"
DESCRIPTION = "OpenHD-air"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

SRC_URI = "\
    file://air.txt \
"

FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"

do_deploy() {
    install -d ${IMAGE_ROOTFS}/boot/openhd/
    install -m 07755 ${WORKDIR}/air.txt ${IMAGE_ROOTFS}/boot/openhd/air.txt
}

addtask deploy after do_install