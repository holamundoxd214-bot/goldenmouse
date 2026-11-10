package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u000E\u001A\u00020\u0007H&J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0007H&J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0010H&R\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0015À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;", "", "angleEglFeaturesSupported", "", "getAngleEglFeaturesSupported", "()Z", "identity", "", "getIdentity", "()Ljava/lang/String;", "user", "", "getUser", "()I", "boot", "read", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "key", "write", "", "value", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface GraphicsAccess {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean getAngleEglFeaturesSupported(GraphicsAccess arg0) {
            return arg0.getAngleEglFeaturesSupported();
        }
    }

    static boolean access$getAngleEglFeaturesSupported$jd(GraphicsAccess arg0) {
        return super.getAngleEglFeaturesSupported();
    }

    String boot();

    default boolean getAngleEglFeaturesSupported() {
        return 0;
    }

    String getIdentity();

    int getUser();

    GraphicsValue read(String arg1);

    void write(String arg1, GraphicsValue arg2);
}

