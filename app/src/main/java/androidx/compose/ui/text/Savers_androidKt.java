package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextMotion$Linearity;
import androidx.compose.ui.text.style.TextMotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"$\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\n\" \u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r\"$\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u000F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0010\"\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0014\"\u001A\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0018\"\u001A\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "getSaver", "(Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "PlatformParagraphStyleSaver", "Landroidx/compose/ui/text/EmojiSupportMatch;", "Landroidx/compose/ui/text/EmojiSupportMatch$Companion;", "(Landroidx/compose/ui/text/EmojiSupportMatch$Companion;)Landroidx/compose/runtime/saveable/Saver;", "emojiSupportMatchSaver", "getEmojiSupportMatchSaver", "()Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/LineBreak;", "Landroidx/compose/ui/text/style/LineBreak$Companion;", "(Landroidx/compose/ui/text/style/LineBreak$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineBreakSaver", "Landroidx/compose/ui/text/style/TextMotion;", "Landroidx/compose/ui/text/style/TextMotion$Companion;", "(Landroidx/compose/ui/text/style/TextMotion$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextMotionSaver", "Landroidx/compose/ui/text/style/TextMotion$Linearity;", "Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;", "(Landroidx/compose/ui/text/style/TextMotion$Linearity$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextMotionLinearitySaver", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Savers_androidKt {
    private static final Saver LineBreakSaver;
    private static final Saver PlatformParagraphStyleSaver;
    private static final Saver TextMotionLinearitySaver;
    private static final Saver TextMotionSaver;
    private static final Saver emojiSupportMatchSaver;

    static {
        Savers_androidKt.PlatformParagraphStyleSaver = SaverKt.Saver(new Savers_androidKt$$ExternalSyntheticLambda0(), new Savers_androidKt$$ExternalSyntheticLambda1());
        Savers_androidKt.emojiSupportMatchSaver = SaverKt.Saver(new Savers_androidKt$$ExternalSyntheticLambda2(), new Savers_androidKt$$ExternalSyntheticLambda3());
        Savers_androidKt.LineBreakSaver = SaverKt.Saver(new Savers_androidKt$$ExternalSyntheticLambda4(), new Savers_androidKt$$ExternalSyntheticLambda5());
        Savers_androidKt.TextMotionSaver = SaverKt.Saver(new Savers_androidKt$$ExternalSyntheticLambda6(), new Savers_androidKt$$ExternalSyntheticLambda7());
        Savers_androidKt.TextMotionLinearitySaver = SaverKt.Saver(new Savers_androidKt$$ExternalSyntheticLambda8(), new Savers_androidKt$$ExternalSyntheticLambda9());
    }

    static final Object LineBreakSaver$lambda$0(SaverScope arg0, LineBreak arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final LineBreak LineBreakSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return LineBreak.box-impl(LineBreak.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object PlatformParagraphStyleSaver$lambda$0(SaverScope arg2, PlatformParagraphStyle arg3) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Boolean.valueOf(arg3.getIncludeFontPadding())), SaversKt.save(EmojiSupportMatch.box-impl(arg3.getEmojiSupportMatch-_3YsG6Y()), Savers_androidKt.getSaver(EmojiSupportMatch.Companion), arg2)});
    }

    static final PlatformParagraphStyle PlatformParagraphStyleSaver$lambda$1(Object arg4) {
        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Object v1 = ((List)arg4).get(0);
        DefaultConstructorMarker v2 = null;
        if(v1 != null) {
        }
        else {
            v1 = v2;
        }

        Intrinsics.checkNotNull(v1);
        boolean v1_1 = ((Boolean)v1).booleanValue();
        arg4 = ((List)arg4).get(1);
        Saver v3 = Savers_androidKt.getSaver(EmojiSupportMatch.Companion);
        if((Intrinsics.areEqual(arg4, Boolean.valueOf(false))) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_23;
        }
        else if(arg4 != null) {
            arg4 = v3.restore(arg4);
        }
        else {
        label_23:
            arg4 = v2;
        }

        Intrinsics.checkNotNull(arg4);
        return new PlatformParagraphStyle(((EmojiSupportMatch)arg4).unbox-impl(), v1_1, v2);
    }

    static final Object TextMotionLinearitySaver$lambda$0(SaverScope arg0, Linearity arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final Linearity TextMotionLinearitySaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return Linearity.box-impl(Linearity.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object TextMotionSaver$lambda$0(SaverScope arg2, TextMotion arg3) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Linearity.box-impl(arg3.getLinearity-4e0Vf04$ui_text()), Savers_androidKt.getSaver(Linearity.Companion), arg2), SaversKt.save(Boolean.valueOf(arg3.getSubpixelTextPositioning$ui_text()))});
    }

    static final TextMotion TextMotionSaver$lambda$1(Object arg5) {
        Object v1;
        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Object v2 = ((List)arg5).get(0);
        Saver v3 = Savers_androidKt.getSaver(Linearity.Companion);
        DefaultConstructorMarker v4 = null;
        if((Intrinsics.areEqual(v2, Boolean.valueOf(false))) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v2 != null) {
            v1 = v3.restore(v2);
        }
        else {
        label_17:
            v1 = v4;
        }

        Intrinsics.checkNotNull(v1);
        int v1_1 = ((Linearity)v1).unbox-impl();
        arg5 = ((List)arg5).get(1);
        if(arg5 != null) {
        }
        else {
            arg5 = v4;
        }

        Intrinsics.checkNotNull(arg5);
        return new TextMotion(v1_1, ((Boolean)arg5).booleanValue(), v4);
    }

    static final Object emojiSupportMatchSaver$lambda$0(SaverScope arg0, EmojiSupportMatch arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final EmojiSupportMatch emojiSupportMatchSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return EmojiSupportMatch.box-impl(EmojiSupportMatch.constructor-impl(((Integer)arg1).intValue()));
    }

    public static final Saver getEmojiSupportMatchSaver() {
        return Savers_androidKt.emojiSupportMatchSaver;
    }

    public static final Saver getSaver(Companion arg0) {
        return Savers_androidKt.PlatformParagraphStyleSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.LineBreak$Companion arg0) {
        return Savers_androidKt.LineBreakSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextMotion$Companion arg0) {
        return Savers_androidKt.TextMotionSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.EmojiSupportMatch$Companion arg0) {
        return Savers_androidKt.emojiSupportMatchSaver;
    }

    private static final Saver getSaver(androidx.compose.ui.text.style.TextMotion$Linearity$Companion arg0) {
        return Savers_androidKt.TextMotionLinearitySaver;
    }
}

