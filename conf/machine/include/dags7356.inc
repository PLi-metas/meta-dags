require conf/machine/include/dags-mips.inc

KERNELVERSION = "3.9.7"

PREFERRED_VERSION_linux-dags = "${KERNELVERSION}"

SOC_FAMILY = "bcm7356"

STB_PLATFORM = "dags7356"

MACHINE_FEATURES += "fan blindscan-tbs RCA"
