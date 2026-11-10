package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J+\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u001C\u0010\u001DR\u001E\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000E\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000E\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\rR\u001C\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0011\u0010\u000B\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "<init>", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU$annotations", "()V", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "getBlurRadius$annotations", "getBlurRadius", "()F", "equals", "", "other", "hashCode", "", "toString", "", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Shadow {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/Shadow$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Shadow getNone() {
            return Shadow.None;
        }

        public static void getNone$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Shadow None;
    private final float blurRadius;
    private final long color;
    private final long offset;

    static {
        Shadow.Companion = new Companion(null);
        Shadow.None = new Shadow(0, 0, 0f, 7, null);
    }

    public Shadow(long arg1, long arg3, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg3, arg5);
    }

    public Shadow(long arg8, long arg10, float arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 1) != 0) {
            arg8 = ColorKt.Color(0xFF000000L);
        }

        long v1 = arg8;
        if((arg13 & 2) != 0) {
            arg10 = Offset.Companion.getZero-F1C5BW0();
        }

        this(v1, arg10, 0f, null);
    }

    private Shadow(long arg1, long arg3, float arg5) {
        super();
        this.color = arg1;
        this.offset = arg3;
        this.blurRadius = arg5;
    }

    public static final Shadow access$getNone$cp() {
        return Shadow.None;
    }

    public final Shadow copy-qcb84PM(long arg8, long arg10, float arg12) {
        return new Shadow(arg8, arg10, arg12, null);
    }

    public static Shadow copy-qcb84PM$default(Shadow arg6, long arg7, long arg9, float arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = arg6.color;
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = arg6.offset;
        }

        long v3 = arg9;
        if((arg12 & 4) != 0) {
            arg11 = arg6.blurRadius;
        }

        return arg6.copy-qcb84PM(v1, v3, arg11);
    }

    public boolean equals(Object arg8) {
        if(this == (((Shadow)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof Shadow)) {
            return 0;
        }

        if(!Color.equals-impl0(this.color, ((Shadow)arg8).color)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.offset, ((Shadow)arg8).offset)) {
            return 0;
        }

        if(this.blurRadius == ((Shadow)arg8).blurRadius) {
            return 1;
        }

        return 0;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public static void getBlurRadius$annotations() {
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public static void getColor-0d7_KjU$annotations() {
    }

    public final long getOffset-F1C5BW0() {
        return this.offset;
    }

    public static void getOffset-F1C5BW0$annotations() {
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.color) * 0x1F + Offset.hashCode-impl(this.offset)) * 0x1F + Float.hashCode(this.blurRadius);
    }

    public String toString() {
        return "Shadow(color=" + Color.toString-impl(this.color) + ", offset=" + Offset.toString-impl(this.offset) + ", blurRadius=" + this.blurRadius + ')';
    }
}

