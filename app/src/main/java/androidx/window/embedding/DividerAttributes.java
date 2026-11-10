package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0005\b&\u0018\u0000 \u000F2\u00020\u0001:\u0004\f\r\u000E\u000FB\u001D\b\u0002\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001A\u00020\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0010"}, d2={"Landroidx/window/embedding/DividerAttributes;", "", "widthDp", "", "color", "<init>", "(II)V", "getWidthDp", "()I", "getColor", "toString", "", "FixedDividerAttributes", "DraggableDividerAttributes", "DragRange", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DividerAttributes {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J-\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u001BJ\u0010\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u0005H\u0002J\u0012\u0010\u001D\u001A\u00020\u00172\b\b\u0001\u0010\u0010\u001A\u00020\u0005H\u0002J\f\u0010\u001E\u001A\u00020\u0005*\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/window/embedding/DividerAttributes$Companion;", "", "<init>", "()V", "WIDTH_SYSTEM_DEFAULT", "", "NO_DIVIDER", "Landroidx/window/embedding/DividerAttributes;", "TYPE_VALUE_FIXED", "TYPE_VALUE_DRAGGABLE", "DRAG_RANGE_VALUE_UNSPECIFIED", "", "COLOR_SYSTEM_DEFAULT", "createDividerAttributes", "type", "widthDp", "color", "dragRangeMinRatio", "dragRangeMaxRatio", "isDraggingToFullscreenAllowed", "", "createDividerAttributes$window_release", "validateXmlDividerAttributes", "", "hasDragRangeMinRatio", "hasDragRangeMaxRatio", "hasIsDraggingToFullscreenAllowed", "validateXmlDividerAttributes$window_release", "validateWidth", "validateColor", "alpha", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final void access$validateColor(Companion arg0, int arg1) {
            arg0.validateColor(arg1);
        }

        public static final void access$validateWidth(Companion arg0, int arg1) {
            arg0.validateWidth(arg1);
        }

        private final int alpha(int arg1) {
            return arg1 >>> 24;
        }

        public final DividerAttributes createDividerAttributes$window_release(int arg1, int arg2, int arg3, float arg4, float arg5, boolean arg6) {
            if(arg1 != 0) {
                if(arg1 == 1) {
                    Builder v0 = new Builder().setWidthDp(arg2).setColor(arg3).setDraggingToFullscreenAllowed(arg6);
                    float v1 = -1f;
                    if(arg4 == v1 || arg5 == v1) {
                        v0.setDragRange(DragRange.DRAG_RANGE_SYSTEM_DEFAULT);
                    }
                    else {
                        v0.setDragRange(new SplitRatioDragRange(arg4, arg5));
                    }

                    return v0.build();
                }

                throw new IllegalArgumentException("Got unknown divider type " + arg1 + '!');
            }

            return new androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder().setWidthDp(arg2).setColor(arg3).build();
        }

        private final void validateColor(int arg2) {
            if(this.alpha(arg2) == 0xFF) {
                return;
            }

            throw new IllegalArgumentException("Divider color must be opaque. Got: " + Integer.toHexString(arg2).toString());
        }

        private final void validateWidth(int arg2) {
            if(arg2 != -1) {
                if(arg2 >= 0) {
                }
                else {
                    throw new IllegalArgumentException("widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: " + arg2.toString());
                }
            }
        }

        public final void validateXmlDividerAttributes$window_release(int arg1, boolean arg2, boolean arg3, boolean arg4) {
            if(arg1 == 1) {
            }
            else if(arg2) {
                goto label_15;
            }
            else if(!arg3) {
                if(!arg4) {
                    return;
                }

                goto label_7;
            }
            else {
                goto label_11;
            }

            return;
        label_7:
            throw new IllegalArgumentException("Fixed divider does not allow attribute isDraggingToFullscreenAllowed!");
        label_11:
            throw new IllegalArgumentException("Fixed divider does not allow attribute dragRangeMaxRatio!");
        label_15:
            throw new IllegalArgumentException("Fixed divider does not allow attribute dragRangeMinRatio!");
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2={"Landroidx/window/embedding/DividerAttributes$DragRange;", "", "<init>", "()V", "SplitRatioDragRange", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class DragRange {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/window/embedding/DividerAttributes$DragRange$Companion;", "", "<init>", "()V", "DRAG_RANGE_SYSTEM_DEFAULT", "Landroidx/window/embedding/DividerAttributes$DragRange;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.DividerAttributes$DragRange$Companion {
            public androidx.window.embedding.DividerAttributes$DragRange$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.DividerAttributes$DragRange$Companion() {
                super();
            }
        }

        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0012"}, d2={"Landroidx/window/embedding/DividerAttributes$DragRange$SplitRatioDragRange;", "Landroidx/window/embedding/DividerAttributes$DragRange;", "minRatio", "", "maxRatio", "<init>", "(FF)V", "getMinRatio", "()F", "getMaxRatio", "toString", "", "equals", "", "other", "", "hashCode", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitRatioDragRange extends DragRange {
            private final float maxRatio;
            private final float minRatio;

            public SplitRatioDragRange(float arg7, float arg8) {
                super(null);
                this.minRatio = arg7;
                this.maxRatio = arg8;
                double v2 = 0;
                if((((double)arg7)) > v2) {
                    double v4 = 1;
                    if((((double)arg7)) < v4) {
                        if((((double)arg8)) > v2 && (((double)arg8)) < v4) {
                            if(arg7 <= arg8) {
                                return;
                            }
                            else {
                                throw new IllegalArgumentException("minRatio must be less than or equal to maxRatio");
                            }
                        }

                        throw new IllegalArgumentException("maxRatio must be in the interval (0.0, 1.0)");
                    }
                }

                throw new IllegalArgumentException("minRatio must be in the interval (0.0, 1.0)");
            }

            public boolean equals(Object arg5) {
                if(this == (((SplitRatioDragRange)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof SplitRatioDragRange)) {
                    return 0;
                }

                if(this.minRatio == ((SplitRatioDragRange)arg5).minRatio && this.maxRatio == ((SplitRatioDragRange)arg5).maxRatio) {
                    return 1;
                }

                return 0;
            }

            public final float getMaxRatio() {
                return this.maxRatio;
            }

            public final float getMinRatio() {
                return this.minRatio;
            }

            public int hashCode() {
                return Float.hashCode(this.minRatio) * 0x1F + Float.hashCode(this.maxRatio);
            }

            public String toString() {
                return "SplitRatioDragRange[" + this.minRatio + ", " + this.maxRatio + ']';
            }
        }

        public static final androidx.window.embedding.DividerAttributes$DragRange$Companion Companion;
        public static final DragRange DRAG_RANGE_SYSTEM_DEFAULT;

        static {
            DragRange.Companion = new androidx.window.embedding.DividerAttributes$DragRange$Companion(null);
            DragRange.DRAG_RANGE_SYSTEM_DEFAULT = new DividerAttributes$DragRange$Companion$DRAG_RANGE_SYSTEM_DEFAULT$1();
        }

        private DragRange() {
            super();
        }

        public DragRange(DefaultConstructorMarker arg1) {
            this();
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B1\b\u0003\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000E\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0003H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\r¨\u0006\u0015"}, d2={"Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;", "Landroidx/window/embedding/DividerAttributes;", "widthDp", "", "color", "dragRange", "Landroidx/window/embedding/DividerAttributes$DragRange;", "isDraggingToFullscreenAllowed", "", "<init>", "(IILandroidx/window/embedding/DividerAttributes$DragRange;Z)V", "getDragRange", "()Landroidx/window/embedding/DividerAttributes$DragRange;", "()Z", "equals", "other", "", "hashCode", "toString", "", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DraggableDividerAttributes extends DividerAttributes {
        @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\u000E\u001A\u00020\u00002\b\b\u0001\u0010\u0007\u001A\u00020\bH\u0007J\u0012\u0010\u000F\u001A\u00020\u00002\b\b\u0001\u0010\t\u001A\u00020\bH\u0007J\u0010\u0010\u0010\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0010\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\rH\u0007J\b\u0010\u0013\u001A\u00020\u0005H\u0007R\u0012\u0010\u0007\u001A\u00020\b8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\b8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes$Builder;", "", "<init>", "()V", "original", "Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;", "(Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;)V", "widthDp", "", "color", "dragRange", "Landroidx/window/embedding/DividerAttributes$DragRange;", "isDraggingToFullscreenAllowed", "", "setWidthDp", "setColor", "setDragRange", "setDraggingToFullscreenAllowed", "allowed", "build", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
            private int color;
            private DragRange dragRange;
            private boolean isDraggingToFullscreenAllowed;
            private int widthDp;

            public Builder() {
                super();
                this.widthDp = -1;
                this.color = 0xFF000000;
                this.dragRange = DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            }

            public Builder(DraggableDividerAttributes arg2) {
                Intrinsics.checkNotNullParameter(arg2, "original");
                this();
                this.widthDp = arg2.getWidthDp();
                this.dragRange = arg2.getDragRange();
                this.color = arg2.getColor();
                this.isDraggingToFullscreenAllowed = arg2.isDraggingToFullscreenAllowed();
            }

            public final DraggableDividerAttributes build() {
                return new DraggableDividerAttributes(this.widthDp, this.color, this.dragRange, this.isDraggingToFullscreenAllowed, null);
            }

            public final Builder setColor(int arg2) {
                DividerAttributes.Companion.validateColor(arg2);
                this.color = arg2;
                return this;
            }

            public final Builder setDragRange(DragRange arg2) {
                Intrinsics.checkNotNullParameter(arg2, "dragRange");
                this.dragRange = arg2;
                return this;
            }

            public final Builder setDraggingToFullscreenAllowed(boolean arg2) {
                this.isDraggingToFullscreenAllowed = arg2;
                return this;
            }

            public final Builder setWidthDp(int arg2) {
                DividerAttributes.Companion.validateWidth(arg2);
                this.widthDp = arg2;
                return this;
            }
        }

        private final DragRange dragRange;
        private final boolean isDraggingToFullscreenAllowed;

        private DraggableDividerAttributes(int arg2, int arg3, DragRange arg4, boolean arg5) {
            super(arg2, arg3, null);
            this.dragRange = arg4;
            this.isDraggingToFullscreenAllowed = arg5;
        }

        DraggableDividerAttributes(int arg1, int arg2, DragRange arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
            if((arg5 & 1) != 0) {
                arg1 = -1;
            }

            if((arg5 & 2) != 0) {
                arg2 = 0xFF000000;
            }

            if((arg5 & 4) != 0) {
                arg3 = DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            }

            this(arg1, arg2, arg3, false);
        }

        public DraggableDividerAttributes(int arg1, int arg2, DragRange arg3, boolean arg4, DefaultConstructorMarker arg5) {
            this(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((DraggableDividerAttributes)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof DraggableDividerAttributes)) {
                return 0;
            }

            if(this.getWidthDp() == ((DraggableDividerAttributes)arg5).getWidthDp() && this.getColor() == ((DraggableDividerAttributes)arg5).getColor() && (Intrinsics.areEqual(this.dragRange, ((DraggableDividerAttributes)arg5).dragRange)) && this.isDraggingToFullscreenAllowed == ((DraggableDividerAttributes)arg5).isDraggingToFullscreenAllowed) {
                return 1;
            }

            return 0;
        }

        public final DragRange getDragRange() {
            return this.dragRange;
        }

        public int hashCode() {
            return ((this.getWidthDp() * 0x1F + this.getColor()) * 0x1F + this.dragRange.hashCode()) * 0x1F + Boolean.hashCode(this.isDraggingToFullscreenAllowed);
        }

        public final boolean isDraggingToFullscreenAllowed() {
            return this.isDraggingToFullscreenAllowed;
        }

        public String toString() {
            return DraggableDividerAttributes.class.getSimpleName() + "{width=" + this.getWidthDp() + ", color=" + this.getColor() + ", primaryContainerDragRange=" + this.dragRange + ", isDraggingToFullscreenAllowed=" + this.isDraggingToFullscreenAllowed + '}';
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u001D\b\u0003\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016¨\u0006\r"}, d2={"Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;", "Landroidx/window/embedding/DividerAttributes;", "widthDp", "", "color", "<init>", "(II)V", "equals", "", "other", "", "hashCode", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FixedDividerAttributes extends DividerAttributes {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\n\u001A\u00020\u00002\b\b\u0001\u0010\u0007\u001A\u00020\bH\u0007J\u0012\u0010\u000B\u001A\u00020\u00002\b\b\u0001\u0010\t\u001A\u00020\bH\u0007J\b\u0010\f\u001A\u00020\u0005H\u0007R\u0012\u0010\u0007\u001A\u00020\b8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\b8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes$Builder;", "", "<init>", "()V", "original", "Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;", "(Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;)V", "widthDp", "", "color", "setWidthDp", "setColor", "build", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder {
            private int color;
            private int widthDp;

            public androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder() {
                super();
                this.widthDp = -1;
                this.color = 0xFF000000;
            }

            public androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder(FixedDividerAttributes arg2) {
                Intrinsics.checkNotNullParameter(arg2, "original");
                this();
                this.widthDp = arg2.getWidthDp();
                this.color = arg2.getColor();
            }

            public final FixedDividerAttributes build() {
                return new FixedDividerAttributes(this.widthDp, this.color, null);
            }

            public final androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder setColor(int arg2) {
                DividerAttributes.Companion.validateColor(arg2);
                this.color = arg2;
                return this;
            }

            public final androidx.window.embedding.DividerAttributes$FixedDividerAttributes$Builder setWidthDp(int arg2) {
                DividerAttributes.Companion.validateWidth(arg2);
                this.widthDp = arg2;
                return this;
            }
        }

        private FixedDividerAttributes(int arg2, int arg3) {
            super(arg2, arg3, null);
        }

        FixedDividerAttributes(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 1) != 0) {
                arg1 = -1;
            }

            if((arg3 & 2) != 0) {
                arg2 = 0xFF000000;
            }

            this(arg1, arg2);
        }

        public FixedDividerAttributes(int arg1, int arg2, DefaultConstructorMarker arg3) {
            this(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((FixedDividerAttributes)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof FixedDividerAttributes)) {
                return 0;
            }

            if(this.getWidthDp() == ((FixedDividerAttributes)arg5).getWidthDp() && this.getColor() == ((FixedDividerAttributes)arg5).getColor()) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return this.getWidthDp() * 0x1F + this.getColor();
        }
    }

    public static final int COLOR_SYSTEM_DEFAULT = 0xFF000000;
    public static final Companion Companion = null;
    public static final float DRAG_RANGE_VALUE_UNSPECIFIED = -1f;
    public static final DividerAttributes NO_DIVIDER = null;
    public static final int TYPE_VALUE_DRAGGABLE = 1;
    public static final int TYPE_VALUE_FIXED = 0;
    public static final int WIDTH_SYSTEM_DEFAULT = -1;
    private final int color;
    private final int widthDp;

    static {
        DividerAttributes.Companion = new Companion(null);
        DividerAttributes.NO_DIVIDER = new DividerAttributes$Companion$NO_DIVIDER$1();
    }

    private DividerAttributes(int arg1, int arg2) {
        super();
        this.widthDp = arg1;
        this.color = arg2;
    }

    DividerAttributes(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = -1;
        }

        if((arg3 & 2) != 0) {
            arg2 = 0xFF000000;
        }

        this(arg1, arg2);
    }

    public DividerAttributes(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getWidthDp() {
        return this.widthDp;
    }

    public String toString() {
        return "DividerAttributes{width=" + this.widthDp + ", color=" + this.color + '}';
    }
}

