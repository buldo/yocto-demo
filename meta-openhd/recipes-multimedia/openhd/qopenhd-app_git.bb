SUMMARY = "qOpenHD"
DESCRIPTION = "qOpenHD"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"
inherit systemd cmake pkgconfig

SRC_URI = "\
    gitsm://github.com/OpenHD/QOpenHD.git;protocol=https;branch=2.5-evo \
"
SRCREV = "39f9e1bcc74adb79d37be2b8eefb92e57d510a02"
S = "${WORKDIR}/git"

DEPENDS = "\
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    " 

RDEPENDS:${PN} += "\
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
"

COMPATIBLE_MACHINE = "^rpi$"

DEPENDS = "\
    qtbase \
    " 

inherit qmake5

