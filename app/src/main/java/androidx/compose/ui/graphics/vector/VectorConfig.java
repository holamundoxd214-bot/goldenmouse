package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001A\u0002H\u0003H\u0016¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/vector/VectorConfig;", "", "getOrDefault", "T", "property", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "defaultValue", "(Landroidx/compose/ui/graphics/vector/VectorProperty;Ljava/lang/Object;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface VectorConfig {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Object getOrDefault(VectorConfig arg0, VectorProperty arg1, Object arg2) {
            return arg0.getOrDefault(arg1, arg2);
        }
    }

    static Object access$getOrDefault$jd(VectorConfig arg0, VectorProperty arg1, Object arg2) {
        return super.getOrDefault(arg1, arg2);
    }

    default Object getOrDefault(VectorProperty arg1, Object arg2) {
        return arg2;
    }
}

