package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000B\f\r¨\u0006\u000E"}, d2={"Landroidx/compose/ui/graphics/Outline;", "", "<init>", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "Rectangle", "Rounded", "Generic", "Landroidx/compose/ui/graphics/Outline$Generic;", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline$Rounded;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Outline {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/Outline$Generic;", "Landroidx/compose/ui/graphics/Outline;", "path", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/Path;)V", "getPath", "()Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Generic extends Outline {
        public static final int $stable = 8;
        private final Path path;

        static {
        }

        public Generic(Path arg2) {
            super(null);
            this.path = arg2;
        }

        public Rect getBounds() {
            return this.path.getBounds();
        }

        public final Path getPath() {
            return this.path;
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline;", "rect", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/ui/geometry/Rect;)V", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "bounds", "getBounds", "equals", "", "other", "", "hashCode", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Rectangle extends Outline {
        public static final int $stable;
        private final Rect rect;

        static {
        }

        public Rectangle(Rect arg2) {
            super(null);
            this.rect = arg2;
        }

        public boolean equals(Object arg4) {
            if(this == (((Rectangle)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Rectangle)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.rect, ((Rectangle)arg4).rect)) {
                return 0;
            }

            return 1;
        }

        public Rect getBounds() {
            return this.rect;
        }

        public final Rect getRect() {
            return this.rect;
        }

        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0016"}, d2={"Landroidx/compose/ui/graphics/Outline$Rounded;", "Landroidx/compose/ui/graphics/Outline;", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "<init>", "(Landroidx/compose/ui/geometry/RoundRect;)V", "getRoundRect", "()Landroidx/compose/ui/geometry/RoundRect;", "roundRectPath", "Landroidx/compose/ui/graphics/Path;", "getRoundRectPath$ui_graphics", "()Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "equals", "", "other", "", "hashCode", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Rounded extends Outline {
        public static final int $stable;
        private final RoundRect roundRect;
        private final Path roundRectPath;

        static {
        }

        public Rounded(RoundRect arg4) {
            DefaultConstructorMarker v0 = null;
            super(v0);
            this.roundRect = arg4;
            if(!RoundRectKt.isSimple(arg4)) {
                Path v1 = AndroidPath_androidKt.Path();
                Path.addRoundRect$default(v1, arg4, ((Direction)v0), 2, v0);
                Path v0_1 = v1;
            }

            this.roundRectPath = ((Path)v0);
        }

        public boolean equals(Object arg4) {
            if(this == (((Rounded)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Rounded)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.roundRect, ((Rounded)arg4).roundRect)) {
                return 0;
            }

            return 1;
        }

        public Rect getBounds() {
            return RoundRectKt.getBoundingRect(this.roundRect);
        }

        public final RoundRect getRoundRect() {
            return this.roundRect;
        }

        public final Path getRoundRectPath$ui_graphics() {
            return this.roundRectPath;
        }

        public int hashCode() {
            return this.roundRect.hashCode();
        }
    }

    public static final int $stable;

    static {
    }

    private Outline() {
        super();
    }

    public Outline(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract Rect getBounds();
}

