package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0083@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F¢\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001A\u00020\u00132\b\u0010\'\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001A\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0012\u0010\u000E\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000BR\u0012\u0010\u0010\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0012\u0010\u0012\u001A\u00020\u00138Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u000BR\u0014\u0010\u0018\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001A\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0015\u0088\u0001\u0002¨\u0006)"}, d2={"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "startX", "", "getStartX-impl", "([I)I", "startY", "getStartY-impl", "endX", "getEndX-impl", "endY", "getEndY-impl", "reverse", "", "getReverse-impl", "([I)Z", "diagonalSize", "getDiagonalSize-impl", "hasAdditionOrRemoval", "getHasAdditionOrRemoval-impl", "isAddition", "isAddition-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "equals", "other", "hashCode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class Snake {
    private final int[] data;

    private Snake(int[] arg1) {
        super();
        this.data = arg1;
    }

    public static final void addDiagonalToStack-impl(int[] arg8, IntStack arg9) {
        int v4;
        int v0 = 0;
        int v1 = arg8[0];
        int v3 = arg8[1];
        int v5 = 2;
        if(Snake.getHasAdditionOrRemoval-impl(arg8)) {
            v4 = Math.min(arg8[v5] - arg8[0], arg8[3] - arg8[1]);
            v5 = 4;
            int v6 = arg8[v5] != 0 ? 1 : 0;
            v1 += (v6 | Snake.isAddition-impl(arg8)) ^ 1;
            if(arg8[v5] != 0) {
                v0 = 1;
            }

            v3 += (Snake.isAddition-impl(arg8) ^ 1 | v0) ^ 1;
        }
        else {
            v4 = arg8[v5] - arg8[0];
        }

        arg9.pushDiagonal(v1, v3, v4);
    }

    public static final Snake box-impl(int[] arg1) {
        return new Snake(arg1);
    }

    public static int[] constructor-impl(int[] arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Snake.equals-impl(this.data, arg1);
    }

    public static boolean equals-impl(int[] arg2, Object arg3) {
        if(!(arg3 instanceof Snake)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((Snake)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int[] arg0, int[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final int[] getData() {
        return this.data;
    }

    public static final int getDiagonalSize-impl(int[] arg3) {
        return Math.min(arg3[2] - arg3[0], arg3[3] - arg3[1]);
    }

    public static final int getEndX-impl(int[] arg1) {
        return arg1[2];
    }

    public static final int getEndY-impl(int[] arg1) {
        return arg1[3];
    }

    private static final boolean getHasAdditionOrRemoval-impl(int[] arg4) {
        if(arg4[3] - arg4[1] != arg4[2] - arg4[0]) {
            return 1;
        }

        return 0;
    }

    public static final boolean getReverse-impl(int[] arg1) {
        if(arg1[4] != 0) {
            return 1;
        }

        return 0;
    }

    public static final int getStartX-impl(int[] arg1) {
        return arg1[0];
    }

    public static final int getStartY-impl(int[] arg1) {
        return arg1[1];
    }

    public int hashCode() {
        return Snake.hashCode-impl(this.data);
    }

    public static int hashCode-impl(int[] arg0) {
        return Arrays.hashCode(arg0);
    }

    private static final boolean isAddition-impl(int[] arg4) {
        if(arg4[3] - arg4[1] > arg4[2] - arg4[0]) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return Snake.toString-impl(this.data);
    }

    public static String toString-impl(int[] arg5) {
        boolean v1 = false;
        StringBuilder v0 = new StringBuilder("Snake(").append(arg5[0]).append(',').append(arg5[1]).append(',').append(arg5[2]).append(',').append(arg5[3]).append(',');
        if(arg5[4] != 0) {
            v1 = true;
        }

        return v0.append(v1).append(')').toString();
    }

    public final int[] unbox-impl() {
        return this.data;
    }
}

