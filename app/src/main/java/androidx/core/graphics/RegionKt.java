package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\u0005\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\n\u001A\u0015\u0010\u0005\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002H\u0086\n\u001A\r\u0010\t\u001A\u00020\u0002*\u00020\u0002H\u0086\n\u001A\r\u0010\n\u001A\u00020\u0002*\u00020\u0002H\u0086\n\u001A\u0015\u0010\u000B\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\f\u001A\u0015\u0010\u000B\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002H\u0086\f\u001A\u0015\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\f\u001A\u0015\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002H\u0086\f\u001A\u0015\u0010\r\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\f\u001A\u0015\u0010\r\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002H\u0086\f\u001A3\u0010\u000E\u001A\u00020\u000F*\u00020\u00022!\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000F0\u0011H\u0086\bø\u0001\u0000\u001A\u0013\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00070\u0016*\u00020\u0002H\u0086\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2={"contains", "", "Landroid/graphics/Region;", "p", "Landroid/graphics/Point;", "plus", "r", "Landroid/graphics/Rect;", "minus", "unaryMinus", "not", "or", "and", "xor", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RegionKt {
    public static final Region and(Region arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.INTERSECT);
        return v0;
    }

    public static final Region and(Region arg1, Region arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.INTERSECT);
        return v0;
    }

    public static final boolean contains(Region arg1, Point arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        return arg1.contains(arg2.x, arg2.y);
    }

    public static final void forEach(Region arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        RegionIterator v0 = new RegionIterator(arg2);
        while(true) {
            Rect v2 = new Rect();
            if(!v0.next(v2)) {
                return;
            }

            arg3.invoke(v2);
        }
    }

    public static final Iterator iterator(Region arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new RegionKt$iterator$1(arg1);
    }

    public static final Region minus(Region arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Region minus(Region arg1, Region arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Region not(Region arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Region v0 = new Region(arg2.getBounds());
        v0.op(arg2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Region or(Region arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final Region or(Region arg1, Region arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.UNION);
        return v0;
    }

    public static final Region plus(Region arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final Region plus(Region arg1, Region arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.UNION);
        return v0;
    }

    public static final Region unaryMinus(Region arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Region v0 = new Region(arg2.getBounds());
        v0.op(arg2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Region xor(Region arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.XOR);
        return v0;
    }

    public static final Region xor(Region arg1, Region arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.XOR);
        return v0;
    }
}

