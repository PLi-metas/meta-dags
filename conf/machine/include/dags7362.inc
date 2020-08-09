require conf/machine/include/dags-mips.inc

KERNELVERSION = "4.2.1"

PREFERRED_VERSION_linux-dags = "${KERNELVERSION}"

SOC_FAMILY = "bcm7362"

STB_PLATFORM = "dags7362"

MACHINE_FEATURES += "blindscan-tbs vfdsymbol"
