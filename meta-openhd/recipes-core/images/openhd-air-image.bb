# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

INIT_MANAGER = "systemd"

DISTRO_FEATURES:append = " systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED:append = " sysvinit"
VIRTUAL-RUNTIME_init_manager ??= "systemd"
VIRTUAL-RUNTIME_initscripts ??= "systemd-compat-units"
VIRTUAL-RUNTIME_login_manager ??= "shadow-base"
VIRTUAL-RUNTIME_dev_manager ??= "systemd"

IMAGE_INSTALL:append = " packagegroup-openhd-air rtl8812au systemd"
EXTRA_IMAGE_FEATURES += " ssh-server-openssh"