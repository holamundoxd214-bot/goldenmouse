package com.TryJeanPc.goldenmouse.aim;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B+\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001A\u00020\u0011J\u0006\u0010\u0012\u001A\u00020\u0011J\u0006\u0010\u0013\u001A\u00020\fJ\"\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator;", "", "downLockMs", "", "suppressAxis", "Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator$SuppressAxis;", "nanoTimeProvider", "Lkotlin/Function0;", "<init>", "(JLcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator$SuppressAxis;Lkotlin/jvm/functions/Function0;)V", "fireDownAtNanos", "value", "", "fireHeld", "getFireHeld", "()Z", "onFireDown", "", "onFireUp", "shouldForwardFireDrag", "filterCameraDelta", "Lkotlin/Pair;", "", "dx", "dy", "SuppressAxis", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FireAimCoordinator {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/FireAimCoordinator$SuppressAxis;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "VERTICAL", "HORIZONTAL", "BOTH", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum SuppressAxis {
        public static final enum SuppressAxis BOTH;
        public static final enum SuppressAxis HORIZONTAL;
        public static final enum SuppressAxis NONE;
        public static final enum SuppressAxis VERTICAL;

        private static final SuppressAxis[] $values() {
            return new SuppressAxis[]{SuppressAxis.NONE, SuppressAxis.VERTICAL, SuppressAxis.HORIZONTAL, SuppressAxis.BOTH};
        }

        static {
            SuppressAxis.NONE = new SuppressAxis("NONE", 0);
            SuppressAxis.VERTICAL = new SuppressAxis("VERTICAL", 1);
            SuppressAxis.HORIZONTAL = new SuppressAxis("HORIZONTAL", 2);
            SuppressAxis.BOTH = new SuppressAxis("BOTH", 3);
            SuppressAxis[] v0 = SuppressAxis.$values();
            SuppressAxis.$VALUES = v0;
            SuppressAxis.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private SuppressAxis(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return SuppressAxis.$ENTRIES;
        }

        public static SuppressAxis valueOf(String arg1) {
            return Enum.valueOf(SuppressAxis.class, arg1);
        }

        public static SuppressAxis[] values() {
            return SuppressAxis.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SuppressAxis.values().length];
            try {
                v0[SuppressAxis.NONE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SuppressAxis.VERTICAL.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[SuppressAxis.HORIZONTAL.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[SuppressAxis.BOTH.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private final long downLockMs;
    private volatile long fireDownAtNanos;
    private volatile boolean fireHeld;
    private final Function0 nanoTimeProvider;
    private final SuppressAxis suppressAxis;

    static {
    }

    public FireAimCoordinator(long arg1, SuppressAxis arg3, Function0 arg4, int arg5, DefaultConstructorMarker arg6) {
        com.TryJeanPc.goldenmouse.aim.FireAimCoordinator$1 v4;
        if((arg5 & 1) != 0) {
            arg1 = 40;
        }

        if((arg5 & 2) != 0) {
            arg3 = SuppressAxis.NONE;
        }

        if((arg5 & 4) != 0) {
            v4 = com.TryJeanPc.goldenmouse.aim.FireAimCoordinator$1.INSTANCE;
        }

        this(arg1, arg3, ((Function0)v4));
    }

    public FireAimCoordinator() {
        this(0, null, null, 7, null);
    }

    public FireAimCoordinator(long arg2, SuppressAxis arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "suppressAxis");
        Intrinsics.checkNotNullParameter(arg5, "nanoTimeProvider");
        super();
        this.downLockMs = arg2;
        this.suppressAxis = arg4;
        this.nanoTimeProvider = arg5;
    }

    public final Pair filterCameraDelta(int arg3, int arg4) {
        if(!this.fireHeld) {
            return TuplesKt.to(Integer.valueOf(arg3), Integer.valueOf(arg4));
        }

        int v2 = WhenMappings.$EnumSwitchMapping$0[this.suppressAxis.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 != 3) {
                    if(v2 == 4) {
                        return TuplesKt.to(Integer.valueOf(0), Integer.valueOf(0));
                    }

                    throw new NoWhenBranchMatchedException();
                }

                return TuplesKt.to(Integer.valueOf(0), Integer.valueOf(arg4));
            }

            return TuplesKt.to(Integer.valueOf(arg3), Integer.valueOf(0));
        }

        return TuplesKt.to(Integer.valueOf(arg3), Integer.valueOf(arg4));
    }

    public final boolean getFireHeld() {
        return this.fireHeld;
    }

    public final void onFireDown() {
        this.fireDownAtNanos = this.nanoTimeProvider.invoke().longValue();
        this.fireHeld = true;
    }

    public final void onFireUp() {
        this.fireHeld = false;
    }

    public final boolean shouldForwardFireDrag() {
        if(!this.fireHeld) {
            return 0;
        }

        if(Long.compare(this.downLockMs, 0) <= 0) {
            return 1;
        }

        if(this.nanoTimeProvider.invoke().longValue() - this.fireDownAtNanos >= this.downLockMs * 1000000) {
            return 1;
        }

        return 0;
    }
}

