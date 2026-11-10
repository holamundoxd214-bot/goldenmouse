package androidx.compose.foundation.text;

import android.os.Build$VERSION;
import android.os.Trace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\u001A%\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001A;\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0014\u0010\u000F\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0013\u001A\u0010\u0010 \u001A\u00020\u00192\u0006\u0010!\u001A\u00020\u0015H\u0000\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0014\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0016\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001A\"\u001A\u0010\u001B\u001A\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006\""}, d2={"LocalBackgroundTextMeasurementExecutor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Ljava/util/concurrent/Executor;", "getLocalBackgroundTextMeasurementExecutor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "BackgroundTextMeasurement", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/text/AnnotatedString;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "PrefetchTextMinimumCoreCount", "", "MinTextLengthThreshold", "MaxTextLengthThreshold", "backingCoreCountSatisfactory", "", "Ljava/lang/Boolean;", "coreCountSatisfactory", "getCoreCountSatisfactory$annotations", "()V", "getCoreCountSatisfactory", "()Z", "shouldPrefetch", "textLength", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicText_androidKt {
    private static final ProvidableCompositionLocal LocalBackgroundTextMeasurementExecutor = null;
    private static final int MaxTextLengthThreshold = 1000;
    private static final int MinTextLengthThreshold = 8;
    private static final int PrefetchTextMinimumCoreCount = 4;
    private static Boolean backingCoreCountSatisfactory;

    public static void $r8$lambda$We-G6SGsxBngQmyXVRoHa2kpcgY(TextStyle arg0, LayoutDirection arg1, List arg2, AnnotatedString arg3, Density arg4, Resolver arg5) {
        BasicText_androidKt.BackgroundTextMeasurement$lambda$1$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void $r8$lambda$rKgaeRcqybJrgIJfnkZ6EYMVkOs(TextStyle arg0, LayoutDirection arg1, String arg2, Density arg3, Resolver arg4) {
        BasicText_androidKt.BackgroundTextMeasurement$lambda$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    static {
        BasicText_androidKt.LocalBackgroundTextMeasurementExecutor = CompositionLocalKt.staticCompositionLocalOf(new BasicText_androidKt$$ExternalSyntheticLambda1());
    }

    public static final void BackgroundTextMeasurement(AnnotatedString arg13, TextStyle arg14, Resolver arg15, List arg16, Composer arg17, int arg18) {
        Composer v0 = arg17;
        int v1 = arg18;
        int v3 = -650368117;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(BackgroundTextMeasurement)N(text,style,fontFamilyResolver,placeholders)103@4490L7:BasicText.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.foundation.text.BackgroundTextMeasurement (BasicText.android.kt:102)");
        }

        ProvidableCompositionLocal v2 = BasicText_androidKt.LocalBackgroundTextMeasurementExecutor;
        v3 = 0x789C5F52;
        String v4 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v0, v3, v4);
        Object v2_1 = v0.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(v0);
        if(v2_1 == null || !BasicText_androidKt.shouldPrefetch(arg13.length())) {
            v0.startReplaceGroup(0xE0CEEAF7);
        }
        else {
            v0.startReplaceGroup(0xE11452EE);
            ComposerKt.sourceInformation(v0, "105@4608L7,106@4651L7,109@4703L732");
            ProvidableCompositionLocal v5 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v0, v3, v4);
            Object v5_1 = v0.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v0);
            Object v8 = v5_1;
            v5 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v0, v3, v4);
            Object v3_1 = v0.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v0);
            Object v11 = v3_1;
            try {
                ComposerKt.sourceInformationMarkerStart(v0, 2061480263, "CC(remember):BasicText.android.kt#9igjgp");
                int v4_1 = 0;
                int v6 = 0x20;
                v3 = (v1 & 0x70 ^ 0x30) > v6 && (v0.changed(arg14)) || (v1 & 0x30) == v6 ? 1 : 0;
                List v9 = arg16;
                v3 = v3 | v0.changed(v8.ordinal()) | v0.changedInstance(v9);
                int v7 = 4;
                if((v1 & 14 ^ 6) > v7 && (v0.changed(arg13)) || (v1 & 6) == v7) {
                    v4_1 = 1;
                }

                v1 = v3 | v4_1 | v0.changed(v11) | v0.changedInstance(arg15);
                v3_1 = v0.rememberedValue();
                if(v1 == 0 && v3_1 != Composer.Companion.getEmpty()) {
                label_83:
                    ComposerKt.sourceInformationMarkerEnd(v0);
                    ((Executor)v2_1).execute(((Runnable)v3_1));
                    goto label_88;
                }

                BasicText_androidKt$$ExternalSyntheticLambda0 v6_1 = new BasicText_androidKt$$ExternalSyntheticLambda0(arg14, ((LayoutDirection)v8), v9, arg13, ((Density)v11), arg15);
                v0.updateRememberedValue(v6_1);
                BasicText_androidKt$$ExternalSyntheticLambda0 v3_2 = v6_1;
                goto label_83;
            }
            catch(RejectedExecutionException ) {
            }
        }

    label_88:
        v0.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
    }

    public static final void BackgroundTextMeasurement(String arg10, TextStyle arg11, Resolver arg12, Composer arg13, int arg14) {
        int v1 = 0x5EBBE35B;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(BackgroundTextMeasurement)N(text,style,fontFamilyResolver)69@3215L7:BasicText.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.foundation.text.BackgroundTextMeasurement (BasicText.android.kt:68)");
        }

        ProvidableCompositionLocal v0 = BasicText_androidKt.LocalBackgroundTextMeasurementExecutor;
        v1 = 0x789C5F52;
        String v2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg13, v1, v2);
        Object v0_1 = arg13.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg13);
        if(v0_1 == null || !BasicText_androidKt.shouldPrefetch(arg10.length())) {
            arg13.startReplaceGroup(0x4A909E87);
        }
        else {
            arg13.startReplaceGroup(0x4AC2B5DF);
            ComposerKt.sourceInformation(arg13, "71@3333L7,72@3376L7,75@3428L699");
            ProvidableCompositionLocal v3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(arg13, v1, v2);
            Object v3_1 = arg13.consume(((CompositionLocal)v3));
            ComposerKt.sourceInformationMarkerEnd(arg13);
            Object v6 = v3_1;
            v3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(arg13, v1, v2);
            Object v1_1 = arg13.consume(((CompositionLocal)v3));
            ComposerKt.sourceInformationMarkerEnd(arg13);
            Object v8 = v1_1;
            try {
                ComposerKt.sourceInformationMarkerStart(arg13, 0x9F50AC36, "CC(remember):BasicText.android.kt#9igjgp");
                int v2_1 = 0;
                int v4 = 0x20;
                v1 = (arg14 & 0x70 ^ 0x30) > v4 && (arg13.changed(arg11)) || (arg14 & 0x30) == v4 ? 1 : 0;
                v1 |= arg13.changed(v6.ordinal());
                int v5 = 4;
                if((arg14 & 14 ^ 6) > v5 && (arg13.changed(arg10)) || (arg14 & 6) == v5) {
                    v2_1 = 1;
                }

                arg14 = v1 | v2_1 | arg13.changed(v8) | arg13.changedInstance(arg12);
                v1_1 = arg13.rememberedValue();
                if(arg14 == 0 && v1_1 != Composer.Companion.getEmpty()) {
                label_78:
                    ComposerKt.sourceInformationMarkerEnd(arg13);
                    ((Executor)v0_1).execute(((Runnable)v1_1));
                    goto label_83;
                }

                BasicText_androidKt$$ExternalSyntheticLambda2 v4_1 = new BasicText_androidKt$$ExternalSyntheticLambda2(arg11, ((LayoutDirection)v6), arg10, ((Density)v8), arg12);
                arg13.updateRememberedValue(v4_1);
                BasicText_androidKt$$ExternalSyntheticLambda2 v1_2 = v4_1;
                goto label_78;
            }
            catch(RejectedExecutionException ) {
            }
        }

    label_83:
        arg13.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
    }

    private static final void BackgroundTextMeasurement$lambda$0$0(TextStyle arg12, LayoutDirection arg13, String arg14, Density arg15, Resolver arg16) {
        Snapshot v3;
        MutableSnapshot v2;
        MutableSnapshot v1;
        Trace.beginSection("BackgroundTextMeasurement");
        try {
            v1 = Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);
        }
        catch(Throwable v0) {
            goto label_39;
        }

        try {
            v2 = v1;
            v3 = ((Snapshot)v2).makeCurrent();
        }
        catch(Throwable v0) {
            goto label_31;
        }

        try {
            ParagraphIntrinsicsKt.ParagraphIntrinsics$default(arg14, TextStyleKt.resolveDefaults(arg12, arg13), CollectionsKt.emptyList(), arg15, arg16, null, 0x20, null).getMaxIntrinsicWidth();
            goto label_19;
        }
        catch(Throwable v0) {
            Throwable v12 = v0;
            try {
                ((Snapshot)v2).restoreCurrent(v3);
                throw v12;
            label_19:
                ((Snapshot)v2).restoreCurrent(v3);
                goto label_20;
            }
            catch(Throwable v0) {
            label_31:
                v12 = v0;
                try {
                    throw v12;
                }
                catch(Throwable v0) {
                    v12 = v0;
                    try {
                        v1.dispose();
                        throw v12;
                    label_20:
                        v1.apply().check();
                        v1.dispose();
                    }
                    catch(Throwable v0) {
                    label_39:
                        Trace.endSection();
                        throw v0;
                    }
                }
            }
        }

        Trace.endSection();
    }

    private static final void BackgroundTextMeasurement$lambda$1$0(TextStyle arg5, LayoutDirection arg6, List arg7, AnnotatedString arg8, Density arg9, Resolver arg10) {
        Snapshot v3;
        MutableSnapshot v2;
        MutableSnapshot v1;
        Trace.beginSection("BackgroundTextMeasurement");
        try {
            v1 = Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);
        }
        catch(Throwable v0) {
            goto label_40;
        }

        try {
            v2 = v1;
            v3 = ((Snapshot)v2).makeCurrent();
        }
        catch(Throwable v0) {
            goto label_32;
        }

        try {
            arg5 = TextStyleKt.resolveDefaults(arg5, arg6);
            if(arg7 == null) {
                arg7 = CollectionsKt.emptyList();
            }

            new MultiParagraphIntrinsics(arg8, arg5, arg7, arg9, arg10).getMaxIntrinsicWidth();
            goto label_20;
        }
        catch(Throwable v0) {
            Throwable v5 = v0;
            try {
                ((Snapshot)v2).restoreCurrent(v3);
                throw v5;
            label_20:
                ((Snapshot)v2).restoreCurrent(v3);
                goto label_21;
            }
            catch(Throwable v0) {
            label_32:
                v5 = v0;
                try {
                    throw v5;
                }
                catch(Throwable v0) {
                    v5 = v0;
                    try {
                        v1.dispose();
                        throw v5;
                    label_21:
                        v1.apply().check();
                        v1.dispose();
                    }
                    catch(Throwable v0) {
                    label_40:
                        Trace.endSection();
                        throw v0;
                    }
                }
            }
        }

        Trace.endSection();
    }

    static final Executor LocalBackgroundTextMeasurementExecutor$lambda$0() {
        return null;
    }

    public static final boolean getCoreCountSatisfactory() {
        Boolean v0 = BasicText_androidKt.backingCoreCountSatisfactory;
        if(v0 == null) {
            boolean v0_1 = Runtime.getRuntime().availableProcessors() >= 4 ? true : false;
            v0 = Boolean.valueOf(v0_1);
            BasicText_androidKt.backingCoreCountSatisfactory = v0;
        }

        Intrinsics.checkNotNull(v0);
        return v0.booleanValue();
    }

    public static void getCoreCountSatisfactory$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalBackgroundTextMeasurementExecutor() {
        return BasicText_androidKt.LocalBackgroundTextMeasurementExecutor;
    }

    public static final boolean shouldPrefetch(int arg2) {
        if(Build$VERSION.SDK_INT >= 28 && arg2 >= 8 && arg2 < 1000 && (BasicText_androidKt.getCoreCountSatisfactory())) {
            return 1;
        }

        return 0;
    }
}

