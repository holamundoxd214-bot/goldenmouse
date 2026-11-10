package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import android.os.Build$VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\bH\u0007R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/graphics/CanvasUtils;", "", "<init>", "()V", "reorderBarrierMethod", "Ljava/lang/reflect/Method;", "inorderBarrierMethod", "orderMethodsFetched", "", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CanvasUtils {
    public static final int $stable;
    public static final CanvasUtils INSTANCE;
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;
    private static Method reorderBarrierMethod;

    static {
        CanvasUtils.INSTANCE = new CanvasUtils();
        CanvasUtils.$stable = 8;
    }

    private CanvasUtils() {
        super();
    }

    public final void enableZ(Canvas arg8, boolean arg9) {
        if(Build$VERSION.SDK_INT >= 29) {
            CanvasZHelper.INSTANCE.enableZ(arg8, arg9);
            return;
        }

        if(!CanvasUtils.orderMethodsFetched) {
            try {
                int v1 = Build$VERSION.SDK_INT;
            }
            catch(NoSuchMethodException ) {
                goto label_48;
            }

            String v3 = "insertInorderBarrier";
            String v4 = "insertReorderBarrier";
            if(v1 == 28) {
                try {
                    Method v1_1 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    Class v2 = Canvas.class;
                    CanvasUtils.reorderBarrierMethod = v1_1.invoke(v2, v4);
                    CanvasUtils.inorderBarrierMethod = v1_1.invoke(v2, v3);
                    goto label_42;
                label_35:
                    Class v1_2 = Canvas.class;
                    CanvasUtils.reorderBarrierMethod = v1_2.getDeclaredMethod(v4);
                    CanvasUtils.inorderBarrierMethod = v1_2.getDeclaredMethod(v3);
                label_42:
                    v1_1 = CanvasUtils.reorderBarrierMethod;
                    if(v1_1 != null) {
                        v1_1.setAccessible(true);
                    }

                    v1_1 = CanvasUtils.inorderBarrierMethod;
                    if(v1_1 != null) {
                        v1_1.setAccessible(true);
                    }

                    goto label_48;
                }
                catch(NoSuchMethodException ) {
                label_48:
                    CanvasUtils.orderMethodsFetched = true;
                    goto label_49;
                }
            }
            else {
                goto label_35;
            }

            goto label_42;
        }

    label_49:
        if(arg9) {
            try {
                Method v7 = CanvasUtils.reorderBarrierMethod;
                if(v7 != null) {
                    Intrinsics.checkNotNull(v7);
                    v7.invoke(arg8);
                }

            label_55:
                if(!arg9) {
                    v7 = CanvasUtils.inorderBarrierMethod;
                    if(v7 != null) {
                        Intrinsics.checkNotNull(v7);
                        v7.invoke(arg8);
                    }
                }

                return;
            }
            catch(InvocationTargetException ) {
                return;
            }
        }

        goto label_55;
    }
}

