package androidx.print;

import android.content.Context;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument$Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal$OnCancelListener;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes$Builder;
import android.print.PrintAttributes$Margins;
import android.print.PrintAttributes$MediaSize;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter$LayoutResultCallback;
import android.print.PrintDocumentAdapter$WriteResultCallback;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo$Builder;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class PrintHelper {
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(PrintHelper arg1, String arg2, int arg3, Bitmap arg4, OnPrintFinishCallback arg5) {
            PrintHelper.this = arg1;
            super();
            this.mJobName = arg2;
            this.mFittingMode = arg3;
            this.mBitmap = arg4;
            this.mCallback = arg5;
        }

        public void onFinish() {
            OnPrintFinishCallback v0 = this.mCallback;
            if(v0 != null) {
                v0.onFinish();
            }
        }

        public void onLayout(PrintAttributes arg1, PrintAttributes arg2, CancellationSignal arg3, PrintDocumentAdapter$LayoutResultCallback arg4, Bundle arg5) {
            this.mAttributes = arg2;
            arg4.onLayoutFinished(new PrintDocumentInfo$Builder(this.mJobName).setContentType(1).setPageCount(1).build(), 1 ^ arg2.equals(arg1));
        }

        public void onWrite(PageRange[] arg8, ParcelFileDescriptor arg9, CancellationSignal arg10, PrintDocumentAdapter$WriteResultCallback arg11) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, arg9, arg10, arg11);
        }
    }

    class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask mLoadBitmap;

        PrintUriAdapter(PrintHelper arg1, String arg2, Uri arg3, OnPrintFinishCallback arg4, int arg5) {
            PrintHelper.this = arg1;
            super();
            this.mJobName = arg2;
            this.mImageFile = arg3;
            this.mCallback = arg4;
            this.mFittingMode = arg5;
            this.mBitmap = null;
        }

        void cancelLoad() {
            Object v0 = PrintHelper.this.mLock;
            __monitor_enter(v0);
            try {
                if(PrintHelper.this.mDecodeOptions != null) {
                    PrintHelper.this.mDecodeOptions = null;
                }

                __monitor_exit(v0);
                return;
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_12;
            }

            throw v2;
        }

        public void onFinish() {
            super.onFinish();
            this.cancelLoad();
            AsyncTask v0 = this.mLoadBitmap;
            if(v0 != null) {
                v0.cancel(true);
            }

            OnPrintFinishCallback v0_1 = this.mCallback;
            if(v0_1 != null) {
                v0_1.onFinish();
            }

            Bitmap v0_2 = this.mBitmap;
            if(v0_2 != null) {
                v0_2.recycle();
                this.mBitmap = null;
            }
        }

        public void onLayout(PrintAttributes arg7, PrintAttributes arg8, CancellationSignal arg9, PrintDocumentAdapter$LayoutResultCallback arg10, Bundle arg11) {
            Throwable v6;
            __monitor_enter(this);
            try {
                this.mAttributes = arg8;
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                PrintUriAdapter v1 = this;
                while(true) {
                    v6 = v0;
                    try {
                        __monitor_exit(v1);
                        break;
                    }
                    catch(Throwable v0) {
                        continue;
                    }
                }

                throw v6;
            }

            if(arg9.isCanceled()) {
                arg10.onLayoutCancelled();
                return;
            }

            if(this.mBitmap != null) {
                arg10.onLayoutFinished(new PrintDocumentInfo$Builder(this.mJobName).setContentType(1).setPageCount(1).build(), 1 ^ arg8.equals(arg7));
                return;
            }

            this.mLoadBitmap = new AsyncTask(arg9, arg8, arg7, arg10) {
                protected Bitmap doInBackground(Uri[] arg1) {
                    try {
                        return this.this$1.this$0.loadConstrainedBitmap(this.this$1.mImageFile);
                    }
                    catch(FileNotFoundException ) {
                        return null;
                    }
                }

                protected Object doInBackground(Object[] arg1) {
                    return this.doInBackground(((Uri[])arg1));
                }

                protected void onCancelled(Bitmap arg1) {
                    this.val$layoutResultCallback.onLayoutCancelled();
                    this.this$1.mLoadBitmap = null;
                }

                protected void onCancelled(Object arg1) {
                    this.onCancelled(((Bitmap)arg1));
                }

                protected void onPostExecute(Bitmap arg10) {
                    super.onPostExecute(arg10);
                    if(arg10 != null) {
                        if((PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION) && this.this$1.this$0.mOrientation != 0) {
                            goto label_33;
                        }

                        __monitor_enter(this);
                        try {
                            PrintAttributes$MediaSize v0_1 = this.this$1.mAttributes.getMediaSize();
                            __monitor_exit(this);
                            if(v0_1 == null) {
                                goto label_33;
                            }
                        }
                        catch(Throwable v0) {
                        label_30:
                            Throwable v10 = v0;
                            try {
                                __monitor_exit(this);
                            }
                            catch(Throwable v0) {
                                goto label_30;
                            }

                            throw v10;
                        }

                        if(v0_1.isPortrait() == PrintHelper.isPortrait(arg10)) {
                            goto label_33;
                        }

                        Matrix v7 = new Matrix();
                        v7.postRotate(90f);
                        arg10 = Bitmap.createBitmap(arg10, 0, 0, arg10.getWidth(), arg10.getHeight(), v7, true);
                    }
                    else {
                    label_33:
                        arg10 = arg10;
                    }

                    this.this$1.mBitmap = arg10;
                    CharSequence v0_2 = null;
                    if(arg10 != null) {
                        this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo$Builder(this.this$1.mJobName).setContentType(1).setPageCount(1).build(), 1 ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
                    }
                    else {
                        this.val$layoutResultCallback.onLayoutFailed(v0_2);
                    }

                    this.this$1.mLoadBitmap = ((AsyncTask)v0_2);
                }

                protected void onPostExecute(Object arg1) {
                    this.onPostExecute(((Bitmap)arg1));
                }

                protected void onPreExecute() {
                    this.val$cancellationSignal.setOnCancelListener(new CancellationSignal$OnCancelListener() {
                        public void onCancel() {
                            this.this$2.this$1.cancelLoad();
                            this.this$2.cancel(false);
                        }
                    });
                }
            }.execute(new Uri[0]);
        }

        public void onWrite(PageRange[] arg8, ParcelFileDescriptor arg9, CancellationSignal arg10, PrintDocumentAdapter$WriteResultCallback arg11) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, arg9, arg10, arg11);
        }
    }

    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory$Options mDecodeOptions;
    final Object mLock;
    int mOrientation;
    int mScaleMode;

    static {
        PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION = true;
        PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT = true;
    }

    public PrintHelper(Context arg2) {
        super();
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = arg2;
    }

    static Bitmap convertBitmapForColorMode(Bitmap arg5, int arg6) {
        if(arg6 != 1) {
            return arg5;
        }

        Bitmap v6 = Bitmap.createBitmap(arg5.getWidth(), arg5.getHeight(), Bitmap$Config.ARGB_8888);
        Canvas v0 = new Canvas(v6);
        Paint v1 = new Paint();
        ColorMatrix v2 = new ColorMatrix();
        v2.setSaturation(0f);
        v1.setColorFilter(new ColorMatrixColorFilter(v2));
        v0.drawBitmap(arg5, 0f, 0f, v1);
        v0.setBitmap(null);
        return v6;
    }

    private static PrintAttributes$Builder copyAttributes(PrintAttributes arg2) {
        PrintAttributes$Builder v0 = new PrintAttributes$Builder().setMediaSize(arg2.getMediaSize()).setResolution(arg2.getResolution()).setMinMargins(arg2.getMinMargins());
        if(arg2.getColorMode() != 0) {
            v0.setColorMode(arg2.getColorMode());
        }

        if(arg2.getDuplexMode() != 0) {
            v0.setDuplexMode(arg2.getDuplexMode());
        }

        return v0;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    static Matrix getMatrix(int arg3, int arg4, RectF arg5, int arg6) {
        Matrix v0 = new Matrix();
        float v3 = ((float)arg3);
        float v1 = arg5.width() / v3;
        float v6 = arg6 == 2 ? Math.max(v1, arg5.height() / (((float)arg4))) : Math.min(v1, arg5.height() / (((float)arg4)));
        v0.postScale(v6, v6);
        v0.postTranslate((arg5.width() - v3 * v6) / 2f, (arg5.height() - (((float)arg4)) * v6) / 2f);
        return v0;
    }

    public int getOrientation() {
        int v0 = this.mOrientation;
        if(v0 == 0) {
            v0 = 1;
        }

        return v0;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    static boolean isPortrait(Bitmap arg1) {
        if(arg1.getWidth() <= arg1.getHeight()) {
            return 1;
        }

        return 0;
    }

    private Bitmap loadBitmap(Uri arg4, BitmapFactory$Options arg5) throws FileNotFoundException {
        Bitmap v4_1;
        InputStream v3_1;
        String v0 = "close fail ";
        String v1 = "PrintHelper";
        if(arg4 != null) {
            Context v3 = this.mContext;
            if(v3 != null) {
                Rect v2 = null;
                try {
                    v3_1 = v3.getContentResolver().openInputStream(arg4);
                }
                catch(Throwable v4) {
                    goto label_19;
                }

                try {
                    v4_1 = BitmapFactory.decodeStream(v3_1, v2, arg5);
                    if(v3_1 == null) {
                        return v4_1;
                    }

                    goto label_10;
                }
                catch(Throwable v4) {
                    InputStream v2_1 = v3_1;
                }

            label_19:
                if((((InputStream)v2)) != null) {
                    try {
                        ((InputStream)v2).close();
                    }
                    catch(IOException v3_2) {
                        Log.w(v1, v0, ((Throwable)v3_2));
                    }

                    goto label_24;
                }
                else {
                label_24:
                    throw v4;
                    try {
                    label_10:
                        v3_1.close();
                        return v4_1;
                    }
                    catch(IOException v3_2) {
                        Log.w(v1, v0, ((Throwable)v3_2));
                    }

                    return v4_1;
                }
            }
        }

        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    Bitmap loadConstrainedBitmap(Uri arg8) throws FileNotFoundException {
        Object v1_1;
        Bitmap v8_1;
        BitmapFactory$Options v1;
        if(arg8 != null && this.mContext != null) {
            BitmapFactory$Options v0 = new BitmapFactory$Options();
            v0.inJustDecodeBounds = true;
            this.loadBitmap(arg8, v0);
            int v2 = v0.outWidth;
            int v0_1 = v0.outHeight;
            BitmapFactory$Options v3 = null;
            if(v2 > 0) {
                if(v0_1 <= 0) {
                }
                else {
                    int v4 = Math.max(v2, v0_1);
                    int v5;
                    for(v5 = 1; v4 > 3500; v5 <<= 1) {
                        v4 >>>= 1;
                    }

                    if(v5 > 0) {
                        if(Math.min(v2, v0_1) / v5 <= 0) {
                        }
                        else {
                            Object v0_2 = this.mLock;
                            __monitor_enter(v0_2);
                            try {
                                BitmapFactory$Options v2_1 = new BitmapFactory$Options();
                                this.mDecodeOptions = v2_1;
                                v2_1.inMutable = true;
                                this.mDecodeOptions.inSampleSize = v5;
                                v1 = this.mDecodeOptions;
                                __monitor_exit(v0_2);
                            }
                            catch(Throwable v7) {
                                goto label_55;
                            }

                            try {
                                v8_1 = this.loadBitmap(arg8, v1);
                            }
                            catch(Throwable v8) {
                                v1_1 = this.mLock;
                                __monitor_enter(v1_1);
                                try {
                                    this.mDecodeOptions = v3;
                                    __monitor_exit(v1_1);
                                }
                                catch(Throwable v7) {
                                    goto label_52;
                                }

                                throw v8;
                            }

                            v0_2 = this.mLock;
                            __monitor_enter(v0_2);
                            try {
                                this.mDecodeOptions = v3;
                                __monitor_exit(v0_2);
                                return v8_1;
                            }
                            catch(Throwable v7) {
                                goto label_43;
                            }

                            try {
                            label_52:
                                __monitor_exit(v1_1);
                            }
                            catch(Throwable v7) {
                                goto label_52;
                            }

                            throw v7;
                            try {
                            label_43:
                                __monitor_exit(v0_2);
                            }
                            catch(Throwable v7) {
                                goto label_43;
                            }

                            throw v7;
                            try {
                            label_55:
                                __monitor_exit(v0_2);
                            }
                            catch(Throwable v7) {
                                goto label_55;
                            }

                            throw v7;
                        }
                    }
                }
            }

            return ((Bitmap)v3);
        }

        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    public void printBitmap(String arg2, Bitmap arg3) {
        this.printBitmap(arg2, arg3, null);
    }

    public void printBitmap(String arg9, Bitmap arg10, OnPrintFinishCallback arg11) {
        if(arg10 == null) {
            return;
        }

        Object v0 = this.mContext.getSystemService("print");
        PrintAttributes$MediaSize v1 = PrintHelper.isPortrait(arg10) ? PrintAttributes$MediaSize.UNKNOWN_PORTRAIT : PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE;
        ((PrintManager)v0).print(arg9, new PrintBitmapAdapter(this, arg9, this.mScaleMode, arg10, arg11), new PrintAttributes$Builder().setMediaSize(v1).setColorMode(this.mColorMode).build());
    }

    public void printBitmap(String arg2, Uri arg3) throws FileNotFoundException {
        this.printBitmap(arg2, arg3, null);
    }

    public void printBitmap(String arg7, Uri arg8, OnPrintFinishCallback arg9) throws FileNotFoundException {
        PrintHelper v1 = this;
        String v2 = arg7;
        PrintUriAdapter v0 = new PrintUriAdapter(v1, v2, arg8, arg9, this.mScaleMode);
        Object v6 = v1.mContext.getSystemService("print");
        PrintAttributes$Builder v7 = new PrintAttributes$Builder();
        v7.setColorMode(v1.mColorMode);
        int v8 = v1.mOrientation;
        if(v8 == 1 || v8 == 0) {
            v7.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE);
        }
        else if(v8 == 2) {
            v7.setMediaSize(PrintAttributes$MediaSize.UNKNOWN_PORTRAIT);
        }

        ((PrintManager)v6).print(v2, ((PrintDocumentAdapter)v0), v7.build());
    }

    public void setColorMode(int arg1) {
        this.mColorMode = arg1;
    }

    public void setOrientation(int arg1) {
        this.mOrientation = arg1;
    }

    public void setScaleMode(int arg1) {
        this.mScaleMode = arg1;
    }

    public static boolean systemSupportsPrint() {
        return 1;
    }

    void writeBitmap(PrintAttributes arg12, int arg13, Bitmap arg14, ParcelFileDescriptor arg15, CancellationSignal arg16, PrintDocumentAdapter$WriteResultCallback arg17) {
        PrintAttributes v5 = PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT ? arg12 : PrintHelper.copyAttributes(arg12).setMinMargins(new PrintAttributes$Margins(0, 0, 0, 0)).build();
        new AsyncTask(arg16, v5, arg14, arg12, arg13, arg15, arg17) {
            protected Object doInBackground(Object[] arg1) {
                return this.doInBackground(((Void[])arg1));
            }

            protected Throwable doInBackground(Void[] arg8) {
                ParcelFileDescriptor v8_1;
                RectF v2;
                Bitmap v1;
                PrintedPdfDocument v8;
                Throwable v0;
                try {
                    v0 = null;
                    if(this.val$cancellationSignal.isCanceled()) {
                        return v0;
                    }

                    v8 = new PrintedPdfDocument(PrintHelper.this.mContext, this.val$pdfAttributes);
                    v1 = PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
                    if(!this.val$cancellationSignal.isCanceled()) {
                        goto label_19;
                    }
                }
                catch(Throwable v7) {
                    return v7;
                }

                return v0;
                try {
                label_19:
                    PdfDocument$Page v3 = v8.startPage(1);
                    if(PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                        v2 = new RectF(v3.getInfo().getContentRect());
                    }
                    else {
                        PrintedPdfDocument v4 = new PrintedPdfDocument(PrintHelper.this.mContext, this.val$attributes);
                        PdfDocument$Page v2_1 = v4.startPage(1);
                        RectF v5 = new RectF(v2_1.getInfo().getContentRect());
                        v4.finishPage(v2_1);
                        v4.close();
                        v2 = v5;
                    }

                    Matrix v4_1 = PrintHelper.getMatrix(v1.getWidth(), v1.getHeight(), v2, this.val$fittingMode);
                    if(PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT) {
                    }
                    else {
                        v4_1.postTranslate(v2.left, v2.top);
                        v3.getCanvas().clipRect(v2);
                    }

                    v3.getCanvas().drawBitmap(v1, v4_1, ((Paint)v0));
                    v8.finishPage(v3);
                    if(!this.val$cancellationSignal.isCanceled()) {
                        goto label_66;
                    }
                }
                catch(Throwable v0) {
                    goto label_80;
                }

                try {
                    v8.close();
                    v8_1 = this.val$fileDescriptor;
                    if(v8_1 != null) {
                        try {
                            v8_1.close();
                            goto label_62;
                        }
                        catch(IOException ) {
                        label_62:
                            if(v1 != this.val$bitmap) {
                                v1.recycle();
                            }

                            return v0;
                        }
                    }

                    goto label_62;
                }
                catch(Throwable v7) {
                    return v7;
                }

                try {
                label_66:
                    v8.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                    goto label_71;
                }
                catch(Throwable v0) {
                    try {
                    label_80:
                        v8.close();
                        v8_1 = this.val$fileDescriptor;
                        if(v8_1 != null) {
                            try {
                                v8_1.close();
                                goto label_84;
                            }
                            catch(IOException ) {
                            label_84:
                                if(v1 != this.val$bitmap) {
                                    v1.recycle();
                                }

                                throw v0;
                            }
                        }

                        goto label_84;
                    label_71:
                        v8.close();
                        v8_1 = this.val$fileDescriptor;
                        if(v8_1 != null) {
                            try {
                                v8_1.close();
                                goto label_75;
                            }
                            catch(IOException ) {
                            label_75:
                                if(v1 != this.val$bitmap) {
                                    v1.recycle();
                                }

                                return v0;
                            }
                        }

                        goto label_75;
                    }
                    catch(Throwable v7) {
                        return v7;
                    }
                }
            }

            protected void onPostExecute(Object arg1) {
                this.onPostExecute(((Throwable)arg1));
            }

            protected void onPostExecute(Throwable arg3) {
                if(this.val$cancellationSignal.isCanceled()) {
                    this.val$writeResultCallback.onWriteCancelled();
                    return;
                }

                if(arg3 == null) {
                    this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    return;
                }

                Log.e("PrintHelper", "Error writing printed content", arg3);
                this.val$writeResultCallback.onWriteFailed(null);
            }
        }.execute(new Void[0]);
    }
}

