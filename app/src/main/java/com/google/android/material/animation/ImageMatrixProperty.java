package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty extends Property {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    public Matrix get(ImageView arg2) {
        this.matrix.set(arg2.getImageMatrix());
        return this.matrix;
    }

    public Object get(Object arg1) {
        return this.get(((ImageView)arg1));
    }

    public void set(ImageView arg1, Matrix arg2) {
        arg1.setImageMatrix(arg2);
    }

    public void set(Object arg1, Object arg2) {
        this.set(((ImageView)arg1), ((Matrix)arg2));
    }
}

