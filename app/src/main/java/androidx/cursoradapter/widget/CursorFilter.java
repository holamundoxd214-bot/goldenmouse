package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter$FilterResults;
import android.widget.Filter;

class CursorFilter extends Filter {
    interface CursorFilterClient {
        void changeCursor(Cursor arg1);

        CharSequence convertToString(Cursor arg1);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence arg1);
    }

    CursorFilterClient mClient;

    CursorFilter(CursorFilterClient arg1) {
        super();
        this.mClient = arg1;
    }

    public CharSequence convertResultToString(Object arg1) {
        return this.mClient.convertToString(((Cursor)arg1));
    }

    protected Filter$FilterResults performFiltering(CharSequence arg2) {
        Cursor v1 = this.mClient.runQueryOnBackgroundThread(arg2);
        Filter$FilterResults v2 = new Filter$FilterResults();
        if(v1 != null) {
            v2.count = v1.getCount();
            v2.values = v1;
            return v2;
        }

        v2.count = 0;
        v2.values = null;
        return v2;
    }

    protected void publishResults(CharSequence arg2, Filter$FilterResults arg3) {
        Cursor v2 = this.mClient.getCursor();
        if(arg3.values != null && arg3.values != v2) {
            this.mClient.changeCursor(arg3.values);
        }
    }
}

