package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2={"Landroidx/compose/ui/graphics/PathEffect;", "", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PathEffect {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0018\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u0007J\u0016\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005J-\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/ui/graphics/PathEffect$Companion;", "", "<init>", "()V", "cornerPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "radius", "", "dashPathEffect", "intervals", "", "phase", "chainPathEffect", "outer", "inner", "stampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "stampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final PathEffect chainPathEffect(PathEffect arg1, PathEffect arg2) {
            return AndroidPathEffect_androidKt.actualChainPathEffect(arg1, arg2);
        }

        public final PathEffect cornerPathEffect(float arg1) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(arg1);
        }

        public final PathEffect dashPathEffect(float[] arg1, float arg2) {
            return AndroidPathEffect_androidKt.actualDashPathEffect(arg1, arg2);
        }

        public static PathEffect dashPathEffect$default(Companion arg0, float[] arg1, float arg2, int arg3, Object arg4) {
            return arg0.dashPathEffect(arg1, 0f);
        }

        public final PathEffect stampedPathEffect-7aD1DOk(Path arg1, float arg2, float arg3, int arg4) {
            return AndroidPathEffect_androidKt.actualStampedPathEffect-7aD1DOk(arg1, arg2, arg3, arg4);
        }
    }

    public static final Companion Companion;

    static {
        PathEffect.Companion = Companion.$$INSTANCE;
    }
}

