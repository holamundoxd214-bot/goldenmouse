package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private RoundedBitmapDrawableFactory() {
        super();
    }

    public static RoundedBitmapDrawable create(Resources arg1, Bitmap arg2) {
        return new RoundedBitmapDrawable21(arg1, arg2);
    }

    public static RoundedBitmapDrawable create(Resources arg2, InputStream arg3) {
        RoundedBitmapDrawable v2 = RoundedBitmapDrawableFactory.create(arg2, BitmapFactory.decodeStream(arg3));
        if(v2.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFa", "RoundedBitmapDrawable cannot decode " + arg3);
        }

        return v2;
    }

    public static RoundedBitmapDrawable create(Resources arg2, String arg3) {
        RoundedBitmapDrawable v2 = RoundedBitmapDrawableFactory.create(arg2, BitmapFactory.decodeFile(arg3));
        if(v2.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFa", "RoundedBitmapDrawable cannot decode " + arg3);
        }

        return v2;
    }
}

