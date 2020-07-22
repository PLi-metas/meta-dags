require conf/machine/include/dags-mips.inc

PREFERRED_VERSION_linux-dags = "4.2.1"

SOC_FAMILY = "bcm73625"

STB_PLATFORM = "dags73625"

MACHINE_FEATURES += "blindscan-tbs dvb-c"

MTD_KERNEL = "mtd2"
MTD_ROOTFS = "mtd0"
SPLASH1_BMP = "splash1_power.bmp"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    dags-dvb-modules-dags73625 \
    "
