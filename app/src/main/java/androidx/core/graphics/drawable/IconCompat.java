package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.Intent$ShortcutIconResource;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Shader$TileMode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static IconCompat createFromIcon(Context arg2, Icon arg3) {
            int v0 = Api23Impl.getType(arg3);
            if(v0 != 2) {
                if(v0 != 4) {
                    if(v0 != 6) {
                        IconCompat v2 = new IconCompat(-1);
                        v2.mObj1 = arg3;
                        return v2;
                    }

                    return IconCompat.createWithAdaptiveBitmapContentUri(Api23Impl.getUri(arg3));
                }

                return IconCompat.createWithContentUri(Api23Impl.getUri(arg3));
            }

            String v0_1 = Api23Impl.getResPackage(arg3);
            try {
                return IconCompat.createWithResource(IconCompat.getResources(arg2, v0_1), v0_1, Api23Impl.getResId(arg3));
            }
            catch(Resources$NotFoundException ) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        }

        static IconCompat createFromIconInner(Object arg2) {
            Preconditions.checkNotNull(arg2);
            int v0 = Api23Impl.getType(arg2);
            if(v0 != 2) {
                if(v0 != 4) {
                    if(v0 != 6) {
                        IconCompat v0_1 = new IconCompat(-1);
                        v0_1.mObj1 = arg2;
                        return v0_1;
                    }

                    return IconCompat.createWithAdaptiveBitmapContentUri(Api23Impl.getUri(arg2));
                }

                return IconCompat.createWithContentUri(Api23Impl.getUri(arg2));
            }

            return IconCompat.createWithResource(null, Api23Impl.getResPackage(arg2), Api23Impl.getResId(arg2));
        }

        static int getResId(Object arg6) {
            String v0 = "Unable to get icon resource";
            String v1 = "IconCompat";
            if(Build$VERSION.SDK_INT >= 28) {
                return Api28Impl.getResId(arg6);
            }

            try {
                return arg6.getClass().getMethod("getResId").invoke(arg6).intValue();
            }
            catch(NoSuchMethodException v6) {
                Log.e(v1, v0, ((Throwable)v6));
                return 0;
            }
            catch(InvocationTargetException v6_1) {
                Log.e(v1, v0, ((Throwable)v6_1));
                return 0;
            }
            catch(IllegalAccessException v6_2) {
                Log.e(v1, v0, ((Throwable)v6_2));
                return 0;
            }
        }

        static String getResPackage(Object arg7) {
            String v0 = "Unable to get icon package";
            String v1 = "IconCompat";
            if(Build$VERSION.SDK_INT >= 28) {
                return Api28Impl.getResPackage(arg7);
            }

            String v2 = null;
            try {
                return arg7.getClass().getMethod("getResPackage").invoke(arg7);
            }
            catch(NoSuchMethodException v7) {
                Log.e(v1, v0, ((Throwable)v7));
                return v2;
            }
            catch(InvocationTargetException v7_1) {
                Log.e(v1, v0, ((Throwable)v7_1));
                return v2;
            }
            catch(IllegalAccessException v7_2) {
                Log.e(v1, v0, ((Throwable)v7_2));
                return v2;
            }
        }

        static int getType(Object arg7) {
            int v7;
            String v0 = "Unable to get icon type ";
            String v1 = "IconCompat";
            if(Build$VERSION.SDK_INT >= 28) {
                return Api28Impl.getType(arg7);
            }

            int v2 = -1;
            try {
                v7 = arg7.getClass().getMethod("getType").invoke(arg7).intValue();
                return v7;
            }
            catch(NoSuchMethodException v3) {
                Log.e(v1, v0 + v7, ((Throwable)v3));
                return v2;
            }
            catch(InvocationTargetException v3_1) {
                Log.e(v1, v0 + v7, ((Throwable)v3_1));
                return v2;
            }
            catch(IllegalAccessException v3_2) {
                Log.e(v1, v0 + v7, ((Throwable)v3_2));
                return v2;
            }
        }

        static Uri getUri(Object arg7) {
            String v0 = "Unable to get icon uri";
            String v1 = "IconCompat";
            if(Build$VERSION.SDK_INT >= 28) {
                return Api28Impl.getUri(arg7);
            }

            Uri v2 = null;
            try {
                return arg7.getClass().getMethod("getUri").invoke(arg7);
            }
            catch(NoSuchMethodException v7) {
                Log.e(v1, v0, ((Throwable)v7));
                return v2;
            }
            catch(InvocationTargetException v7_1) {
                Log.e(v1, v0, ((Throwable)v7_1));
                return v2;
            }
            catch(IllegalAccessException v7_2) {
                Log.e(v1, v0, ((Throwable)v7_2));
                return v2;
            }
        }

        static Icon toIcon(IconCompat arg2, Context arg3) {
            switch(arg2.mType) {
                case -1: {
                    goto label_63;
                }
                case 1: {
                    goto label_51;
                }
                case 2: {
                    goto label_47;
                }
                case 3: {
                    goto label_42;
                }
                case 4: {
                    goto label_39;
                }
                case 5: {
                    goto label_36;
                }
                case 6: {
                    goto label_6;
                }
            }

            throw new IllegalArgumentException("Unknown type");
        label_51:
            Icon v3 = Icon.createWithBitmap(arg2.mObj1);
            goto label_53;
        label_36:
            v3 = Api26Impl.createWithAdaptiveBitmap(arg2.mObj1);
            goto label_53;
        label_6:
            if(Build$VERSION.SDK_INT >= 30) {
                v3 = Api30Impl.createWithAdaptiveBitmapContentUri(arg2.getUri());
                goto label_53;
            }

            if(arg3 == null) {
                goto label_27;
            }

            InputStream v3_1 = arg2.getUriInputStream(arg3);
            if(v3_1 != null) {
                v3 = Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream(v3_1));
            }
            else {
                throw new IllegalStateException("Cannot load adaptive icon from uri: " + arg2.getUri());
            label_27:
                throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + arg2.getUri());
            label_39:
                v3 = Icon.createWithContentUri(arg2.mObj1);
                goto label_53;
            label_42:
                v3 = Icon.createWithData(arg2.mObj1, arg2.mInt1, arg2.mInt2);
                goto label_53;
            label_63:
                return arg2.mObj1;
            label_47:
                v3 = Icon.createWithResource(arg2.getResPackage(), arg2.mInt1);
            }

        label_53:
            if(arg2.mTintList != null) {
                v3.setTintList(arg2.mTintList);
            }

            if(arg2.mTintMode != IconCompat.DEFAULT_TINT_MODE) {
                v3.setTintMode(arg2.mTintMode);
            }

            return v3;
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static Icon createWithAdaptiveBitmap(Bitmap arg0) {
            return Icon.createWithAdaptiveBitmap(arg0);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static int getResId(Object arg0) {
            return ((Icon)arg0).getResId();
        }

        static String getResPackage(Object arg0) {
            return ((Icon)arg0).getResPackage();
        }

        static int getType(Object arg0) {
            return ((Icon)arg0).getType();
        }

        static Uri getUri(Object arg0) {
            return ((Icon)arg0).getUri();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static Icon createWithAdaptiveBitmapContentUri(Uri arg0) {
            return Icon.createWithAdaptiveBitmapContentUri(arg0);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface IconType {
    }

    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010417f;
    static final PorterDuff$Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.666667f;
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
    static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.916667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    PorterDuff$Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    static {
        IconCompat.DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }

    public IconCompat() {
        super();
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = IconCompat.DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    IconCompat(int arg3) {
        super();
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = IconCompat.DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = arg3;
    }

    public void addToShortcutIntent(Intent arg5, Drawable arg6, Context arg7) {
        Bitmap v4;
        Bitmap v7;
        int v7_1;
        this.checkResource(arg7);
        int v0 = this.mType;
        if(v0 == 1) {
            Object v4_1 = this.mObj1;
            if(arg6 == null) {
                goto label_63;
            }

            v4 = ((Bitmap)v4_1).copy(((Bitmap)v4_1).getConfig(), true);
        }
        else if(v0 == 2) {
            try {
                arg7 = arg7.createPackageContext(this.getResPackage(), 0);
                if(arg6 == null) {
                    arg5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent$ShortcutIconResource.fromContext(arg7, this.mInt1));
                    return;
                }
                else {
                    Drawable v0_1 = ContextCompat.getDrawable(arg7, this.mInt1);
                    if(v0_1.getIntrinsicWidth() <= 0 || v0_1.getIntrinsicHeight() <= 0) {
                        v7_1 = arg7.getSystemService("activity").getLauncherLargeIconSize();
                        v7 = Bitmap.createBitmap(v7_1, v7_1, Bitmap$Config.ARGB_8888);
                    }
                    else {
                        v7 = Bitmap.createBitmap(v0_1.getIntrinsicWidth(), v0_1.getIntrinsicHeight(), Bitmap$Config.ARGB_8888);
                    }

                    v0_1.setBounds(0, 0, v7.getWidth(), v7.getHeight());
                    v0_1.draw(new Canvas(v7));
                    v4 = v7;
                }
            }
            catch(PackageManager$NameNotFoundException v5) {
                throw new IllegalArgumentException("Can\'t find package " + ((IconCompat)v4).mObj1, ((Throwable)v5));
            }
        }
        else if(v0 == 5) {
            v4 = IconCompat.createLegacyIconFromAdaptiveIcon(this.mObj1, true);
        }
        else {
            throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        }

    label_63:
        if(arg6 != null) {
            v7_1 = v4.getWidth();
            v0 = v4.getHeight();
            arg6.setBounds(v7_1 / 2, v0 / 2, v7_1, v0);
            arg6.draw(new Canvas(v4));
        }

        arg5.putExtra("android.intent.extra.shortcut.ICON", ((Parcelable)v4));
    }

    public void checkResource(Context arg9) {
        if(this.mType == 2) {
            Object v0 = this.mObj1;
            if(v0 != null) {
                String v1 = ":";
                if(!((String)v0).contains(((CharSequence)v1))) {
                }
                else {
                    String v3 = ((String)v0).split(v1, -1)[1];
                    String v6 = v3.split("/", -1)[0];
                    v3 = v3.split("/", -1)[1];
                    v1 = ((String)v0).split(v1, -1)[0];
                    String v4 = "IconCompat";
                    if("0_resource_name_obfuscated".equals(v3)) {
                        Log.i(v4, "Found obfuscated resource, not trying to update resource id for it");
                        return;
                    }
                    else {
                        String v2 = this.getResPackage();
                        int v9 = IconCompat.getResources(arg9, v2).getIdentifier(v3, v6, v1);
                        if(this.mInt1 != v9) {
                            Log.i(v4, "Id has changed for " + v2 + " " + (((String)v0)));
                            this.mInt1 = v9;
                        }
                    }
                }
            }
        }
    }

    public static IconCompat createFromBundle(Bundle arg4) {
        int v0 = arg4.getInt("type");
        IconCompat v1 = new IconCompat(v0);
        v1.mInt1 = arg4.getInt("int1");
        v1.mInt2 = arg4.getInt("int2");
        v1.mString1 = arg4.getString("string1");
        String v2 = "tint_list";
        if(arg4.containsKey(v2)) {
            v1.mTintList = arg4.getParcelable(v2);
        }

        v2 = "tint_mode";
        if(arg4.containsKey(v2)) {
            v1.mTintMode = PorterDuff$Mode.valueOf(arg4.getString(v2));
        }

        v2 = "obj";
        switch(v0) {
            case 3: {
                goto label_35;
            }
            case -1: 
            case 1: 
            case 5: {
                goto label_41;
            }
            case 2: 
            case 4: 
            case 6: {
                goto label_38;
            }
        }

        Log.w("IconCompat", "Unknown type " + v0);
        return null;
    label_35:
        v1.mObj1 = arg4.getByteArray(v2);
        return v1;
    label_38:
        v1.mObj1 = arg4.getString(v2);
        return v1;
    label_41:
        v1.mObj1 = arg4.getParcelable(v2);
        return v1;
    }

    public static IconCompat createFromIcon(Icon arg0) {
        return Api23Impl.createFromIconInner(arg0);
    }

    public static IconCompat createFromIcon(Context arg0, Icon arg1) {
        Preconditions.checkNotNull(arg1);
        return Api23Impl.createFromIcon(arg0, arg1);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon arg2) {
        if(Api23Impl.getType(arg2) == 2 && Api23Impl.getResId(arg2) == 0) {
            return null;
        }

        return Api23Impl.createFromIconInner(arg2);
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap arg9, boolean arg10) {
        int v0 = ((int)((((float)Math.min(arg9.getWidth(), arg9.getHeight()))) * 0.666667f));
        Bitmap v1 = Bitmap.createBitmap(v0, v0, Bitmap$Config.ARGB_8888);
        Canvas v2 = new Canvas(v1);
        Paint v3 = new Paint(3);
        float v4 = ((float)v0);
        float v5 = 0.5f * v4;
        float v6 = 0.916667f * v5;
        if(arg10) {
            float v10 = 0.010417f * v4;
            v3.setColor(0);
            v3.setShadowLayer(v10, 0f, v4 * 0.020833f, 0x3D000000);
            v2.drawCircle(v5, v5, v6, v3);
            v3.setShadowLayer(v10, 0f, 0f, 0x1E000000);
            v2.drawCircle(v5, v5, v6, v3);
            v3.clearShadowLayer();
        }

        v3.setColor(0xFF000000);
        BitmapShader v10_1 = new BitmapShader(arg9, Shader$TileMode.CLAMP, Shader$TileMode.CLAMP);
        Matrix v4_1 = new Matrix();
        v4_1.setTranslate((((float)(-(arg9.getWidth() - v0)))) / 2f, (((float)(-(arg9.getHeight() - v0)))) / 2f);
        v10_1.setLocalMatrix(v4_1);
        v3.setShader(((Shader)v10_1));
        v2.drawCircle(v5, v5, v6, v3);
        v2.setBitmap(null);
        return v1;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap arg2) {
        ObjectsCompat.requireNonNull(arg2);
        IconCompat v0 = new IconCompat(5);
        v0.mObj1 = arg2;
        return v0;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri arg0) {
        ObjectsCompat.requireNonNull(arg0);
        return IconCompat.createWithAdaptiveBitmapContentUri(arg0.toString());
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String arg2) {
        ObjectsCompat.requireNonNull(arg2);
        IconCompat v0 = new IconCompat(6);
        v0.mObj1 = arg2;
        return v0;
    }

    public static IconCompat createWithBitmap(Bitmap arg2) {
        ObjectsCompat.requireNonNull(arg2);
        IconCompat v0 = new IconCompat(1);
        v0.mObj1 = arg2;
        return v0;
    }

    public static IconCompat createWithContentUri(Uri arg0) {
        ObjectsCompat.requireNonNull(arg0);
        return IconCompat.createWithContentUri(arg0.toString());
    }

    public static IconCompat createWithContentUri(String arg2) {
        ObjectsCompat.requireNonNull(arg2);
        IconCompat v0 = new IconCompat(4);
        v0.mObj1 = arg2;
        return v0;
    }

    public static IconCompat createWithData(byte[] arg2, int arg3, int arg4) {
        ObjectsCompat.requireNonNull(arg2);
        IconCompat v0 = new IconCompat(3);
        v0.mObj1 = arg2;
        v0.mInt1 = arg3;
        v0.mInt2 = arg4;
        return v0;
    }

    public static IconCompat createWithResource(Resources arg2, String arg3, int arg4) {
        ObjectsCompat.requireNonNull(arg3);
        if(arg4 != 0) {
            IconCompat v0 = new IconCompat(2);
            v0.mInt1 = arg4;
            if(arg2 != null) {
                try {
                    v0.mObj1 = arg2.getResourceName(arg4);
                }
                catch(Resources$NotFoundException ) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            }
            else {
                v0.mObj1 = arg3;
            }

            v0.mString1 = arg3;
            return v0;
        }

        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static IconCompat createWithResource(Context arg1, int arg2) {
        ObjectsCompat.requireNonNull(arg1);
        return IconCompat.createWithResource(arg1.getResources(), arg1.getPackageName(), arg2);
    }

    public Bitmap getBitmap() {
        int v0 = this.mType;
        if(v0 == -1) {
            Object v3 = this.mObj1;
            if((v3 instanceof Bitmap)) {
                return ((Bitmap)v3);
            }

            return null;
        }

        if(v0 == 1) {
            return this.mObj1;
        }

        if(v0 == 5) {
            return IconCompat.createLegacyIconFromAdaptiveIcon(this.mObj1, true);
        }

        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int getResId() {
        int v0 = this.mType;
        if(v0 == -1) {
            return Api23Impl.getResId(this.mObj1);
        }

        if(v0 == 2) {
            return this.mInt1;
        }

        throw new IllegalStateException("called getResId() on " + this);
    }

    public String getResPackage() {
        int v0 = this.mType;
        int v1 = -1;
        if(v0 == v1) {
            return Api23Impl.getResPackage(this.mObj1);
        }

        if(v0 == 2) {
            String v0_1 = this.mString1;
            if(v0_1 != null) {
                if(TextUtils.isEmpty(((CharSequence)v0_1))) {
                }
                else {
                    return this.mString1;
                }
            }

            return this.mObj1.split(":", v1)[0];
        }

        throw new IllegalStateException("called getResPackage() on " + this);
    }

    static Resources getResources(Context arg2, String arg3) {
        if("android".equals(arg3)) {
            return Resources.getSystem();
        }

        PackageManager v2 = arg2.getPackageManager();
        int v0 = 0x2000;
        Resources v1 = null;
        try {
            ApplicationInfo v0_1 = v2.getApplicationInfo(arg3, v0);
            if(v0_1 == null) {
                return v1;
            }

            return v2.getResourcesForApplication(v0_1);
        }
        catch(PackageManager$NameNotFoundException v2_1) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", arg3), ((Throwable)v2_1));
            return v1;
        }

        return v1;
    }

    public int getType() {
        int v0 = this.mType;
        if(v0 == -1) {
            return Api23Impl.getType(this.mObj1);
        }

        return v0;
    }

    public Uri getUri() {
        int v0 = this.mType;
        if(v0 == -1) {
            return Api23Impl.getUri(this.mObj1);
        }

        if(v0 != 4) {
            if(v0 == 6) {
            }
            else {
                throw new IllegalStateException("called getUri() on " + this);
            }
        }

        return Uri.parse(this.mObj1);
    }

    public InputStream getUriInputStream(Context arg5) {
        Uri v0 = this.getUri();
        String v1 = v0.getScheme();
        String v3 = "IconCompat";
        if(!"content".equals(v1)) {
            if("file".equals(v1)) {
            }
            else {
                try {
                    return new FileInputStream(new File(this.mObj1));
                }
                catch(FileNotFoundException v4) {
                    Log.w(v3, "Unable to load image from path: " + v0, ((Throwable)v4));
                    return null;
                }
            }
        }

        try {
            return arg5.getContentResolver().openInputStream(v0);
        }
        catch(Exception v4_1) {
            Log.w(v3, "Unable to load image from URI: " + v0, ((Throwable)v4_1));
        }

        return null;
    }

    public Drawable loadDrawable(Context arg1) {
        this.checkResource(arg1);
        return this.toIcon(arg1).loadDrawable(arg1);
    }

    public void onPostParceling() {
        this.mTintMode = PorterDuff$Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
            case -1: {
                goto label_40;
            }
            case 3: {
                goto label_7;
            }
            case 1: 
            case 5: {
                goto label_28;
            }
            case 2: 
            case 4: 
            case 6: {
                goto label_10;
            }
        }

        return;
    label_7:
        this.mObj1 = this.mData;
        return;
    label_40:
        Parcelable v0 = this.mParcelable;
        if(v0 != null) {
            this.mObj1 = v0;
            return;
        }

        throw new IllegalArgumentException("Invalid icon");
    label_10:
        String v0_1 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = v0_1;
        if(this.mType == 2 && this.mString1 == null) {
            this.mString1 = v0_1.split(":", -1)[0];
            return;
        }

        return;
    label_28:
        v0 = this.mParcelable;
        if(v0 != null) {
            this.mObj1 = v0;
            return;
        }

        byte[] v0_2 = this.mData;
        this.mObj1 = v0_2;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = v0_2.length;
    }

    public void onPreParceling(boolean arg4) {
        this.mTintModeStr = this.mTintMode.name();
        String v1 = "UTF-16";
        switch(this.mType) {
            case -1: {
                goto label_33;
            }
            case 2: {
                goto label_16;
            }
            case 3: {
                goto label_13;
            }
            case 1: 
            case 5: {
                goto label_21;
            }
            case 4: 
            case 6: {
                goto label_7;
            }
        }

        return;
    label_33:
        if(!arg4) {
            this.mParcelable = this.mObj1;
            return;
        }

        throw new IllegalArgumentException("Can\'t serialize Icon created with IconCompat#createFromIcon");
    label_21:
        Object v0 = this.mObj1;
        if(arg4) {
            ByteArrayOutputStream v4 = new ByteArrayOutputStream();
            ((Bitmap)v0).compress(Bitmap$CompressFormat.PNG, 90, ((OutputStream)v4));
            this.mData = v4.toByteArray();
            return;
        }

        this.mParcelable = ((Parcelable)v0);
        return;
    label_7:
        this.mData = this.mObj1.toString().getBytes(Charset.forName(v1));
        return;
    label_13:
        this.mData = this.mObj1;
        return;
    label_16:
        this.mData = this.mObj1.getBytes(Charset.forName(v1));
    }

    public IconCompat setTint(int arg1) {
        return this.setTintList(ColorStateList.valueOf(arg1));
    }

    public IconCompat setTintList(ColorStateList arg1) {
        this.mTintList = arg1;
        return this;
    }

    public IconCompat setTintMode(PorterDuff$Mode arg1) {
        this.mTintMode = arg1;
        return this;
    }

    public Bundle toBundle() {
        Bundle v0 = new Bundle();
        String v2 = "obj";
        switch(this.mType) {
            case -1: {
                goto label_18;
            }
            case 3: {
                goto label_9;
            }
            case 1: 
            case 5: {
                goto label_15;
            }
            case 2: 
            case 4: 
            case 6: {
                goto label_12;
            }
        }

        throw new IllegalArgumentException("Invalid icon");
    label_18:
        v0.putParcelable(v2, this.mObj1);
        goto label_20;
    label_9:
        v0.putByteArray(v2, this.mObj1);
        goto label_20;
    label_12:
        v0.putString(v2, this.mObj1);
        goto label_20;
    label_15:
        v0.putParcelable(v2, this.mObj1);
    label_20:
        v0.putInt("type", this.mType);
        v0.putInt("int1", this.mInt1);
        v0.putInt("int2", this.mInt2);
        v0.putString("string1", this.mString1);
        ColorStateList v1 = this.mTintList;
        if(v1 != null) {
            v0.putParcelable("tint_list", ((Parcelable)v1));
        }

        PorterDuff$Mode v3 = this.mTintMode;
        if(v3 != IconCompat.DEFAULT_TINT_MODE) {
            v0.putString("tint_mode", v3.name());
        }

        return v0;
    }

    public Icon toIcon(Context arg1) {
        return Api23Impl.toIcon(this, arg1);
    }

    @Deprecated public Icon toIcon() {
        return this.toIcon(null);
    }

    public String toString() {
        if(this.mType == -1) {
            return String.valueOf(this.mObj1);
        }

        StringBuilder v0 = new StringBuilder("Icon(typ=").append(IconCompat.typeToString(this.mType));
        switch(this.mType) {
            case 2: {
                v0.append(" pkg=").append(this.mString1).append(" id=").append(String.format("0x%08x", Integer.valueOf(this.getResId())));
                break;
            }
            case 3: {
                v0.append(" len=").append(this.mInt1);
                if(this.mInt2 == 0) {
                    goto label_54;
                }

                v0.append(" off=").append(this.mInt2);
                break;
            }
            case 1: 
            case 5: {
                v0.append(" size=").append(this.mObj1.getWidth()).append("x").append(this.mObj1.getHeight());
                break;
            }
            case 4: 
            case 6: {
                v0.append(" uri=").append(this.mObj1);
                break;
            }
            default: {
                break;
            }
        }

    label_54:
        if(this.mTintList != null) {
            v0.append(" tint=");
            v0.append(this.mTintList);
        }

        if(this.mTintMode != IconCompat.DEFAULT_TINT_MODE) {
            v0.append(" mode=").append(this.mTintMode);
        }

        v0.append(")");
        return v0.toString();
    }

    private static String typeToString(int arg0) {
        switch(arg0) {
            case 1: {
                return "BITMAP";
            }
            case 2: {
                return "RESOURCE";
            }
            case 3: {
                return "DATA";
            }
            case 4: {
                return "URI";
            }
            case 5: {
                return "BITMAP_MASKABLE";
            }
            case 6: {
                return "URI_MASKABLE";
            }
        }

        return "UNKNOWN";
    }
}

