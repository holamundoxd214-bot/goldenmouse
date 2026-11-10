package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nJ\u0015\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0003¢\u0006\u0002\u0010\u000EJ\u0015\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/TextContextMenuHelperApi28;", "", "<init>", "()V", "textClassificationItem", "", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "context", "Landroid/content/Context;", "component", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuTextClassificationItem;", "IconBox", "icon", "Landroid/graphics/drawable/Icon;", "(Landroid/graphics/drawable/Icon;Landroidx/compose/runtime/Composer;I)V", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextContextMenuHelperApi28 {
    public static final TextContextMenuHelperApi28 INSTANCE;

    public static Unit $r8$lambda$OiLaLJEfuZFbev2c6XR_takxCWA(Drawable arg0, DrawScope arg1) {
        return TextContextMenuHelperApi28.IconBox$lambda$3$0(arg0, arg1);
    }

    static {
        TextContextMenuHelperApi28.INSTANCE = new TextContextMenuHelperApi28();
    }

    private TextContextMenuHelperApi28() {
        super();
    }

    private final void IconBox(Drawable arg6, Composer arg7, int arg8) {
        int v1;
        int v0 = 0xF5CAF94;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(IconBox)N(drawable)276@10890L217,275@10822L295:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        int v2 = 2;
        if((arg8 & 6) == 0) {
            v1 = arg7.changedInstance(arg6) ? 4 : v2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg7.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:274)");
            }

            Modifier v0_1 = SizeKt.size-3ABfNKs(Modifier.Companion, ContextMenuSpec.INSTANCE.getIconSize-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(arg7, 0xAAEF292D, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            boolean v1_1 = arg7.changedInstance(arg6);
            Object v2_2 = arg7.rememberedValue();
            if((v1_1) || v2_2 == Composer.Companion.getEmpty()) {
                TextContextMenuHelperApi28$$ExternalSyntheticLambda6 v2_3 = new TextContextMenuHelperApi28$$ExternalSyntheticLambda6(arg6);
                arg7.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            BoxKt.Box(DrawModifierKt.drawBehind(v0_1, ((Function1)v2_2)), arg7, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_53;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_53:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new TextContextMenuHelperApi28$$ExternalSyntheticLambda7(this, arg6, arg8));
        }
    }

    private final void IconBox(Icon arg5, Composer arg6, int arg7) {
        ScopeUpdateScope v6;
        int v2;
        int v1;
        int v0 = 2116504409;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(IconBox)N(icon)268@10623L7,269@10654L54,270@10727L17:DefaultTextContextMenuDropdownProvider.android.kt#18dpbw");
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg5) ? 4 : 2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            v2 = arg6.changed(this) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:267)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg6.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg6);
            ComposerKt.sourceInformationMarkerStart(arg6, 0x9181E4CF, "CC(remember):DefaultTextContextMenuDropdownProvider.android.kt#9igjgp");
            v2 = arg6.changed(arg5) | arg6.changed(v0_2);
            Object v3 = arg6.rememberedValue();
            if(v2 != 0 || v3 == Composer.Companion.getEmpty()) {
                Drawable v3_1 = arg5.loadDrawable(((Context)v0_2));
                arg6.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg6);
            if(v3 == null) {
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v6 = arg6.endRestartGroup();
                if(v6 == null) {
                    return;
                }

                TextContextMenuHelperApi28$$ExternalSyntheticLambda0 v0_3 = new TextContextMenuHelperApi28$$ExternalSyntheticLambda0(this, arg5, arg7);
                goto label_64;
            }

            this.IconBox(((Drawable)v3), arg6, v1 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_73;
            }

            ComposerKt.traceEventEnd();
            goto label_73;
        }
        else {
            arg6.skipToGroupEnd();
        label_73:
            v6 = arg6.endRestartGroup();
            if(v6 == null) {
                return;
            }

            TextContextMenuHelperApi28$$ExternalSyntheticLambda1 v0_4 = new TextContextMenuHelperApi28$$ExternalSyntheticLambda1(this, arg5, arg7);
        label_64:
            v6.updateScope(((Function2)v0_4));
            return;
        }
    }

    static final Unit IconBox$lambda$1(TextContextMenuHelperApi28 arg0, Icon arg1, int arg2, Composer arg3, int arg4) {
        arg0.IconBox(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit IconBox$lambda$2(TextContextMenuHelperApi28 arg0, Icon arg1, int arg2, Composer arg3, int arg4) {
        arg0.IconBox(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconBox$lambda$3$0(Drawable arg6, DrawScope arg7) {
        Canvas v0 = arg7.getDrawContext().getCanvas();
        arg6.setBounds(0, 0, ((int)Float.intBitsToFloat(((int)(arg7.getSize-NH-jbRc() >> 0x20)))), ((int)Float.intBitsToFloat(((int)(arg7.getSize-NH-jbRc() & 0xFFFFFFFFL)))));
        arg6.draw(AndroidCanvas_androidKt.getNativeCanvas(v0));
        return Unit.INSTANCE;
    }

    static final Unit IconBox$lambda$4(TextContextMenuHelperApi28 arg0, Drawable arg1, int arg2, Composer arg3, int arg4) {
        arg0.IconBox(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$IconBox(TextContextMenuHelperApi28 arg0, Drawable arg1, Composer arg2, int arg3) {
        arg0.IconBox(arg1, arg2, arg3);
    }

    public static final void access$IconBox(TextContextMenuHelperApi28 arg0, Icon arg1, Composer arg2, int arg3) {
        arg0.IconBox(arg1, arg2, arg3);
    }

    public final void textClassificationItem(ContextMenuScope arg22, Context arg23, TextContextMenuTextClassificationItem arg24) {
        Context v0 = arg23;
        if(v0 == null) {
            return;
        }

        int v1 = arg24.getIndex();
        TextClassification v2 = arg24.getTextClassification();
        ComposableLambda v3 = null;
        if(v1 < 0) {
            TextContextMenuHelperApi28$$ExternalSyntheticLambda2 v6 = new TextContextMenuHelperApi28$$ExternalSyntheticLambda2(v2);
            Drawable v1_1 = v2.getIcon();
            if(v1_1 != null) {
                v3 = ComposableLambdaKt.composableLambdaInstance(0xBD0CF585, true, new TextContextMenuHelperApi28$textClassificationItem$2$1(v1_1));
            }

            ContextMenuScope.item$default(arg22, ((Function2)v6), null, false, v3, new TextContextMenuHelperApi28$$ExternalSyntheticLambda3(v0, v2), 6, null);
            return;
        }

        Object v0_1 = v2.getActions().get(v1);
        v1 = v1 == 0 ? 1 : 0;
        TextContextMenuHelperApi28$$ExternalSyntheticLambda4 v14 = new TextContextMenuHelperApi28$$ExternalSyntheticLambda4(((RemoteAction)v0_1));
        if(v1 != 0 || (((RemoteAction)v0_1).shouldShowIcon())) {
            v3 = ComposableLambdaKt.composableLambdaInstance(0xB4D406E8, true, new TextContextMenuHelperApi28$textClassificationItem$5(((RemoteAction)v0_1)));
        }

        ContextMenuScope.item$default(arg22, ((Function2)v14), null, false, v3, new TextContextMenuHelperApi28$$ExternalSyntheticLambda5(((RemoteAction)v0_1)), 6, null);
    }

    static final String textClassificationItem$lambda$0(TextClassification arg3, Composer arg4, int arg5) {
        int v0 = 950061013;
        arg4.startReplaceGroup(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:246)");
        }

        String v3 = String.valueOf(arg3.getLabel());
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg4.endReplaceGroup();
        return v3;
    }

    static final Unit textClassificationItem$lambda$2(Context arg1, TextClassification arg2) {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final String textClassificationItem$lambda$3(RemoteAction arg3, Composer arg4, int arg5) {
        int v0 = 0xADF2D8EC;
        arg4.startReplaceGroup(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.textClassificationItem.<anonymous> (DefaultTextContextMenuDropdownProvider.android.kt:254)");
        }

        String v3 = arg3.getTitle().toString();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg4.endReplaceGroup();
        return v3;
    }

    static final Unit textClassificationItem$lambda$4(RemoteAction arg1) {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(arg1.getActionIntent());
        return Unit.INSTANCE;
    }
}

