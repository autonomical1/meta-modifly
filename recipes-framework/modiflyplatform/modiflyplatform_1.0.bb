SUMMARY="Install Modifly Platform for drone system"
LICENSE="CLOSED"

SRC_URI=" \
          git://git@github.com/Couch-Potato/ModiflyPlatform.git;branch=jeremy-dev;protocol=ssh;name=modifly \
          git://github.com/WohlSoft/LuaJIT.git;branch=v2.1;protocol=https;destsuffix=git/thirdparty/LuaJIT;name=LuaJIT \
          git://github.com/mavlink/MAVSDK.git;branch=main;protocol=https;destsuffix=git/thirdparty/MAVSDK;name=MAVSDK \
          git://github.com/libsdl-org/SDL.git;branch=main;protocol=https;destsuffix=git/thirdparty/SDL;name=sdl \
          git://github.com/curl/curl.git;branch=master;protocol=https;destsuffix=git/thirdparty/curl;name=curl \
          git://github.com/fmtlib/fmt.git;branch=master;protocol=https;destsuffix=git/thirdparty/fmt;name=fmt \
          git://github.com/ocornut/imgui.git;branch=master;protocol=https;destsuffix=git/thirdparty/imgui;name=imgui \
          git://github.com/opencv/opencv.git;branch=4.x;protocol=https;destsuffix=git/thirdparty/opencv;name=opencv \
          git://github.com/openssl/openssl.git;branch=master;protocol=https;destsuffix=git/thirdparty/openssl;name=openssl \
          git://github.com/SergiusTheBest/plog.git;branch=master;protocol=https;destsuffix=git/thirdparty/plog;name=plog \
          git://github.com/ThePhD/sol2.git;branch=develop;protocol=https;destsuffix=git/thirdparty/sol2;name=sol2 \
          git://github.com/tensorflow/tensorflow.git;branch=master;protocol=https;destsuffix=git/thirdparty/tensorflow;name=tensorflow \
          git://github.com/marzer/tomlplusplus.git;branch=master;protocol=https;destsuffix=git/thirdparty/tomlplusplus;name=tomlplusplus \
          "

SRCREV_FORMAT = "modifly_LuaJIT_MAVSDK_sdl_curl_fmt_imgui_opencv_openssl_plog_sol2_tensorflow_tomlplusplus"
SRCREV_modifly = "128dd3abedd30d74903092e30bbc15f54bd4f65a"
SRCREV_LuaJIT = "879f3976f3657c11464206b2d49e21accdfb62bc"
SRCREV_MAVSDK = "6f09ba984807d02a15055b3b6e8fb67251bf026d"
SRCREV_sdl = "26e947f8eaab4737a597c60993adb9a8d0634127"
SRCREV_curl = "ab173d14437b4eea67bea139a5c28645d6b2ae88"
SRCREV_fmt = "cacdf1439fa67a45dc82d2ae9cc274ed538b20e3"
SRCREV_imgui = "06ce312745e0b25bfa8412b324503393964e3812"
SRCREV_opencv = "62ef27ac1e9df26d475a76f9a34f4ca78cb34390"
SRCREV_openssl = "0f644b96d209443b4566f7e86e3be2568292e75b"
SRCREV_plog = "199734337bec45e72956c4e82f848a716cbf7ac3"
SRCREV_sol2 = "9c882a28fdb6f4ad79a53a4191b43ce48a661175"
SRCREV_tensorflow = "53217e4b993c814661568af569be96527a363199"
SRCREV_tomlplusplus = "a851257c493cc7adc54953d5609c0a85e0ef3ce3"



DEPENDS = " \
            boost \
            cmake-native \
            ninja \
            git \
            mesa \
            ffmpeg \
            openssl \
            hdf5 \
            libedgetpu-std \
            nano \
            curl \
            gnupg \
            users \
            lgpio \
            glibc \
            sierra-mc7411 \
            "

IMAGE_INSTALL:append = " \
                        apt \
                        libxext-dev \
                        kernel-image \
                        kernel-modules \
                        kernel-module-sierra-mc7411 \
                        "

S = "${WORKDIR}/git"

inherit cmake
do_configure[depends] += " cmake-native:do_populate_sysroot cmake:do_populate_sysroot"

EXTRA_OECMAKE = "-DCMAKE_SYSROOT=${STAGING_DIR_TARGET}"

do_configure () {
    #install -d ${S}/build-arm64
    #cmake --no-warn-unused-cli -DCMAKE_C_COMPILER:FILEPATH=/usr/bin/x86_64-linux-gnu-gcc -DCMAKE_CXX_COMPILER:FILEPATH=/usr/bin/x86_64-linux-gnu-g++ -S ${S} -B ${S}/build-arm64
    #cmake --no-warn-unused-cli -S ${S} -B ${S}/build-arm64
    unset CFLAGS CXXFLAGS LDFLAGS
    export CC=/usr/bin/gcc
    export CXX=/usr/bin/g++

    cmake ${S}/. -G Ninja
}

do_compile () {                               
    cmake --build ${S}/ModiflyPlatform/build-arm64 --config Debug --target MF24_Platform_MK2L
}
FILES:${PN}:append = "${D}/*"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/mfprivexec ${D}${bindir}/mfprivexec
    install -m 0755 ${S}/MF24_Platform_MK2L ${D}${bindir}/MF24_Platform_MK2L
}