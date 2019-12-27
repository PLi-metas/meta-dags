require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force2plushv|lunix|purehdse|lunixco)$"

SRCDATE = "20191015"
KV = "4.2.1"

SRC_URI[md5sum] = "ab994ebea47eb053d03be3d24f26788f"
SRC_URI[sha256sum] = "6254ca6babb232ee3c660237c3e2cdfc72934388b38c15f987f7dd35db4bf2e3"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_73625-${KV}-${SRCDATE}.tar.gz"
