SUMMARY = "Minimal factory image which includes OTA Lite, Docker, and OpenSSH support"

require recipes-samples/images/lmp-image-common.inc

# Factory tooling requires SOTA (OSTree + Aktualizr-lite)
require ${@bb.utils.contains('DISTRO_FEATURES', 'sota', 'recipes-samples/images/lmp-feature-factory.inc', '', d)}

# Enable wayland related recipes if required by DISTRO
require ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'recipes-samples/images/lmp-feature-wayland.inc', '', d)}

# Enable auto register related recipes if required by DISTRO
require ${@bb.utils.contains('DISTRO_FEATURES', 'auto-register', 'recipes-samples/images/lmp-feature-auto-register.inc', '', d)}

# Enable alsa related recipes if required by DISTRO
require ${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'recipes-samples/images/lmp-feature-alsa.inc', '', d)}

# Enable alsa related recipes if required by DISTRO
require ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'recipes-samples/images/lmp-feature-pulseaudio.inc', '', d)}

# Enable OP-TEE related recipes if provided by the image
require ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'recipes-samples/images/lmp-feature-optee.inc', '', d)}

# Enable SE05X related recipes if provided by machine
require ${@bb.utils.contains('MACHINE_FEATURES', 'se05x', 'recipes-samples/images/lmp-feature-se05x.inc', '', d)}

# Enable TPM2 related recipes if provided by machine
require ${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'recipes-samples/images/lmp-feature-tpm2.inc', '', d)}

# Enable EFI support if provided by machine
require ${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'recipes-samples/images/lmp-feature-efi.inc', '', d)}

# Enable IMA support if required by DISTRO
require ${@bb.utils.contains('MACHINE_FEATURES', 'ima', 'recipes-samples/images/lmp-feature-ima.inc', '', d)}

# Enable Xenomai4 related recipes if provided by the image
require ${@bb.utils.contains('MACHINE_FEATURES', 'xeno4', 'recipes-samples/images/lmp-feature-xeno4.inc', '', d)}

# Enable jailhouse related recipes if provided by the machine
require ${@bb.utils.contains('MACHINE_FEATURES', 'jailhouse', 'recipes-samples/images/lmp-feature-jailhouse.inc', '', d)}

# Enable TI tas2563 related recipes if required by MACHINE
require ${@bb.utils.contains('MACHINE_FEATURES', 'tas2563', 'recipes-samples/images/lmp-feature-tas2563.inc', '', d)}

# Enable TI tas2781 related recipes if required by MACHINE
require ${@bb.utils.contains('MACHINE_FEATURES', 'tas2781', 'recipes-samples/images/lmp-feature-tas2781.inc', '', d)}

# Enable ST usb4500 related recipes if required by MACHINE
require ${@bb.utils.contains('MACHINE_FEATURES', 'stusb4500', 'recipes-samples/images/lmp-feature-stusb4500.inc', '', d)}

# Enable Infineon bgt60 related recipes if required by MACHINE
require ${@bb.utils.contains('MACHINE_FEATURES', 'bgt60', 'recipes-samples/images/lmp-feature-bgt60.inc', '', d)}

# Set image features based on DEV_MODE environment variable defined in Factory configuration
IMAGE_FEATURES += "${@bb.utils.contains('DEV_MODE', '1', 'debug-tweaks tools-sdk', '', d)}"

# Enable development related recipes if required by IMAGE_FEATURES
require ${@bb.utils.contains('IMAGE_FEATURES', 'debug-tweaks', 'recipes-samples/images/lmp-feature-dev.inc', '', d)}

require recipes-samples/images/lmp-feature-softhsm.inc
require recipes-samples/images/lmp-feature-wireguard.inc
require recipes-samples/images/lmp-feature-docker.inc
require recipes-samples/images/lmp-feature-wifi.inc
require recipes-samples/images/lmp-feature-ota-utils.inc
require recipes-samples/images/lmp-feature-sbin-path-helper.inc

IMAGE_FEATURES += "ssh-server-openssh"

CORE_IMAGE_BASE_INSTALL_GPLV3 = "\
    packagegroup-core-full-cmdline-utils \
    packagegroup-core-full-cmdline-multiuser \
"

CORE_IMAGE_BASE_INSTALL += " \
    board-scripts \
    lmp-auto-hostname \
    kernel-modules \
    networkmanager-nmcli \
    modemmanager \
    libiio \
    lmsensors \
    packagegroup-core-full-cmdline-extended \
    ${@bb.utils.contains('LMP_DISABLE_GPLV3', '1', '', '${CORE_IMAGE_BASE_INSTALL_GPLV3}', d)} \
"
