package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilterClient {
    class ChangeObserver extends ContentObserver {
        ChangeObserver(CursorAdapter arg1) {
            CursorAdapter.this = arg1;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return 1;
        }

        public void onChange(boolean arg1) {
            CursorAdapter.this.onContentChanged();
        }
    }

    class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver(CursorAdapter arg1) {
            CursorAdapter.this = arg1;
            super();
        }

        public void onChanged() {
            CursorAdapter.this.mDataValid = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter.this.mDataValid = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }

    @Deprecated public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    @Deprecated public CursorAdapter(Context arg2, Cursor arg3) {
        super();
        this.init(arg2, arg3, 1);
    }

    public CursorAdapter(Context arg1, Cursor arg2, int arg3) {
        super();
        this.init(arg1, arg2, arg3);
    }

    public CursorAdapter(Context arg1, Cursor arg2, boolean arg3) {
        super();
        int v3 = arg3 ? 1 : 2;
        this.init(arg1, arg2, v3);
    }

    public abstract void bindView(View arg1, Context arg2, Cursor arg3);

    public void changeCursor(Cursor arg1) {
        Cursor v0 = this.swapCursor(arg1);
        if(v0 != null) {
            v0.close();
        }
    }

    public CharSequence convertToString(Cursor arg1) {
        if(arg1 == null) {
            return "";
        }

        return arg1.toString();
    }

    public int getCount() {
        if(this.mDataValid) {
            Cursor v1 = this.mCursor;
            if(v1 != null) {
                return v1.getCount();
            }
        }

        return 0;
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int arg2, View arg3, ViewGroup arg4) {
        if(this.mDataValid) {
            this.mCursor.moveToPosition(arg2);
            if(arg3 == null) {
                arg3 = this.newDropDownView(this.mContext, this.mCursor, arg4);
            }

            this.bindView(arg3, this.mContext, this.mCursor);
            return arg3;
        }

        return null;
    }

    public Filter getFilter() {
        CursorFilter v0 = this.mCursorFilter;
        if(v0 == null) {
            v0 = new CursorFilter(((CursorFilterClient)this));
            this.mCursorFilter = v0;
        }

        return ((Filter)v0);
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int arg2) {
        if(this.mDataValid) {
            Cursor v0 = this.mCursor;
            if(v0 != null) {
                v0.moveToPosition(arg2);
                return this.mCursor;
            }
        }

        return null;
    }

    public long getItemId(int arg4) {
        long v1 = 0;
        if(this.mDataValid) {
            Cursor v0 = this.mCursor;
            if(v0 != null && (v0.moveToPosition(arg4))) {
                return this.mCursor.getLong(this.mRowIDColumn);
            }
        }

        return v1;
    }

    public View getView(int arg2, View arg3, ViewGroup arg4) {
        if(this.mDataValid) {
            if(this.mCursor.moveToPosition(arg2)) {
                if(arg3 == null) {
                    arg3 = this.newView(this.mContext, this.mCursor, arg4);
                }

                this.bindView(arg3, this.mContext, this.mCursor);
                return arg3;
            }

            throw new IllegalStateException("couldn\'t move cursor to position " + arg2);
        }

        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public boolean hasStableIds() {
        return 1;
    }

    void init(Context arg4, Cursor arg5, int arg6) {
        boolean v1 = false;
        if((arg6 & 1) == 1) {
            arg6 |= 2;
            this.mAutoRequery = true;
        }
        else {
            this.mAutoRequery = false;
        }

        if(arg5 != null) {
            v1 = true;
        }

        this.mCursor = arg5;
        this.mDataValid = v1;
        this.mContext = arg4;
        int v4 = v1 ? arg5.getColumnIndexOrThrow("_id") : -1;
        this.mRowIDColumn = v4;
        if((arg6 & 2) == 2) {
            this.mChangeObserver = new ChangeObserver(this);
            this.mDataSetObserver = new MyDataSetObserver(this);
        }
        else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }

        if(v1) {
            ChangeObserver v4_1 = this.mChangeObserver;
            if(v4_1 != null) {
                arg5.registerContentObserver(((ContentObserver)v4_1));
            }

            DataSetObserver v3 = this.mDataSetObserver;
            if(v3 == null) {
                return;
            }

            arg5.registerDataSetObserver(v3);
        }
    }

    @Deprecated protected void init(Context arg1, Cursor arg2, boolean arg3) {
        int v3 = arg3 ? 1 : 2;
        this.init(arg1, arg2, v3);
    }

    public View newDropDownView(Context arg1, Cursor arg2, ViewGroup arg3) {
        return this.newView(arg1, arg2, arg3);
    }

    public abstract View newView(Context arg1, Cursor arg2, ViewGroup arg3);

    protected void onContentChanged() {
        if(this.mAutoRequery) {
            Cursor v0 = this.mCursor;
            if(v0 != null && !v0.isClosed()) {
                this.mDataValid = this.mCursor.requery();
            }
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence arg2) {
        FilterQueryProvider v0 = this.mFilterQueryProvider;
        if(v0 != null) {
            return v0.runQuery(arg2);
        }

        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider arg1) {
        this.mFilterQueryProvider = arg1;
    }

    public Cursor swapCursor(Cursor arg3) {
        DataSetObserver v1_1;
        ChangeObserver v1;
        Cursor v0 = this.mCursor;
        if(arg3 == v0) {
            return null;
        }

        if(v0 != null) {
            v1 = this.mChangeObserver;
            if(v1 != null) {
                v0.unregisterContentObserver(((ContentObserver)v1));
            }

            v1_1 = this.mDataSetObserver;
            if(v1_1 == null) {
                goto label_11;
            }

            v0.unregisterDataSetObserver(v1_1);
        }

    label_11:
        this.mCursor = arg3;
        if(arg3 != null) {
            v1 = this.mChangeObserver;
            if(v1 != null) {
                arg3.registerContentObserver(((ContentObserver)v1));
            }

            v1_1 = this.mDataSetObserver;
            if(v1_1 != null) {
                arg3.registerDataSetObserver(v1_1);
            }

            this.mRowIDColumn = arg3.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            this.notifyDataSetChanged();
            return v0;
        }

        this.mRowIDColumn = -1;
        this.mDataValid = false;
        this.notifyDataSetInvalidated();
        return v0;
    }
}

