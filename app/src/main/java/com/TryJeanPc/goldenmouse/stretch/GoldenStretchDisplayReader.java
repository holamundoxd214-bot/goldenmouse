package com.TryJeanPc.goldenmouse.stretch;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.Display$Mode;
import android.view.Display;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tJ\u0010\u0010\n\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\tR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/GoldenStretchDisplayReader;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "readLogicalSize", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "display", "Landroid/view/Display;", "read", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchDisplayReader {
    public static final int $stable = 8;
    private final Context context;

    static {
    }

    public GoldenStretchDisplayReader(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super();
        this.context = arg2;
    }

    public final StretchDisplayRead read(Display arg8) {
        Unavailable v7_2;
        Available v7_1;
        StretchSize v4;
        StretchSize v3;
        int v0;
        StretchDisplayIdentity v2;
        if(arg8 != null) {
            try {
                if(!arg8.isValid()) {
                }
                else {
                    v2 = new StretchDisplayIdentity(arg8.getDisplayId(), arg8.getName());
                    v0 = arg8.getRotation();
                    v3 = this.readLogicalSize(arg8);
                    if(v3 == null) {
                        return new Unavailable(StretchReadIssue.LOGICAL_SIZE_UNAVAILABLE);
                    }
                    else {
                        goto label_15;
                    }
                }

                goto label_50;
            }
            catch(RuntimeException ) {
                goto label_54;
            }

        label_15:
            StretchSize v7 = null;
            try {
                Display$Mode v1 = arg8.getMode();
                if(v1 != null) {
                    v4 = new StretchSize(v1.getPhysicalWidth(), v1.getPhysicalHeight());
                    if(v4.getWidth() > 0 && v4.getHeight() > 0) {
                        goto label_26;
                    }
                }
            }
            catch(RuntimeException ) {
            }

            goto label_27;
        label_26:
            v7 = v4;
        label_27:
            StretchSize v5 = v7;
            try {
                if(arg8.isValid()) {
                    if(arg8.getRotation() != v0) {
                    }
                    else {
                        Integer v4_1 = Integer.valueOf(v0);
                        StretchLogicalSizeSource v8 = Build$VERSION.SDK_INT >= 30 ? StretchLogicalSizeSource.MAXIMUM_WINDOW_METRICS : StretchLogicalSizeSource.DISPLAY_REAL_SIZE;
                        v7_1 = new Available(new StretchDisplaySnapshot(v2, v3, v4_1, v5, v8));
                        goto label_57;
                    }
                }

                v7_2 = new Unavailable(StretchReadIssue.DISPLAY_CHANGED);
                goto label_57;
            label_50:
                return new Unavailable(StretchReadIssue.DISPLAY_UNAVAILABLE);
            }
            catch(RuntimeException ) {
            label_54:
                v7_2 = new Unavailable(StretchReadIssue.READ_FAILED);
                goto label_57;
            }
        }

        goto label_50;
    label_57:
        return ((StretchDisplayRead)v7_1);
    }

    public final StretchSize readLogicalSize(Display arg4) {
        StretchSize v4;
        Bundle v0 = null;
        if(arg4 != null) {
            if(!arg4.isValid()) {
            }
            else {
                if(Build$VERSION.SDK_INT >= 30) {
                    Context v3 = this.context.createDisplayContext(arg4).createWindowContext(0x7F6, v0);
                    Intrinsics.checkNotNullExpressionValue(v3, "createWindowContext(...)");
                    Rect v3_1 = v3.getSystemService(WindowManager.class).getMaximumWindowMetrics().getBounds();
                    Intrinsics.checkNotNullExpressionValue(v3_1, "getBounds(...)");
                    v4 = new StretchSize(v3_1.width(), v3_1.height());
                }
                else {
                    Point v3_2 = new Point();
                    arg4.getRealSize(v3_2);
                    v4 = new StretchSize(v3_2.x, v3_2.y);
                }

                if(v4.getWidth() <= 0) {
                    goto label_37;
                }

                if(v4.getHeight() <= 0) {
                    goto label_37;
                }

                return v4;
            }
        }

    label_37:
        return ((StretchSize)v0);
    }
}

