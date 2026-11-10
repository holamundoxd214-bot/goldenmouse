package androidx.appcompat.widget;

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
import androidx.appcompat.resources.Compatibility$Api15Impl;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources arg4) {
        super(arg4.getAssets(), arg4.getDisplayMetrics(), arg4.getConfiguration());
        this.mResources = arg4;
    }

    public XmlResourceParser getAnimation(int arg1) throws Resources$NotFoundException {
        return this.mResources.getAnimation(arg1);
    }

    public boolean getBoolean(int arg1) throws Resources$NotFoundException {
        return this.mResources.getBoolean(arg1);
    }

    public int getColor(int arg1) throws Resources$NotFoundException {
        return this.mResources.getColor(arg1);
    }

    public ColorStateList getColorStateList(int arg1) throws Resources$NotFoundException {
        return this.mResources.getColorStateList(arg1);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int arg1) throws Resources$NotFoundException {
        return this.mResources.getDimension(arg1);
    }

    public int getDimensionPixelOffset(int arg1) throws Resources$NotFoundException {
        return this.mResources.getDimensionPixelOffset(arg1);
    }

    public int getDimensionPixelSize(int arg1) throws Resources$NotFoundException {
        return this.mResources.getDimensionPixelSize(arg1);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int arg1) throws Resources$NotFoundException {
        return this.mResources.getDrawable(arg1);
    }

    public Drawable getDrawable(int arg1, Resources$Theme arg2) throws Resources$NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, arg1, arg2);
    }

    final Drawable getDrawableCanonical(int arg1) throws Resources$NotFoundException {
        return super.getDrawable(arg1);
    }

    public Drawable getDrawableForDensity(int arg2, int arg3) throws Resources$NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, arg2, arg3, null);
    }

    public Drawable getDrawableForDensity(int arg1, int arg2, Resources$Theme arg3) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, arg1, arg2, arg3);
    }

    public float getFraction(int arg1, int arg2, int arg3) {
        return this.mResources.getFraction(arg1, arg2, arg3);
    }

    public int getIdentifier(String arg1, String arg2, String arg3) {
        return this.mResources.getIdentifier(arg1, arg2, arg3);
    }

    public int[] getIntArray(int arg1) throws Resources$NotFoundException {
        return this.mResources.getIntArray(arg1);
    }

    public int getInteger(int arg1) throws Resources$NotFoundException {
        return this.mResources.getInteger(arg1);
    }

    public XmlResourceParser getLayout(int arg1) throws Resources$NotFoundException {
        return this.mResources.getLayout(arg1);
    }

    public Movie getMovie(int arg1) throws Resources$NotFoundException {
        return this.mResources.getMovie(arg1);
    }

    public String getQuantityString(int arg1, int arg2) throws Resources$NotFoundException {
        return this.mResources.getQuantityString(arg1, arg2);
    }

    public String getQuantityString(int arg1, int arg2, Object[] arg3) throws Resources$NotFoundException {
        return this.mResources.getQuantityString(arg1, arg2, arg3);
    }

    public CharSequence getQuantityText(int arg1, int arg2) throws Resources$NotFoundException {
        return this.mResources.getQuantityText(arg1, arg2);
    }

    public String getResourceEntryName(int arg1) throws Resources$NotFoundException {
        return this.mResources.getResourceEntryName(arg1);
    }

    public String getResourceName(int arg1) throws Resources$NotFoundException {
        return this.mResources.getResourceName(arg1);
    }

    public String getResourcePackageName(int arg1) throws Resources$NotFoundException {
        return this.mResources.getResourcePackageName(arg1);
    }

    public String getResourceTypeName(int arg1) throws Resources$NotFoundException {
        return this.mResources.getResourceTypeName(arg1);
    }

    public String getString(int arg1) throws Resources$NotFoundException {
        return this.mResources.getString(arg1);
    }

    public String getString(int arg1, Object[] arg2) throws Resources$NotFoundException {
        return this.mResources.getString(arg1, arg2);
    }

    public String[] getStringArray(int arg1) throws Resources$NotFoundException {
        return this.mResources.getStringArray(arg1);
    }

    public CharSequence getText(int arg1) throws Resources$NotFoundException {
        return this.mResources.getText(arg1);
    }

    public CharSequence getText(int arg1, CharSequence arg2) {
        return this.mResources.getText(arg1, arg2);
    }

    public CharSequence[] getTextArray(int arg1) throws Resources$NotFoundException {
        return this.mResources.getTextArray(arg1);
    }

    public void getValue(int arg1, TypedValue arg2, boolean arg3) throws Resources$NotFoundException {
        this.mResources.getValue(arg1, arg2, arg3);
    }

    public void getValue(String arg1, TypedValue arg2, boolean arg3) throws Resources$NotFoundException {
        this.mResources.getValue(arg1, arg2, arg3);
    }

    public void getValueForDensity(int arg1, int arg2, TypedValue arg3, boolean arg4) throws Resources$NotFoundException {
        Api15Impl.getValueForDensity(this.mResources, arg1, arg2, arg3, arg4);
    }

    public XmlResourceParser getXml(int arg1) throws Resources$NotFoundException {
        return this.mResources.getXml(arg1);
    }

    public TypedArray obtainAttributes(AttributeSet arg1, int[] arg2) {
        return this.mResources.obtainAttributes(arg1, arg2);
    }

    public TypedArray obtainTypedArray(int arg1) throws Resources$NotFoundException {
        return this.mResources.obtainTypedArray(arg1);
    }

    public InputStream openRawResource(int arg1) throws Resources$NotFoundException {
        return this.mResources.openRawResource(arg1);
    }

    public InputStream openRawResource(int arg1, TypedValue arg2) throws Resources$NotFoundException {
        return this.mResources.openRawResource(arg1, arg2);
    }

    public AssetFileDescriptor openRawResourceFd(int arg1) throws Resources$NotFoundException {
        return this.mResources.openRawResourceFd(arg1);
    }

    public void parseBundleExtra(String arg1, AttributeSet arg2, Bundle arg3) throws XmlPullParserException {
        this.mResources.parseBundleExtra(arg1, arg2, arg3);
    }

    public void parseBundleExtras(XmlResourceParser arg1, Bundle arg2) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(arg1, arg2);
    }

    public void updateConfiguration(Configuration arg1, DisplayMetrics arg2) {
        super.updateConfiguration(arg1, arg2);
        Resources v0 = this.mResources;
        if(v0 != null) {
            v0.updateConfiguration(arg1, arg2);
        }
    }
}

