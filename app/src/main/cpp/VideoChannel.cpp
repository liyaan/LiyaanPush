//
// Created by 86133 on 2022/1/22.
//

#include "VideoChannel.h"

void VideoChannel::setVideoEncInfo(int width,int height,int fps,int bitrate){
    mWidth = width;
    mHeight = height;
    mFps = fps;
    mBitrate = bitrate;
    ySize = width*height;
    uvSize = ySize/4;
}