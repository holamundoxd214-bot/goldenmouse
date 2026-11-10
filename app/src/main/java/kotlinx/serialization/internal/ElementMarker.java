package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0018\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0006J\u0006\u0010\u0011\u001A\u00020\u0006J\u0010\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u0006H\u0002J\u0010\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0006H\u0002J\b\u0010\u0015\u001A\u00020\u0006H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lkotlinx/serialization/internal/ElementMarker;", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "readIfAbsent", "Lkotlin/Function2;", "", "", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "lowerMarks", "", "highMarksArray", "", "mark", "", "index", "nextUnmarkedIndex", "prepareHighMarksArray", "elementsCount", "markHigh", "nextUnmarkedHighIndex", "Companion", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @CoreFriendModuleApi public final class ElementMarker {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "<init>", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion;
    private static final long[] EMPTY_HIGH_MARKS;
    private final SerialDescriptor descriptor;
    private final long[] highMarksArray;
    private long lowerMarks;
    private final Function2 readIfAbsent;

    static {
        ElementMarker.Companion = new Companion(null);
        ElementMarker.EMPTY_HIGH_MARKS = new long[0];
    }

    public ElementMarker(SerialDescriptor arg3, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "readIfAbsent");
        super();
        this.descriptor = arg3;
        this.readIfAbsent = arg4;
        int v3 = arg3.getElementsCount();
        long v0 = 0;
        int v4 = 0x40;
        if(v3 <= v4) {
            if(v3 == v4) {
            }
            else {
                v0 = -1 << v3;
            }

            this.lowerMarks = v0;
            this.highMarksArray = ElementMarker.EMPTY_HIGH_MARKS;
            return;
        }

        this.lowerMarks = v0;
        this.highMarksArray = this.prepareHighMarksArray(v3);
    }

    public final void mark(int arg5) {
        if(arg5 < 0x40) {
            this.lowerMarks |= 1 << arg5;
            return;
        }

        this.markHigh(arg5);
    }

    private final void markHigh(int arg6) {
        int v0 = (arg6 >>> 6) - 1;
        this.highMarksArray[v0] |= 1 << (arg6 & 0x3F);
    }

    private final int nextUnmarkedHighIndex() {
        int v4;
        int v0 = this.highMarksArray.length;
        int v1;
        for(v1 = 0; v1 < v0; v1 = v2) {
            int v2 = v1 + 1;
            int v3 = v2 * 0x40;
            long v5 = this.highMarksArray[v1];
            do {
                if(v5 == -1) {
                    goto label_25;
                }

                v4 = Long.numberOfTrailingZeros(~v5);
                v5 |= 1 << v4;
                v4 += v3;
            }
            while(!this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(v4)).booleanValue());

            this.highMarksArray[v1] = v5;
            return v4;
        label_25:
            this.highMarksArray[v1] = v5;
        }

        return -1;
    }

    public final int nextUnmarkedIndex() {
        int v1_1;
        int v0 = this.descriptor.getElementsCount();
        do {
            long v1 = this.lowerMarks;
            if(v1 == -1) {
                goto label_19;
            }

            v1_1 = Long.numberOfTrailingZeros(~v1);
            this.lowerMarks |= 1 << v1_1;
        }
        while(!this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(v1_1)).booleanValue());

        return v1_1;
    label_19:
        if(v0 > 0x40) {
            return this.nextUnmarkedHighIndex();
        }

        return -1;
    }

    private final long[] prepareHighMarksArray(int arg4) {
        long[] v3 = new long[arg4 - 1 >>> 6];
        if((arg4 & 0x3F) != 0) {
            v3[ArraysKt.getLastIndex(v3)] = -1 << arg4;
        }

        return v3;
    }
}

