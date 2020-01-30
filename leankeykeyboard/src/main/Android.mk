LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := \
    $(call all-java-files-under, java)

LOCAL_PACKAGE_NAME := LeanKeyKeyboard

#ifeq ($(shell test $(PLATFORM_SDK_VERSION) -ge 26 && echo OK),OK)
#LOCAL_PROPRIETARY_MODULE := true
#endif

LOCAL_CERTIFICATE := shared

LOCAL_PROGUARD_ENABLED := disabled

#ifndef PRODUCT_SHIPPING_API_LEVEL
#LOCAL_PRIVATE_PLATFORM_APIS := true
#endif

LOCAL_PRIVATE_PLATFORM_APIS := true

LOCAL_STATIC_ANDROID_LIBRARIES := \
    android-support-compat \
    android-support-v7-appcompat

LOCAL_STATIC_JAVA_LIBRARIES := \
	leankey-robolectric \
	leankey-crashlytics

LOCAL_RESOURCE_DIR := \
    $(LOCAL_PATH)/res

include $(BUILD_PACKAGE)
