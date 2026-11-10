package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonTapBlueStacks;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditableVisual;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BotonTapBlueStacks extends BotonEditableVisual {
    public static final int $stable = 8;

    static {
    }

    public BotonTapBlueStacks(Context arg18) {
        Intrinsics.checkNotNullParameter(arg18, "context");
        super(arg18, "TAP", drawable.icono_tap_tecla, new TapComponent(null, 0, 0, false, 0, 0f, false, 0x7F, null), null, 16, null);
    }
}

