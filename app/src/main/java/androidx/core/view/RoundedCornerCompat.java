package androidx.core.view;

import android.graphics.Point;
import android.view.RoundedCorner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RoundedCornerCompat {
    @Retention(value=RetentionPolicy.SOURCE) @public interface Position {
    }

    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 2;
    public static final int POSITION_TOP_LEFT = 0;
    public static final int POSITION_TOP_RIGHT = 1;
    private final Point mCenter;
    private final int mPosition;
    private final int mRadius;

    public RoundedCornerCompat(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.mPosition = arg1;
        this.mRadius = arg2;
        this.mCenter = new Point(arg3, arg4);
    }

    private RoundedCornerCompat(int arg2, int arg3, Point arg4) {
        this(arg2, arg3, arg4.x, arg4.y);
    }

    public boolean equals(Object arg5) {
        if((((RoundedCornerCompat)arg5)) == this) {
            return 1;
        }

        if(((arg5 instanceof RoundedCornerCompat)) && this.mPosition == ((RoundedCornerCompat)arg5).mPosition && this.mRadius == ((RoundedCornerCompat)arg5).mRadius && (this.mCenter.equals(((RoundedCornerCompat)arg5).mCenter))) {
            return 1;
        }

        return 0;
    }

    public Point getCenter() {
        return new Point(this.mCenter);
    }

    public int getCenterX() {
        return this.mCenter.x;
    }

    public int getCenterY() {
        return this.mCenter.y;
    }

    public int getPosition() {
        return this.mPosition;
    }

    private String getPositionString(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        return "Invalid";
                    }

                    return "BottomLeft";
                }

                return "BottomRight";
            }

            return "TopRight";
        }

        return "TopLeft";
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int hashCode() {
        return (this.mPosition * 0x1F + this.mRadius) * 0x1F + this.mCenter.hashCode();
    }

    private static int toCompatPosition(int arg3) {
        if(arg3 != 0) {
            int v0 = 1;
            if(arg3 != 1) {
                v0 = 2;
                if(arg3 != v0) {
                    v0 = 3;
                    if(arg3 == v0) {
                        return v0;
                    }
                    else {
                        throw new IllegalArgumentException("Invalid position: " + arg3);
                    }
                }
            }

            return v0;
        }

        return 0;
    }

    static int toPlatformPosition(int arg3) {
        if(arg3 != 0) {
            int v0 = 1;
            if(arg3 != 1) {
                v0 = 2;
                if(arg3 != v0) {
                    v0 = 3;
                    if(arg3 == v0) {
                        return v0;
                    }
                    else {
                        throw new IllegalArgumentException("Invalid position: " + arg3);
                    }
                }
            }

            return v0;
        }

        return 0;
    }

    static RoundedCorner toPlatformRoundedCorner(RoundedCornerCompat arg4) {
        if(arg4 != null) {
            return new RoundedCorner(RoundedCornerCompat.toPlatformPosition(arg4.getPosition()), arg4.getRadius(), arg4.getCenterX(), arg4.getCenterY());
        }

        return null;
    }

    static RoundedCornerCompat toRoundedCornerCompat(RoundedCorner arg3) {
        if(arg3 != null) {
            return new RoundedCornerCompat(RoundedCornerCompat.toCompatPosition(arg3.getPosition()), arg3.getRadius(), arg3.getCenter());
        }

        return null;
    }

    public String toString() {
        return "RoundedCornerCompat{position=" + this.getPositionString(this.mPosition) + ", radius=" + this.mRadius + ", center=" + this.mCenter + '}';
    }
}

