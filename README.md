# yocto-demo

# How to build
```sh
git clone --recurse-submodules https://github.com/buldo/yocto-demo.git
source poky/oe-init-build-env .
bitbake openhd-air-image
```

Maybe build will be failed. Try run this first
```sh
git config --global --add safe.directory '*'
```