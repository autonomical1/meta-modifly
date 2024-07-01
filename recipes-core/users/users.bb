SUMMARY = "Custom user/credential setup"
SECTION = "core"
LICENSE = "CLOSED"

S = "${WORKDIR}"
EXCLUDE_FROM_WORLD = "1"

inherit useradd

PASSWD = "\$1\$D6AE0GXn\$0hpOD2nHze8aheTCLlFyR/"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} += " -d /home/usl -p '${PASSWD}' usl"

do_install () {
    install -d ${D}/home/usl 
}

FILES:${PN} += "/home/usl"
