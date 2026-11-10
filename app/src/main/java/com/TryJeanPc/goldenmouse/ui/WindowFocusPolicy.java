package com.TryJeanPc.goldenmouse.ui;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/WindowFocusPolicy;", "", "<init>", "()V", "prepare", "", "root", "Landroid/view/View;", "dialog", "Landroid/app/Dialog;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WindowFocusPolicy {
    public static final int $stable;
    public static final WindowFocusPolicy INSTANCE;

    static {
        WindowFocusPolicy.INSTANCE = new WindowFocusPolicy();
    }

    private WindowFocusPolicy() {
        super();
    }

    public final void prepare(Dialog arg5) {
        Intrinsics.checkNotNullParameter(arg5, "dialog");
        arg5.create();
        Window v5 = arg5.getWindow();
        if(v5 != null) {
            View v5_1 = v5.getDecorView();
            if(v5_1 == null) {
            }
            else {
                int v0 = 0;
                v5_1.setDefaultFocusHighlightEnabled(false);
                v5_1 = v5_1.findViewById(0x1020002);
                if(v5_1 == null) {
                }
                else {
                    ((ViewGroup)v5_1).setDefaultFocusHighlightEnabled(false);
                    int v1 = ((ViewGroup)v5_1).getChildCount();
                    while(v0 < v1) {
                        View v2 = ((ViewGroup)v5_1).getChildAt(v0);
                        Intrinsics.checkNotNullExpressionValue(v2, "getChildAt(...)");
                        this.prepare(v2);
                        ++v0;
                    }
                }
            }
        }
    }

    public final void prepare(View arg7) {
        Intrinsics.checkNotNullParameter(arg7, "root");
        if((Intrinsics.areEqual(arg7.getClass(), View.class)) || (Intrinsics.areEqual(arg7.getClass(), FrameLayout.class)) || (Intrinsics.areEqual(arg7.getClass(), LinearLayout.class)) || (Intrinsics.areEqual(arg7.getClass(), RelativeLayout.class))) {
            int v0 = 0;
            arg7.setDefaultFocusHighlightEnabled(false);
            if((arg7 instanceof ViewGroup)) {
                int v1 = ((ViewGroup)arg7).getChildCount();
                while(v0 < v1) {
                    View v2 = ((ViewGroup)arg7).getChildAt(v0);
                    ViewGroup$LayoutParams v3 = v2.getLayoutParams();
                    if(v3 != null) {
                        int v5 = -1;
                        if(v3.width == v5 && v3.height == v5) {
                            Intrinsics.checkNotNull(v2);
                            this.prepare(v2);
                        }
                    }

                    ++v0;
                }
            }
        }
        else {
        }
    }
}

