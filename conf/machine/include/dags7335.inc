require conf/machine/include/dags-mips.inc

KERNELVERSION = "3.9.7"

PREFERRED_VERSION_linux-dags = "${KERNELVERSION}"

SOC_FAMILY = "bcm7335"

STB_PLATFORM = "dags7335"

MACHINE_FEATURES += "fan blindscan-tbs"
