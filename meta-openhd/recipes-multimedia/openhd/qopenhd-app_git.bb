SUMMARY = "qOpenHD"
DESCRIPTION = "qOpenHD"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"
inherit systemd pkgconfig qmake5

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "qopenhd.service"

SRC_URI = "gitsm://github.com/OpenHD/QOpenHD.git;protocol=https;branch=2.5-evo \
           file://0001-add-platform.patch \
           file://0002-constants.patch \
           file://0003-array.patch \
           file://qopenhd.sh \
           file://qopenhd.service \
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
    qtbase \
    qtdeclarative \
    qtlocation \
    qtspeech \
    qtquickcontrols \
    qtquickcontrols-mkspecs  \
    qtquickcontrols2 \
    qtquickcontrols2-mkspecs  \
    qtgraphicaleffects-qmlplugins \
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

FILES:${PN} += " \
    /usr/local/share/qopenhd/ \
    ${systemd_unitdir}/system/openhd.service \
    /home/root/.config/ \
"
do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/release/QOpenHD ${D}${bindir}

    install -d ${D}/usr/local/share/qopenhd/
    install -m 0644 ${S}/rpi_qt_eglfs_kms_config.json ${D}/usr/local/share/qopenhd/

    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/qopenhd.sh ${D}${sysconfdir}/profile.d/

    install -d ${D}/home/root/.config/
    touch ${D}/home/root/.config/keep

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/qopenhd.service ${D}${systemd_system_unitdir}
}