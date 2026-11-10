package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated public ResourceCursorAdapter(Context arg1, int arg2, Cursor arg3, boolean arg4) {
        super(arg1, arg3, arg4);
        this.mDropDownLayout = arg2;
        this.mLayout = arg2;
        this.mInflater = arg1.getSystemService("layout_inflater");
    }

    @Deprecated public ResourceCursorAdapter(Context arg1, int arg2, Cursor arg3) {
        super(arg1, arg3);
        this.mDropDownLayout = arg2;
        this.mLayout = arg2;
        this.mInflater = arg1.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context arg1, int arg2, Cursor arg3, int arg4) {
        super(arg1, arg3, arg4);
        this.mDropDownLayout = arg2;
        this.mLayout = arg2;
        this.mInflater = arg1.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context arg1, Cursor arg2, ViewGroup arg3) {
        return this.mInflater.inflate(this.mDropDownLayout, arg3, false);
    }

    public View newView(Context arg1, Cursor arg2, ViewGroup arg3) {
        return this.mInflater.inflate(this.mLayout, arg3, false);
    }

    public void setDropDownViewResource(int arg1) {
        this.mDropDownLayout = arg1;
    }

    public void setViewResource(int arg1) {
        this.mLayout = arg1;
    }
}

