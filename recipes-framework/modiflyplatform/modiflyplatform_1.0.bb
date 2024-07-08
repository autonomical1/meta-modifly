SUMMARY="Install Modifly Platform for drone system"
LICENSE="CLOSED"

SRC_URI=" \
            gitsm://git@github.com/Couch-Potato/ModiflyPlatform.git;branch=jeremy-dev;protocol=ssh;name=modifly;recurse=1 \
            "

SRCREV = "${AUTOREV}"

RUNTIMETARGET:append:pn-gcc-runtime = " libquadmath libgfortran"

IMAGE_INSTALL:append = " \
                        gfortran \
                        gfortran-symlinks \
                        libgfortran \
                        libgfortran-dev \
                        apt \
                        libxext-dev \
                        kernel-image \
                        kernel-modules \
                        kernel-module-sierra-mc7411 \
                        "

DEPENDS = " \
            boost \
            cmake-native \
            ninja \
            git \
            mesa \
            ffmpeg \
            openssl \
            hdf5 \
            libedgetpu-max \
            nano \
            curl \
            gnupg \
            users \
            lgpio \
            glibc \
            sierra-mc7411 \
            wayland \
            "


S = "${WORKDIR}/git"


inherit cmake
do_configure[depends] += " cmake-native:do_populate_sysroot cmake:do_populate_sysroot"
do_configure[network] = "1"
EXTRA_OECMAKE = ""

do_configure () {
    unset CFLAGS CXXFLAGS LDFLAGS
    export CC=/usr/bin/gcc
    export CXX=/usr/bin/g++
    export HDF5_ROOT=/opt/yocto/poky/build/tmp/work/core2-64-poky-linux/hdf5/1.14.2/package/usr
    export OPENSSL_ROOT_DIR=/usr/bin/openssl
    install -d ${S}/build-arm64
    /usr/bin/cmake -S ${S} -B ${S}/build-arm64 -G Ninja
    #cmake --no-warn-unused-cli -S ${S} -B ${S}/build-arm64
    #/usr/bin/cmake ${S}/. -G Ninja
}

do_compile () {                               
    cmake --build ${S}/build-arm64 --config Debug --target MF24_Platform_MK2L
}
FILES:${PN}:append = "${D}/*"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/mfprivexec ${D}${bindir}/mfprivexec
    install -m 0755 ${S}/MF24_Platform_MK2L ${D}${bindir}/MF24_Platform_MK2L
}