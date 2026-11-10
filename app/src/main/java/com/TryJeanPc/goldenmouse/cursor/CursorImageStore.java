package com.TryJeanPc.goldenmouse.cursor;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AtomicFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001A\n \u000E*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005H\u0002J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\u0018\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u001BH\u0002J\u0014\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00050\u001D2\u0006\u0010\u000F\u001A\u00020\u0010J\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000F\u001A\u00020\u0010J\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u000F\u001A\u00020\u0010J\u0018\u0010 \u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005J\u0016\u0010!\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005J\u000E\u0010\"\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u0010J\u0016\u0010#\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005J\u0016\u0010$\u001A\u00020\u00172\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010%\u001A\u00020&R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorImageStore;", "", "<init>", "()V", "ACTION_CHANGED", "", "ACTION_PICKER_FINISHED", "MAX_BYTES", "", "MAX_SIDE", "", "SELECTION_KEY", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "imageFile", "Landroid/util/AtomicFile;", "id", "migrate", "", "writeBitmap", "file", "bitmap", "Landroid/graphics/Bitmap;", "listImages", "", "selectedId", "load", "thumbnail", "select", "restoreDefault", "deleteImage", "importImage", "uri", "Landroid/net/Uri;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorImageStore {
    public static final int $stable = 0;
    public static final String ACTION_CHANGED = "com.TryJeanPc.goldenmouse.CURSOR_IMAGE_CHANGED";
    public static final String ACTION_PICKER_FINISHED = "com.TryJeanPc.goldenmouse.CURSOR_PICKER_FINISHED";
    public static final CursorImageStore INSTANCE = null;
    private static final long MAX_BYTES = 0x1000000;
    private static final int MAX_SIDE = 0x200;
    private static final String SELECTION_KEY = "imagen_cursor";

    static {
        CursorImageStore.INSTANCE = new CursorImageStore();
    }

    private CursorImageStore() {
        super();
    }

    public final void deleteImage(Context arg2, String arg3) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "context");
            Intrinsics.checkNotNullParameter(arg3, "id");
            if(Intrinsics.areEqual(arg3, this.selectedId(arg2))) {
                goto label_20;
            }

            AtomicFile v2_1 = this.imageFile(arg2, arg3);
            v2_1.delete();
            if(v2_1.getBaseFile().exists()) {
                goto label_15;
            }
        }
        catch(Throwable v2) {
            goto label_26;
        }

        __monitor_exit(this);
        return;
        try {
        label_15:
            throw new IllegalStateException("No se pudo eliminar la imagen".toString());
        label_20:
            throw new IllegalArgumentException("Selecciona otro cursor antes de eliminar el activo".toString());
        label_26:
            __monitor_exit(this);
        }
        catch(Throwable v2) {
            goto label_26;
        }

        throw v2;
    }

    private final File directory(Context arg2) {
        File v1 = new File(arg2.getFilesDir(), "cursor_library");
        if(!v1.isDirectory()) {
            if(v1.mkdirs()) {
            }
            else {
                throw new IllegalStateException("No se pudo abrir la biblioteca".toString());
            }
        }

        return v1;
    }

    private final AtomicFile imageFile(Context arg4, String arg5) {
        if(new Regex("[a-zA-Z0-9-]+\\.png").matches(arg5)) {
            return new AtomicFile(new File(this.directory(arg4), arg5));
        }

        throw new IllegalArgumentException("Imagen no válida".toString());
    }

    public final void importImage(Context arg12, Uri arg13) {
        Bitmap v13_2;
        Throwable v1_1;
        FileOutputStream v2;
        InputStream v13;
        File v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg12, "context");
            Intrinsics.checkNotNullParameter(arg13, "uri");
            this.migrate(arg12);
            v0 = File.createTempFile("cursor_import_", ".tmp", arg12.getCacheDir());
        }
        catch(Throwable v12) {
            goto label_135;
        }

        try {
            v13 = arg12.getContentResolver().openInputStream(arg13);
            if(v13 == null) {
                goto label_127;
            }
        }
        catch(Throwable v12) {
            goto label_132;
        }

        InputStream v1 = v13;
        try {
            Intrinsics.checkNotNull(v0);
            v2 = new FileOutputStream(v0);
        }
        catch(Throwable v12) {
            goto label_123;
        }

        FileOutputStream v3 = v2;
        try {
            byte[] v4 = new byte[0x2000];
            long v5 = 0;
            while(true) {
                int v7 = v1.read(v4);
                if(v7 < 0) {
                    goto label_35;
                }

                v5 += ((long)v7);
                if(v5 > 0x1000000) {
                    break;
                }

                v3.write(v4, 0, v7);
            }

            throw new IllegalArgumentException("La imagen supera el límite de 16 MB".toString());
        label_35:
            v1_1 = null;
        }
        catch(Throwable v12) {
            goto label_118;
        }

        try {
            CloseableKt.closeFinally(((Closeable)v2), v1_1);
        }
        catch(Throwable v12) {
            goto label_123;
        }

        try {
            CloseableKt.closeFinally(((Closeable)v13), v1_1);
            BitmapFactory$Options v13_1 = new BitmapFactory$Options();
            int v1_2 = 1;
            v13_1.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(v0.getPath(), v13_1);
            if(SetsKt.setOf(new String[]{"image/png", "image/jpeg"}).contains(v13_1.outMimeType)) {
                int v2_1 = v13_1.outWidth;
                if(1 <= v2_1) {
                    int v3_1 = 0x8001;
                    if(v2_1 < v3_1) {
                        v2_1 = v13_1.outHeight;
                        if(1 <= v2_1) {
                            if(v2_1 >= v3_1) {
                                goto label_112;
                            }

                            goto label_63;
                        }
                    }
                }
            }

        label_112:
            throw new IllegalArgumentException("Selecciona una imagen PNG o JPG válida".toString());
        label_63:
            while(Math.max(v13_1.outWidth, v13_1.outHeight) / v1_2 > 0x200) {
                v1_2 *= 2;
            }

            v13_1 = new BitmapFactory$Options();
            v13_1.inSampleSize = v1_2;
            v13_1.inPreferredConfig = Bitmap$Config.ARGB_8888;
            v13_2 = BitmapFactory.decodeFile(v0.getPath(), v13_1);
            if(v13_2 == null) {
                goto label_108;
            }
        }
        catch(Throwable v12) {
            goto label_132;
        }

        try {
            new CursorBitmapDrawable(v13_2);
            String v1_3 = UUID.randomUUID() + ".png";
            this.writeBitmap(this.imageFile(arg12, v1_3), v13_2);
            if(!this.prefs(arg12).edit().putString("imagen_cursor", v1_3).commit()) {
                goto label_100;
            }
        }
        catch(Throwable v12) {
            goto label_106;
        }

        try {
            v13_2.recycle();
        }
        catch(Throwable v12) {
            goto label_132;
        }

        try {
            v0.delete();
        }
        catch(Throwable v12) {
            goto label_135;
        }

        __monitor_exit(this);
        return;
        try {
        label_100:
            throw new IllegalStateException("La imagen se importó, pero no se pudo guardar la selección".toString());
        }
        catch(Throwable v12) {
            try {
            label_106:
                v13_2.recycle();
                throw v12;
            label_108:
                throw new IllegalArgumentException("No se pudo leer la imagen");
            }
            catch(Throwable v12) {
                goto label_132;
            }
        }

        try {
        label_118:
            throw v12;
        }
        catch(Throwable v1_1) {
            try {
                CloseableKt.closeFinally(((Closeable)v2), v12);
                throw v1_1;
            }
            catch(Throwable v12) {
                try {
                label_123:
                    throw v12;
                }
                catch(Throwable v1_1) {
                    try {
                        CloseableKt.closeFinally(((Closeable)v13), v12);
                        throw v1_1;
                    label_127:
                        throw new IllegalArgumentException("No se pudo abrir la imagen");
                    }
                    catch(Throwable v12) {
                        try {
                        label_132:
                            v0.delete();
                            throw v12;
                        label_135:
                            __monitor_exit(this);
                        }
                        catch(Throwable v12) {
                            goto label_135;
                        }
                    }
                }
            }
        }

        throw v12;
    }

    public final List listImages(Context arg10) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg10, "context");
            this.migrate(arg10);
            File[] v10_1 = this.directory(arg10).listFiles();
            if(v10_1 == null) {
                v10_1 = new File[0];
            }

            ArrayList v1 = new ArrayList();
            int v2 = v10_1.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                File v4 = v10_1[v3];
                if(v4.isFile()) {
                    String v5 = v4.getName();
                    Intrinsics.checkNotNullExpressionValue(v5, "getName(...)");
                    if(StringsKt.endsWith$default(v5, ".png", false, 2, null)) {
                        ((Collection)v1).add(v4);
                    }
                }
            }

            List v10_2 = CollectionsKt.sortedWith(((Iterable)v1), new CursorImageStore$listImages$$inlined$sortedBy$1());
            ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10_2), 10));
            Iterator v10_3 = ((Iterable)v10_2).iterator();
            while(v10_3.hasNext()) {
                ((Collection)v0).add(v10_3.next().getName());
            }

            __monitor_exit(this);
            return ((List)v0);
        }
        catch(Throwable v10) {
            try {
            label_45:
                __monitor_exit(this);
            }
            catch(Throwable v10) {
                goto label_45;
            }

            throw v10;
        }
    }

    public final Bitmap load(Context arg3) {
        Bitmap v0_3;
        FileInputStream v3_1;
        Bitmap v1;
        String v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "context");
            v0 = this.selectedId(arg3);
            v1 = null;
            if(v0 != null) {
                goto label_8;
            }
        }
        catch(Throwable v3) {
            goto label_26;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_8:
            v3_1 = this.imageFile(arg3, v0).openRead();
        }
        catch(Throwable v3) {
            goto label_26;
        }

        FileInputStream v0_1 = v3_1;
        try {
            v0_3 = BitmapFactory.decodeStream(((InputStream)v0_1));
            goto label_12;
        }
        catch(Throwable v0_2) {
            try {
                throw v0_2;
            }
            catch(Throwable v1_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)v3_1), v0_2);
                    throw v1_1;
                label_12:
                    CloseableKt.closeFinally(((Closeable)v3_1), ((Throwable)v1));
                    if(v0_3 == null) {
                        goto label_16;
                    }
                }
                catch(Throwable v3) {
                    goto label_26;
                }
            }
        }

        __monitor_exit(this);
        return v0_3;
        try {
        label_16:
            throw new IllegalArgumentException("La copia del cursor no es válida");
        label_26:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_26;
        }

        throw v3;
    }

    private final void migrate(Context arg10) {
        FileOutputStream v3_1;
        FileInputStream v0_1;
        SharedPreferences v0 = this.prefs(arg10);
        String v1 = "cursor_library_migrated";
        if(v0.getBoolean(v1, false)) {
        }
        else {
            File v3 = new File(arg10.getFilesDir(), "custom_cursor.png");
            File v4 = new File(v3.getPath() + ".bak");
            if(v4.exists()) {
                v3 = v4;
            }

            boolean v4_1 = v3.exists();
            SharedPreferences$Editor v5 = v0.edit();
            if(v4_1) {
                String v4_2 = "cursor_migration_id";
                String v6 = null;
                String v7 = v0.getString(v4_2, v6);
                if(v7 == null) {
                    v7 = UUID.randomUUID() + ".png";
                    if(v0.edit().putString(v4_2, v7).commit()) {
                    }
                    else {
                        throw new IllegalStateException("Check failed.");
                    }
                }

                AtomicFile v9 = this.imageFile(arg10, v7);
                if(!v9.getBaseFile().exists()) {
                    FileInputStream v10 = new FileInputStream(v3);
                    try {
                        v0_1 = v10;
                        v3_1 = v9.startWrite();
                    }
                    catch(Throwable v9_1) {
                        goto label_65;
                    }

                    try {
                        Intrinsics.checkNotNull(v3_1);
                        ByteStreamsKt.copyTo$default(((InputStream)v0_1), v3_1, 0, 2, v6);
                        v9.finishWrite(v3_1);
                        goto label_58;
                    }
                    catch(Throwable v0_2) {
                        try {
                            v9.failWrite(v3_1);
                            throw v0_2;
                        label_58:
                        }
                        catch(Throwable v9_1) {
                            try {
                            label_65:
                                throw v9_1;
                            }
                            catch(Throwable v0_2) {
                                CloseableKt.closeFinally(((Closeable)v10), v9_1);
                                throw v0_2;
                            }
                        }
                    }

                    CloseableKt.closeFinally(((Closeable)v10), ((Throwable)v6));
                }

                v5.putString("imagen_cursor", v7);
            }

            if(!v5.putBoolean(v1, true).commit()) {
                goto label_76;
            }
        }

        return;
    label_76:
        throw new IllegalStateException("No se pudo guardar la migración".toString());
    }

    private final SharedPreferences prefs(Context arg2) {
        return arg2.getSharedPreferences("mouse_settings", 0);
    }

    public final void restoreDefault(Context arg2) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "context");
            this.migrate(arg2);
            if(!this.prefs(arg2).edit().remove("imagen_cursor").commit()) {
                goto label_12;
            }
        }
        catch(Throwable v2) {
            goto label_18;
        }

        __monitor_exit(this);
        return;
        try {
        label_12:
            throw new IllegalStateException("No se pudo restaurar el cursor".toString());
        label_18:
            __monitor_exit(this);
        }
        catch(Throwable v2) {
            goto label_18;
        }

        throw v2;
    }

    public final void select(Context arg4, String arg5) {
        Throwable v2;
        Bitmap v1_1;
        FileInputStream v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg4, "context");
            Intrinsics.checkNotNullParameter(arg5, "id");
            this.migrate(arg4);
            v0 = this.imageFile(arg4, arg5).openRead();
        }
        catch(Throwable v4) {
            goto label_42;
        }

        FileInputStream v1 = v0;
        try {
            v1_1 = BitmapFactory.decodeStream(((InputStream)v1));
            v2 = null;
            goto label_11;
        }
        catch(Throwable v4) {
            try {
                throw v4;
            }
            catch(Throwable v5) {
                try {
                    CloseableKt.closeFinally(((Closeable)v0), v4);
                    throw v5;
                label_11:
                    CloseableKt.closeFinally(((Closeable)v0), v2);
                    if(v1_1 == null) {
                        goto label_32;
                    }
                }
                catch(Throwable v4) {
                    goto label_42;
                }
            }
        }

        try {
            new CursorBitmapDrawable(v1_1);
            goto label_15;
        }
        catch(Throwable v4) {
            try {
                v1_1.recycle();
                throw v4;
            label_15:
                v1_1.recycle();
                if(!this.prefs(arg4).edit().putString("imagen_cursor", arg5).commit()) {
                    goto label_24;
                }
            }
            catch(Throwable v4) {
                goto label_42;
            }
        }

        __monitor_exit(this);
        return;
        try {
        label_24:
            throw new IllegalStateException("No se pudo guardar la selección".toString());
        label_32:
            throw new IllegalArgumentException("La imagen no es válida");
        label_42:
            __monitor_exit(this);
        }
        catch(Throwable v4) {
            goto label_42;
        }

        throw v4;
    }

    public final String selectedId(Context arg3) {
        String v3_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "context");
            this.migrate(arg3);
            v3_1 = this.prefs(arg3).getString("imagen_cursor", null);
        }
        catch(Throwable v3) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_11;
            }

            throw v3;
        }

        __monitor_exit(this);
        return v3_1;
    }

    public final Bitmap thumbnail(Context arg3, String arg4) {
        Bitmap v4_2;
        Rect v1;
        FileInputStream v3_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "context");
            Intrinsics.checkNotNullParameter(arg4, "id");
            v3_1 = this.imageFile(arg3, arg4).openRead();
        }
        catch(Throwable v3) {
            goto label_24;
        }

        FileInputStream v4 = v3_1;
        try {
            BitmapFactory$Options v0 = new BitmapFactory$Options();
            v0.inSampleSize = 4;
            v1 = null;
            v4_2 = BitmapFactory.decodeStream(((InputStream)v4), v1, v0);
            goto label_15;
        }
        catch(Throwable v4_1) {
            try {
                throw v4_1;
            }
            catch(Throwable v0_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)v3_1), v4_1);
                    throw v0_1;
                label_15:
                    CloseableKt.closeFinally(((Closeable)v3_1), ((Throwable)v1));
                    goto label_16;
                label_24:
                    __monitor_exit(this);
                }
                catch(Throwable v3) {
                    goto label_24;
                }
            }
        }

        throw v3;
    label_16:
        __monitor_exit(this);
        return v4_2;
    }

    private final void writeBitmap(AtomicFile arg4, Bitmap arg5) {
        FileOutputStream v3 = arg4.startWrite();
        try {
            if(arg5.compress(Bitmap$CompressFormat.PNG, 100, v3)) {
                arg4.finishWrite(v3);
                return;
            }

            throw new IllegalStateException("Check failed.");
        }
        catch(Throwable v5) {
            arg4.failWrite(v3);
            throw v5;
        }
    }
}

