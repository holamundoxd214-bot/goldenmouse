package androidx.compose.ui.text.android;

import android.text.Layout$Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import kotlin.Metadata;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JØ\u0001\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0003\u0010\u0014\u001A\u00020\r2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0003\u0010\u0017\u001A\u00020\r2\b\b\u0003\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u00192\b\b\u0002\u0010\u001B\u001A\u00020\r2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001D2\b\b\u0002\u0010\u001F\u001A\u00020\r2\b\b\u0002\u0010 \u001A\u00020\r2\b\b\u0002\u0010!\u001A\u00020\r2\b\b\u0002\u0010\"\u001A\u00020\r2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010$J\u0016\u0010&\u001A\u00020\u001D2\u0006\u0010\'\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001DR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "<init>", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "start", "end", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", "layout", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StaticLayoutFactory {
    public static final int $stable;
    public static final StaticLayoutFactory INSTANCE;
    private static final StaticLayoutFactoryImpl delegate;

    static {
        StaticLayoutFactory.INSTANCE = new StaticLayoutFactory();
        StaticLayoutFactory.delegate = new StaticLayoutFactory23();
        StaticLayoutFactory.$stable = 8;
    }

    private StaticLayoutFactory() {
        super();
    }

    public final StaticLayout create(CharSequence arg24, TextPaint arg25, int arg26, int arg27, int arg28, TextDirectionHeuristic arg29, Layout$Alignment arg30, int arg31, TextUtils$TruncateAt arg32, int arg33, float arg34, float arg35, int arg36, boolean arg37, boolean arg38, int arg39, int arg40, int arg41, int arg42, int[] arg43, int[] arg44) {
        return StaticLayoutFactory.delegate.create(new StaticLayoutParams(arg24, arg27, arg28, arg25, arg26, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44));
    }

    public static StaticLayout create$default(StaticLayoutFactory arg25, CharSequence arg26, TextPaint arg27, int arg28, int arg29, int arg30, TextDirectionHeuristic arg31, Layout$Alignment arg32, int arg33, TextUtils$TruncateAt arg34, int arg35, float arg36, float arg37, int arg38, boolean arg39, boolean arg40, int arg41, int arg42, int arg43, int arg44, int[] arg45, int[] arg46, int arg47, Object arg48) {
        StaticLayoutFactory v3_1;
        int v6;
        TextPaint v5;
        CharSequence v4;
        int[] v24;
        int v0 = arg47;
        int v7 = (v0 & 8) != 0 ? 0 : arg29;
        int v8 = (v0 & 16) != 0 ? arg26.length() : arg30;
        TextDirectionHeuristic v9 = (v0 & 0x20) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text() : arg31;
        Layout$Alignment v10 = (v0 & 0x40) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text() : arg32;
        int v11 = (v0 & 0x80) != 0 ? 0x7FFFFFFF : arg33;
        TextUtils$TruncateAt v3 = null;
        TextUtils$TruncateAt v12 = (v0 & 0x100) != 0 ? v3 : arg34;
        int v13 = (v0 & 0x200) != 0 ? arg28 : arg35;
        float v14 = (v0 & 0x400) != 0 ? 1f : arg36;
        float v15 = (v0 & 0x800) != 0 ? 0f : arg37;
        int v16 = (v0 & 0x1000) != 0 ? 0 : arg38;
        boolean v17 = (v0 & 0x2000) != 0 ? false : arg39;
        boolean v18 = (v0 & 0x4000) != 0 ? true : arg40;
        int v19 = (0x8000 & v0) != 0 ? 0 : arg41;
        int v20 = (0x10000 & v0) != 0 ? 0 : arg42;
        int v21 = (0x20000 & v0) != 0 ? 0 : arg43;
        int v22 = (0x40000 & v0) != 0 ? 0 : arg44;
        int[] v23 = (0x80000 & v0) != 0 ? ((int[])v3) : arg45;
        if((v0 & 0x100000) != 0) {
            v24 = ((int[])v3);
            v4 = arg26;
            v5 = arg27;
            v6 = arg28;
            v3_1 = arg25;
        }
        else {
            v24 = arg46;
            v3_1 = arg25;
            v4 = arg26;
            v5 = arg27;
            v6 = arg28;
        }

        return v3_1.create(v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24);
    }

    public final boolean isFallbackLineSpacingEnabled(StaticLayout arg1, boolean arg2) {
        return StaticLayoutFactory.delegate.isFallbackLineSpacingEnabled(arg1, arg2);
    }
}

