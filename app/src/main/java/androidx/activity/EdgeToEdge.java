package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A%\u0010\u000B\u001A\u00020\f*\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000FH\u0007¢\u0006\u0002\b\u0011\"\u001C\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005\"\u001C\u0010\u0006\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001A\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"DefaultLightScrim", "", "getDefaultLightScrim$annotations", "()V", "getDefaultLightScrim", "()I", "DefaultDarkScrim", "getDefaultDarkScrim$annotations", "getDefaultDarkScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class EdgeToEdge {
    private static final int DefaultDarkScrim;
    private static final int DefaultLightScrim;
    private static EdgeToEdgeImpl Impl;

    static {
        EdgeToEdge.DefaultLightScrim = Color.argb(230, 0xFF, 0xFF, 0xFF);
        EdgeToEdge.DefaultDarkScrim = Color.argb(0x80, 27, 27, 27);
    }

    public static final void enable(ComponentActivity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        EdgeToEdge.enable$default(arg2, null, null, 3, null);
    }

    public static final void enable(ComponentActivity arg2, SystemBarStyle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "statusBarStyle");
        EdgeToEdge.enable$default(arg2, arg3, null, 2, null);
    }

    public static final void enable(ComponentActivity arg7, SystemBarStyle arg8, SystemBarStyle arg9) {
        EdgeToEdgeApi30 v0_2;
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "statusBarStyle");
        Intrinsics.checkNotNullParameter(arg9, "navigationBarStyle");
        View v6 = arg7.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v6, "getDecorView(...)");
        EdgeToEdgeImpl v0 = EdgeToEdge.Impl;
        if(v0 == null) {
            if(Build$VERSION.SDK_INT >= 35) {
                EdgeToEdgeApi35 v0_1 = new EdgeToEdgeApi35();
            }
            else if(Build$VERSION.SDK_INT >= 30) {
                v0_2 = new EdgeToEdgeApi30();
            }
            else if(Build$VERSION.SDK_INT >= 29) {
                EdgeToEdgeApi29 v0_3 = new EdgeToEdgeApi29();
            }
            else if(Build$VERSION.SDK_INT >= 28) {
                EdgeToEdgeApi28 v0_4 = new EdgeToEdgeApi28();
            }
            else {
                EdgeToEdgeApi26 v0_5 = new EdgeToEdgeApi26();
            }

            EdgeToEdge.Impl = ((EdgeToEdgeImpl)v0_2);
        }

        EdgeToEdgeImpl v2 = ((EdgeToEdgeImpl)v0_2);
        ComponentActivity v5 = arg7;
        EdgeToEdge$$ExternalSyntheticLambda0 v1 = new EdgeToEdge$$ExternalSyntheticLambda0(v2, arg8, arg9, v5, v6);
        Iterator v7 = ViewGroupKt.getChildren(((ViewGroup)v6)).iterator();
        do {
            if(v7.hasNext()) {
                if(!(v7.next().getTag() instanceof EdgeToEdgeImpl)) {
                    continue;
                }

                break;
            }
            else {
                goto label_54;
            }
        }
        while(true);

        goto label_63;
    label_54:
        EdgeToEdge$enableEdgeToEdge$1$2 v8 = new EdgeToEdge$enableEdgeToEdge$1$2(((Runnable)v1), ((ViewGroup)v6).getContext());
        v8.setTag(v2);
        v8.setVisibility(8);
        v8.setWillNotDraw(true);
        ((ViewGroup)v6).addView(((View)v8));
    label_63:
        ((Runnable)v1).run();
        Window v7_1 = v5.getWindow();
        Intrinsics.checkNotNullExpressionValue(v7_1, "getWindow(...)");
        v2.adjustLayoutInDisplayCutoutMode(v7_1);
    }

    public static void enable$default(ComponentActivity arg6, SystemBarStyle arg7, SystemBarStyle arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg7 = Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }

        if((arg9 & 2) != 0) {
            arg8 = Companion.auto$default(SystemBarStyle.Companion, EdgeToEdge.DefaultLightScrim, EdgeToEdge.DefaultDarkScrim, null, 4, null);
        }

        EdgeToEdge.enable(arg6, arg7, arg8);
    }

    static final void enableEdgeToEdge$lambda$1(EdgeToEdgeImpl arg7, SystemBarStyle arg8, SystemBarStyle arg9, ComponentActivity arg10, View arg11) {
        Window v3 = arg10.getWindow();
        Intrinsics.checkNotNullExpressionValue(v3, "getWindow(...)");
        Function1 v10 = arg8.getDetectDarkMode$activity();
        Resources v0 = arg11.getResources();
        Intrinsics.checkNotNullExpressionValue(v0, "getResources(...)");
        boolean v5 = v10.invoke(v0).booleanValue();
        v10 = arg9.getDetectDarkMode$activity();
        v0 = arg11.getResources();
        Intrinsics.checkNotNullExpressionValue(v0, "getResources(...)");
        arg7.setUp(arg8, arg9, v3, arg11, v5, v10.invoke(v0).booleanValue());
    }

    public static final int getDefaultDarkScrim() {
        return EdgeToEdge.DefaultDarkScrim;
    }

    public static void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return EdgeToEdge.DefaultLightScrim;
    }

    public static void getDefaultLightScrim$annotations() {
    }
}

