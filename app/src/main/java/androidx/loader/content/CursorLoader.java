package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(Context arg1) {
        super(arg1);
        this.mObserver = new ForceLoadContentObserver(((Loader)this));
    }

    public CursorLoader(Context arg1, Uri arg2, String[] arg3, String arg4, String[] arg5, String arg6) {
        super(arg1);
        this.mObserver = new ForceLoadContentObserver(((Loader)this));
        this.mUri = arg2;
        this.mProjection = arg3;
        this.mSelection = arg4;
        this.mSelectionArgs = arg5;
        this.mSortOrder = arg6;
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        __monitor_enter(this);
        try {
            CancellationSignal v0_1 = this.mCancellationSignal;
            if(v0_1 != null) {
                v0_1.cancel();
            }

            __monitor_exit(this);
            return;
        label_8:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_8;
        }

        throw v0;
    }

    public void deliverResult(Cursor arg3) {
        if(!this.isReset()) {
            Cursor v0 = this.mCursor;
            this.mCursor = arg3;
            if(this.isStarted()) {
                super.deliverResult(arg3);
            }

            if(v0 == null) {
                return;
            }

            if(v0 == arg3) {
                return;
            }

            if(v0.isClosed()) {
                return;
            }

            v0.close();
        }
        else if(arg3 != null) {
            arg3.close();
            return;
        }
    }

    public void deliverResult(Object arg1) {
        this.deliverResult(((Cursor)arg1));
    }

    @Deprecated public void dump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
        super.dump(arg1, arg2, arg3, arg4);
        arg3.print(arg1);
        arg3.print("mUri=");
        arg3.println(this.mUri);
        arg3.print(arg1);
        arg3.print("mProjection=");
        arg3.println(Arrays.toString(this.mProjection));
        arg3.print(arg1);
        arg3.print("mSelection=");
        arg3.println(this.mSelection);
        arg3.print(arg1);
        arg3.print("mSelectionArgs=");
        arg3.println(Arrays.toString(this.mSelectionArgs));
        arg3.print(arg1);
        arg3.print("mSortOrder=");
        arg3.println(this.mSortOrder);
        arg3.print(arg1);
        arg3.print("mCursor=");
        arg3.println(this.mCursor);
        arg3.print(arg1);
        arg3.print("mContentChanged=");
        arg3.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Cursor loadInBackground() {
        Cursor v2;
        CancellationSignal v1;
        __monitor_enter(this);
        try {
            if(this.isLoadInBackgroundCanceled()) {
                goto label_40;
            }

            this.mCancellationSignal = new CancellationSignal();
            __monitor_exit(this);
            v1 = null;
        }
        catch(Throwable v0) {
            goto label_44;
        }

        try {
            v2 = ContentResolverCompat.query(this.getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
            if(v2 != null) {
                try {
                    v2.getCount();
                    v2.registerContentObserver(this.mObserver);
                }
                catch(RuntimeException v0_1) {
                    try {
                        v2.close();
                        throw v0_1;
                    }
                    catch(Throwable v0) {
                    label_33:
                        __monitor_enter(this);
                        try {
                            this.mCancellationSignal = v1;
                            __monitor_exit(this);
                        }
                        catch(Throwable v0) {
                            try {
                            label_38:
                                __monitor_exit(this);
                            }
                            catch(Throwable v0) {
                                goto label_38;
                            }

                            throw v0;
                        }

                        throw v0;
                    }
                }
            }
        }
        catch(Throwable v0) {
            goto label_33;
        }

        __monitor_enter(this);
        try {
            this.mCancellationSignal = v1;
            __monitor_exit(this);
            return v2;
        label_30:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_30;
        }

        throw v0;
        try {
        label_40:
            throw new OperationCanceledException();
        label_44:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_44;
        }

        throw v0;
    }

    public Object loadInBackground() {
        return this.loadInBackground();
    }

    public void onCanceled(Cursor arg1) {
        if(arg1 != null && !arg1.isClosed()) {
            arg1.close();
        }
    }

    public void onCanceled(Object arg1) {
        this.onCanceled(((Cursor)arg1));
    }

    protected void onReset() {
        super.onReset();
        this.onStopLoading();
        Cursor v0 = this.mCursor;
        if(v0 != null && !v0.isClosed()) {
            this.mCursor.close();
        }

        this.mCursor = null;
    }

    protected void onStartLoading() {
        Cursor v0 = this.mCursor;
        if(v0 != null) {
            this.deliverResult(v0);
        }

        if(!this.takeContentChanged()) {
            if(this.mCursor == null) {
            }
            else {
                return;
            }
        }

        this.forceLoad();
    }

    protected void onStopLoading() {
        this.cancelLoad();
    }

    public void setProjection(String[] arg1) {
        this.mProjection = arg1;
    }

    public void setSelection(String arg1) {
        this.mSelection = arg1;
    }

    public void setSelectionArgs(String[] arg1) {
        this.mSelectionArgs = arg1;
    }

    public void setSortOrder(String arg1) {
        this.mSortOrder = arg1;
    }

    public void setUri(Uri arg1) {
        this.mUri = arg1;
    }
}

