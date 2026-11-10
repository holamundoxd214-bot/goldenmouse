package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0001?BO\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001E\u001A\u00020\u0000H\u0002J(\u0010\u001F\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u00032\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\u0003H\u0002J\u0018\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\'H\u0086\u0002¢\u0006\u0004\b(\u0010)J\b\u0010*\u001A\u00020+H\u0016J\t\u0010,\u001A\u00020\u0003HÆ\u0003J\t\u0010-\u001A\u00020\u0003HÆ\u0003J\t\u0010.\u001A\u00020\u0003HÆ\u0003J\t\u0010/\u001A\u00020\u0003HÆ\u0003J\u0010\u00100\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b1\u0010\u0014J\u0010\u00102\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b3\u0010\u0014J\u0010\u00104\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b5\u0010\u0014J\u0010\u00106\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b7\u0010\u0014J`\u00108\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001A\u00020%2\b\u0010<\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001A\u00020>HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000B\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u000FR\u0011\u0010\u001B\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u000FR\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006@"}, d2={"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "<init>", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "getTopLeftCornerRadius-kKHJgLs", "()J", "J", "getTopRightCornerRadius-kKHJgLs", "getBottomRightCornerRadius-kKHJgLs", "getBottomLeftCornerRadius-kKHJgLs", "width", "getWidth", "height", "getHeight", "_scaledRadiiRect", "scaledRadiiRect", "minRadius", "min", "radius1", "radius2", "limit", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "Companion", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RoundRect {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }

        @JvmStatic public static void getZero$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final RoundRect Zero;
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    static {
        RoundRect.Companion = new Companion(null);
        RoundRect.Zero = RoundRectKt.RoundRect-gG7oq9Y(0f, 0f, 0f, 0f, CornerRadius.Companion.getZero-kKHJgLs());
    }

    public RoundRect(float arg1, float arg2, float arg3, float arg4, long arg5, long arg7, long arg9, long arg11, DefaultConstructorMarker arg13) {
        this(arg1, arg2, arg3, arg4, arg5, arg7, arg9, arg11);
    }

    private RoundRect(float arg1, float arg2, float arg3, float arg4, long arg5, long arg7, long arg9, long arg11) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
        this.topLeftCornerRadius = arg5;
        this.topRightCornerRadius = arg7;
        this.bottomRightCornerRadius = arg9;
        this.bottomLeftCornerRadius = arg11;
    }

    public RoundRect(float arg18, float arg19, float arg20, float arg21, long arg22, long arg24, long arg26, long arg28, int arg30, DefaultConstructorMarker arg31) {
        int v0 = arg30;
        long v8 = (v0 & 16) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg22;
        long v10 = (v0 & 0x20) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg24;
        long v12 = (v0 & 0x40) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg26;
        long v14 = (v0 & 0x80) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg28;
        this(arg18, arg19, arg20, arg21, v8, v10, v12, v14, null);
    }

    public static final RoundRect access$getZero$cp() {
        return RoundRect.Zero;
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    public final long component5-kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    public final long component6-kKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final long component7-kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final long component8-kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final boolean contains-k-4lQ0M(long arg11) {
        float v12_1;
        float v10;
        float v11_1;
        float v1_1;
        int v0 = 0x20;
        int v1 = ((int)(arg11 >> v0));
        if(Float.compare(Float.intBitsToFloat(v1), this.left) >= 0 && Float.intBitsToFloat(v1) < this.right) {
            long v4 = 0xFFFFFFFFL;
            int v11 = ((int)(arg11 & v4));
            if(Float.intBitsToFloat(v11) >= this.top) {
                if(Float.intBitsToFloat(v11) >= this.bottom) {
                }
                else {
                    RoundRect v12 = this.scaledRadiiRect();
                    if(Float.compare(Float.intBitsToFloat(v1), this.left + Float.intBitsToFloat(((int)(v12.topLeftCornerRadius >> v0)))) >= 0 || Float.intBitsToFloat(v11) >= this.top + Float.intBitsToFloat(((int)(v12.topLeftCornerRadius & v4)))) {
                        if(Float.intBitsToFloat(v1) > this.right - Float.intBitsToFloat(((int)(v12.topRightCornerRadius >> v0))) && Float.intBitsToFloat(v11) < this.top + Float.intBitsToFloat(((int)(v12.topRightCornerRadius & v4)))) {
                            v1_1 = Float.intBitsToFloat(v1) - this.right + Float.intBitsToFloat(((int)(v12.topRightCornerRadius >> v0)));
                            v11_1 = Float.intBitsToFloat(v11) - this.top - Float.intBitsToFloat(((int)(v12.topRightCornerRadius & v4)));
                            v10 = Float.intBitsToFloat(((int)(v12.topRightCornerRadius >> v0)));
                            v12_1 = Float.intBitsToFloat(((int)(v4 & v12.topRightCornerRadius)));
                            goto label_187;
                        }

                        if(Float.intBitsToFloat(v1) > this.right - Float.intBitsToFloat(((int)(v12.bottomRightCornerRadius >> v0))) && Float.intBitsToFloat(v11) > this.bottom - Float.intBitsToFloat(((int)(v12.bottomRightCornerRadius & v4)))) {
                            v1_1 = Float.intBitsToFloat(v1) - this.right + Float.intBitsToFloat(((int)(v12.bottomRightCornerRadius >> v0)));
                            v11_1 = Float.intBitsToFloat(v11) - this.bottom + Float.intBitsToFloat(((int)(v12.bottomRightCornerRadius & v4)));
                            v10 = Float.intBitsToFloat(((int)(v12.bottomRightCornerRadius >> v0)));
                            v12_1 = Float.intBitsToFloat(((int)(v4 & v12.bottomRightCornerRadius)));
                            goto label_187;
                        }

                        if(Float.intBitsToFloat(v1) < this.left + Float.intBitsToFloat(((int)(v12.bottomLeftCornerRadius >> v0))) && Float.intBitsToFloat(v11) > this.bottom - Float.intBitsToFloat(((int)(v12.bottomLeftCornerRadius & v4)))) {
                            v1_1 = Float.intBitsToFloat(v1) - this.left - Float.intBitsToFloat(((int)(v12.bottomLeftCornerRadius >> v0)));
                            v11_1 = Float.intBitsToFloat(v11) - this.bottom + Float.intBitsToFloat(((int)(v12.bottomLeftCornerRadius & v4)));
                            v10 = Float.intBitsToFloat(((int)(v12.bottomLeftCornerRadius >> v0)));
                            v12_1 = Float.intBitsToFloat(((int)(v4 & v12.bottomLeftCornerRadius)));
                            goto label_187;
                        }

                        return 1;
                    }
                    else {
                        v1_1 = Float.intBitsToFloat(v1) - this.left - Float.intBitsToFloat(((int)(v12.topLeftCornerRadius >> v0)));
                        v11_1 = Float.intBitsToFloat(v11) - this.top - Float.intBitsToFloat(((int)(v12.topLeftCornerRadius & v4)));
                        v10 = Float.intBitsToFloat(((int)(v12.topLeftCornerRadius >> v0)));
                        v12_1 = Float.intBitsToFloat(((int)(v4 & v12.topLeftCornerRadius)));
                    }

                label_187:
                    v1_1 /= v10;
                    v11_1 /= v12_1;
                    if(v1_1 * v1_1 + v11_1 * v11_1 <= 1f) {
                        return 1;
                    }
                    else {
                        return 0;
                    }

                    return 1;
                }
            }
        }

        return 0;
    }

    public final RoundRect copy-MDFrsts(float arg15, float arg16, float arg17, float arg18, long arg19, long arg21, long arg23, long arg25) {
        return new RoundRect(arg15, arg16, arg17, arg18, arg19, arg21, arg23, arg25, null);
    }

    public static RoundRect copy-MDFrsts$default(RoundRect arg0, float arg1, float arg2, float arg3, float arg4, long arg5, long arg7, long arg9, long arg11, int arg13, Object arg14) {
        if((arg13 & 1) != 0) {
            arg1 = arg0.left;
        }

        if((arg13 & 2) != 0) {
            arg2 = arg0.top;
        }

        if((arg13 & 4) != 0) {
            arg3 = arg0.right;
        }

        if((arg13 & 8) != 0) {
            arg4 = arg0.bottom;
        }

        if((arg13 & 16) != 0) {
            arg5 = arg0.topLeftCornerRadius;
        }

        if((arg13 & 0x20) != 0) {
            arg7 = arg0.topRightCornerRadius;
        }

        if((arg13 & 0x40) != 0) {
            arg9 = arg0.bottomRightCornerRadius;
        }

        if((arg13 & 0x80) != 0) {
            arg11 = arg0.bottomLeftCornerRadius;
        }

        return arg0.copy-MDFrsts(arg1, arg2, arg3, arg4, arg5, arg7, arg9, arg11);
    }

    public boolean equals(Object arg8) {
        if(this == (((RoundRect)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RoundRect)) {
            return 0;
        }

        if(Float.compare(this.left, ((RoundRect)arg8).left) != 0) {
            return 0;
        }

        if(Float.compare(this.top, ((RoundRect)arg8).top) != 0) {
            return 0;
        }

        if(Float.compare(this.right, ((RoundRect)arg8).right) != 0) {
            return 0;
        }

        if(Float.compare(this.bottom, ((RoundRect)arg8).bottom) != 0) {
            return 0;
        }

        if(!CornerRadius.equals-impl0(this.topLeftCornerRadius, ((RoundRect)arg8).topLeftCornerRadius)) {
            return 0;
        }

        if(!CornerRadius.equals-impl0(this.topRightCornerRadius, ((RoundRect)arg8).topRightCornerRadius)) {
            return 0;
        }

        if(!CornerRadius.equals-impl0(this.bottomRightCornerRadius, ((RoundRect)arg8).bottomRightCornerRadius)) {
            return 0;
        }

        if(!CornerRadius.equals-impl0(this.bottomLeftCornerRadius, ((RoundRect)arg8).bottomLeftCornerRadius)) {
            return 0;
        }

        return 1;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final long getBottomLeftCornerRadius-kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final long getBottomRightCornerRadius-kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final long getTopLeftCornerRadius-kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    public final long getTopRightCornerRadius-kKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public static final RoundRect getZero() {
        return RoundRect.Companion.getZero();
    }

    public int hashCode() {
        return ((((((Float.hashCode(this.left) * 0x1F + Float.hashCode(this.top)) * 0x1F + Float.hashCode(this.right)) * 0x1F + Float.hashCode(this.bottom)) * 0x1F + CornerRadius.hashCode-impl(this.topLeftCornerRadius)) * 0x1F + CornerRadius.hashCode-impl(this.topRightCornerRadius)) * 0x1F + CornerRadius.hashCode-impl(this.bottomRightCornerRadius)) * 0x1F + CornerRadius.hashCode-impl(this.bottomLeftCornerRadius);
    }

    private final float minRadius(float arg1, float arg2, float arg3, float arg4) {
        arg2 += arg3;
        if(arg2 > arg4) {
            if(arg2 == 0f) {
                return arg1;
            }

            return Math.min(arg1, arg4 / arg2);
        }

        return arg1;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect v0 = this;
        RoundRect v1 = v0._scaledRadiiRect;
        if(v1 == null) {
            float v1_1 = v0.minRadius(v0.minRadius(v0.minRadius(v0.minRadius(1f, Float.intBitsToFloat(((int)(v0.bottomLeftCornerRadius & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v0.topLeftCornerRadius & 0xFFFFFFFFL))), v0.getHeight()), Float.intBitsToFloat(((int)(v0.topLeftCornerRadius >> 0x20))), Float.intBitsToFloat(((int)(v0.topRightCornerRadius >> 0x20))), v0.getWidth()), Float.intBitsToFloat(((int)(v0.topRightCornerRadius & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v0.bottomRightCornerRadius & 0xFFFFFFFFL))), v0.getHeight()), Float.intBitsToFloat(((int)(v0.bottomRightCornerRadius >> 0x20))), Float.intBitsToFloat(((int)(v0.bottomLeftCornerRadius >> 0x20))), v0.getWidth());
            RoundRect v5 = new RoundRect(v0.left * v1_1, v0.top * v1_1, v0.right * v1_1, v0.bottom * v1_1, CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.topLeftCornerRadius & 0xFFFFFFFFL))) * v1_1))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.topLeftCornerRadius >> 0x20))) * v1_1))) << 0x20), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.topRightCornerRadius & 0xFFFFFFFFL))) * v1_1))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.topRightCornerRadius >> 0x20))) * v1_1))) << 0x20), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.bottomRightCornerRadius & 0xFFFFFFFFL))) * v1_1))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.bottomRightCornerRadius >> 0x20))) * v1_1))) << 0x20), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.bottomLeftCornerRadius >> 0x20))) * v1_1))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v0.bottomLeftCornerRadius & 0xFFFFFFFFL))) * v1_1))) & 0xFFFFFFFFL), null);
            v0._scaledRadiiRect = v5;
            return v5;
        }

        return v1;
    }

    public String toString() {
        long v0 = this.topLeftCornerRadius;
        long v2 = this.topRightCornerRadius;
        long v4 = this.bottomRightCornerRadius;
        long v6 = this.bottomLeftCornerRadius;
        String v12 = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        char v9 = ')';
        String v11 = "RoundRect(rect=";
        if((CornerRadius.equals-impl0(v0, v2)) && (CornerRadius.equals-impl0(v2, v4)) && (CornerRadius.equals-impl0(v4, v6))) {
            int v2_1 = ((int)(v0 >> 0x20));
            int v0_1 = ((int)(v0 & 0xFFFFFFFFL));
            if(Float.intBitsToFloat(v2_1) == Float.intBitsToFloat(v0_1)) {
                return v11 + v12 + ", radius=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v2_1), 1) + v9;
            }
            else {
                return v11 + v12 + ", x=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v2_1), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v0_1), 1) + v9;
            }
        }

        return v11 + v12 + ", topLeft=" + CornerRadius.toString-impl(v0) + ", topRight=" + CornerRadius.toString-impl(v2) + ", bottomRight=" + CornerRadius.toString-impl(v4) + ", bottomLeft=" + CornerRadius.toString-impl(v6) + v9;
    }
}

