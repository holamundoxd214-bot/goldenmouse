package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001As\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u0014\b\u0002\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000F2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000FH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2={"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ClickableTextKt {
    public static Unit $r8$lambda$07dfqW0g2v-7i7yzLp4WWuLvtEs(TextLayoutResult arg0) {
        return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0(arg0);
    }

    public static Unit $r8$lambda$ZQKvYAmftr9X0YapjDpBgn7jTcU(MutableState arg0, Function1 arg1, TextLayoutResult arg2) {
        return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(arg0, arg1, arg2);
    }

    @Deprecated(message="Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation. Check LinkAnnotation\'s documentation for more details and samples.") public static final void ClickableText-4YKlhWE(AnnotatedString arg26, Modifier arg27, TextStyle arg28, boolean arg29, int arg30, int arg31, Function1 arg32, Function1 arg33, Composer arg34, int arg35, int arg36) {
        boolean v4_3;
        TextStyle v3_2;
        Object v7_2;
        Composer v21;
        ClickableTextKt$$ExternalSyntheticLambda1 v6_3;
        ClickableTextKt$ClickableText$pressIndicator$1$1 v11_2;
        Object v0_3;
        int v19;
        Function1 v0;
        int v3;
        int v15;
        int v14;
        int v13;
        int v11;
        TextStyle v7;
        int v6;
        Modifier v5;
        int v2;
        Function1 v8 = arg33;
        int v9 = arg35;
        Composer v1 = arg34.startRestartGroup(0xF14D09D7);
        ComposerKt.sourceInformation(v1, "C(ClickableText)N(text,modifier,style,softWrap,overflow:c#ui.text.style.TextOverflow,maxLines,onTextLayout,onClick)77@3766L2,80@3825L52,82@3942L208,97@4371L76,90@4156L298:ClickableText.kt#423gt5");
        AnnotatedString v10 = arg26;
        if((v9 & 6) == 0) {
            v2 = v1.changed(v10) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        int v4 = arg36 & 2;
        if(v4 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v9 & 0x30) == 0) {
            v5 = arg27;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_32:
            v5 = arg27;
        }

        v6 = arg36 & 4;
        if(v6 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg28;
            v11 = v1.changed(v7) ? 0x100 : 0x80;
            v2 |= v11;
        }
        else {
        label_47:
            v7 = arg28;
        }

        v11 = arg36 & 8;
        if(v11 != 0) {
            v2 |= 0xC00;
        }
        else if((v9 & 0xC00) == 0) {
            v13 = v1.changed(arg29) ? 0x800 : 0x400;
            v2 |= v13;
        }

        v13 = arg36 & 16;
        if(v13 != 0) {
            v2 |= 0x6000;
            goto label_77;
        }
        else if((v9 & 0x6000) == 0) {
            v14 = arg30;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v2 |= v15;
        }
        else {
        label_77:
            v14 = arg30;
        }

        v15 = arg36 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            v3 = arg31;
            if((v9 & v16) == 0) {
                v16 = v1.changed(v3) ? 0x20000 : 0x10000;
                v2 |= v16;
            }
        }

        v16 = arg36 & 0x40;
        int v18 = 0x180000;
        if(v16 != 0) {
            v2 |= v18;
        }
        else {
            v0 = arg32;
            if((v9 & v18) == 0) {
                v19 = v1.changedInstance(v0) ? 0x100000 : 0x80000;
                v2 |= v19;
            }
        }

        if((v9 & 0xC00000) == 0) {
            v19 = v1.changedInstance(v8) ? 0x800000 : 0x400000;
            v2 |= v19;
        }

        v19 = 0;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v4 != 0) {
                Companion v5_1 = Modifier.Companion;
            }

            TextStyle v12 = v6 != 0 ? TextStyle.Companion.getDefault() : v7;
            int v0_2 = v15;
            boolean v15_1 = v11 != 0 ? true : arg29;
            if(v13 != 0) {
                v14 = TextOverflow.Companion.getClip-gIe3tQ8();
            }

            if(v0_2 != 0) {
                int v25 = v16;
                v16 = 0x7FFFFFFF;
                v0_2 = v25;
            }
            else {
                v0_2 = v16;
                v16 = arg31;
            }

            String v3_1 = "CC(remember):ClickableText.kt#9igjgp";
            if(v0_2 != 0) {
                ComposerKt.sourceInformationMarkerStart(v1, -768470151, v3_1);
                v0_3 = v1.rememberedValue();
                if(v0_3 == Composer.Companion.getEmpty()) {
                    ClickableTextKt$$ExternalSyntheticLambda0 v0_4 = new ClickableTextKt$$ExternalSyntheticLambda0();
                    v1.updateRememberedValue(v0_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
            }
            else {
                v0 = arg32;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF14D09D7, v2, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
            }

            ComposerKt.sourceInformationMarkerStart(v1, 0xD2321B0B, v3_1);
            Object v4_1 = v1.rememberedValue();
            if(v4_1 == Composer.Companion.getEmpty()) {
                MutableState v4_2 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                v1.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            Companion v6_1 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v1, 0xD2322A47, v3_1);
            int v7_1 = (0x1C00000 & v2) == 0x800000 ? 1 : 0;
            Object v11_1 = v1.rememberedValue();
            if(v7_1 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v11_2 = new ClickableTextKt$ClickableText$pressIndicator$1$1(((MutableState)v4_1), v8);
                v1.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            Modifier v11_3 = v5.then(SuspendingPointerInputFilterKt.pointerInput(((Modifier)v6_1), v8, ((PointerInputEventHandler)v11_2)));
            ComposerKt.sourceInformationMarkerStart(v1, 0xD2325F63, v3_1);
            v3 = 0x380000;
            if((v2 & v3) == 0x100000) {
                v19 = 1;
            }

            Object v6_2 = v1.rememberedValue();
            if(v19 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = new ClickableTextKt$$ExternalSyntheticLambda1(((MutableState)v4_1), ((Function1)v0_3));
                v1.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v21 = v1;
            BasicTextKt.BasicText-CL7eQgs(v10, v11_3, v12, v6_3, v14, v15_1, v16, 0, null, null, null, v21, 0xE38E & v2 | 0x70000 & v2 << 6 | v2 << 3 & v3, 0, 0x780);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_2 = v0_3;
            v3_2 = v12;
            v4_3 = v15_1;
            v6 = v16;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v4_3 = arg29;
            v6 = arg31;
            v3_2 = v7;
            Function1 v7_3 = arg32;
        }

        Modifier v2_1 = v5;
        int v5_2 = v14;
        ScopeUpdateScope v11_4 = v21.endRestartGroup();
        if(v11_4 != null) {
            v11_4.updateScope(new ClickableTextKt$$ExternalSyntheticLambda2(arg26, v2_1, v3_2, v4_3, v5_2, v6, ((Function1)v7_2), v8, v9, arg36));
        }
    }

    private static final Unit ClickableText_4YKlhWE$lambda$0$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    private static final Unit ClickableText_4YKlhWE$lambda$3$0(MutableState arg0, Function1 arg1, TextLayoutResult arg2) {
        arg0.setValue(arg2);
        arg1.invoke(arg2);
        return Unit.INSTANCE;
    }

    static final Unit ClickableText_4YKlhWE$lambda$4(AnnotatedString arg12, Modifier arg13, TextStyle arg14, boolean arg15, int arg16, int arg17, Function1 arg18, Function1 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        ClickableTextKt.ClickableText-4YKlhWE(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }
}

