SUMMARY = "MAVSDK"
DESCRIPTION = "OpenHD MAPSDK"
HOMEPAGE = "https://github.com/OpenHD/OpenHD"
SECTION = "console/utils"

# TODO: Change license
LICENSE="CLOSED"
inherit cmake pkgconfig

SRC_URI = "\
    gitsm://github.com/OpenHD/MAVSDK;protocol=https;branch=detached2 \
"
SRCREV = "40d22079275266af84e70d20c03f9fb108764464"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git"

OECMAKE_TARGET_COMPILE ?= "build/default"
EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=OFF -DCMAKE_BUILD_TYPE=Release -DBUILD_TESTS=OFF -DSUPERBUILD=OFF -H."
COMPATIBLE_MACHINE = "^rpi$"

DEPENDS = "\
    jsoncpp \
    libtinyxml2 \
    curl \
    " 

#EXTRA_OECMAKE = "\
#    -DFETCHCONTENT_FULLY_DISCONNECTED=OFF \
#    -D
#"

FILES:${PN} += "${systemd_unitdir}/system/openhd.service"

EXTRA_OECMAKE:append:raspberrypi0-2w = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"
EXTRA_OECMAKE:append:raspberrypi3 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"
EXTRA_OECMAKE:append:raspberrypi4 = " -DENABLE_COMPILE_FLAGS_FOR_TARGET=armv8-neon"

# Build does not version solibs so we need to change the suffix
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_configure[network] =  "1"
do_compile[network] = "1"