SUMMARY = "Realtek 802.11n WLAN Adapter Linux driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

inherit module

SRC_URI = " \
    git://github.com/OpenHD/rtl8812au;protocol=https;branch=v5.2.20 \
    file://0001-Use-modules_install-as-wanted-by-yocto.patch \
"

SRCREV = "670f70ff3d470cba0bea08b9ea40813e4b3591b6"

PV = "v5.2.20-git"
S = "${WORKDIR}/git"

EXTRA_OEMAKE:append = " KSRC=${STAGING_KERNEL_DIR}"