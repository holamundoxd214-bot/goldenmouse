package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0000H\u0016J\u0016\u0010\u0010\u001A\u00020\u00002\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/style/TextForegroundStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "merge", "other", "takeOrElse", "Lkotlin/Function0;", "Unspecified", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextForegroundStyle {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0004\u001A\u00020\u00052\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/style/TextForegroundStyle$Companion;", "", "<init>", "()V", "from", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextForegroundStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final TextForegroundStyle from(Brush arg3, float arg4) {
            if(arg3 == null) {
                return Unspecified.INSTANCE;
            }

            if((arg3 instanceof SolidColor)) {
                return this.from-8_81llA(TextDrawStyleKt.modulate-DxMtmZc(((SolidColor)arg3).getValue-0d7_KjU(), arg4));
            }

            if((arg3 instanceof ShaderBrush)) {
                return new BrushStyle(((ShaderBrush)arg3), arg4);
            }

            throw new NoWhenBranchMatchedException();
        }

        public final TextForegroundStyle from-8_81llA(long arg3) {
            ColorStyle v2;
            if(arg3 != 16) {
                v2 = new ColorStyle(arg3, null);
            }
            else {
                Unspecified v2_1 = Unspecified.INSTANCE;
            }

            return ((TextForegroundStyle)v2);
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/style/TextForegroundStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "<init>", "()V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Unspecified implements TextForegroundStyle {
        public static final int $stable;
        public static final Unspecified INSTANCE;

        static {
            Unspecified.INSTANCE = new Unspecified();
        }

        private Unspecified() {
            super();
        }

        public float getAlpha() {
            return NaNf;
        }

        public Brush getBrush() {
            return null;
        }

        public long getColor-0d7_KjU() {
            return Color.Companion.getUnspecified-0d7_KjU();
        }
    }

    public static final Companion Companion;

    static {
        TextForegroundStyle.Companion = Companion.$$INSTANCE;
    }

    float getAlpha();

    Brush getBrush();

    long getColor-0d7_KjU();

    default TextForegroundStyle merge(TextForegroundStyle arg4) {
        boolean v0 = arg4 instanceof BrushStyle;
        if((v0) && ((this instanceof BrushStyle))) {
            return new BrushStyle(((BrushStyle)arg4).getValue(), TextDrawStyleKt.access$takeOrElse(((BrushStyle)arg4).getAlpha(), new TextForegroundStyle$$ExternalSyntheticLambda0(this)));
        }

        if((v0) && !(this instanceof BrushStyle)) {
            return arg4;
        }

        if(!v0 && ((this instanceof BrushStyle))) {
            return this;
        }

        return arg4.takeOrElse(new TextForegroundStyle$$ExternalSyntheticLambda1(this));
    }

    static float merge$lambda$0(TextForegroundStyle arg0) {
        return ((BrushStyle)arg0).getAlpha();
    }

    static TextForegroundStyle merge$lambda$1(TextForegroundStyle arg0) {
        return arg0;
    }

    default TextForegroundStyle takeOrElse(Function0 arg2) {
        if(!Intrinsics.areEqual(this, Unspecified.INSTANCE)) {
            return this;
        }

        return arg2.invoke();
    }
}

