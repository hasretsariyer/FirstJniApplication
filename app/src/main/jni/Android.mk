LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE    := jni-sample

LOCAL_LDLIBS :=  -llog # for __android_log_print

LOCAL_SRC_FILES := $(LOCAL_PATH)/jni-sample.cpp
include $(BUILD_SHARED_LIBRARY)