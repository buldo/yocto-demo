SUMMARY = "qOpenHD"
DESCRIPTION = "qOpenHD"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"
inherit pkgconfig qmake5

SRC_URI = "gitsm://github.com/OpenHD/QOpenHD.git;protocol=https;branch=2.5-evo \
           file://0001-add-platform.patch \
           file://0002-constants.patch \
           file://0003-array.patch \
           "
SRCREV = "168c86495a8017397869d22db9980103ec81d2dc"
S = "${WORKDIR}/git"

DEPENDS = "\
    coreutils-native \
    userland \
    jsoncpp \
    libtinyxml2 \
    openhd-mavsdk \
    qtbase \
    qtdeclarative \
    qtdeclarative-native \
    qtlocation \
    qtspeech \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-omx \
    gstreamer1.0-meta-base \
    " 

RDEPENDS:${PN} += "\
    userland \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-omx \
    gstreamer1.0-meta-base \
"

COMPATIBLE_MACHINE = "^rpi$"

do_install:append() {
#    install -d ${D}${systemd_system_unitdir}
#    install -m 0644 ${WORKDIR}/openhd.service ${D}${systemd_system_unitdir}
    install -d ${D}${bindir}
    install -m 0755 ${B}/release/QOpenHD ${D}${bindir}
}