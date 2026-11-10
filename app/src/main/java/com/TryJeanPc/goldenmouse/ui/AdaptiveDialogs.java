package com.TryJeanPc.goldenmouse.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0001\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u001A\b\u0002\u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FH\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/AdaptiveDialogs;", "", "<init>", "()V", "showXml", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "layout", "", "type", "Lcom/TryJeanPc/goldenmouse/ui/WindowType;", "config", "Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;", "configure", "Lkotlin/Function2;", "Landroid/view/View;", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AdaptiveDialogs {
    public static final int $stable;
    public static final AdaptiveDialogs INSTANCE;

    static {
        AdaptiveDialogs.INSTANCE = new AdaptiveDialogs();
    }

    private AdaptiveDialogs() {
        super();
    }

    public final Dialog showXml(Context arg8, int arg9, WindowType arg10, WindowSizingConfig arg11, Function2 arg12) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        Intrinsics.checkNotNullParameter(arg10, "type");
        Intrinsics.checkNotNullParameter(arg11, "config");
        Intrinsics.checkNotNullParameter(arg12, "configure");
        Dialog v1 = new Dialog(arg8);
        v1.requestWindowFeature(1);
        View v7 = LayoutInflater.from(v1.getContext()).inflate(arg9, null);
        v1.setContentView(v7);
        Window v8 = v1.getWindow();
        if(v8 != null) {
            v8.setBackgroundDrawable(new ColorDrawable(0));
            arg9 = arg10 == WindowType.SIDE_PANEL ? 0x800015 : 17;
            v8.setGravity(arg9);
        }

        Intrinsics.checkNotNull(v7);
        arg12.invoke(v1, v7);
        Binding v7_1 = AdaptiveWindowSizing.bind$default(AdaptiveWindowSizing.INSTANCE, v1, arg10, arg11, false, 8, null);
        try {
            WindowFocusPolicy.INSTANCE.prepare(v1);
            v1.show();
            v7_1.refresh();
            return v1;
        }
        catch(Exception v0) {
            v7_1.close();
            v1.dismiss();
            throw v0;
        }
    }

    public static Dialog showXml$default(AdaptiveDialogs arg12, Context arg13, int arg14, WindowType arg15, WindowSizingConfig arg16, Function2 arg17, int arg18, Object arg19) {
        Function2 v7_1;
        WindowSizingConfig v6 = (arg18 & 8) != 0 ? new WindowSizingConfig(null, null, 0, 0, null, null, null, null, 0xFF, null) : arg16;
        if((arg18 & 16) != 0) {
            AdaptiveDialogs$$ExternalSyntheticLambda0 v7 = new AdaptiveDialogs$$ExternalSyntheticLambda0();
        }
        else {
            v7_1 = arg17;
        }

        return arg12.showXml(arg13, arg14, arg15, v6, v7_1);
    }

    static final Unit showXml$lambda$0(Dialog arg1, View arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<unused var>");
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        return Unit.INSTANCE;
    }
}

