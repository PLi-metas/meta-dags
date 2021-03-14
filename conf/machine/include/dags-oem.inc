# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

BOX_BRAND = "dags"

MACHINE_FEATURES += "alsa hdmicec switchoff textlcd ci dags HDMI"

BOOTLOGO_FILENAME = "splash.bmp"

DVBPROVIDER = "kernel"
DVBSKYPROVIDER = "kernel"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	${@bb.utils.contains("SOC_FAMILY", "hisi3798mv200", "dagsmv200-shutdown" , "dags-shutdown", d)} \
	"

GLIBC_EXTRA_OECONF = "--with-tls"
DVBMEDIASINK_CONFIG = "${@bb.utils.contains("SOC_FAMILY", "", "--with-dags" , "dags-shutdown", d)} --with-pcm --with-eac3 --with-amr --with-wmv"

PREFERRED_PROVIDER_virtual/kernel = "linux-dags"
PREFERRED_PROVIDER_virtual/egl = "${@bb.utils.contains("SOC_FAMILY", "hisi3798mv200", "dags-opengl-${SOC_FAMILY}" , "v3d-libgles-${STB_PLATFORM}", d)}" 
PREFERRED_PROVIDER_virtual/libgles1 = "${@bb.utils.contains("SOC_FAMILY", "hisi3798mv200", "dags-opengl-${SOC_FAMILY}" , "v3d-libgles-${STB_PLATFORM}", d)}"
PREFERRED_PROVIDER_virtual/libgles2 = "${@bb.utils.contains("SOC_FAMILY", "hisi3798mv200", "dags-opengl-${SOC_FAMILY}" , "v3d-libgles-${STB_PLATFORM}", d)}"
PREFERRED_PROVIDER_virtual/blindscan-dvbs ?= "dags-blindscan-utils"

require conf/machine/include/soc-family.inc

BLINDSCAN_BINARY = "dags_blindscan"

RCNAME ?= "optimuss1"

PREFERRED_VERSION_linux-dags = "${KERNELVERSION}"
