package androidx.core.graphics;

import android.graphics.Rect;

public final class Insets {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static android.graphics.Insets of(int arg0, int arg1, int arg2, int arg3) {
            return android.graphics.Insets.of(arg0, arg1, arg2, arg3);
        }
    }

    public static final Insets NONE;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static {
        Insets.NONE = new Insets(0, 0, 0, 0);
    }

    private Insets(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
    }

    public static Insets add(Insets arg4, Insets arg5) {
        return Insets.of(arg4.left + arg5.left, arg4.top + arg5.top, arg4.right + arg5.right, arg4.bottom + arg5.bottom);
    }

    public boolean equals(Object arg5) {
        if(this == (((Insets)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.bottom != ((Insets)arg5).bottom) {
                return 0;
            }
            else if(this.left != ((Insets)arg5).left) {
                return 0;
            }
            else if(this.right != ((Insets)arg5).right) {
                return 0;
            }
            else if(this.top != ((Insets)arg5).top) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        return ((this.left * 0x1F + this.top) * 0x1F + this.right) * 0x1F + this.bottom;
    }

    public static Insets max(Insets arg4, Insets arg5) {
        return Insets.of(Math.max(arg4.left, arg5.left), Math.max(arg4.top, arg5.top), Math.max(arg4.right, arg5.right), Math.max(arg4.bottom, arg5.bottom));
    }

    public static Insets min(Insets arg4, Insets arg5) {
        return Insets.of(Math.min(arg4.left, arg5.left), Math.min(arg4.top, arg5.top), Math.min(arg4.right, arg5.right), Math.min(arg4.bottom, arg5.bottom));
    }

    public static Insets of(int arg1, int arg2, int arg3, int arg4) {
        if(arg1 == 0 && arg2 == 0 && arg3 == 0 && arg4 == 0) {
            return Insets.NONE;
        }

        return new Insets(arg1, arg2, arg3, arg4);
    }

    public static Insets of(Rect arg3) {
        return Insets.of(arg3.left, arg3.top, arg3.right, arg3.bottom);
    }

    public static Insets subtract(Insets arg4, Insets arg5) {
        return Insets.of(arg4.left - arg5.left, arg4.top - arg5.top, arg4.right - arg5.right, arg4.bottom - arg5.bottom);
    }

    public static Insets toCompatInsets(android.graphics.Insets arg3) {
        return Insets.of(arg3.left, arg3.top, arg3.right, arg3.bottom);
    }

    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    @Deprecated public static Insets wrap(android.graphics.Insets arg0) {
        return Insets.toCompatInsets(arg0);
    }
}

