package com.TryJeanPc.goldenmouse.telemetry;

import android.content.Context;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindows;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002J\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0011\u001A\u00020\u0010J\u000E\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014J\u0006\u0010\u0015\u001A\u00020\tR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/BluestacksOsdOverlay;", "", "context", "Landroid/content/Context;", "windowManager", "Landroid/view/WindowManager;", "<init>", "(Landroid/content/Context;Landroid/view/WindowManager;)V", "managed", "", "view", "Landroid/view/View;", "rootOsdView", "fpsNumberTextView", "Landroid/widget/TextView;", "mostrar", "", "ocultar", "actualizarTexto", "nuevoTexto", "", "isShowing", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BluestacksOsdOverlay {
    public static final int $stable = 8;
    private final Context context;
    private TextView fpsNumberTextView;
    private View rootOsdView;
    private final WindowManager windowManager;

    static {
    }

    public BluestacksOsdOverlay(Context arg2, WindowManager arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "windowManager");
        super();
        this.context = arg2;
        this.windowManager = arg3;
    }

    public BluestacksOsdOverlay(Context arg1, WindowManager arg2, int arg3, DefaultConstructorMarker arg4) {
        Object v2;
        if((arg3 & 2) != 0) {
            v2 = arg1.getSystemService("window");
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.WindowManager");
        }

        this(arg1, ((WindowManager)v2));
    }

    public final void actualizarTexto(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "nuevoTexto");
        String v0 = new Regex("[^0-9]").replace(((CharSequence)arg3), "");
        TextView v2 = this.fpsNumberTextView;
        if(v2 != null) {
            if(((CharSequence)v0).length() > 0) {
                arg3 = v0;
            }

            v2.setText(((CharSequence)arg3));
        }
    }

    public final boolean isShowing() {
        View v0 = this.rootOsdView;
        if(v0 != null && (this.managed(v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean managed(View arg2) {
        WindowManager v1 = this.windowManager;
        if((v1 instanceof SessionOverlayWindows)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((SessionOverlayWindows)v1).isManaged(arg2);
        }

        return arg2.isAttachedToWindow();
    }

    public final void mostrar() {
        View v3_1;
        View v0 = this.rootOsdView;
        if(v0 != null && (this.managed(v0))) {
            return;
        }

        this.ocultar();
        try {
            ViewGroup v3 = null;
            v0 = LayoutInflater.from(this.context).inflate(layout.fps, v3);
            View v2 = v0.findViewById(id.emulator_fps);
            if(v2 == null) {
                if((v0 instanceof TextView)) {
                    v3_1 = v0;
                }

                if(v3_1 == null) {
                    v2 = v0.findViewWithTag("fpsText");
                    goto label_23;
                }

                v2 = v3_1;
            }

        label_23:
            this.fpsNumberTextView = ((TextView)v2);
            WindowManager$LayoutParams v3_2 = new WindowManager$LayoutParams(-2, -2, 0x7F6, 792, -3);
            v3_2.gravity = 0x800053;
            v3_2.x = 0;
            v3_2.y = 0;
            if(Build$VERSION.SDK_INT >= 28) {
                v3_2.layoutInDisplayCutoutMode = 1;
            }

            this.windowManager.addView(v0, ((ViewGroup$LayoutParams)v3_2));
            this.rootOsdView = v0;
            return;
        }
        catch(Exception v0_1) {
            Log.e("BluestacksOsdOverlay", "Error agregando overlay OSD: " + v0_1.getMessage());
            return;
        }
    }

    public final void ocultar() {
        View v0 = this.rootOsdView;
        if(v0 != null) {
            try {
                if(this.managed(v0)) {
                    this.windowManager.removeViewImmediate(v0);
                }
            }
            catch(Exception v0_1) {
                Integer.valueOf(Log.e("BluestacksOsdOverlay", "Error removiendo overlay OSD: " + v0_1.getMessage()));
            }
        }

        this.rootOsdView = null;
        this.fpsNumberTextView = null;
    }
}

