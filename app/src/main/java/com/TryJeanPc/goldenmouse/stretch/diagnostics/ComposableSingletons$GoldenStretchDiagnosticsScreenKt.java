package com.TryJeanPc.goldenmouse.stretch.diagnostics;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.TryJeanPc.goldenmouse.GoldenUiColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class ComposableSingletons$GoldenStretchDiagnosticsScreenKt {
    public static final ComposableSingletons$GoldenStretchDiagnosticsScreenKt INSTANCE;
    private static Function3 lambda$-163646878;
    private static Function3 lambda$-381960713;
    private static Function3 lambda$1774586020;

    static {
        ComposableSingletons$GoldenStretchDiagnosticsScreenKt.INSTANCE = new ComposableSingletons$GoldenStretchDiagnosticsScreenKt();
        ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$1774586020 = ComposableLambdaKt.composableLambdaInstance(1774586020, false, new ComposableSingletons$GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda0());
        ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-163646878 = ComposableLambdaKt.composableLambdaInstance(0xF63EF262, false, new ComposableSingletons$GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda1());
        ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-381960713 = ComposableLambdaKt.composableLambdaInstance(0xE93BBDF7, false, new ComposableSingletons$GoldenStretchDiagnosticsScreenKt$$ExternalSyntheticLambda2());
    }

    public ComposableSingletons$GoldenStretchDiagnosticsScreenKt() {
        super();
    }

    public final Function3 getLambda$-163646878$app() {
        return ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-163646878;
    }

    public final Function3 getLambda$-381960713$app() {
        return ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-381960713;
    }

    public final Function3 getLambda$1774586020$app() {
        return ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$1774586020;
    }

    static final Unit lambda_1774586020$lambda$0(RowScope arg26, Composer arg27, int arg28) {
        Composer v0 = arg27;
        int v1 = arg28;
        Intrinsics.checkNotNullParameter(arg26, "$this$Button");
        ComposerKt.sourceInformation(v0, "C78@4043L44:GoldenStretchDiagnosticsScreen.kt#e575ws");
        boolean v2 = (v1 & 17) != 16 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774586020, v1, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$1774586020.<anonymous> (GoldenStretchDiagnosticsScreen.kt:78)");
            }

            TextKt.Text-Nvy7gAk("Ejecutar diagnóstico de solo lectura", null, 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, arg27, 6, 0, 0x3FFFE);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg27.skipToGroupEnd();
        }

    label_50:
        return Unit.INSTANCE;
    }

    static final Unit lambda__163646878$lambda$1(RowScope arg26, Composer arg27, int arg28) {
        Composer v0 = arg27;
        int v1 = arg28;
        Intrinsics.checkNotNullParameter(arg26, "$this$OutlinedButton");
        ComposerKt.sourceInformation(v0, "C80@4232L60:GoldenStretchDiagnosticsScreen.kt#e575ws");
        boolean v2 = (v1 & 17) != 16 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF63EF262, v1, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-163646878.<anonymous> (GoldenStretchDiagnosticsScreen.kt:80)");
            }

            TextKt.Text-Nvy7gAk("Verificar journal y reconexión", null, GoldenUiColorsKt.getMetallicGold(), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, arg27, 390, 0, 0x3FFFA);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg27.skipToGroupEnd();
        }

    label_50:
        return Unit.INSTANCE;
    }

    static final Unit lambda__381960713$lambda$2(RowScope arg26, Composer arg27, int arg28) {
        Composer v0 = arg27;
        int v1 = arg28;
        Intrinsics.checkNotNullParameter(arg26, "$this$TextButton");
        ComposerKt.sourceInformation(v0, "C95@5421L36:GoldenStretchDiagnosticsScreen.kt#e575ws");
        boolean v2 = (v1 & 17) != 16 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE93BBDF7, v1, -1, "com.TryJeanPc.goldenmouse.stretch.diagnostics.ComposableSingletons$GoldenStretchDiagnosticsScreenKt.lambda$-381960713.<anonymous> (GoldenStretchDiagnosticsScreen.kt:95)");
            }

            TextKt.Text-Nvy7gAk("Volver", null, GoldenUiColorsKt.getMetallicGold(), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, arg27, 390, 0, 0x3FFFA);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg27.skipToGroupEnd();
        }

    label_50:
        return Unit.INSTANCE;
    }
}

