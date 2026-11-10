package androidx.constraintlayout.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public Rectangle() {
        super();
    }

    public boolean contains(int arg3, int arg4) {
        int v0 = this.x;
        if(arg3 >= v0 && arg3 < v0 + this.width) {
            arg3 = this.y;
            if(arg4 >= arg3 && arg4 < arg3 + this.height) {
                return 1;
            }
        }

        return 0;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    void grow(int arg2, int arg3) {
        this.x -= arg2;
        this.y -= arg3;
        this.width += arg2 * 2;
        this.height += arg3 * 2;
    }

    boolean intersects(Rectangle arg4) {
        int v0 = this.x;
        int v1 = arg4.x;
        if(v0 >= v1 && v0 < v1 + arg4.width) {
            int v3 = this.y;
            v0 = arg4.y;
            if(v3 >= v0 && v3 < v0 + arg4.height) {
                return 1;
            }
        }

        return 0;
    }

    public void setBounds(int arg1, int arg2, int arg3, int arg4) {
        this.x = arg1;
        this.y = arg2;
        this.width = arg3;
        this.height = arg4;
    }
}

