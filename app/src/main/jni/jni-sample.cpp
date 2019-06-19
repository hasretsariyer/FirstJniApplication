#include <jni.h>
#include <string>
#include <android/log.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_firstjniapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string msg = "Hello from JNI";
    __android_log_print(ANDROID_LOG_INFO, "FROMJNI", "Log message from JNI");
    return env->NewStringUTF(msg.c_str());
}
