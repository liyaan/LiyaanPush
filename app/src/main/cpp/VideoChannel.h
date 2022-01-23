//
// Created by 86133 on 2022/1/22.
//

#ifndef LIYAANPUSH_VIDEOCHANNEL_H
#define LIYAANPUSH_VIDEOCHANNEL_H


class VideoChannel {

public:
    void setVideoEncInfo(int width,int height,int fps,int bitrate);

private:
    int mWidth;
    int mHeight;
    int mFps;
    int mBitrate;
    int ySize;
    int uvSize;
};


#endif //LIYAANPUSH_VIDEOCHANNEL_H
