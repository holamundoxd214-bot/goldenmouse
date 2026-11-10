package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.profile.MacroScriptComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/BotonMacroScript;", "Lcom/TryJeanPc/goldenmouse/controls/BotonEditableVisual;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BotonMacroScript extends BotonEditableVisual {
    public static final int $stable = 8;

    static {
    }

    public BotonMacroScript(Context arg8) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        super(arg8, "MACRO_SCRIPT", drawable.scriptboton, new MacroScriptComponent(null, null, 3, null), new BotonMacroScript$$ExternalSyntheticLambda0());
    }

    static final float _init_$lambda$0(float arg4, float arg5, float arg6, float arg7) {
        return Math.min(EditorHitShapes.INSTANCE.getOval().distance(arg4, arg5, arg6, arg7), EditorHitShapes.INSTANCE.getOval().distance(arg4 - arg6 * 0.62f, arg5 - 0.62f * arg7, arg6 * 0.38f, arg7 * 0.38f));
    }
}

