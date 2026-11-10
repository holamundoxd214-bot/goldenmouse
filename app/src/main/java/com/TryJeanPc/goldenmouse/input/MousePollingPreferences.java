package com.TryJeanPc.goldenmouse.input;

import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\bJ\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MousePollingPreferences;", "", "<init>", "()V", "HZ_KEY", "", "CUSTOM_KEY", "load", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "prefs", "Landroid/content/SharedPreferences;", "write", "Landroid/content/SharedPreferences$Editor;", "editor", "value", "save", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MousePollingPreferences {
    public static final int $stable = 0;
    public static final String CUSTOM_KEY = "mouse_polling_custom";
    public static final String HZ_KEY = "mouse_polling_hz";
    public static final MousePollingPreferences INSTANCE;

    static {
        MousePollingPreferences.INSTANCE = new MousePollingPreferences();
    }

    private MousePollingPreferences() {
        super();
    }

    public final MousePollingSelection load(SharedPreferences arg5) {
        MousePollingSelection v4_2;
        Object v4_1;
        Intrinsics.checkNotNullParameter(arg5, "prefs");
        int v1 = 0x7D;
        try {
            v4_1 = Result.constructor-impl(new MousePollingSelection(arg5.getInt("mouse_polling_hz", v1), arg5.getBoolean("mouse_polling_custom", false)));
        }
        catch(Throwable v4) {
            v4_1 = Result.constructor-impl(ResultKt.createFailure(v4));
        }

        MousePollingSelection v5 = new MousePollingSelection(v1, false, 2, null);
        if(Result.isFailure-impl(v4_1)) {
            v4_2 = v5;
        }

        return v4_2;
    }

    public final void save(SharedPreferences arg4, MousePollingSelection arg5) {
        Intrinsics.checkNotNullParameter(arg4, "prefs");
        Intrinsics.checkNotNullParameter(arg5, "value");
        MousePollingSelection v0 = this.load(arg4);
        SharedPreferences$Editor v1 = arg4.edit();
        String v2 = "edit(...)";
        Intrinsics.checkNotNullExpressionValue(v1, v2);
        if(this.write(v1, arg5).commit()) {
            return;
        }

        SharedPreferences$Editor v4 = arg4.edit();
        Intrinsics.checkNotNullExpressionValue(v4, v2);
        this.write(v4, v0).commit();
        throw new IllegalStateException("No se pudo guardar la frecuencia del mouse".toString());
    }

    public final SharedPreferences$Editor write(SharedPreferences$Editor arg2, MousePollingSelection arg3) {
        Intrinsics.checkNotNullParameter(arg2, "editor");
        Intrinsics.checkNotNullParameter(arg3, "value");
        SharedPreferences$Editor v1 = arg2.putInt("mouse_polling_hz", arg3.getHz()).putBoolean("mouse_polling_custom", arg3.getCustom());
        Intrinsics.checkNotNullExpressionValue(v1, "putBoolean(...)");
        return v1;
    }
}

