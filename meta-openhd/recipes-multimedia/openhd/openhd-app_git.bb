SUMMARY = "OpenHD"
DESCRIPTION = "OpenHD"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"

SRC_URI = "\
    gitsm://github.com/OpenHD/OpenHD.git;protocol=https;branch=2.3-evo \
"
SRCREV = "bc9ca106de846ac43f85d6dae6f40111da48aff6"

S = "${WORKDIR}/git/OpenHD"

COMPATIBLE_MACHINE = "^rpi$"

DEPENDS = "boost gstreamer1.0-omx libsodium libv4l libpcap"

inherit cmake pkgconfig

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBoost_INCLUDE_DIR=${STAGING_INCDIR} \
    -DCMAKE_LIBRARY_PATH=${STAGING_LIBDIR} \
    -DFETCHCONTENT_FULLY_DISCONNECTED=OFF \
"

EXTRA_OECMAKE:append:raspberrypi3 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"
EXTRA_OECMAKE:append:raspberrypi4 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"

# Build does not version solibs so we need to change the suffix
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_configure[network] =  "1"
do_compile[network] = "1"

do_install:append() {
    # Requires python3-core which not all systems may have
    # rm ${D}/${bindir}/camera-bug-report
}
