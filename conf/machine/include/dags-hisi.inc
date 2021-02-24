include conf/machine/include/dags-oem.inc

DISTRO_FEATURES_remove += "x11 wayland"

KERNELVERSION = "4.4.35"

SOC_FAMILY = "hisi3798mv200"
HICHIPSET = "3798mv200"
CHIPSET = "Hi3798Mv200"

KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.tar.bz2"
MTD_BLACK  = "mmcblk0"

MTD_KERNEL = "mmcblk0p12"
MTD_ROOTFS = "mmcblk0p13"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	dags-reader-${SOC_FAMILY} \
	dags-libreader-${SOC_FAMILY} \
	dags-loadmodules-${SOC_FAMILY} \
	e2fsprogs-resize2fs \
	dags-libs-${SOC_FAMILY} \
	kernel-module-extrawlan-rtl8192eu \
	firmware-rtl8192eu \
	dags-bootoptions-${MACHINE} \
	dags-buildimage \
	deepsleep-${SOC_FAMILY} \
	"

MACHINE_FEATURES += "emmc mmc 7segment hisi mali AV_JACK multitranscoding fastboot"

MACHINE_FEATURES_remove += "ci"

IMAGE_CLASSES += "dags-emmc_image"
IMAGE_FSTYPES += "dagsemmc"
IMAGE_ROOTFS_SIZE ?= "524288"

TARGET_ARCH = "arm"
DEFAULTTUNE = "cortexa15hf-neon-vfpv4"

PREFERRED_PROVIDER_virtual/enigma2-mediaservice = "enigma2-plugin-systemplugins-servicehisilicon"

require conf/machine/include/tune-cortexa15.inc

IMAGE_CMD_dagsemmc_append = "\
	mkdir -p ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}; \
	mkdir -p ${DEPLOY_DIR_IMAGE}/release/${IMAGEDIR}; \
	cp ${DEPLOY_DIR_IMAGE}/uImage ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE}; \
	mv ${IMGDEPLOYDIR}/${IMAGE_NAME}_subrootfs.ext4 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.ext4; \
	echo ${IMAGE_NAME} > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/imageversion; \
	echo "https://forum.openvision.tech/app.php/donate" > ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/donate.txt; \
	cd ${DEPLOY_DIR_IMAGE}; \
	zip ${IMAGE_NAME}_recovery_mmc.zip ${IMAGEDIR}/*; \
	cd ${IMAGE_ROOTFS}; \
	tar -cvf ${DEPLOY_DIR_IMAGE}/rootfs.tar -C ${IMAGE_ROOTFS} .; \
	mv ${DEPLOY_DIR_IMAGE}/rootfs.tar ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
	cd ${DEPLOY_DIR_IMAGE}; \
	bzip2 ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/rootfs.tar; \
	zip -j ${IMAGE_NAME}_mmc.zip ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/imageversion ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/donate.txt ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${KERNEL_FILE} ${DEPLOY_DIR_IMAGE}/${IMAGEDIR}/${ROOTFS_FILE}; \
	rm -f ${DEPLOY_DIR_IMAGE}/*.ext4; \
	rm -Rf ${DEPLOY_DIR_IMAGE}/rootfs; \
	rm -Rf ${IMAGEDIR}; \
	rm -Rf release; \
	"

IMAGE_CMD_prepend = "\
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	rm -Rf ${DEPLOY_DIR_IMAGE}/rootfs; \
	"

DVBMEDIASINK_CONFIG += "--with-h265 --with-vb8 --with-vb9 --with-spark --with-dts"

EXTRA_OECONF_append_pn-enigma2 = "--with-lcddev=/dev/null --with-alphablendingacceleration=always --with-blitaccelerationthreshold=250  --with-fillaccelerationthreshold=190000 --with-subttxtabnormalptsdiffs=3600000"

EXTRA_ALSA = "mv200"

STB_PLATFORM = "dagsmv200"

RCNAME = "qviart5"
