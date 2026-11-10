package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001H\u0096\u0002R+\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuState;", "", "initialStatus", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "<init>", "(Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;)V", "<set-?>", "status", "getStatus", "()Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "setStatus", "status$delegate", "Landroidx/compose/runtime/MutableState;", "toString", "", "hashCode", "", "equals", "", "other", "Status", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextMenuState {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "", "<init>", "()V", "Open", "Closed", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Status {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "<init>", "()V", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Closed extends Status {
            public static final int $stable;
            public static final Closed INSTANCE;

            static {
                Closed.INSTANCE = new Closed();
            }

            private Closed() {
                super(null);
            }

            public String toString() {
                return "Closed";
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "offset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOffset-F1C5BW0", "()J", "J", "toString", "", "hashCode", "", "equals", "", "other", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Open extends Status {
            public static final int $stable;
            private final long offset;

            static {
            }

            public Open(long arg1, DefaultConstructorMarker arg3) {
                this(arg1);
            }

            private Open(long arg3) {
                super(null);
                this.offset = arg3;
                int v2 = (arg3 & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L ? 1 : 0;
                if(v2 == 0) {
                    InlineClassHelperKt.throwIllegalStateException("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
                }
            }

            public boolean equals(Object arg3) {
                if((((Open)arg3)) == this) {
                    return 1;
                }

                if(!(arg3 instanceof Open)) {
                    return 0;
                }

                return Offset.equals-impl0(this.offset, ((Open)arg3).offset);
            }

            public final long getOffset-F1C5BW0() {
                return this.offset;
            }

            public int hashCode() {
                return Offset.hashCode-impl(this.offset);
            }

            public String toString() {
                return "Open(offset=" + Offset.toString-impl(this.offset) + ')';
            }
        }

        public static final int $stable;

        static {
        }

        private Status() {
            super();
        }

        public Status(DefaultConstructorMarker arg1) {
            this();
        }
    }

    public static final int $stable;
    private final MutableState status$delegate;

    static {
    }

    public ContextMenuState() {
        this(null, 1, null);
    }

    public ContextMenuState(Status arg1, int arg2, DefaultConstructorMarker arg3) {
        Closed v1;
        if((arg2 & 1) != 0) {
            v1 = Closed.INSTANCE;
        }

        this(((Status)v1));
    }

    public ContextMenuState(Status arg3) {
        super();
        this.status$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    public boolean equals(Object arg2) {
        if((((ContextMenuState)arg2)) == this) {
            return 1;
        }

        if(!(arg2 instanceof ContextMenuState)) {
            return 0;
        }

        return Intrinsics.areEqual(((ContextMenuState)arg2).getStatus(), this.getStatus());
    }

    public final Status getStatus() {
        return this.status$delegate.getValue();
    }

    public int hashCode() {
        return this.getStatus().hashCode();
    }

    public final void setStatus(Status arg1) {
        this.status$delegate.setValue(arg1);
    }

    public String toString() {
        return "ContextMenuState(status=" + this.getStatus() + ')';
    }
}

