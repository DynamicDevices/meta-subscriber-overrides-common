FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:imx8mm-jaguar-sentai = " \
		file://enable_i2c-dev.cfg \
		file://enable_lp50xx.cfg \
                file://enable_usb_modem.cfg \
		file://imx8mm-jaguar-sentai.dts \
                file://01-fix-enable-lp50xx.patch \
		file://02-disable-wifi-scan-msg.patch \
"

# NOTE: This DTB file is created as a default for use with local development
#       when building lmp-base. It is NOT used by the lmp build or under CI
#       which uses the DTS in lmp-device-tree
do_configure:append:imx8mm-jaguar-sentai(){
 cp ${WORKDIR}/imx8mm-jaguar-sentai.dts ${S}/arch/arm64/boot/dts
 echo "dtb-y += imx8mm-jaguar-sentai.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
}

SRC_URI:append:imx8mm-jaguar-handheld = " \
		file://enable_i2c-dev.cfg \
		file://imx8mm-jaguar-handheld.dts \
"

# NOTE: This DTB file is created as a default for use with local development
#       when building lmp-base. It is NOT used by the lmp build or under CI
#       which uses the DTS in lmp-device-tree
do_configure:append:imx8mm-jaguar-handheld(){
 cp ${WORKDIR}/imx8mm-jaguar-handheld.dts ${S}/arch/arm64/boot/dts
 echo "dtb-y += imx8mm-jaguar-handheld.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
}
