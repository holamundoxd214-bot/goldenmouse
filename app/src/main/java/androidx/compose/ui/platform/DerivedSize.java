package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0012"}, d2={"Landroidx/compose/ui/platform/DerivedSize;", "", "pxSize", "Landroidx/compose/ui/unit/IntSize;", "dpSize", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPxSize-YbymL2g", "()J", "J", "getDpSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DerivedSize {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\u0012\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/ui/platform/DerivedSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/platform/DerivedSize;", "getZero", "()Landroidx/compose/ui/platform/DerivedSize;", "fromPxSize", "pxSize", "Landroidx/compose/ui/unit/IntSize;", "density", "Landroidx/compose/ui/unit/Density;", "fromPxSize-viCIZxY", "(JLandroidx/compose/ui/unit/Density;)Landroidx/compose/ui/platform/DerivedSize;", "fromDpSize", "dpSize", "Landroidx/compose/ui/unit/DpSize;", "fromDpSize-itqla9I", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final DerivedSize fromDpSize-itqla9I(long arg9, Density arg11) {
            return new DerivedSize(IntSizeKt.toIntSize-uvyYCjk(arg11.toSize-XkaWNTQ(arg9)), arg9, null);
        }

        public final DerivedSize fromPxSize-viCIZxY(long arg9, Density arg11) {
            return new DerivedSize(arg9, arg11.toDpSize-k-rfVVM(IntSizeKt.toSize-ozmzZPI(arg9)), null);
        }

        public final DerivedSize getZero() {
            return DerivedSize.Zero;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final DerivedSize Zero;
    private final long dpSize;
    private final long pxSize;

    static {
        DerivedSize.Companion = new Companion(null);
        DerivedSize.Zero = new DerivedSize(IntSize.Companion.getZero-YbymL2g(), DpSize.Companion.getZero-MYxV2XQ(), null);
    }

    public DerivedSize(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    private DerivedSize(long arg1, long arg3) {
        super();
        this.pxSize = arg1;
        this.dpSize = arg3;
    }

    public static final DerivedSize access$getZero$cp() {
        return DerivedSize.Zero;
    }

    public boolean equals(Object arg8) {
        if(this == (((DerivedSize)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof DerivedSize)) {
            return 0;
        }

        if(!IntSize.equals-impl0(this.pxSize, ((DerivedSize)arg8).pxSize)) {
            return 0;
        }

        if(!DpSize.equals-impl0(this.dpSize, ((DerivedSize)arg8).dpSize)) {
            return 0;
        }

        return 1;
    }

    public final long getDpSize-MYxV2XQ() {
        return this.dpSize;
    }

    public final long getPxSize-YbymL2g() {
        return this.pxSize;
    }

    public int hashCode() {
        return IntSize.hashCode-impl(this.pxSize) * 0x1F + DpSize.hashCode-impl(this.dpSize);
    }
}

