FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append:modifly-osiris = " \
                    file://tegra234-mb2-bct-misc-no-eeprom-p3767-0000.dts \
                    file://tegra234-mb1-bct-pinmux-custom-p3767-dp-a03.dtsi \
                    file://tegra234-mb1-bct-padvoltage-custom-p3767-dp-a03.dtsi \
                    file://tegra234-mb1-bct-gpio-custom-p3767-dp-a03.dtsi \
                    "

CUSTOM_DTSI_DIR := "${THISDIR}/${BPN}"
do_install:append:modifly-osiris() {
    install -m 0644 ${CUSTOM_DTSI_DIR}/tegra234-mb2-bct-misc-no-eeprom-p3767-0000.dts ${D}${datadir}/tegraflash/
    install -m 0644 ${CUSTOM_DTSI_DIR}/tegra234-mb1-bct-pinmux-custom-p3767-dp-a03.dtsi ${D}${datadir}/tegraflash/
    install -m 0644 ${CUSTOM_DTSI_DIR}/tegra234-mb1-bct-padvoltage-custom-p3767-dp-a03.dtsi ${D}${datadir}/tegraflash/
    #install -m 0644 ${CUSTOM_DTSI_DIR}/tegra234-mb1-bct-gpio-custom-p3767-dp-a03.dtsi ${D}${datadir}/tegraflash/
}