package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0014\u0010\u0006\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u0007\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001F\u0010\u0006\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001D\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0017R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u001EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020*8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020*8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010,R\u0010\u0010/\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001A\u0002028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b4\u00105R\u0014\u00106\u001A\u000207X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b8\u00109¨\u0006:"}, d2={"Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;)V", "getText", "()Ljava/lang/String;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getAnnotations", "()Ljava/util/List;", "getPlaceholders", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "charSequence", "", "getCharSequence$ui_text", "()Ljava/lang/CharSequence;", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics$ui_text", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "resolvedTypefaces", "Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "emojiCompatProcessed", "", "hasStaleResolvedFonts", "getHasStaleResolvedFonts", "()Z", "textDirectionHeuristic", "", "getTextDirectionHeuristic$ui_text", "()I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    public static final int $stable = 8;
    private final List annotations;
    private final CharSequence charSequence;
    private final Density density;
    private final boolean emojiCompatProcessed;
    private final Resolver fontFamilyResolver;
    private final LayoutIntrinsics layoutIntrinsics;
    private final List placeholders;
    private TypefaceDirtyTrackerLinkedList resolvedTypefaces;
    private final TextStyle style;
    private final String text;
    private final int textDirectionHeuristic;
    private final AndroidTextPaint textPaint;

    static {
    }

    public AndroidParagraphIntrinsics(String arg10, TextStyle arg11, List arg12, List arg13, Resolver arg14, Density arg15) {
        ArrayList v11_3;
        Range v14;
        Object v2;
        super();
        this.text = arg10;
        this.style = arg11;
        this.annotations = arg12;
        this.placeholders = arg13;
        this.fontFamilyResolver = arg14;
        this.density = arg15;
        AndroidTextPaint v10 = new AndroidTextPaint(1, arg15.getDensity());
        this.textPaint = v10;
        boolean v13 = !AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(arg11) ? false : EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue();
        this.emojiCompatProcessed = v13;
        this.textDirectionHeuristic = AndroidParagraphIntrinsics_androidKt.resolveTextDirectionHeuristics-HklW4sA(arg11.getTextDirection-s_7X-co(), arg11.getLocaleList());
        AndroidParagraphIntrinsics$$ExternalSyntheticLambda0 v7 = new AndroidParagraphIntrinsics$$ExternalSyntheticLambda0(this);
        TextPaintExtensions_androidKt.setTextMotion(v10, arg11.getTextMotion());
        SpanStyle v11 = arg11.toSpanStyle();
        int v13_1 = arg12.size();
        int v1 = 0;
        while(true) {
            if(v1 < v13_1) {
                v2 = arg12.get(v1);
                if((v2.getItem() instanceof SpanStyle)) {
                }
                else {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_44;
        }

        v2 = null;
    label_44:
        boolean v12 = v2 != null ? true : false;
        SpanStyle v10_1 = TextPaintExtensions_androidKt.applySpanStyle(v10, v11, ((Function4)v7), arg15, v12);
        List v11_1 = this.annotations;
        if(v10_1 != null) {
            int v11_2 = v11_1.size() + 1;
            ArrayList v12_1 = new ArrayList(v11_2);
            for(v13_1 = 0; v13_1 < v11_2; ++v13_1) {
                if(v13_1 == 0) {
                    v14 = new Range(v10_1, 0, this.text.length());
                }
                else {
                    Object v14_1 = this.annotations.get(v13_1 - 1);
                }

                v12_1.add(v14);
            }

            v11_3 = v12_1;
        }

        CharSequence v10_2 = AndroidParagraphHelper_androidKt.createCharSequence(this.text, this.textPaint.getTextSize(), this.style, ((List)v11_3), this.placeholders, this.density, ((Function4)v7), this.emojiCompatProcessed);
        this.charSequence = v10_2;
        this.layoutIntrinsics = new LayoutIntrinsics(v10_2, this.textPaint, this.textDirectionHeuristic);
    }

    static final Typeface _init_$lambda$0(AndroidParagraphIntrinsics arg1, FontFamily arg2, FontWeight arg3, FontStyle arg4, FontSynthesis arg5) {
        State v2 = arg1.fontFamilyResolver.resolve-DPcqOEQ(arg2, arg3, arg4.unbox-impl(), arg5.unbox-impl());
        if(!(v2 instanceof Immutable)) {
            TypefaceDirtyTrackerLinkedList v3 = new TypefaceDirtyTrackerLinkedList(v2, arg1.resolvedTypefaces);
            arg1.resolvedTypefaces = v3;
            return v3.getTypeface();
        }

        Object v1 = ((Immutable)v2).getValue();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.graphics.Typeface");
        return ((Typeface)v1);
    }

    public final List getAnnotations() {
        return this.annotations;
    }

    public final CharSequence getCharSequence$ui_text() {
        return this.charSequence;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public boolean getHasStaleResolvedFonts() {
        TypefaceDirtyTrackerLinkedList v0 = this.resolvedTypefaces;
        boolean v0_1 = v0 != null ? v0.isStaleResolvedFont() : false;
        if(!v0_1 && ((this.emojiCompatProcessed) || !AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(this.style) || !EmojiCompatStatus.INSTANCE.getFontLoaded().getValue().booleanValue())) {
            return 0;
        }

        return 1;
    }

    public final LayoutIntrinsics getLayoutIntrinsics$ui_text() {
        return this.layoutIntrinsics;
    }

    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final List getPlaceholders() {
        return this.placeholders;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextDirectionHeuristic$ui_text() {
        return this.textDirectionHeuristic;
    }

    public final AndroidTextPaint getTextPaint$ui_text() {
        return this.textPaint;
    }
}

