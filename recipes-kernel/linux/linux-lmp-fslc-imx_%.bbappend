FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

#KERNEL_REPO = "git://github.com/DynamicDevices/linux-fslc.git"
#KERNEL_BRANCH = "ajl/6.1-2.2.x-imx"
#SRCREV_machine = "b7a6070a84787c49e9891a24bddbc4faaff35a53"

SRC_URI:append:imx8mm-jaguar-sentai = " \
		file://enable_i2c-dev.cfg \
		file://enable_lp50xx.cfg \
                file://enable_usb_modem.cfg \
		file://enable_gpio_key.cfg \
		file://enable_stts22h.cfg \
		file://enable_lis2dh.cfg \
		file://enable_sht4x.cfg \
		file://imx8mm-jaguar-sentai.dts \
                file://01-fix-enable-lp50xx.patch \
		file://02-disable-wifi-scan-msg.patch \
		file://03-add-st-mems-support.patch \
"

SRC_URI:append:imx8mm-jaguar-phasora = " \
		file://enable_i2c-dev.cfg \
		file://imx8mm-jaguar-phasora.dts \
"

# NOTE: This DTB file is created as a default for use with local development
#       when building lmp-base. It is NOT used by the lmp build or under CI
#       which uses the DTS in lmp-device-tree
do_configure:append:imx8mm-jaguar-sentai(){
 cp ${WORKDIR}/imx8mm-jaguar-sentai.dts ${S}/arch/arm64/boot/dts
 echo "dtb-y += imx8mm-jaguar-sentai.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
}

# NOTE: This DTB file is created as a default for use with local development
#       when building lmp-base. It is NOT used by the lmp build or under CI
#       which uses the DTS in lmp-device-tree
do_configure:append:imx8mm-jaguar-handheld(){
 cp ${WORKDIR}/imx8mm-jaguar-handheld.dts ${S}/arch/arm64/boot/dts
 echo "dtb-y += imx8mm-jaguar-handheld.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
}

# NOTE: This DTB file is created as a default for use with local development
#       when building lmp-base. It is NOT used by the lmp build or under CI
#       which uses the DTS in lmp-device-tree
#do_configure:append:imx8mm-jaguar-phasora(){
# cp ${WORKDIR}/imx8mm-jaguar-phasora.dts ${S}/arch/arm64/boot/dts
# echo "dtb-y += imx8mm-jaguar-phasora.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
#}

SRC_URI:append:imx8mm-jaguar-handheld = " \
		file://enable_i2c-dev.cfg \
		file://imx8mm-jaguar-handheld.dts \
"

#SRC_URI:append:imx8mm-jaguar-phasora = " \
#		file://enable_i2c-dev.cfg \
#                file://0001-support-phasora-mipi-display.patch \
#                file://0002-use-edt-ft5x06-ts.patch \
#                file://0003-enable-st7701.cfg \
#                file://0004-change-drm-resolution-for-lcd.patch \
#                file://0005-add-lcd-imx8mm-evk-qca-wifi.dts.patch \
#                file://0006-enable-edt-ft5x06.cfg \
#                file://0007-imx8mm-evkb-add-mipi-dsi.patch \
#                file://0008-dts-support-cortex-m4.patch \
#                file://iwlwifi-ty-a0-gf-a0-59.ucode \
#"

#file://imx8mm-jaguar-phasora.dts \
#

#INSANE_SKIP:imx8mm-jaguar-phasora = "usrmerge"
#PACKAGES:imx8mm-jaguar-phasora =+ "kernel-firmware"
#RPROVIDES:${PN}:imx8mm-jaguar-phasora += "kernel-firmware"
#FILES:kernel-firmware:imx8mm-jaguar-phasora += "/lib/firmware/iwlwifi-ty-a0-gf-a0-59.ucode"

#do_configure:append:imx8mm-jaguar-phasora() {
#   for i in ../*.cfg; do
#      [ -f "$i" ] || break
#      bbdebug 2 "applying $i file contents to .config"
#      cat ../*.cfg >> ${B}/.config
#   done
#}

#do_install:append:imx8mm-jaguar-phasora() {
#   install -d ${D}/lib/firmware
#   install -m 0644  ../iwlwifi-ty-a0-gf-a0-59.ucode ${D}/lib/firmware
#}

