package com.androworld.musicvideo.libffmpeg;

public interface FFmpegLoadBinaryResponseHandler extends ResponseHandler {
    void onFailure();

    void onFailure(String str);

    void onSuccess();

    void onSuccess(String str);
}
