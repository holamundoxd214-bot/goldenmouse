package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode$ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel$MapMode;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
        super();
    }

    public static void closeQuietly(Closeable arg0) {
        if(arg0 != null) {
            try {
                arg0.close();
                return;
            }
            catch(IOException ) {
                return;
            }
        }
    }

    public static ByteBuffer copyToDirectBuffer(Context arg1, Resources arg2, int arg3) {
        ByteBuffer v2_1;
        File v1 = TypefaceCompatUtil.getTempFile(arg1);
        ByteBuffer v0 = null;
        if(v1 == null) {
            return v0;
        }

        try {
            if(TypefaceCompatUtil.copyToFile(v1, arg2, arg3)) {
                goto label_8;
            }
        }
        catch(Throwable v2) {
            goto label_12;
        }

        v1.delete();
        return v0;
        try {
        label_8:
            v2_1 = TypefaceCompatUtil.mmap(v1);
        }
        catch(Throwable v2) {
        label_12:
            v1.delete();
            throw v2;
        }

        v1.delete();
        return v2_1;
    }

    public static boolean copyToFile(File arg5, InputStream arg6) {
        FileOutputStream v2_2;
        int v5_2;
        FileOutputStream v3;
        StrictMode$ThreadPolicy v0 = StrictMode.allowThreadDiskWrites();
        Closeable v2 = null;
        try {
            v3 = new FileOutputStream(arg5, false);
            v5_2 = 0x400;
            goto label_6;
        }
        catch(Throwable v5) {
        }
        catch(IOException v5_1) {
            goto label_25;
            try {
            label_6:
                byte[] v5_3 = new byte[v5_2];
                while(true) {
                    int v2_1 = arg6.read(v5_3);
                    if(v2_1 == -1) {
                        break;
                    }

                    v3.write(v5_3, 0, v2_1);
                }
            }
            catch(Throwable v5) {
                goto label_17;
            }
            catch(IOException v5_1) {
                goto label_20;
            }

            TypefaceCompatUtil.closeQuietly(((Closeable)v3));
            StrictMode.setThreadPolicy(v0);
            return 1;
        label_20:
            v2_2 = v3;
            try {
            label_25:
                Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + v5_1.getMessage());
            }
            catch(Throwable v5) {
                goto label_37;
            }
        }

        TypefaceCompatUtil.closeQuietly(((Closeable)v2_2));
        StrictMode.setThreadPolicy(v0);
        return 0;
    label_17:
        v2_2 = v3;
    label_37:
        TypefaceCompatUtil.closeQuietly(((Closeable)v2_2));
        StrictMode.setThreadPolicy(v0);
        throw v5;
    }

    public static boolean copyToFile(File arg0, Resources arg1, int arg2) {
        boolean v0_1;
        Closeable v1_1;
        InputStream v1;
        try {
            v1 = arg1.openRawResource(arg2);
        }
        catch(Throwable v0) {
            v1_1 = null;
            goto label_8;
        }

        try {
            v0_1 = TypefaceCompatUtil.copyToFile(arg0, v1);
            goto label_2;
        }
        catch(Throwable v0) {
        }

    label_8:
        TypefaceCompatUtil.closeQuietly(v1_1);
        throw v0;
    label_2:
        TypefaceCompatUtil.closeQuietly(((Closeable)v1));
        return v0_1;
    }

    public static File getTempFile(Context arg5) {
        File v5 = arg5.getCacheDir();
        File v0 = null;
        if(v5 == null) {
            return v0;
        }

        String v1 = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int v2;
        for(v2 = 0; v2 < 100; ++v2) {
            File v3 = new File(v5, v1 + v2);
            try {
                if(!v3.createNewFile()) {
                    goto label_28;
                }
            }
            catch(IOException ) {
                goto label_28;
            }

            return v3;
        label_28:
        }

        return v0;
    }

    public static ByteBuffer mmap(Context arg8, CancellationSignal arg9, Uri arg10) {
        MappedByteBuffer v10;
        FileInputStream v9;
        ParcelFileDescriptor v8_1;
        ContentResolver v8 = arg8.getContentResolver();
        ByteBuffer v1 = null;
        try {
            v8_1 = v8.openFileDescriptor(arg10, "r", arg9);
            if(v8_1 != null) {
                goto label_8;
            }

            if(v8_1 != null) {
                v8_1.close();
            }
        }
        catch(IOException ) {
            return v1;
        }

        return v1;
        try {
        label_8:
            v9 = new FileInputStream(v8_1.getFileDescriptor());
        }
        catch(Throwable v0) {
            goto label_29;
        }

        try {
            FileChannel v2 = v9.getChannel();
            v10 = v2.map(FileChannel$MapMode.READ_ONLY, 0, v2.size());
            goto label_16;
        }
        catch(Throwable v0) {
            Throwable v10_1 = v0;
            try {
                v9.close();
                goto label_27;
            }
            catch(Throwable v0) {
                Throwable v9_1 = v0;
                try {
                    v10_1.addSuppressed(v9_1);
                label_27:
                    throw v10_1;
                label_16:
                    v9.close();
                    if(v8_1 == null) {
                        goto label_19;
                    }

                    goto label_18;
                }
                catch(Throwable v0) {
                label_29:
                    v9_1 = v0;
                    if(v8_1 != null) {
                        try {
                            v8_1.close();
                            goto label_36;
                        }
                        catch(Throwable v0) {
                            Throwable v8_2 = v0;
                            try {
                                v9_1.addSuppressed(v8_2);
                            label_36:
                                throw v9_1;
                            label_18:
                                v8_1.close();
                            }
                            catch(IOException ) {
                                return v1;
                            }
                        }
                    }
                    else {
                        goto label_36;
                    }
                }
            }
        }

    label_19:
        return ((ByteBuffer)v10);
    }

    private static ByteBuffer mmap(File arg8) {
        MappedByteBuffer v8;
        FileInputStream v1;
        try {
            v1 = new FileInputStream(arg8);
        }
        catch(IOException ) {
            return null;
        }

        try {
            FileChannel v2 = v1.getChannel();
            v8 = v2.map(FileChannel$MapMode.READ_ONLY, 0, v2.size());
            goto label_7;
        }
        catch(Throwable v0) {
            Throwable v8_1 = v0;
            try {
                v1.close();
                goto label_15;
            }
            catch(Throwable v0) {
                try {
                    v8_1.addSuppressed(v0);
                label_15:
                    throw v8_1;
                label_7:
                    v1.close();
                    return ((ByteBuffer)v8);
                }
                catch(IOException ) {
                    return null;
                }
            }
        }
    }

    public static Map readFontInfoIntoByteBuffer(Context arg5, FontInfo[] arg6, CancellationSignal arg7) {
        HashMap v0 = new HashMap();
        int v1 = arg6.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            FontInfo v3 = arg6[v2];
            if(v3.getResultCode() != 0) {
            }
            else {
                Uri v3_1 = v3.getUri();
                if(v0.containsKey(v3_1)) {
                }
                else {
                    v0.put(v3_1, TypefaceCompatUtil.mmap(arg5, arg7, v3_1));
                }
            }
        }

        return Collections.unmodifiableMap(((Map)v0));
    }
}

