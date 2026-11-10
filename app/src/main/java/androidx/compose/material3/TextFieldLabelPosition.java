package androidx.compose.material3;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2={"Landroidx/compose/material3/TextFieldLabelPosition;", "", "<init>", "()V", "Attached", "Above", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class TextFieldLabelPosition {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/material3/TextFieldLabelPosition$Above;", "Landroidx/compose/material3/TextFieldLabelPosition;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "equals", "", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Above extends TextFieldLabelPosition {
        public static final int $stable;
        private final Horizontal alignment;

        static {
        }

        public Above() {
            this(null, 1, null);
        }

        public Above(Horizontal arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = Alignment.Companion.getStart();
            }

            this(arg1);
        }

        public Above(Horizontal arg2) {
            super(null);
            this.alignment = arg2;
        }

        public boolean equals(Object arg2) {
            if(this == (((Above)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof Above)) {
                return 0;
            }

            return Intrinsics.areEqual(this.alignment, ((Above)arg2).alignment);
        }

        public final Horizontal getAlignment() {
            return this.alignment;
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public String toString() {
            return "Above(alignment=" + this.alignment + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000E\u001A\u00020\u00032\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0015"}, d2={"Landroidx/compose/material3/TextFieldLabelPosition$Attached;", "Landroidx/compose/material3/TextFieldLabelPosition;", "alwaysMinimize", "", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "<init>", "(ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;)V", "getAlwaysMinimize", "()Z", "getMinimizedAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getExpandedAlignment", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Attached extends TextFieldLabelPosition {
        public static final int $stable;
        private final boolean alwaysMinimize;
        private final Horizontal expandedAlignment;
        private final Horizontal minimizedAlignment;

        static {
        }

        public Attached(boolean arg1, Horizontal arg2, Horizontal arg3, int arg4, DefaultConstructorMarker arg5) {
            if((arg4 & 2) != 0) {
                arg2 = Alignment.Companion.getStart();
            }

            if((arg4 & 4) != 0) {
                arg3 = Alignment.Companion.getStart();
            }

            this(false, arg2, arg3);
        }

        public Attached() {
            this(false, null, null, 7, null);
        }

        public Attached(boolean arg2, Horizontal arg3, Horizontal arg4) {
            super(null);
            this.alwaysMinimize = arg2;
            this.minimizedAlignment = arg3;
            this.expandedAlignment = arg4;
        }

        public boolean equals(Object arg5) {
            if(this == (((Attached)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Attached)) {
                return 0;
            }

            if(this.alwaysMinimize != ((Attached)arg5).alwaysMinimize) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.minimizedAlignment, ((Attached)arg5).minimizedAlignment)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.expandedAlignment, ((Attached)arg5).expandedAlignment)) {
                return 0;
            }

            return 1;
        }

        public final boolean getAlwaysMinimize() {
            return this.alwaysMinimize;
        }

        public final Horizontal getExpandedAlignment() {
            return this.expandedAlignment;
        }

        public final Horizontal getMinimizedAlignment() {
            return this.minimizedAlignment;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.alwaysMinimize) * 0x1F + this.minimizedAlignment.hashCode()) * 0x1F + this.expandedAlignment.hashCode();
        }

        public String toString() {
            return "Attached(alwaysMinimize=" + this.alwaysMinimize + ", minimizedAlignment=" + this.minimizedAlignment + ", expandedAlignment=" + this.expandedAlignment + ')';
        }
    }

    public static final int $stable;

    static {
    }

    private TextFieldLabelPosition() {
        super();
    }

    public TextFieldLabelPosition(DefaultConstructorMarker arg1) {
        this();
    }
}

