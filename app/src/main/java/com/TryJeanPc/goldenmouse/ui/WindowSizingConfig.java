package com.TryJeanPc.goldenmouse.ui;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000FJ\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000FJ\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000FJ\u0010\u0010 \u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000FJ\u0010\u0010!\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000FJ\u0010\u0010\"\u001A\u0004\u0018\u00010\u000BHÆ\u0003¢\u0006\u0002\u0010\u0019Jj\u0010#\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001A\u00020\u0003HÖ\u0001J\t\u0010)\u001A\u00020*HÖ\u0001R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0015\u0010\u000FR\u0015\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0016\u0010\u000FR\u0015\u0010\t\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u0017\u0010\u000FR\u0015\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;", "", "preferredWidthDp", "", "preferredHeightDp", "minWidthDp", "minHeightDp", "maxWidthDp", "maxHeightDp", "marginDp", "preferredWidthFraction", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "getPreferredWidthDp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreferredHeightDp", "getMinWidthDp", "()I", "getMinHeightDp", "getMaxWidthDp", "getMaxHeightDp", "getMarginDp", "getPreferredWidthFraction", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/TryJeanPc/goldenmouse/ui/WindowSizingConfig;", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WindowSizingConfig {
    public static final int $stable;
    private final Integer marginDp;
    private final Integer maxHeightDp;
    private final Integer maxWidthDp;
    private final int minHeightDp;
    private final int minWidthDp;
    private final Integer preferredHeightDp;
    private final Integer preferredWidthDp;
    private final Float preferredWidthFraction;

    static {
    }

    public WindowSizingConfig(Integer arg3, Integer arg4, int arg5, int arg6, Integer arg7, Integer arg8, Integer arg9, Float arg10, int arg11, DefaultConstructorMarker arg12) {
        Integer v0 = null;
        if((arg11 & 1) != 0) {
            arg3 = v0;
        }

        if((arg11 & 2) != 0) {
            arg4 = v0;
        }

        if((arg11 & 16) != 0) {
            arg7 = v0;
        }

        if((arg11 & 0x20) != 0) {
            arg8 = v0;
        }

        if((arg11 & 0x40) != 0) {
            arg9 = v0;
        }

        if((arg11 & 0x80) != 0) {
            arg10 = ((Float)v0);
        }

        this(arg3, arg4, 0, 0, arg7, arg8, arg9, arg10);
    }

    public WindowSizingConfig() {
        this(null, null, 0, 0, null, null, null, null, 0xFF, null);
    }

    public WindowSizingConfig(Integer arg1, Integer arg2, int arg3, int arg4, Integer arg5, Integer arg6, Integer arg7, Float arg8) {
        super();
        this.preferredWidthDp = arg1;
        this.preferredHeightDp = arg2;
        this.minWidthDp = arg3;
        this.minHeightDp = arg4;
        this.maxWidthDp = arg5;
        this.maxHeightDp = arg6;
        this.marginDp = arg7;
        this.preferredWidthFraction = arg8;
        String v7 = "Failed requirement.";
        if(arg3 >= 0 && arg4 >= 0) {
            List v1 = CollectionsKt.listOfNotNull(new Integer[]{arg1, arg2, arg5, arg6});
            if(!(v1 instanceof Collection) || !v1.isEmpty()) {
                Iterator v1_1 = ((Iterable)v1).iterator();
                while(true) {
                    if(v1_1.hasNext()) {
                        if(v1_1.next().intValue() > 0) {
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_40;
                }

                throw new IllegalArgumentException(v7.toString());
            }
            else {
            }

        label_40:
            arg1 = this.marginDp;
            if(arg1 != null) {
                if(arg1.intValue() >= 0) {
                }
                else {
                    throw new IllegalArgumentException(v7.toString());
                }
            }

            Float v1_2 = this.preferredWidthFraction;
            if(v1_2 != null && (Math.abs(v1_2.floatValue()) > 3.402823E+38f || this.preferredWidthFraction.floatValue() <= 0f || this.preferredWidthFraction.floatValue() > 1f)) {
                throw new IllegalArgumentException(v7.toString());
            }

            return;
        }

        throw new IllegalArgumentException(v7.toString());
    }

    public final Integer component1() {
        return this.preferredWidthDp;
    }

    public final Integer component2() {
        return this.preferredHeightDp;
    }

    public final int component3() {
        return this.minWidthDp;
    }

    public final int component4() {
        return this.minHeightDp;
    }

    public final Integer component5() {
        return this.maxWidthDp;
    }

    public final Integer component6() {
        return this.maxHeightDp;
    }

    public final Integer component7() {
        return this.marginDp;
    }

    public final Float component8() {
        return this.preferredWidthFraction;
    }

    public final WindowSizingConfig copy(Integer arg1, Integer arg2, int arg3, int arg4, Integer arg5, Integer arg6, Integer arg7, Float arg8) {
        return new WindowSizingConfig(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static WindowSizingConfig copy$default(WindowSizingConfig arg0, Integer arg1, Integer arg2, int arg3, int arg4, Integer arg5, Integer arg6, Integer arg7, Float arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.preferredWidthDp;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.preferredHeightDp;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.minWidthDp;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.minHeightDp;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.maxWidthDp;
        }

        if((arg9 & 0x20) != 0) {
            arg6 = arg0.maxHeightDp;
        }

        if((arg9 & 0x40) != 0) {
            arg7 = arg0.marginDp;
        }

        if((arg9 & 0x80) != 0) {
            arg8 = arg0.preferredWidthFraction;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public boolean equals(Object arg5) {
        if(this == (((WindowSizingConfig)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof WindowSizingConfig)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.preferredWidthDp, ((WindowSizingConfig)arg5).preferredWidthDp)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.preferredHeightDp, ((WindowSizingConfig)arg5).preferredHeightDp)) {
            return 0;
        }

        if(this.minWidthDp != ((WindowSizingConfig)arg5).minWidthDp) {
            return 0;
        }

        if(this.minHeightDp != ((WindowSizingConfig)arg5).minHeightDp) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.maxWidthDp, ((WindowSizingConfig)arg5).maxWidthDp)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.maxHeightDp, ((WindowSizingConfig)arg5).maxHeightDp)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.marginDp, ((WindowSizingConfig)arg5).marginDp)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.preferredWidthFraction, ((WindowSizingConfig)arg5).preferredWidthFraction)) {
            return 0;
        }

        return 1;
    }

    public final Integer getMarginDp() {
        return this.marginDp;
    }

    public final Integer getMaxHeightDp() {
        return this.maxHeightDp;
    }

    public final Integer getMaxWidthDp() {
        return this.maxWidthDp;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getMinWidthDp() {
        return this.minWidthDp;
    }

    public final Integer getPreferredHeightDp() {
        return this.preferredHeightDp;
    }

    public final Integer getPreferredWidthDp() {
        return this.preferredWidthDp;
    }

    public final Float getPreferredWidthFraction() {
        return this.preferredWidthFraction;
    }

    public int hashCode() {
        Integer v0 = this.preferredWidthDp;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Integer v2 = this.preferredHeightDp;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (((v0_1 + v2_1) * 0x1F + Integer.hashCode(this.minWidthDp)) * 0x1F + Integer.hashCode(this.minHeightDp)) * 0x1F;
        v2 = this.maxWidthDp;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.maxHeightDp;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.marginDp;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Float v3 = this.preferredWidthFraction;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "WindowSizingConfig(preferredWidthDp=" + this.preferredWidthDp + ", preferredHeightDp=" + this.preferredHeightDp + ", minWidthDp=" + this.minWidthDp + ", minHeightDp=" + this.minHeightDp + ", maxWidthDp=" + this.maxWidthDp + ", maxHeightDp=" + this.maxHeightDp + ", marginDp=" + this.marginDp + ", preferredWidthFraction=" + this.preferredWidthFraction + ")";
    }
}

