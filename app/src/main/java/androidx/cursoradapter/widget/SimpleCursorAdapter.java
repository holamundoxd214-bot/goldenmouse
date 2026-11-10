package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor arg1);
    }

    public interface ViewBinder {
        boolean setViewValue(View arg1, Cursor arg2, int arg3);
    }

    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    @Deprecated public SimpleCursorAdapter(Context arg1, int arg2, Cursor arg3, String[] arg4, int[] arg5) {
        super(arg1, arg2, arg3);
        this.mStringConversionColumn = -1;
        this.mTo = arg5;
        this.mOriginalFrom = arg4;
        this.findColumns(arg3, arg4);
    }

    public SimpleCursorAdapter(Context arg1, int arg2, Cursor arg3, String[] arg4, int[] arg5, int arg6) {
        super(arg1, arg2, arg3, arg6);
        this.mStringConversionColumn = -1;
        this.mTo = arg5;
        this.mOriginalFrom = arg4;
        this.findColumns(arg3, arg4);
    }

    public void bindView(View arg9, Context arg10, Cursor arg11) {
        ViewBinder v10 = this.mViewBinder;
        int[] v0 = this.mTo;
        int v1 = v0.length;
        int[] v2 = this.mFrom;
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            View v5 = arg9.findViewById(v0[v4]);
            if(v5 != null) {
                boolean v6 = v10 != null ? v10.setViewValue(v5, arg11, v2[v4]) : false;
                if(v6) {
                    goto label_39;
                }

                String v6_1 = arg11.getString(v2[v4]);
                if(v6_1 == null) {
                    v6_1 = "";
                }

                if((v5 instanceof TextView)) {
                    this.setViewText(((TextView)v5), v6_1);
                    goto label_39;
                }

                if((v5 instanceof ImageView)) {
                    this.setViewImage(((ImageView)v5), v6_1);
                    goto label_39;
                }

                throw new IllegalStateException(v5.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
            }

        label_39:
        }
    }

    public void changeCursorAndColumns(Cursor arg1, String[] arg2, int[] arg3) {
        this.mOriginalFrom = arg2;
        this.mTo = arg3;
        this.findColumns(arg1, arg2);
        super.changeCursor(arg1);
    }

    public CharSequence convertToString(Cursor arg3) {
        CursorToStringConverter v0 = this.mCursorToStringConverter;
        if(v0 != null) {
            return v0.convertToString(arg3);
        }

        int v0_1 = this.mStringConversionColumn;
        if(v0_1 > -1) {
            return arg3.getString(v0_1);
        }

        return super.convertToString(arg3);
    }

    private void findColumns(Cursor arg5, String[] arg6) {
        if(arg5 != null) {
            int v0 = arg6.length;
            int[] v1 = this.mFrom;
            if(v1 == null || v1.length != v0) {
                this.mFrom = new int[v0];
            }

            int v1_1;
            for(v1_1 = 0; v1_1 < v0; ++v1_1) {
                this.mFrom[v1_1] = arg5.getColumnIndexOrThrow(arg6[v1_1]);
            }

            return;
        }

        this.mFrom = null;
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter arg1) {
        this.mCursorToStringConverter = arg1;
    }

    public void setStringConversionColumn(int arg1) {
        this.mStringConversionColumn = arg1;
    }

    public void setViewBinder(ViewBinder arg1) {
        this.mViewBinder = arg1;
    }

    public void setViewImage(ImageView arg1, String arg2) {
        try {
            arg1.setImageResource(Integer.parseInt(arg2));
            return;
        }
        catch(NumberFormatException ) {
            arg1.setImageURI(Uri.parse(arg2));
            return;
        }
    }

    public void setViewText(TextView arg1, String arg2) {
        arg1.setText(((CharSequence)arg2));
    }

    public Cursor swapCursor(Cursor arg2) {
        this.findColumns(arg2, this.mOriginalFrom);
        return super.swapCursor(arg2);
    }
}

