require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force3uhd|tmtwin4k|revo4k)$"

SRCDATE = "20200409"
KV = "3.14.28"

SRC_URI[md5sum] = "33707de7d861750484f6df8ea236fd33"
SRC_URI[sha256sum] = "84006f15928d111c1e03f8982cb7a7a9748c6032118dc5230a741fdbd52f6f01"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-200mm-${KV}-${SRCDATE}.tar.gz"
