package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/GoldenSharkGameSwitch;", "Landroidx/appcompat/widget/SwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenSharkGameSwitch extends SwitchCompat {
    public static final int $stable = 8;

    static {
    }

    public GoldenSharkGameSwitch(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        this(arg3, null, 2, null);
    }

    public GoldenSharkGameSwitch(Context arg1, AttributeSet arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public GoldenSharkGameSwitch(Context arg2, AttributeSet arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super(arg2, arg3, 0);
        this.setEnforceSwitchWidth(false);
        this.setSwitchMinWidth(((int)((((float)this.getThumbDrawable().getIntrinsicWidth())) * 1.69f)));
    }
}

