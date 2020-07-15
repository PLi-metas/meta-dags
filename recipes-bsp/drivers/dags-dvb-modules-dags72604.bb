require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force4|lunix4k)$"

SRCDATE = "20200713"
KV = "4.1.20"

SRC_URI[md5sum] = "05978b566915887931df6678dc015da2"
SRC_URI[sha256sum] = "3f33d70885f4d33e92b2f92113ca46086c47d525bbb34867ef1e87aece1b9300"

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
