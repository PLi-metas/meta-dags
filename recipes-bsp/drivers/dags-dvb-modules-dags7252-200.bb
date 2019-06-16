require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhd|tmtwin4k|revo4k"

SRCDATE = "20190424"
KV = "3.14.28"

SRC_URI[md5sum] = "a2e3bc02be5a63d4230b29e5a80d52ff"
SRC_URI[sha256sum] = "ba7bf7ff75add7ee5a435a47ed8d1c90b7c00db836e0fa8c0fa7a487f451c14b"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-200mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
