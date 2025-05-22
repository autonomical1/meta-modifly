SUMMARY = "Installs the ATH11K/QCN9074 WiFi PCI driver"
HOMEPAGE = "https://git.codelinaro.org/clo/ath-firmware/ath11k-firmware"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.qca_firmware;md5=74852b14e2b35d8052226443d436a244"

SRC_URI = "git://git.codelinaro.org/clo/ath-firmware/ath11k-firmware;protocol=https;branch=main"
SRCREV = "06cd6f9f388938b18b82177ea9283175a933515d"

S = "${WORKDIR}/git"
QCN9074 = "${S}/QCN9074/hw1.0/2.9.0.1/WLAN.HK.2.9.0.1-02175-QCAHKSWPL_SILICONZ-2"

deltask do_compile
do_install () {
    install -d ${D}/usr/lib/firmware/ath11k/QCN9074/hw1.0/
    install -m 0644 ${S}/QCN9074/hw1.0/board-2.bin ${D}/usr/lib/firmware/ath11k/QCN9074/hw1.0 
    install -m 0644 ${QCN9074}/m3.bin ${D}/usr/lib/firmware/ath11k/QCN9074/hw1.0/
    install -m 0644 ${QCN9074}/amss.bin ${D}/usr/lib/firmware/ath11k/QCN9074/hw1.0/
}

FILES:${PN} = " \
                /usr/lib/firmware/ath11k/QCN9074/hw1.0/ \
                /usr/lib/firmware/ath11k/QCN9074/hw1.0/amss.bin \
                /usr/lib/firmware/ath11k/QCN9074/hw1.0/m3.bin \
                /usr/lib/firmware/ath11k/QCN9074/hw1.0/board-2.bin \
                "

INSANE_SKIP:append = "arch"