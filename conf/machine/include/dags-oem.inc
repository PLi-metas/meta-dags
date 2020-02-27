# We know about rtc
require conf/machine/include/build-extras.inc

BOX_BRAND = "dags"

MACHINE_FEATURES += "3dtv alsa hdmicec switchoff textlcd ci dags"

BOOTLOGO_FILENAME = "splash.bmp"

DVBPROVIDER = "kernel"
DVBSKYPROVIDER = "kernel"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    dags-shutdown \
    "

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "\
    kernel-module-cdfs \
    "

MACHINE_EXTRA_RRECOMMENDS += "\
    gstreamer1.0-plugin-dvbmediasink \
    gstreamer1.0-libav \
    "

require conf/machine/include/autoload-filesystems.inc

GLIBC_EXTRA_OECONF = "--with-tls"
DVBMEDIASINK_CONFIG = "--with-dags --with-pcm --with-eac3 --with-amr --with-wmv"

PREFERRED_PROVIDER_virtual/kernel = "linux-dags"

require conf/machine/include/soc-family.inc
