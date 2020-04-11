require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force4|lunix4k)$"

SRCDATE = "20200407"
KV = "4.1.20"

SRC_URI[md5sum] = "fcb9ecb0f77ddd616b66330ff228ed5f"
SRC_URI[sha256sum] = "f0e10f73b93ecf222094d91aca33aebb90f4fe6eb1ea1324cfdc344de3a465d2"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_72604-${KV}-${SRCDATE}.tar.gz"

do_install() {
		install -d ${D}/lib/modules/${KV}/extra
		for f in ${S}/lib/modules/${KV}/extra/*.ko; do
			install -m 0644 $f ${D}/lib/modules/${KV}/extra;
		done
		install -d ${D}/${sysconfdir}/modules-load.d
		for i in `ls ${D}/lib/modules/${KV}/extra | grep \\.ko | sed -e 's/.ko//g'`; do
		    echo $i >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
		done
}
