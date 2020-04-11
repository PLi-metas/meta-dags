require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force3uhdplus|tm4ksuper|lunix34k|galaxy4k)$"

SRCDATE = "20200409"
KV = "3.14.28"

SRC_URI[md5sum] = "0ab1f767f63faf5d42ffeb9511d98ae1"
SRC_URI[sha256sum] = "b6c295095598a89a58d89e3269e6984494052f3521cc83ba64ba515a4e446cf6"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"
