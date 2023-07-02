SUMMARY = "Linux libcamera framework for openhd"
SECTION = "libs"

LICENSE="CLOSED"

SRC_URI = " \
        git://github.com/raspberrypi/libcamera.git;protocol=https;branch=main \
"

SRCREV = "06bbff9c23d5a85acd65595216c6b75094891f72"

PE = "1"

S = "${WORKDIR}/git"

DEPENDS = "\
    python3-pyyaml-native \
    python3-jinja2-native \
    python3-ply-native \
    python3-jinja2-native \
    udev \
    gnutls \
    chrpath-native \
    libevent \
    libyaml \
    gstreamer1.0 \
    gstreamer1.0-plugins-base\
    "

#PACKAGECONFIG ??= ""
#PACKAGECONFIG[gst] = "-Dgstreamer=enabled,-Dgstreamer=disabled,gstreamer1.0 gstreamer1.0-plugins-base"

LIBCAMERA_PIPELINES ??= "auto"

EXTRA_OEMESON = " \
    -Dpipelines=${LIBCAMERA_PIPELINES} \
    -Dv4l2=true \
    -Dcam=enabled \
    -Dlc-compliance=disabled \
    -Dtest=false \
    -Ddocumentation=disabled \
    -Dgstreamer=enabled \
"
inherit meson pkgconfig python3native

do_configure:prepend() {
    sed -i -e 's|py_compile=True,||' ${S}/utils/ipc/mojo/public/tools/mojom/mojom/generate/template_expander.py
}

do_install:append() {
    chrpath -d ${D}${libdir}/libcamera.so
    chrpath -d ${D}${libdir}/v4l2-compat.so
}

addtask do_recalculate_ipa_signatures_package after do_package before do_packagedata
do_recalculate_ipa_signatures_package() {
    local modules
    for module in $(find ${PKGD}/usr/lib/libcamera -name "*.so.sign"); do
        module="${module%.sign}"
        if [ -f "${module}" ] ; then
            modules="${modules} ${module}"
        fi
    done

    ${S}/src/ipa/ipa-sign-install.sh ${B}/src/ipa-priv-key.pem "${modules}"
}

FILES:${PN} += " \
    ${libdir}/v4l2-compat.so \
    ${libdir}/gstreamer-1.0 \
    /usr/share/libcamera \
    /usr/lib/libcamera \
    "


# libcamera-v4l2 explicitly sets _FILE_OFFSET_BITS=32 to get access to
# both 32 and 64 bit file APIs.
GLIBC_64BIT_TIME_FLAGS = ""
