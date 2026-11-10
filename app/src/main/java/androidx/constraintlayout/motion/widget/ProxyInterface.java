package androidx.constraintlayout.motion.widget;

interface ProxyInterface {
    int designAccess(int arg1, String arg2, Object arg3, float[] arg4, int arg5, float[] arg6, int arg7);

    float getKeyFramePosition(Object arg1, int arg2, float arg3, float arg4);

    Object getKeyframeAtLocation(Object arg1, float arg2, float arg3);

    Boolean getPositionKeyframe(Object arg1, Object arg2, float arg3, float arg4, String[] arg5, float[] arg6);

    long getTransitionTimeMs();

    void setAttributes(int arg1, String arg2, Object arg3, Object arg4);

    void setKeyFrame(Object arg1, int arg2, String arg3, Object arg4);

    boolean setKeyFramePosition(Object arg1, int arg2, int arg3, float arg4, float arg5);

    void setToolPosition(float arg1);
}

