package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0000\u001A\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0018\u0010\u0006\u001A\u00020\u0007*\u00020\b2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nH\u0000¨\u0006\u000B"}, d2={"areObjectsOfSameType", "", "a", "", "b", "classKeyForObject", "tryPopulateReflectively", "", "Landroidx/compose/ui/platform/InspectorInfo;", "element", "Landroidx/compose/ui/node/ModifierNodeElement;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Actual_jvmKt {
    public static final boolean areObjectsOfSameType(Object arg0, Object arg1) {
        if(arg0.getClass() == arg1.getClass()) {
            return 1;
        }

        return 0;
    }

    public static final Object classKeyForObject(Object arg0) {
        return arg0.getClass();
    }

    public static final void tryPopulateReflectively(InspectorInfo arg6, ModifierNodeElement arg7) {
        List v0 = ArraysKt.sortedWith(arg7.getClass().getDeclaredFields(), new Actual_jvmKt$tryPopulateReflectively$$inlined$sortedBy$1());
        int v1 = v0.size();
        int v2 = 0;
        while(v2 < v1) {
            Object v3 = v0.get(v2);
            if(!((Field)v3).getDeclaringClass().isAssignableFrom(ModifierNodeElement.class)) {
                try {
                    ((Field)v3).setAccessible(true);
                    arg6.getProperties().set(((Field)v3).getName(), ((Field)v3).get(arg7));
                    goto label_20;
                }
                catch(IllegalAccessException ) {
                label_20:
                    ++v2;
                    continue;
                }
            }

            goto label_20;
        }
    }
}

