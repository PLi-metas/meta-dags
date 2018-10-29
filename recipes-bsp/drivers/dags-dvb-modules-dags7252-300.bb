require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "force3uhdplus|tm4ksuper"

SRCDATE = "20180917"
KV = "3.14.28"

SRC_URI[md5sum] = "bd437f51600f126eba4f66f55a3888f8"
SRC_URI[sha256sum] = "4b7c2e015ceb28c74991662c06a769d054c96cd8449b4c0d67fb1d0bd5587aec"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7252S-300mm-${KV}-${SRCDATE}.tar.gz"

do_populate_sysroot[noexec] = "1"

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -m 0644 ${WORKDIR}/lib/modules/${KV}/extra/bcmlinuxdvb.ko ${D}/lib/modules/${KV}/extra/bcmlinuxdvb_${MACHINE}.ko
    install -d ${D}/${sysconfdir}/modules-load.d
    echo bcmlinuxdvb_${MACHINE} _hwtype=\$hwtypenum > ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
