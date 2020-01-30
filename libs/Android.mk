LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := leankey-robolectric:robolectric-3.5.1.jar

include $(BUILD_MULTI_PREBUILT)

include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := leankey-crashlytics:crashlytics-2.8.0.jar

include $(BUILD_MULTI_PREBUILT)
