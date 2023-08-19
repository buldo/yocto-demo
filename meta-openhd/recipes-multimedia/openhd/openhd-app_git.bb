SUMMARY = "OpenHD"
DESCRIPTION = "OpenHD"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"
inherit systemd cmake pkgconfig

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "openhd.service"

SRC_URI = "\
    gitsm://github.com/OpenHD/OpenHD.git;protocol=https;branch=2.5-evo \
    file://openhd.service \
"
SRCREV = "af1e67c7cc605447ad35f75daffb676b8122b835"

S = "${WORKDIR}/git/OpenHD"

COMPATIBLE_MACHINE = "^rpi$"

DEPENDS = "\
    boost \
    libsodium \
    libv4l \
    libpcap \
    openhd-libcamera \ 
    gstreamer1.0 \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    " 

RDEPENDS:${PN} += "\
    gstreamer1.0 \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    openhd-libcamera \
    libpcap \
    libv4l \
    boost \
    libsodium \
    networkmanager \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Debug \
    -DBoost_INCLUDE_DIR=${STAGING_INCDIR} \
    -DCMAKE_LIBRARY_PATH=${STAGING_LIBDIR} \
    -DFETCHCONTENT_FULLY_DISCONNECTED=OFF \
"

FILES:${PN} += "${systemd_unitdir}/system/openhd.service"

EXTRA_OECMAKE:append:raspberrypi0-2w = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"
EXTRA_OECMAKE:append:raspberrypi3 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"
EXTRA_OECMAKE:append:raspberrypi4 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"

# Build does not version solibs so we need to change the suffix
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_configure[network] =  "1"
do_compile[network] = "1"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/openhd.service ${D}${systemd_system_unitdir}
}
