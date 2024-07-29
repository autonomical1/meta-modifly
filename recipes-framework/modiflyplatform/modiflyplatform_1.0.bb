SUMMARY="Install Modifly Platform for drone system"
LICENSE="CLOSED"

SRC_URI=" \
            gitsm://git@github.com/Couch-Potato/ModiflyPlatform.git;branch=jeremy-dev;protocol=ssh \
            file://0002-Remove-wayland-dependency.patch \
            file://0001-fix-bad-paths.patch \
            file://host-toolchain.cmake \
            file://0003-add-compiler-for-minilua.patch \
            file://toolchain.cmake \
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
                        "

DEPENDS += "libx11 libxext libxrandr libxinerama libxcursor"

DEPENDS = " \
            glibc \
            boost \
            bazel-native \
            cmake-native \
            libedgetpu-std
            ninja \
            git \
            ffmpeg \
            openssl \
            hdf5 \
            nano \
            linux-libc-headers \
            curl \
            users \
            libglvnd \
            "


S = "${WORKDIR}/git"



inherit cmake
do_configure[depends] += " cmake-native:do_populate_sysroot cmake:do_populate_sysroot glibc:do_populate_sysroot"
do_configure[network] = "1"
EXTRA_OECMAKE = " \
                -DCMAKE_TOOLCHAIN_FILE=${WORKDIR}/host-toolchain.cmake \
                -DCMAKE_C_COMPILER:FILEPATH=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-gcc \
                -DCMAKE_CXX_COMPILER:FILEPATH=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-g++ \
                -DOPENGL_INCLUDE_DIR=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/include \
                -DOPENGL_egl_LIBRARY=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libEGL.so \
                -DOPENGL_gl_LIBRARY=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libGL.so \
                -DOPENGL_glu_LIBRARY=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libGLU.so \
                -DOPENGL_glx_LIBRARY=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libGLX.so \
                -DOPENGL_opengl_LIBRARY=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libOpenGL.so \
                -DX11_INCLUDE_DIR=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/include/X11 \
                -DX11_X11_LIB=/opt/yocto/poky/build/tmp/work/cortexa57-poky-linux/modiflyplatform/1.0/recipe-sysroot/usr/lib/libX11.so \
                -DHOSTCC=/usr/bin/gcc \
                -D_MIPS_SIM=_ABI64 \
"

CFLAGS:append = " --sysroot=${STAGING_DIR_TARGET}"
CXXFLAGS:append = " --sysroot=${STAGING_DIR_TARGET}"
CFLAGS += " -D_MIPS_SIM=_ABI64"
CXXFLAGS += " -D_MIPS_SIM=_ABI64"

# Remove or conditionally apply -fcanon-prefix-map
TARGET_CFLAGS:remove = "-fcanon-prefix-map"
TARGET_CXXFLAGS:remove = "-fcanon-prefix-map"

# Alternatively, conditionally set flags
TARGET_CFLAGS += "${@bb.utils.contains('BUILD_ARCH', 'x86_64', '', '-fcanon-prefix-map=...', d)}"
TARGET_CXXFLAGS += "${@bb.utils.contains('BUILD_ARCH', 'x86_64', '', '-fcanon-prefix-map=...', d)}"


LUA_TARGET_OS = "Unknown"
LUA_TARGET_OS_darwin = "Darwin"
LUA_TARGET_OS_linux = "Linux"
LUA_TARGET_OS_linux-gnueabi = "Linux"


do_configure() {
    export CC=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-gcc 
    export CXX=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-g++
    export LDFLAGS='${LDFLAGS} --sysroot=${STAGING_DIR_TARGET}'
    export CFLAGS='${CFLAGS} --sysroot=${STAGING_DIR_TARGET}'
    export OPENGL_INCLUDE_DIR=${STAGING_DIR_TARGET}/usr/include
    export CMAKE_PREFIX_PATH=${STAGING_DIR_TARGET}
    export CMAKE_LIBRARY_PATH=${STAGING_DIR_TARGET}/usr/lib
    export CMAKE_INCLUDE_PATH=${STAGING_DIR_TARGET}/usr/include
    install -d ${S}/build-arm64
    cmake --no-warn-unused-cli -S ${S} -B ${S}/build-arm64 -G Ninja
}

do_compile () {
    export CC=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-gcc 
    export CXX=${STAGING_DIR_NATIVE}/usr/bin/aarch64-poky-linux/aarch64-poky-linux-g++
    
    cmake --build ${S}/build-arm64 --target MF24_Platform_MK2L
}
FILES:${PN}:append = "${D}/*"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/mfprivexec ${D}${bindir}/mfprivexec
    install -m 0755 ${S}/MF24_Platform_MK2L ${D}${bindir}/MF24_Platform_MK2L
}

BBCLASSEXTEND += "multilib:lib32"