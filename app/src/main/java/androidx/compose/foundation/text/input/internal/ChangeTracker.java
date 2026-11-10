package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer$ChangeList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001!B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\nJ\u0006\u0010\u0012\u001A\u00020\u000EJ\u0017\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u001A\u001A\u00020\u001BH\u0016J*\u0010\u001C\u001A\u00020\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010 \u001A\u00020\nH\u0002R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\""}, d2={"Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "initialChanges", "<init>", "(Landroidx/compose/foundation/text/input/internal/ChangeTracker;)V", "_changes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "_changesTemp", "changeCount", "", "getChangeCount", "()I", "trackChange", "", "preStart", "preEnd", "postLength", "clearChanges", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "toString", "", "appendNewChange", "mergedOverlappingChange", "preMin", "preMax", "postDelta", "Change", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChangeTracker implements ChangeList {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J1\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\n\"\u0004\b\u000E\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\n\"\u0004\b\u0010\u0010\fR\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "", "preStart", "", "preEnd", "originalStart", "originalEnd", "<init>", "(IIII)V", "getPreStart", "()I", "setPreStart", "(I)V", "getPreEnd", "setPreEnd", "getOriginalStart", "setOriginalStart", "getOriginalEnd", "setOriginalEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Change {
        private int originalEnd;
        private int originalStart;
        private int preEnd;
        private int preStart;

        public Change(int arg1, int arg2, int arg3, int arg4) {
            super();
            this.preStart = arg1;
            this.preEnd = arg2;
            this.originalStart = arg3;
            this.originalEnd = arg4;
        }

        public final int component1() {
            return this.preStart;
        }

        public final int component2() {
            return this.preEnd;
        }

        public final int component3() {
            return this.originalStart;
        }

        public final int component4() {
            return this.originalEnd;
        }

        public final Change copy(int arg1, int arg2, int arg3, int arg4) {
            return new Change(arg1, arg2, arg3, arg4);
        }

        public static Change copy$default(Change arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.preStart;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.preEnd;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.originalStart;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.originalEnd;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((Change)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Change)) {
                return 0;
            }

            if(this.preStart != ((Change)arg5).preStart) {
                return 0;
            }

            if(this.preEnd != ((Change)arg5).preEnd) {
                return 0;
            }

            if(this.originalStart != ((Change)arg5).originalStart) {
                return 0;
            }

            if(this.originalEnd != ((Change)arg5).originalEnd) {
                return 0;
            }

            return 1;
        }

        public final int getOriginalEnd() {
            return this.originalEnd;
        }

        public final int getOriginalStart() {
            return this.originalStart;
        }

        public final int getPreEnd() {
            return this.preEnd;
        }

        public final int getPreStart() {
            return this.preStart;
        }

        public int hashCode() {
            return ((Integer.hashCode(this.preStart) * 0x1F + Integer.hashCode(this.preEnd)) * 0x1F + Integer.hashCode(this.originalStart)) * 0x1F + Integer.hashCode(this.originalEnd);
        }

        public final void setOriginalEnd(int arg1) {
            this.originalEnd = arg1;
        }

        public final void setOriginalStart(int arg1) {
            this.originalStart = arg1;
        }

        public final void setPreEnd(int arg1) {
            this.preEnd = arg1;
        }

        public final void setPreStart(int arg1) {
            this.preStart = arg1;
        }

        public String toString() {
            return "Change(preStart=" + this.preStart + ", preEnd=" + this.preEnd + ", originalStart=" + this.originalStart + ", originalEnd=" + this.originalEnd + ')';
        }
    }

    public static final int $stable = 8;
    private MutableVector _changes;
    private MutableVector _changesTemp;

    static {
    }

    public ChangeTracker(ChangeTracker arg9) {
        super();
        int v3 = 0;
        this._changes = new MutableVector(new Change[16], 0);
        this._changesTemp = new MutableVector(new Change[16], 0);
        if(arg9 != null) {
            MutableVector v9 = arg9._changes;
            if(v9 != null) {
                Object[] v0 = v9.content;
                int v9_1 = v9.getSize();
                while(v3 < v9_1) {
                    this._changes.add(new Change(v0[v3].getPreStart(), v0[v3].getPreEnd(), v0[v3].getOriginalStart(), v0[v3].getOriginalEnd()));
                    ++v3;
                }
            }
        }
    }

    public ChangeTracker(ChangeTracker arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public ChangeTracker() {
        this(null, 1, null);
    }

    private final void appendNewChange(Change arg3, int arg4, int arg5, int arg6) {
        int v0;
        if(this._changesTemp.getSize() == 0) {
            v0 = 0;
        }
        else {
            Object v0_1 = this._changesTemp.last();
            v0 = ((Change)v0_1).getPreEnd() - ((Change)v0_1).getOriginalEnd();
        }

        if(arg3 == null) {
            int v3 = arg4 - v0;
            arg3 = new Change(arg4, arg5 + arg6, v3, arg5 - arg4 + v3);
        }
        else {
            if(arg3.getPreStart() > arg4) {
                arg3.setPreStart(arg4);
                arg3.setOriginalStart(arg4);
            }

            if(arg5 > arg3.getPreEnd()) {
                arg4 = arg3.getPreEnd() - arg3.getOriginalEnd();
                arg3.setPreEnd(arg5);
                arg3.setOriginalEnd(arg5 - arg4);
            }

            arg3.setPreEnd(arg3.getPreEnd() + arg6);
        }

        this._changesTemp.add(arg3);
    }

    public final void clearChanges() {
        this._changes.clear();
    }

    public int getChangeCount() {
        return this._changes.getSize();
    }

    public long getOriginalRange--jx7JFs(int arg1) {
        return TextRangeKt.TextRange(this._changes.content[arg1].getOriginalStart(), this._changes.content[arg1].getOriginalEnd());
    }

    public long getRange--jx7JFs(int arg1) {
        return TextRangeKt.TextRange(this._changes.content[arg1].getPreStart(), this._changes.content[arg1].getPreEnd());
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("ChangeList(changes=[");
        MutableVector v1 = this._changes;
        Object[] v2 = v1.content;
        int v1_1 = v1.getSize();
        int v3;
        for(v3 = 0; v3 < v1_1; ++v3) {
            v0.append("(" + v2[v3].getOriginalStart() + ',' + v2[v3].getOriginalEnd() + ")->(" + v2[v3].getPreStart() + ',' + v2[v3].getPreEnd() + ')');
            if(v3 < this.getChangeCount() - 1) {
                v0.append(", ");
            }
        }

        v0.append("])");
        String v8 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v8, "toString(...)");
        return v8;
    }

    public final void trackChange(int arg7, int arg8, int arg9) {
        if(arg7 == arg8 && arg9 == 0) {
            return;
        }

        int v0 = Math.min(arg7, arg8);
        arg7 = Math.max(arg7, arg8);
        arg9 -= arg7 - v0;
        arg8 = 0;
        Object v2 = null;
        int v1 = 0;
        while(arg8 < this._changes.getSize()) {
            Object v3 = this._changes.content[arg8];
            int v4 = ((Change)v3).getPreStart();
            if(v0 > v4 || v4 > arg7) {
                v4 = ((Change)v3).getPreEnd();
                if(v0 <= v4 && v4 <= arg7) {
                    goto label_34;
                }

                v4 = ((Change)v3).getPreStart();
                if(v0 <= ((Change)v3).getPreEnd() && v4 <= v0) {
                    goto label_34;
                }

                v4 = ((Change)v3).getPreStart();
                if(arg7 <= ((Change)v3).getPreEnd() && v4 <= arg7) {
                label_34:
                    if(v2 == null) {
                        v2 = v3;
                    }
                    else {
                        ((Change)v2).setPreEnd(((Change)v3).getPreEnd());
                        ((Change)v2).setOriginalEnd(((Change)v3).getOriginalEnd());
                    }

                    goto label_41;
                }

                if(((Change)v3).getPreStart() > arg7 && v1 == 0) {
                    this.appendNewChange(((Change)v2), v0, arg7, arg9);
                    v1 = 1;
                }

                if(v1 != 0) {
                    ((Change)v3).setPreStart(((Change)v3).getPreStart() + arg9);
                    ((Change)v3).setPreEnd(((Change)v3).getPreEnd() + arg9);
                }

                this._changesTemp.add(v3);
            }
            else {
                goto label_34;
            }

        label_41:
            ++arg8;
        }

        if(v1 == 0) {
            this.appendNewChange(((Change)v2), v0, arg7, arg9);
        }

        MutableVector v7 = this._changes;
        this._changes = this._changesTemp;
        this._changesTemp = v7;
        v7.clear();
    }
}

