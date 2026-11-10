package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/graphics/Interpolatable;", "", "lerp", "other", "t", "", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Interpolatable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001A\u0004\u0018\u00010\u00012\b\u0010\u0005\u001A\u0004\u0018\u00010\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/Interpolatable$Companion;", "", "<init>", "()V", "lerp", "a", "b", "t", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final Object lerp(Object arg3, Object arg4, float arg5) {
            float v0 = 0.5f;
            if(!Intrinsics.areEqual(arg3, arg4)) {
                Object v2 = (arg3 instanceof Interpolatable) ? arg3.lerp(arg4, arg5) : null;
                if(v2 == null && ((arg4 instanceof Interpolatable))) {
                    v2 = arg4.lerp(arg3, 1f - arg5);
                }

                if(v2 != null) {
                    return v2;
                }

                if(arg5 >= v0) {
                    return arg4;
                }

                return arg3;
            }
            else if(arg5 < v0) {
                return arg3;
            }

            return arg4;
        }
    }

    public static final Companion Companion;

    static {
        Interpolatable.Companion = Companion.$$INSTANCE;
    }

    Object lerp(Object arg1, float arg2);
}

