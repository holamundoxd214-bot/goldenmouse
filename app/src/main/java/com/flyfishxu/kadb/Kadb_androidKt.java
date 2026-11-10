package com.flyfishxu.kadb;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\"\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b\u001A6\u0010\t\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E\u001A\u001A\u0010\u000F\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b\u001A\u0012\u0010\u0010\u001A\u00020\f*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0004\u001A\u0012\u0010\u0010\u001A\u00020\f*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012¨\u0006\u0013"}, d2={"pull", "", "Lcom/flyfishxu/kadb/Kadb;", "dst", "Landroidx/documentfile/provider/DocumentFile;", "remotePath", "", "context", "Landroid/content/Context;", "push", "src", "mode", "", "lastModifiedMs", "", "install", "readMode", "file", "Ljava/io/File;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class Kadb_androidKt {
    public static final void install(Kadb arg4, DocumentFile arg5, Context arg6) {
        Source v0;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "src");
        Intrinsics.checkNotNullParameter(arg6, "context");
        InputStream v6 = arg6.getContentResolver().openInputStream(arg5.getUri());
        if(v6 != null) {
            try {
                v0 = Okio.source(v6);
            }
            catch(Throwable v4) {
                goto label_29;
            }

            Source v1 = v0;
            try {
                arg4.install(v1, arg5.length(), new String[0]);
                v4 = null;
                goto label_19;
            }
            catch(Throwable v4) {
                try {
                    throw v4;
                }
                catch(Throwable v5) {
                    try {
                        CloseableKt.closeFinally(((Closeable)v0), v4);
                        throw v5;
                    label_19:
                        CloseableKt.closeFinally(((Closeable)v0), v4);
                    }
                    catch(Throwable v4) {
                        try {
                        label_29:
                            throw v4;
                        }
                        catch(Throwable v5) {
                            CloseableKt.closeFinally(((Closeable)v6), v4);
                            throw v5;
                        }
                    }
                }
            }

            CloseableKt.closeFinally(((Closeable)v6), v4);
            return;
        }

        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final void pull(Kadb arg1, DocumentFile arg2, String arg3, Context arg4) {
        Sink v4;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "dst");
        Intrinsics.checkNotNullParameter(arg3, "remotePath");
        Intrinsics.checkNotNullParameter(arg4, "context");
        OutputStream v2 = arg4.getContentResolver().openOutputStream(arg2.getUri());
        if(v2 != null) {
            try {
                v4 = Okio.sink(v2);
            }
            catch(Throwable v1) {
                goto label_28;
            }

            Sink v0 = v4;
            try {
                arg1.pull(v0, arg3);
                v1 = null;
                goto label_18;
            }
            catch(Throwable v1) {
                try {
                    throw v1;
                }
                catch(Throwable v3) {
                    try {
                        CloseableKt.closeFinally(((Closeable)v4), v1);
                        throw v3;
                    label_18:
                        CloseableKt.closeFinally(((Closeable)v4), v1);
                    }
                    catch(Throwable v1) {
                        try {
                        label_28:
                            throw v1;
                        }
                        catch(Throwable v3) {
                            CloseableKt.closeFinally(((Closeable)v2), v1);
                            throw v3;
                        }
                    }
                }
            }

            CloseableKt.closeFinally(((Closeable)v2), v1);
            return;
        }

        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final void push(Kadb arg6, DocumentFile arg7, String arg8, Context arg9, int arg10, long arg11) {
        Throwable v6;
        Source v9;
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "src");
        Intrinsics.checkNotNullParameter(arg8, "remotePath");
        Intrinsics.checkNotNullParameter(arg9, "context");
        InputStream v7 = arg9.getContentResolver().openInputStream(arg7.getUri());
        if(v7 != null) {
            try {
                v9 = Okio.source(v7);
            }
            catch(Throwable v0) {
                goto label_34;
            }

            Source v1 = v9;
            try {
                arg6.push(v1, arg8, arg10, arg11);
                v6 = null;
                goto label_22;
            }
            catch(Throwable v0) {
                v6 = v0;
                try {
                    throw v6;
                }
                catch(Throwable v0) {
                    Throwable v8 = v0;
                    try {
                        CloseableKt.closeFinally(((Closeable)v9), v6);
                        throw v8;
                    label_22:
                        CloseableKt.closeFinally(((Closeable)v9), v6);
                    }
                    catch(Throwable v0) {
                    label_34:
                        v6 = v0;
                        try {
                            throw v6;
                        }
                        catch(Throwable v0) {
                            CloseableKt.closeFinally(((Closeable)v7), v6);
                            throw v0;
                        }
                    }
                }
            }

            CloseableKt.closeFinally(((Closeable)v7), v6);
            return;
        }

        throw new IllegalStateException("Required value was null.".toString());
    }

    public static void push$default(Kadb arg7, DocumentFile arg8, String arg9, Context arg10, int arg11, long arg12, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg11 = Kadb_androidKt.readMode(arg7, arg8);
        }

        int v4 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = arg8.lastModified();
        }

        Kadb_androidKt.push(arg7, arg8, arg9, arg10, v4, arg12);
    }

    public static final int readMode(Kadb arg1, File arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "file");
        Object v1 = Files.getAttribute(arg2.toPath(), "unix:mode", new LinkOption[0]);
        if((v1 instanceof Integer)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        throw new RuntimeException("Unable to read file mode");
    }

    public static final int readMode(Kadb arg1, DocumentFile arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "file");
        int v1 = arg2.canRead() ? 0x100 : 0;
        if(arg2.canWrite()) {
            v1 |= 0x80;
        }

        return v1;
    }
}

