# Base this image on core-image-base
include recipes-core/images/core-image-base.bb
inherit systemd
COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " \
    packagegroup-openhd-air \
    rtl8812au \
    systemd \
    userland \
    libcamera \
    ${VIDEO_TOOLS} \
    "
EXTRA_IMAGE_FEATURES += " ssh-server-openssh"

VIDEO_TOOLS = " \
            gstreamer1.0 \
            gstreamer1.0-plugins-good \ 
            gstreamer1.0-plugins-base \ 
            gstreamer1.0-plugins-ugly \
            gstreamer1.0-libav \
            gst-player \
            gstreamer1.0-meta-base \
            gst-examples \
            gstreamer1.0-rtsp-server \
           "

# RPI_SDIMG_EXTRA_DEPENDS += " \
#     openhd-air-marker:do_deploy \
# "
