require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force3uhdplus|tm4ksuper|lunix34k|galaxy4k)$"

SRCDATE = "20200203"
KV = "3.14.28"

SRC_URI[md5sum] = "83f0ed4e67c5640281b0b0ef0416990b"
SRC_URI[sha256sum] = "51ec59cd3f7890d38948a2b033414dc0d4864523efb146fe9915d0e122835b5d"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"
