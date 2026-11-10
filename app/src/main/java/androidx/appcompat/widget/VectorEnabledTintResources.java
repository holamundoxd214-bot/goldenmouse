package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

public class VectorEnabledTintResources extends ResourcesWrapper {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private final WeakReference mContextRef;
    private static boolean sCompatVectorFromResourcesEnabled = false;

    static {
    }

    public VectorEnabledTintResources(Context arg1, Resources arg2) {
        super(arg2);
        this.mContextRef = new WeakReference(arg1);
    }

    public XmlResourceParser getAnimation(int arg1) throws Resources$NotFoundException {
        return super.getAnimation(arg1);
    }

    public boolean getBoolean(int arg1) throws Resources$NotFoundException {
        return super.getBoolean(arg1);
    }

    public int getColor(int arg1) throws Resources$NotFoundException {
        return super.getColor(arg1);
    }

    public ColorStateList getColorStateList(int arg1) throws Resources$NotFoundException {
        return super.getColorStateList(arg1);
    }

    public Configuration getConfiguration() {
        return super.getConfiguration();
    }

    public float getDimension(int arg1) throws Resources$NotFoundException {
        return super.getDimension(arg1);
    }

    public int getDimensionPixelOffset(int arg1) throws Resources$NotFoundException {
        return super.getDimensionPixelOffset(arg1);
    }

    public int getDimensionPixelSize(int arg1) throws Resources$NotFoundException {
        return super.getDimensionPixelSize(arg1);
    }

    public DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    public Drawable getDrawable(int arg3) throws Resources$NotFoundException {
        Object v0 = this.mContextRef.get();
        if(v0 != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(((Context)v0), this, arg3);
        }

        return this.getDrawableCanonical(arg3);
    }

    public Drawable getDrawable(int arg1, Resources$Theme arg2) throws Resources$NotFoundException {
        return super.getDrawable(arg1, arg2);
    }

    public Drawable getDrawableForDensity(int arg1, int arg2) throws Resources$NotFoundException {
        return super.getDrawableForDensity(arg1, arg2);
    }

    public Drawable getDrawableForDensity(int arg1, int arg2, Resources$Theme arg3) {
        return super.getDrawableForDensity(arg1, arg2, arg3);
    }

    public float getFraction(int arg1, int arg2, int arg3) {
        return super.getFraction(arg1, arg2, arg3);
    }

    public int getIdentifier(String arg1, String arg2, String arg3) {
        return super.getIdentifier(arg1, arg2, arg3);
    }

    public int[] getIntArray(int arg1) throws Resources$NotFoundException {
        return super.getIntArray(arg1);
    }

    public int getInteger(int arg1) throws Resources$NotFoundException {
        return super.getInteger(arg1);
    }

    public XmlResourceParser getLayout(int arg1) throws Resources$NotFoundException {
        return super.getLayout(arg1);
    }

    public Movie getMovie(int arg1) throws Resources$NotFoundException {
        return super.getMovie(arg1);
    }

    public String getQuantityString(int arg1, int arg2) throws Resources$NotFoundException {
        return super.getQuantityString(arg1, arg2);
    }

    public String getQuantityString(int arg1, int arg2, Object[] arg3) throws Resources$NotFoundException {
        return super.getQuantityString(arg1, arg2, arg3);
    }

    public CharSequence getQuantityText(int arg1, int arg2) throws Resources$NotFoundException {
        return super.getQuantityText(arg1, arg2);
    }

    public String getResourceEntryName(int arg1) throws Resources$NotFoundException {
        return super.getResourceEntryName(arg1);
    }

    public String getResourceName(int arg1) throws Resources$NotFoundException {
        return super.getResourceName(arg1);
    }

    public String getResourcePackageName(int arg1) throws Resources$NotFoundException {
        return super.getResourcePackageName(arg1);
    }

    public String getResourceTypeName(int arg1) throws Resources$NotFoundException {
        return super.getResourceTypeName(arg1);
    }

    public String getString(int arg1) throws Resources$NotFoundException {
        return super.getString(arg1);
    }

    public String getString(int arg1, Object[] arg2) throws Resources$NotFoundException {
        return super.getString(arg1, arg2);
    }

    public String[] getStringArray(int arg1) throws Resources$NotFoundException {
        return super.getStringArray(arg1);
    }

    public CharSequence getText(int arg1) throws Resources$NotFoundException {
        return super.getText(arg1);
    }

    public CharSequence getText(int arg1, CharSequence arg2) {
        return super.getText(arg1, arg2);
    }

    public CharSequence[] getTextArray(int arg1) throws Resources$NotFoundException {
        return super.getTextArray(arg1);
    }

    public void getValue(int arg1, TypedValue arg2, boolean arg3) throws Resources$NotFoundException {
        super.getValue(arg1, arg2, arg3);
    }

    public void getValue(String arg1, TypedValue arg2, boolean arg3) throws Resources$NotFoundException {
        super.getValue(arg1, arg2, arg3);
    }

    public void getValueForDensity(int arg1, int arg2, TypedValue arg3, boolean arg4) throws Resources$NotFoundException {
        super.getValueForDensity(arg1, arg2, arg3, arg4);
    }

    public XmlResourceParser getXml(int arg1) throws Resources$NotFoundException {
        return super.getXml(arg1);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.sCompatVectorFromResourcesEnabled;
    }

    public TypedArray obtainAttributes(AttributeSet arg1, int[] arg2) {
        return super.obtainAttributes(arg1, arg2);
    }

    public TypedArray obtainTypedArray(int arg1) throws Resources$NotFoundException {
        return super.obtainTypedArray(arg1);
    }

    public InputStream openRawResource(int arg1) throws Resources$NotFoundException {
        return super.openRawResource(arg1);
    }

    public InputStream openRawResource(int arg1, TypedValue arg2) throws Resources$NotFoundException {
        return super.openRawResource(arg1, arg2);
    }

    public AssetFileDescriptor openRawResourceFd(int arg1) throws Resources$NotFoundException {
        return super.openRawResourceFd(arg1);
    }

    public void parseBundleExtra(String arg1, AttributeSet arg2, Bundle arg3) throws XmlPullParserException {
        super.parseBundleExtra(arg1, arg2, arg3);
    }

    public void parseBundleExtras(XmlResourceParser arg1, Bundle arg2) throws XmlPullParserException, IOException {
        super.parseBundleExtras(arg1, arg2);
    }

    public static void setCompatVectorFromResourcesEnabled(boolean arg0) {
        VectorEnabledTintResources.sCompatVectorFromResourcesEnabled = arg0;
    }

    public static boolean shouldBeUsed() {
        VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
        return 0;
    }

    public void updateConfiguration(Configuration arg1, DisplayMetrics arg2) {
        super.updateConfiguration(arg1, arg2);
    }
}

