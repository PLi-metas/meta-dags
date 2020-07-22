require conf/machine/include/dags-mips.inc

PREFERRED_VERSION_linux-dags = "4.2.1"

SOC_FAMILY = "bcm7362"

STB_PLATFORM = "dags7362"

MACHINE_FEATURES += "blindscan-tbs vfdsymbol"
