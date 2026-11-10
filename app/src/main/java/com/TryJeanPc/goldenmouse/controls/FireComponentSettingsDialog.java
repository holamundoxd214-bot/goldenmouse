package com.TryJeanPc.goldenmouse.controls;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.TryJeanPc.goldenmouse.profile.FireComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00050\u000F2\u0018\u0010\u0010\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\u0011¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/FireComponentSettingsDialog;", "", "<init>", "()V", "show", "", "context", "Landroid/content/Context;", "placement", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/FireComponent;", "bindingLabel", "", "onRebind", "Lkotlin/Function0;", "onApply", "Lkotlin/Function2;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FireComponentSettingsDialog {
    public static final int $stable;
    public static final FireComponentSettingsDialog INSTANCE;

    static {
        FireComponentSettingsDialog.INSTANCE = new FireComponentSettingsDialog();
    }

    private FireComponentSettingsDialog() {
        super();
    }

    public final void show(Context arg8, ComponentPlacement arg9, FireComponent arg10, String arg11, Function0 arg12, Function2 arg13) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        Intrinsics.checkNotNullParameter(arg9, "placement");
        Intrinsics.checkNotNullParameter(arg10, "settings");
        Intrinsics.checkNotNullParameter(arg11, "bindingLabel");
        Intrinsics.checkNotNullParameter(arg12, "onRebind");
        Intrinsics.checkNotNullParameter(arg13, "onApply");
        GoldenPanel v7 = new GoldenPanel(arg8);
        v7.title("CONFIGURAR DISPARO");
        LinearLayout v11 = v7.card("PROPIEDADES BÁSICAS");
        EditText v3 = v7.field(v11, "Posición X", arg9.getX());
        EditText v5 = v7.field(v11, "Posición Y", arg9.getY());
        v3.setInputType(v3.getInputType() | 0x1000);
        v5.setInputType(v5.getInputType() | 0x1000);
        v7.show(arg8, new FireComponentSettingsDialog$$ExternalSyntheticLambda1(arg13, v3, arg9, v5, arg10));
    }

    public static void show$default(FireComponentSettingsDialog arg7, Context arg8, ComponentPlacement arg9, FireComponent arg10, String arg11, Function0 arg12, Function2 arg13, int arg14, Object arg15) {
        FireComponentSettingsDialog$$ExternalSyntheticLambda0 v12;
        if((arg14 & 8) != 0) {
            arg11 = "";
        }

        String v4 = arg11;
        if((arg14 & 16) != 0) {
            v12 = new FireComponentSettingsDialog$$ExternalSyntheticLambda0();
        }

        arg7.show(arg8, arg9, arg10, v4, ((Function0)v12), arg13);
    }

    static final Unit show$lambda$0() {
        return Unit.INSTANCE;
    }

    static final Unit show$lambda$1(Function2 arg6, EditText arg7, ComponentPlacement arg8, EditText arg9, FireComponent arg10) {
        Float v7 = StringsKt.toFloatOrNull(arg7.getText().toString());
        float v7_1 = v7 != null ? v7.floatValue() : arg8.getX();
        float v1 = v7_1;
        v7 = StringsKt.toFloatOrNull(arg9.getText().toString());
        v7_1 = v7 != null ? v7.floatValue() : arg8.getY();
        arg6.invoke(new ComponentPlacement(v1, v7_1, null, 4, null), arg10);
        return Unit.INSTANCE;
    }
}

