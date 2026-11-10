package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;

class DocumentsContractApi19 {
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
        super();
    }

    public static boolean canRead(Context arg3, Uri arg4) {
        if(arg3.checkCallingOrSelfUriPermission(arg4, 1) != 0) {
            return 0;
        }

        if(TextUtils.isEmpty(DocumentsContractApi19.getRawType(arg3, arg4))) {
            return 0;
        }

        return 1;
    }

    public static boolean canWrite(Context arg4, Uri arg5) {
        int v0 = 2;
        if(arg4.checkCallingOrSelfUriPermission(arg5, v0) != 0) {
            return 0;
        }

        String v1 = DocumentsContractApi19.getRawType(arg4, arg5);
        int v4 = DocumentsContractApi19.queryForInt(arg4, arg5, "flags", 0);
        if(TextUtils.isEmpty(((CharSequence)v1))) {
            return 0;
        }

        if((v4 & 4) != 0) {
            return 1;
        }

        if(("vnd.android.document/directory".equals(v1)) && (v4 & 8) != 0) {
            return 1;
        }

        if(!TextUtils.isEmpty(((CharSequence)v1)) && (v4 & v0) != 0) {
            return 1;
        }

        return 0;
    }

    private static void closeQuietly(AutoCloseable arg0) {
        if(arg0 != null) {
            try {
                OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg0);
                return;
            }
            catch(Exception ) {
                return;
            }
            catch(RuntimeException v0) {
                throw v0;
            }
        }
    }

    public static boolean exists(Context arg10, Uri arg11) {
        Cursor v9;
        String v1 = "Failed query: ";
        ContentResolver v2 = arg10.getContentResolver();
        boolean v10 = true;
        try {
            v9 = v2.query(arg11, new String[]{"document_id"}, null, null, null);
            if(v9.getCount() <= 0) {
                goto label_16;
            }
        }
        catch(Throwable v0) {
        label_20:
            Throwable v10_2 = v0;
            DocumentsContractApi19.closeQuietly(((AutoCloseable)v9));
            throw v10_2;
        }
        catch(Exception v0_1) {
            Exception v10_1 = v0_1;
            try {
                Log.w("DocumentFile", v1 + v10_1);
            }
            catch(Throwable v0) {
                goto label_20;
            }

            DocumentsContractApi19.closeQuietly(((AutoCloseable)v9));
            return 0;
        }

        goto label_17;
    label_16:
        v10 = false;
    label_17:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v9));
        return v10;
    }

    public static long getFlags(Context arg3, Uri arg4) {
        return DocumentsContractApi19.queryForLong(arg3, arg4, "flags", 0);
    }

    public static String getName(Context arg2, Uri arg3) {
        return DocumentsContractApi19.queryForString(arg2, arg3, "_display_name", null);
    }

    private static String getRawType(Context arg2, Uri arg3) {
        return DocumentsContractApi19.queryForString(arg2, arg3, "mime_type", null);
    }

    public static String getType(Context arg0, Uri arg1) {
        String v0 = DocumentsContractApi19.getRawType(arg0, arg1);
        if("vnd.android.document/directory".equals(v0)) {
            v0 = null;
        }

        return v0;
    }

    public static boolean isDirectory(Context arg1, Uri arg2) {
        return "vnd.android.document/directory".equals(DocumentsContractApi19.getRawType(arg1, arg2));
    }

    public static boolean isFile(Context arg0, Uri arg1) {
        String v0 = DocumentsContractApi19.getRawType(arg0, arg1);
        if(!"vnd.android.document/directory".equals(v0)) {
            if(TextUtils.isEmpty(((CharSequence)v0))) {
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public static boolean isVirtual(Context arg4, Uri arg5) {
        if(!DocumentsContract.isDocumentUri(arg4, arg5)) {
            return 0;
        }

        if((DocumentsContractApi19.getFlags(arg4, arg5) & 0x200) != 0) {
            return 1;
        }

        return 0;
    }

    public static long lastModified(Context arg3, Uri arg4) {
        return DocumentsContractApi19.queryForLong(arg3, arg4, "last_modified", 0);
    }

    public static long length(Context arg3, Uri arg4) {
        return DocumentsContractApi19.queryForLong(arg3, arg4, "_size", 0);
    }

    private static int queryForInt(Context arg2, Uri arg3, String arg4, int arg5) {
        return ((int)DocumentsContractApi19.queryForLong(arg2, arg3, arg4, ((long)arg5)));
    }

    private static long queryForLong(Context arg9, Uri arg10, String arg11, long arg12) {
        long v9;
        Cursor v8;
        String v1 = "Failed query: ";
        ContentResolver v2 = arg9.getContentResolver();
        try {
            v8 = v2.query(arg10, new String[]{arg11}, null, null, null);
            if((v8.moveToFirst()) && !v8.isNull(0)) {
                v9 = v8.getLong(0);
                goto label_17;
            }

            goto label_19;
        }
        catch(Throwable v0) {
        label_22:
            Throwable v9_2 = v0;
            DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
            throw v9_2;
        }
        catch(Exception v0_1) {
            Exception v9_1 = v0_1;
            try {
                Log.w("DocumentFile", v1 + v9_1);
            }
            catch(Throwable v0) {
                goto label_22;
            }

            DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
            return arg12;
        }

    label_17:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
        return v9;
    label_19:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
        return arg12;
    }

    private static String queryForString(Context arg9, Uri arg10, String arg11, String arg12) {
        String v9;
        Cursor v8;
        String v1 = "Failed query: ";
        ContentResolver v2 = arg9.getContentResolver();
        try {
            v8 = v2.query(arg10, new String[]{arg11}, null, null, null);
            if((v8.moveToFirst()) && !v8.isNull(0)) {
                v9 = v8.getString(0);
                goto label_17;
            }

            goto label_19;
        }
        catch(Throwable v0) {
        label_22:
            Throwable v9_2 = v0;
            DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
            throw v9_2;
        }
        catch(Exception v0_1) {
            Exception v9_1 = v0_1;
            try {
                Log.w("DocumentFile", v1 + v9_1);
            }
            catch(Throwable v0) {
                goto label_22;
            }

            DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
            return arg12;
        }

    label_17:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
        return v9;
    label_19:
        DocumentsContractApi19.closeQuietly(((AutoCloseable)v8));
        return arg12;
    }
}

