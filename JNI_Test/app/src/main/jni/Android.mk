LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := JNI_Test
LOCAL_SRC_FILES := JniFuncs.cpp

include $(BUILD_SHARED_LIBRARY)