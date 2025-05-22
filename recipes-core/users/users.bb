SUMMARY = "Custom user/credential setup"
SECTION = "core"
LICENSE = "CLOSED"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

PASSWD = "\$1\$D6AE0GXn\$0hpOD2nHze8aheTCLlFyR/"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} += " -d /home/usl -p '${PASSWD}' usl"

do_install () {
    install -d ${D}/home/usl 
    install -d ${D}${sysconfdir}/sudoers.d/
}

do_install:append () {
    echo "usl ALL=(ALL) ALL" > ${D}${sysconfdir}/sudoers.d/001_usl
}

FILES:${PN} =  " \
                /home/usl \ 
                ${sysconfdir}/sudoers.d/ \
                "