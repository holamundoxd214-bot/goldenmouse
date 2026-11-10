package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001AZ\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\b2\u0017\u0010\u000E\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000F¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001A\r\u0010\u0014\u001A\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001AR\u0010\u0017\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0017\u0010\u000E\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000F¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", "transform", "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidExternalSurface_androidKt {
    public static Unit $r8$lambda$1lUqfS793IrzPlJ0H2_b36axFYE(TextureView arg0) {
        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0(arg0);
    }

    public static SurfaceView $r8$lambda$9SmtiSLAQ9hfeH2ebFaOKRh1n7g(Function1 arg0, AndroidExternalSurfaceState arg1, Context arg2) {
        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(arg0, arg1, arg2);
    }

    public static TextureView $r8$lambda$AADyQaGNBx4TcT2CHAXzE1MPVG8(Context arg0) {
        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0(arg0);
    }

    public static Unit $r8$lambda$mOOACBDYCQWHD1UzfP8VYpNez04(SurfaceView arg0) {
        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0(arg0);
    }

    public static Unit $r8$lambda$vtCG1ACX7GOhJVNcBTaeoO8jJAs(long arg0, boolean arg2, int arg3, boolean arg4, SurfaceView arg5) {
        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(arg0, arg2, arg3, arg4, arg5);
    }

    public static Unit $r8$lambda$y_m2f4L-OZryKRPlLAkDxg-9FoQ(long arg0, AndroidEmbeddedExternalSurfaceState arg2, Function1 arg3, boolean arg4, float[] arg5, TextureView arg6) {
        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(arg0, arg2, arg3, arg4, arg5, arg6);
    }

    public static final void AndroidEmbeddedExternalSurface-sv6N_fY(Modifier arg23, boolean arg24, long arg25, float[] arg27, Function1 arg28, Composer arg29, int arg30, int arg31) {
        float[] v5_4;
        boolean v2_4;
        long v3_1;
        long v17;
        Object v12_1;
        AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5 v2_3;
        AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4 v2_2;
        Modifier v1_1;
        float[] v22;
        boolean v21;
        Companion v1_2;
        Function1 v14_3;
        Matrix v14;
        long v10;
        int v8;
        boolean v6;
        Modifier v2;
        int v3;
        int v7 = arg30;
        int v0 = 0xCF76AC2;
        Composer v13 = arg29.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(AndroidEmbeddedExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,transform:c#ui.graphics.Matrix,onInit)433@18602L45,436@18684L19,438@18752L2,439@18773L639,435@18653L766:AndroidExternalSurface.android.kt#71ulvw");
        int v1 = arg31 & 1;
        if(v1 != 0) {
            v3 = v7 | 6;
            v2 = arg23;
        }
        else if((v7 & 6) == 0) {
            v2 = arg23;
            v3 = v13.changed(v2) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v2 = arg23;
            v3 = v7;
        }

        int v4 = arg31 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_38;
        }
        else if((v7 & 0x30) == 0) {
            v6 = arg24;
            v8 = v13.changed(v6) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_38:
            v6 = arg24;
        }

        int v9 = 0x100;
        if((v7 & 0x180) == 0) {
            v10 = arg25;
            v8 = (arg31 & 4) != 0 || !v13.changed(v10) ? 0x80 : v9;
            v3 |= v8;
        }
        else {
            v10 = arg25;
        }

        v8 = arg31 & 8;
        if(v8 != 0) {
            v3 |= 0xC00;
        }
        else if((v7 & 0xC00) == 0) {
            if(arg27 != null) {
                v14 = Matrix.box-impl(arg27);
            }
            else {
                Object v14_1 = null;
            }

            int v14_2 = v13.changedInstance(v14) ? 0x800 : 0x400;
            v3 |= v14_2;
        }

        if((v7 & 0x6000) == 0) {
            v14_3 = arg28;
            int v16 = v13.changedInstance(v14_3) ? 0x4000 : 0x2000;
            v3 |= v16;
        }
        else {
            v14_3 = arg28;
        }

        int v15 = 0;
        boolean v5 = (v3 & 9363) != 9362 ? true : false;
        if(v13.shouldExecute(v5, v3 & 1)) {
            v13.startDefaults();
            if((v7 & 1) == 0 || (v13.getDefaultsInvalid())) {
                if(v1 != 0) {
                    v1_2 = Modifier.Companion;
                }
                else {
                    v1_1 = v2;
                }

                if(v4 != 0) {
                    v6 = true;
                }

                if((arg31 & 4) != 0) {
                    v3 &= -897;
                    v10 = IntSize.Companion.getZero-YbymL2g();
                }

                if(v8 != 0) {
                    v21 = v6;
                    v22 = null;
                    goto label_123;
                }

                v22 = arg27;
            label_103:
                v21 = v6;
            }
            else {
                v13.skipToGroupEnd();
                if((arg31 & 4) != 0) {
                    v3 &= -897;
                }

                v22 = arg27;
                v1_1 = v2;
                goto label_103;
            }

        label_123:
            v13.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
            }

            AndroidEmbeddedExternalSurfaceState v0_1 = AndroidExternalSurface_androidKt.rememberAndroidEmbeddedExternalSurfaceState(v13, 0);
            String v4_1 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 0xACC7EB35, v4_1);
            Object v2_1 = v13.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4();
                v13.updateRememberedValue(v2_2);
            }

            Object v8_1 = v2_2;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xACC7F3A4, v4_1);
            v2_1 = v13.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_3 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5();
                v13.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerStart(v13, 0xACC7F8C1, v4_1);
            v4 = (v3 & 0x380 ^ 0x180) > v9 && (v13.changed(v10)) || (v3 & 0x180) == v9 ? 1 : 0;
            v4 |= v13.changedInstance(v0_1);
            int v5_1 = (0xE000 & v3) == 0x4000 ? 1 : 0;
            v4 |= v5_1;
            if((v3 & 0x70) == 0x20) {
                v15 = 1;
            }

            v4 |= v15;
            if(v22 != null) {
                Matrix v12 = Matrix.box-impl(v22);
            }
            else {
                v12_1 = null;
            }

            v4 |= v13.changedInstance(v12_1);
            Object v5_2 = v13.rememberedValue();
            if(v4 != 0 || v5_2 == Composer.Companion.getEmpty()) {
                v17 = v10;
                AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6 v5_3 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6(v17, v0_1, v14_3, v21, v22);
                v13.updateRememberedValue(v5_3);
            }
            else {
                v17 = v10;
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Modifier v9_1 = ((Modifier)v1_2);
            AndroidView_androidKt.AndroidView(((Function1)v8_1), v9_1, v2_3, null, v5_2, v13, v3 << 3 & 0x70 | 390, 8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v9_1;
            v3_1 = v17;
            v2_4 = v21;
            v5_4 = v22;
        }
        else {
            v13.skipToGroupEnd();
            v5_4 = arg27;
            v1_1 = v2;
            v2_4 = v6;
            v3_1 = v10;
        }

        ScopeUpdateScope v9_2 = v13.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda7(v1_1, v2_4, v3_1, v5_4, arg28, v7, arg31));
        }
    }

    private static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0(Context arg1) {
        return new TextureView(arg1);
    }

    private static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0(TextureView arg0) {
        return Unit.INSTANCE;
    }

    private static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(long arg4, AndroidEmbeddedExternalSurfaceState arg6, Function1 arg7, boolean arg8, float[] arg9, TextureView arg10) {
        android.graphics.Matrix v4;
        if(!IntSize.equals-impl0(arg4, IntSize.Companion.getZero-YbymL2g())) {
            SurfaceTexture v0 = arg10.getSurfaceTexture();
            if(v0 != null) {
                v0.setDefaultBufferSize(((int)(arg4 >> 0x20)), ((int)(0xFFFFFFFFL & arg4)));
            }
        }

        arg6.setSurfaceSize-ozmzZPI(arg4);
        if(arg10.getSurfaceTextureListener() != arg6) {
            arg7.invoke(arg6);
            arg10.setSurfaceTextureListener(arg6);
        }

        arg10.setOpaque(arg8);
        if(arg9 != null) {
            v4 = arg6.getMatrix();
            AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(v4, arg9);
        }
        else {
            v4 = null;
        }

        arg10.setTransform(v4);
        return Unit.INSTANCE;
    }

    static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(Modifier arg10, boolean arg11, long arg12, float[] arg14, Function1 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface-sv6N_fY(arg10, arg11, arg12, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    public static final void AndroidExternalSurface-58FFMhA(Modifier arg20, boolean arg21, long arg22, int arg24, boolean arg25, Function1 arg26, Composer arg27, int arg28, int arg29) {
        int v5_3;
        boolean v2_4;
        long v3_1;
        boolean v17;
        long v4_2;
        AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2 v2_3;
        AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0 v5_2;
        Companion v10_1;
        Modifier v1_2;
        int v18;
        boolean v13;
        int v16;
        int v15;
        long v11;
        int v9;
        boolean v6;
        Modifier v2;
        int v3;
        Function1 v7 = arg26;
        int v8 = arg28;
        Composer v14 = arg27.startRestartGroup(0x2633308E);
        ComposerKt.sourceInformation(v14, "C(AndroidExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,zOrder:c#foundation.AndroidExternalSurfaceZOrder,isSecure,onInit)275@12030L37,278@12104L150,285@12303L2,286@12324L774,277@12073L1032:AndroidExternalSurface.android.kt#71ulvw");
        int v1 = arg29 & 1;
        if(v1 != 0) {
            v3 = v8 | 6;
            v2 = arg20;
        }
        else if((v8 & 6) == 0) {
            v2 = arg20;
            v3 = v14.changed(v2) ? 4 : 2;
            v3 |= v8;
        }
        else {
            v2 = arg20;
            v3 = v8;
        }

        int v4 = arg29 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_39;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg21;
            v9 = v14.changed(v6) ? 0x20 : 16;
            v3 |= v9;
        }
        else {
        label_39:
            v6 = arg21;
        }

        if((v8 & 0x180) == 0) {
            v11 = arg22;
            v9 = (arg29 & 4) != 0 || !v14.changed(v11) ? 0x80 : 0x100;
            v3 |= v9;
        }
        else {
            v11 = arg22;
        }

        v9 = arg29 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_67;
        }
        else if((v8 & 0xC00) == 0) {
            v15 = arg24;
            v16 = v14.changed(v15) ? 0x800 : 0x400;
            v3 |= v16;
        }
        else {
        label_67:
            v15 = arg24;
        }

        v16 = arg29 & 16;
        if(v16 != 0) {
            v3 |= 0x6000;
            goto label_82;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg25;
            v18 = v14.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v18;
        }
        else {
        label_82:
            v13 = arg25;
        }

        if((v8 & 0x30000) == 0) {
            v18 = v14.changedInstance(v7) ? 0x20000 : 0x10000;
            v3 |= v18;
        }

        int v0 = 0;
        boolean v5 = (v3 & 74899) != 74898 ? true : false;
        if(v14.shouldExecute(v5, v3 & 1)) {
            v14.startDefaults();
            if((v8 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v1 != 0) {
                    Companion v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                if(v4 != 0) {
                    v6 = true;
                }

                if((arg29 & 4) != 0) {
                    v3 &= -897;
                    v11 = IntSize.Companion.getZero-YbymL2g();
                }

                if(v9 != 0) {
                    v15 = AndroidExternalSurfaceZOrder.Companion.getBehind-B_4ceCc();
                }

                if(v16 != 0) {
                    v13 = false;
                }

                v10_1 = ((Companion)v1_2);
            }
            else {
                v14.skipToGroupEnd();
                if((arg29 & 4) != 0) {
                    v3 &= -897;
                }

                Modifier v10 = v2;
            }

            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2633308E, v3, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
            }

            AndroidExternalSurfaceState v1_3 = AndroidExternalSurface_androidKt.rememberAndroidExternalSurfaceState(v14, 0);
            String v4_1 = "CC(remember):AndroidExternalSurface.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0x66297684, v4_1);
            int v2_1 = (0x70000 & v3) == 0x20000 ? 1 : 0;
            v2_1 |= v14.changedInstance(v1_3);
            Object v5_1 = v14.rememberedValue();
            if(v2_1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0(v7, v1_3);
                v14.updateRememberedValue(v5_2);
            }

            Object v9_1 = v5_2;
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x66298ED0, v4_1);
            Object v1_4 = v14.rememberedValue();
            if(v1_4 == Composer.Companion.getEmpty()) {
                AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1 v1_5 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1();
                v14.updateRememberedValue(v1_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 1714001012, v4_1);
            v4 = 0x100;
            v2_1 = (v3 & 0x380 ^ 0x180) > v4 && (v14.changed(v11)) || (v3 & 0x180) == v4 ? 1 : 0;
            v4 = (v3 & 0x70) == 0x20 ? 1 : 0;
            v2_1 |= v4;
            v4 = (v3 & 0x1C00) == 0x800 ? 1 : 0;
            v2_1 |= v4;
            if((0xE000 & v3) == 0x4000) {
                v0 = 1;
            }

            v0 |= v2_1;
            Object v2_2 = v14.rememberedValue();
            if(v0 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                v2_3 = new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2(v11, v6, v15, v13);
                v4_2 = v11;
                v0 = v15;
                v17 = v13;
                v14.updateRememberedValue(v2_3);
            }
            else {
                v4_2 = v11;
                v17 = v13;
                v0 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            AndroidView_androidKt.AndroidView(((Function1)v9_1), ((Modifier)v10_1), v1_4, null, v2_3, v14, v3 << 3 & 0x70 | 0x180, 8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v4_2;
            v2_4 = v6;
            v1_2 = ((Modifier)v10_1);
            v6 = v17;
            v5_3 = v0;
        }
        else {
            v14.skipToGroupEnd();
            v1_2 = v2;
            v2_4 = v6;
            v3_1 = v11;
            v6 = v13;
            v5_3 = v15;
        }

        ScopeUpdateScope v10_2 = v14.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3(v1_2, v2_4, v3_1, v5_3, v6, v7, v8, arg29));
        }
    }

    private static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$0$0(Function1 arg1, AndroidExternalSurfaceState arg2, Context arg3) {
        SurfaceView v0 = new SurfaceView(arg3);
        arg1.invoke(arg2);
        v0.getHolder().addCallback(((SurfaceHolder$Callback)arg2));
        return v0;
    }

    private static final Unit AndroidExternalSurface_58FFMhA$lambda$1$0(SurfaceView arg0) {
        return Unit.INSTANCE;
    }

    private static final Unit AndroidExternalSurface_58FFMhA$lambda$2$0(long arg4, boolean arg6, int arg7, boolean arg8, SurfaceView arg9) {
        if(!IntSize.equals-impl0(arg4, IntSize.Companion.getZero-YbymL2g())) {
            arg9.getHolder().setFixedSize(((int)(arg4 >> 0x20)), ((int)(arg4 & 0xFFFFFFFFL)));
        }
        else {
            arg9.getHolder().setSizeFromLayout();
        }

        SurfaceHolder v4 = arg9.getHolder();
        int v5 = arg6 ? -1 : -3;
        v4.setFormat(v5);
        if(AndroidExternalSurfaceZOrder.equals-impl0(arg7, AndroidExternalSurfaceZOrder.Companion.getBehind-B_4ceCc())) {
            arg9.setZOrderOnTop(false);
        }
        else if(AndroidExternalSurfaceZOrder.equals-impl0(arg7, AndroidExternalSurfaceZOrder.Companion.getMediaOverlay-B_4ceCc())) {
            arg9.setZOrderMediaOverlay(true);
        }
        else if(AndroidExternalSurfaceZOrder.equals-impl0(arg7, AndroidExternalSurfaceZOrder.Companion.getOnTop-B_4ceCc())) {
            arg9.setZOrderOnTop(true);
        }

        arg9.setSecure(arg8);
        return Unit.INSTANCE;
    }

    static final Unit AndroidExternalSurface_58FFMhA$lambda$3(Modifier arg11, boolean arg12, long arg13, int arg15, boolean arg16, Function1 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AndroidExternalSurface_androidKt.AndroidExternalSurface-58FFMhA(arg11, arg12, arg13, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer arg3, int arg4) {
        CoroutineScope v4_1;
        int v1 = 0xC0F8CA83;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberAndroidEmbeddedExternalSurfaceState)371@14901L24,372@14937L55:AndroidExternalSurface.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(arg3, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, arg3);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, 0x65F0479A, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object v0 = arg3.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            AndroidEmbeddedExternalSurfaceState v0_1 = new AndroidEmbeddedExternalSurfaceState(v4_1);
            arg3.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((AndroidEmbeddedExternalSurfaceState)v0);
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer arg3, int arg4) {
        AndroidExternalSurfaceState v0_1;
        CoroutineScope v4_1;
        int v1 = 0xCBEDADC3;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberAndroidExternalSurfaceState)188@7180L24,189@7216L47:AndroidExternalSurface.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
        }

        ComposerKt.sourceInformationMarkerStart(arg3, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(arg3, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
        Object v4 = arg3.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, arg3);
            arg3.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, -2026284846, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object v0 = arg3.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = new AndroidExternalSurfaceState(v4_1);
            arg3.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }
}

