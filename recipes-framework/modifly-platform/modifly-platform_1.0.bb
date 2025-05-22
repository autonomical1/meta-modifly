SUMMARY = "Install the Modifly Drone Ecosystem"
LICENSE = "CLOSED"


SRC_URI = " \
        file://modifly/MF24_Platform_Osiris \
	    file://modifly/platform.toml \
        file://modifly/modifly.service \
	    file://modifly/cockpit-base.mpk \
	    file://modifly/libMF24_Impl_CCC_F446.so \
	    file://mavsdk/libmavsdk.so.2 \
	    file://mavsdk/libjsoncpp.so.25 \
	    file://mavsdk/libtinyxml2.so.9 \
	    file://lgpio/liblgpio.so.1 \
	    file://opencv/libjpeg.so.8 \
	    file://bullet/libBulletDynamics.so.3.24 \
	    file://bullet/libBulletCollision.so.3.24 \
	    file://bullet/libLinearMath.so.3.24 \
"


DEPENDS = "hdf5 glib-2.0 networkmanager boost \
            mesa libxext ffmpeg openssl glew"


RDEPENDS:${PN}:append = "libavcodec mesa glib-2.0 libnm libswscale \
			            libavutil libpng boost-filesystem \
                        boost-thread boost-chrono libcurl hdf5 opencv"

do_install() {
    install -d ${D}/usr/bin/
    install -d ${D}/etc/modifly/config/
    install -d ${D}${systemd_unitdir}/system/
    install -d ${D}${libdir}

    install -m 0755 ${UNPACKDIR}/modifly/platform.toml ${D}/etc/modifly/config/platform.toml

    install -m 0644 ${UNPACKDIR}/modifly/modifly.service ${D}${systemd_unitdir}/system/modifly.service

    install -m 0755 ${UNPACKDIR}/mavsdk/libmavsdk.so.2 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/mavsdk/libjsoncpp.so.25 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/mavsdk/libtinyxml2.so.9 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/lgpio/liblgpio.so.1 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/opencv/libjpeg.so.8 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/modifly/libMF24_Impl_CCC_F446.so ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/bullet/libBulletDynamics.so.3.24 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/bullet/libBulletCollision.so.3.24 ${D}${libdir}
    install -m 0755 ${UNPACKDIR}/bullet/libLinearMath.so.3.24 ${D}${libdir}

}

do_install:append() {
    install -m 0755 ${UNPACKDIR}/modifly/MF24_Platform_Osiris ${D}/usr/bin/
    install -m 0755 ${UNPACKDIR}/modifly/cockpit-base.mpk ${D}/usr/bin/
}

FILES:${PN} = " \
                /usr/lib \
                /usr/lib/systemd \
                /usr/lib/systemd/system \
                /usr/lib/systemd/system/modifly.service \
                /etc \
                /usr/bin/cockpit-base.mpk \
                /usr/bin/MF24_Platform_Osiris \
                /usr/bin/mf-cockpit \
                /usr/bin/modifly \
                /etc/modifly \
                /etc/modifly/platform.toml \
                "

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

INSANE_SKIP:${PN}:append = "file-rdeps already-stripped"
