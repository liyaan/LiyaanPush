#include <jni.h>
#include <string>
#include "x264.h"
#include "librtmp/rtmp.h"
#include "VideoChannel.h"

VideoChannel *videoChannel;
extern "C" JNIEXPORT jstring JNICALL
Java_com_liyaan_liyaanpush_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    x264_picture_t* x264_picture = new x264_picture_t;
    RTMP_Alloc();
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_liyaan_liyaanpush_LivePusher_native_1init(JNIEnv *env, jobject thiz) {
    videoChannel = new VideoChannel();
}
extern "C"
JNIEXPORT void JNICALL
Java_com_liyaan_liyaanpush_LivePusher_native_1setVideoEncInfo(JNIEnv *env, jobject thiz, jint width,
                                                              jint height, jint fps, jint bitrate) {
    if(!videoChannel){
        return;
    }
    videoChannel.setVideoEncInfo(width,height,fps,bitrate);
}