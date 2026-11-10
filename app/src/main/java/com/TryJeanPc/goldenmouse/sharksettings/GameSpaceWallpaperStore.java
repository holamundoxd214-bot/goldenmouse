package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace$Named;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder$ImageInfo;
import android.graphics.ImageDecoder$Source;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build$VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\fJ\"\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0007J\u0016\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0016J\u0016\u0010\u0017\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/sharksettings/GameSpaceWallpaperStore;", "", "<init>", "()V", "PREFS", "", "MAX_EDGE", "", "MAX_PIXELS", "selected", "Ljava/io/File;", "context", "Landroid/content/Context;", "selectDefault", "", "boundedSize", "Lkotlin/Pair;", "width", "height", "decode", "Landroid/graphics/Bitmap;", "uri", "Landroid/net/Uri;", "save", "bitmap", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameSpaceWallpaperStore {
    public static final int $stable = 0;
    public static final GameSpaceWallpaperStore INSTANCE = null;
    public static final int MAX_EDGE = 0x800;
    public static final int MAX_PIXELS = 2000000;
    private static final String PREFS = "gamespace_wallpaper";

    static {
        GameSpaceWallpaperStore.INSTANCE = new GameSpaceWallpaperStore();
    }

    private GameSpaceWallpaperStore() {
        super();
    }

    public final Pair boundedSize(int arg7, int arg8) {
        if(arg7 > 0 && arg8 > 0) {
            double v2 = 2048 / (((double)Math.max(arg7, arg8)));
            double v6 = ((double)arg7);
            double v4 = ((double)arg8);
            double v0 = Math.min(1, Math.min(v2, Math.sqrt(2000000 / v6 / v4)));
            return TuplesKt.to(Integer.valueOf(Math.max(1, ((int)(v6 * v0)))), Integer.valueOf(Math.max(1, ((int)(v4 * v0)))));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Bitmap decode(Context arg13, Uri arg14) {
        Throwable v13_1;
        Bitmap v5_1;
        Bitmap v12;
        Intrinsics.checkNotNullParameter(arg13, "context");
        Intrinsics.checkNotNullParameter(arg14, "uri");
        ContentResolver v13 = arg13.getContentResolver();
        String v0 = v13.getType(arg14);
        int v1 = 2;
        Object v3 = null;
        if(v0 != null) {
            if(StringsKt.startsWith$default(v0, "image/", false, v1, v3)) {
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        if(Build$VERSION.SDK_INT >= 28) {
            v12 = ImageDecoder.decodeBitmap(ImageDecoder.createSource(v13, arg14), new GameSpaceWallpaperStore$$ExternalSyntheticLambda0());
            Intrinsics.checkNotNullExpressionValue(v12, "decodeBitmap(...)");
            return v12;
        }

        BitmapFactory$Options v0_1 = new BitmapFactory$Options();
        int v4 = 1;
        v0_1.inJustDecodeBounds = true;
        InputStream v5 = v13.openInputStream(arg14);
        try {
            BitmapFactory.decodeStream(v5, ((Rect)v3), v0_1);
        }
        catch(Throwable v0_2) {
            Throwable v12_1 = v0_2;
            try {
                throw v12_1;
            }
            catch(Throwable v0_2) {
                CloseableKt.closeFinally(((Closeable)v5), v12_1);
                throw v0_2;
            }
        }

        CloseableKt.closeFinally(((Closeable)v5), ((Throwable)v3));
        Pair v12_2 = this.boundedSize(v0_1.outWidth, v0_1.outHeight);
        int v6 = v12_2.component1().intValue();
        int v12_3 = v12_2.component2().intValue();
        v0_1.inSampleSize = 1;
        while(true) {
            if(v0_1.outWidth / v0_1.inSampleSize <= v6) {
                if(v0_1.outHeight / v0_1.inSampleSize > v12_3) {
                }
                else {
                    v0_1.inJustDecodeBounds = false;
                    InputStream v12_4 = v13.openInputStream(arg14);
                    try {
                        v5_1 = BitmapFactory.decodeStream(v12_4, ((Rect)v3), v0_1);
                    }
                    catch(Throwable v0_2) {
                        v13_1 = v0_2;
                        try {
                            throw v13_1;
                        }
                        catch(Throwable v0_2) {
                            CloseableKt.closeFinally(((Closeable)v12_4), v13_1);
                            throw v0_2;
                        }
                    }

                    CloseableKt.closeFinally(((Closeable)v12_4), ((Throwable)v3));
                    if(v5_1 != null) {
                        v12_4 = v13.openInputStream(arg14);
                        try {
                            InputStream v13_2 = v12_4;
                            if(v13_2 != null) {
                                v4 = new ExifInterface(v13_2).getAttributeInt("Orientation", 1);
                            }
                        }
                        catch(Throwable v0_2) {
                            v13_1 = v0_2;
                            try {
                                throw v13_1;
                            }
                            catch(Throwable v0_2) {
                                CloseableKt.closeFinally(((Closeable)v12_4), v13_1);
                                throw v0_2;
                            }
                        }

                        CloseableKt.closeFinally(((Closeable)v12_4), ((Throwable)v3));
                        Matrix v10 = new Matrix();
                        float v12_5 = -90f;
                        float v13_3 = 90f;
                        float v14 = 1f;
                        float v0_3 = -1f;
                        switch(v4) {
                            case 2: {
                                v10.setScale(v0_3, v14);
                                break;
                            }
                            case 3: {
                                v10.setRotate(180f);
                                break;
                            }
                            case 4: {
                                v10.setScale(v14, v0_3);
                                break;
                            }
                            case 5: {
                                v10.setRotate(v13_3);
                                v10.postScale(v0_3, v14);
                                break;
                            }
                            case 6: {
                                v10.setRotate(v13_3);
                                break;
                            }
                            case 7: {
                                v10.setRotate(v12_5);
                                v10.postScale(v0_3, v14);
                                break;
                            }
                            case 8: {
                                v10.setRotate(v12_5);
                                break;
                            }
                            default: {
                                break;
                            }
                        }

                        if(v10.isIdentity()) {
                            return v5_1;
                        }

                        v12 = Bitmap.createBitmap(v5_1, 0, 0, v5_1.getWidth(), v5_1.getHeight(), v10, true);
                        Intrinsics.checkNotNullExpressionValue(v12, "createBitmap(...)");
                        if(v12 != v5_1) {
                            v5_1.recycle();
                        }

                        return v12;
                    }
                    else {
                        throw new IOException("Imagen no válida");
                    }
                }
            }

            v0_1.inSampleSize *= v1;
        }
    }

    static final void decode$lambda$3(ImageDecoder arg1, ImageDecoder$ImageInfo arg2, ImageDecoder$Source arg3) {
        Intrinsics.checkNotNullParameter(arg1, "decoder");
        Intrinsics.checkNotNullParameter(arg2, "info");
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        Pair v2 = GameSpaceWallpaperStore.INSTANCE.boundedSize(arg2.getSize().getWidth(), arg2.getSize().getHeight());
        arg1.setTargetSize(v2.component1().intValue(), v2.component2().intValue());
        arg1.setAllocator(1);
        arg1.setTargetColorSpace(ColorSpace.get(ColorSpace$Named.SRGB));
    }

    public final File save(Context arg12, Bitmap arg13) {
        FileOutputStream v6;
        String v5;
        String v4;
        SharedPreferences v12_1;
        File v2;
        File v1;
        String v0 = "photo_";
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg12, "context");
            Intrinsics.checkNotNullParameter(arg13, "bitmap");
            v1 = new File(arg12.getFilesDir(), "gamespace_wallpaper");
            if(!v1.isDirectory()) {
                if(v1.mkdirs()) {
                }
                else {
                    throw new IOException("No se pudo guardar el fondo");
                }
            }

            v2 = new File(v1, v0 + UUID.randomUUID() + ".jpg");
            v12_1 = arg12.getSharedPreferences("gamespace_wallpaper", 0);
            v4 = null;
            v0 = v12_1.getString("type", v4);
            v5 = v12_1.getString("file", v4);
        }
        catch(Throwable v12) {
            goto label_108;
        }

        try {
            v6 = new FileOutputStream(v2);
        }
        catch(Exception v12_2) {
            goto label_105;
        }
        catch(Throwable v12) {
            goto label_108;
        }

        FileOutputStream v7 = v6;
        try {
            if(!arg13.compress(Bitmap$CompressFormat.JPEG, 90, v7)) {
                goto label_95;
            }

            v7.getFD().sync();
        }
        catch(Throwable v12) {
            goto label_100;
        }

        try {
            CloseableKt.closeFinally(((Closeable)v6), ((Throwable)v4));
            if(!v12_1.edit().putString("type", "photo").putString("file", v2.getName()).commit()) {
                goto label_85;
            }
        }
        catch(Exception v12_2) {
            goto label_105;
        }
        catch(Throwable v12) {
            goto label_108;
        }

        try {
            File[] v12_3 = v1.listFiles();
            if(v12_3 != null) {
                ArrayList v13 = new ArrayList();
                int v0_1 = v12_3.length;
                int v1_1;
                for(v1_1 = 0; v1_1 < v0_1; ++v1_1) {
                    File v5_1 = v12_3[v1_1];
                    if(!Intrinsics.areEqual(v5_1, v2)) {
                        String v6_1 = v5_1.getName();
                        Intrinsics.checkNotNullExpressionValue(v6_1, "getName(...)");
                        if(StringsKt.startsWith$default(v6_1, "photo_", false, 2, v4)) {
                            ((Collection)v13).add(v5_1);
                        }
                    }
                }

                Iterator v12_4 = ((Iterable)v13).iterator();
                while(v12_4.hasNext()) {
                    v12_4.next().delete();
                }
            }
        }
        catch(Throwable v12) {
            goto label_108;
        }

        __monitor_exit(this);
        return v2;
        try {
        label_85:
            v12_1.edit().putString("type", v0).putString("file", v5).apply();
            throw new IOException("No se pudo registrar el fondo");
        }
        catch(Exception v12_2) {
            goto label_105;
        }
        catch(Throwable v12) {
            goto label_108;
        }

        try {
        label_95:
            throw new IOException("Error JPEG");
        }
        catch(Throwable v12) {
            try {
            label_100:
                throw v12;
            }
            catch(Throwable v13_1) {
                try {
                    CloseableKt.closeFinally(((Closeable)v6), v12);
                    throw v13_1;
                }
                catch(Throwable v12) {
                label_109:
                    throw v12;
                }
                catch(Exception v12_2) {
                    try {
                    label_105:
                        v2.delete();
                        throw v12_2;
                    label_108:
                        __monitor_exit(this);
                        goto label_109;
                    }
                    catch(Throwable v12) {
                        goto label_108;
                    }
                }
            }
        }
    }

    public final void selectDefault(Context arg10) {
        String v4;
        String v2;
        SharedPreferences v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg10, "context");
            v0 = arg10.getSharedPreferences("gamespace_wallpaper", 0);
            String v3 = null;
            v2 = v0.getString("type", v3);
            v4 = v0.getString("file", v3);
            if(!v0.edit().putString("type", "default").remove("file").commit()) {
                goto label_49;
            }

            File[] v10_1 = new File(arg10.getFilesDir(), "gamespace_wallpaper").listFiles();
            if(v10_1 != null) {
                ArrayList v0_1 = new ArrayList();
                int v2_1 = v10_1.length;
                int v4_1;
                for(v4_1 = 0; v4_1 < v2_1; ++v4_1) {
                    File v5 = v10_1[v4_1];
                    String v6 = v5.getName();
                    Intrinsics.checkNotNullExpressionValue(v6, "getName(...)");
                    if(StringsKt.startsWith$default(v6, "photo_", false, 2, v3)) {
                        ((Collection)v0_1).add(v5);
                    }
                }

                Iterator v10_2 = ((Iterable)v0_1).iterator();
                while(v10_2.hasNext()) {
                    v10_2.next().delete();
                }
            }
        }
        catch(Throwable v10) {
            goto label_60;
        }

        __monitor_exit(this);
        return;
        try {
        label_49:
            v0.edit().putString("type", v2).putString("file", v4).apply();
            throw new IOException("No se pudo registrar el fondo");
        label_60:
            __monitor_exit(this);
        }
        catch(Throwable v10) {
            goto label_60;
        }

        throw v10;
    }

    public final File selected(Context arg5) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        SharedPreferences v4 = arg5.getSharedPreferences("gamespace_wallpaper", 0);
        String v1 = null;
        if(!Intrinsics.areEqual(v4.getString("type", v1), "photo")) {
            return ((File)v1);
        }

        String v4_1 = v4.getString("file", v1);
        if(v4_1 == null) {
            return ((File)v1);
        }

        if(!new Regex("photo_[a-f0-9-]{36}\\.jpg").matches(v4_1)) {
            return ((File)v1);
        }

        File v0 = new File(arg5.getFilesDir(), "gamespace_wallpaper/" + v4_1);
        if(v0.isFile()) {
            return v0;
        }

        return ((File)v1);
    }
}

