# yocto-demo

# WLS2 Prepare
We need en_US.ETF-8 locale for build
```
sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev python3-subunit mesa-common-dev zstd liblz4-tool file locales
sudo locale-gen en_US.UTF-8
```

# How to build
```sh
git clone --recurse-submodules https://github.com/buldo/yocto-demo.git
cd yocto-demo
source poky/oe-init-build-env .

# Build rpi zero 2W air image
bitbake mc:rpiz2w:openhd-air-image

# Build rpi4 ground image
bitbake mc:rpi4:openhd-ground-image
```

Maybe build will be failed. Try run this first
```sh
git config --global --add safe.directory '*'
```
