package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View$OnClickListener {
    final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View arg2) {
            super();
            this.mText1 = arg2.findViewById(0x1020014);
            this.mText2 = arg2.findViewById(0x1020015);
            this.mIcon1 = arg2.findViewById(0x1020007);
            this.mIcon2 = arg2.findViewById(0x1020008);
            this.mIconRefine = arg2.findViewById(id.edit_query);
        }
    }

    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    public SuggestionsAdapter(Context arg4, SearchView arg5, SearchableInfo arg6, WeakHashMap arg7) {
        super(arg4, arg5.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = arg5;
        this.mSearchable = arg6;
        this.mCommitIconResId = arg5.getSuggestionCommitIconResId();
        this.mProviderContext = arg4;
        this.mOutsideDrawablesCache = arg7;
    }

    public void bindView(View arg7, Context arg8, Cursor arg9) {
        CharSequence v0_1;
        Object v7 = arg7.getTag();
        int v8 = this.mFlagsCol;
        v8 = v8 != -1 ? arg9.getInt(v8) : 0;
        if(((ChildViewCache)v7).mText1 != null) {
            this.setViewText(((ChildViewCache)v7).mText1, SuggestionsAdapter.getStringOrNull(arg9, this.mText1Col));
        }

        int v2 = 2;
        if(((ChildViewCache)v7).mText2 != null) {
            String v0 = SuggestionsAdapter.getStringOrNull(arg9, this.mText2UrlCol);
            if(v0 != null) {
                v0_1 = this.formatUrl(((CharSequence)v0));
            }
            else {
                v0 = SuggestionsAdapter.getStringOrNull(arg9, this.mText2Col);
            }

            if(TextUtils.isEmpty(v0_1)) {
                if(((ChildViewCache)v7).mText1 != null) {
                    ((ChildViewCache)v7).mText1.setSingleLine(false);
                    ((ChildViewCache)v7).mText1.setMaxLines(v2);
                }
            }
            else if(((ChildViewCache)v7).mText1 != null) {
                ((ChildViewCache)v7).mText1.setSingleLine(true);
                ((ChildViewCache)v7).mText1.setMaxLines(1);
            }

            this.setViewText(((ChildViewCache)v7).mText2, v0_1);
        }

        if(((ChildViewCache)v7).mIcon1 != null) {
            this.setViewDrawable(((ChildViewCache)v7).mIcon1, this.getIcon1(arg9), 4);
        }

        int v4 = 8;
        if(((ChildViewCache)v7).mIcon2 != null) {
            this.setViewDrawable(((ChildViewCache)v7).mIcon2, this.getIcon2(arg9), v4);
        }

        int v9 = this.mQueryRefinement;
        if(v9 != v2 && (v9 != 1 || (v8 & 1) == 0)) {
            ((ChildViewCache)v7).mIconRefine.setVisibility(v4);
            return;
        }

        ((ChildViewCache)v7).mIconRefine.setVisibility(0);
        ((ChildViewCache)v7).mIconRefine.setTag(((ChildViewCache)v7).mText1.getText());
        ((ChildViewCache)v7).mIconRefine.setOnClickListener(((View$OnClickListener)this));
    }

    public void changeCursor(Cursor arg3) {
        String v1 = "SuggestionsAdapter";
        if(this.mClosed) {
            Log.w(v1, "Tried to change cursor after adapter was closed.");
            if(arg3 != null) {
                arg3.close();
                return;
            }
        }
        else {
            try {
                super.changeCursor(arg3);
                if(arg3 != null) {
                    this.mText1Col = arg3.getColumnIndex("suggest_text_1");
                    this.mText2Col = arg3.getColumnIndex("suggest_text_2");
                    this.mText2UrlCol = arg3.getColumnIndex("suggest_text_2_url");
                    this.mIconName1Col = arg3.getColumnIndex("suggest_icon_1");
                    this.mIconName2Col = arg3.getColumnIndex("suggest_icon_2");
                    this.mFlagsCol = arg3.getColumnIndex("suggest_flags");
                }
            }
            catch(Exception v2) {
                Log.e(v1, "error changing cursor and caching columns", ((Throwable)v2));
                return;
            }
        }
    }

    private Drawable checkIconCache(String arg1) {
        Object v0 = this.mOutsideDrawablesCache.get(arg1);
        if(v0 == null) {
            return null;
        }

        return ((Drawable$ConstantState)v0).newDrawable();
    }

    public void close() {
        this.changeCursor(null);
        this.mClosed = true;
    }

    public CharSequence convertToString(Cursor arg3) {
        CharSequence v0 = null;
        if(arg3 == null) {
            return v0;
        }

        String v1 = SuggestionsAdapter.getColumnString(arg3, "suggest_intent_query");
        if(v1 != null) {
            return ((CharSequence)v1);
        }

        if(this.mSearchable.shouldRewriteQueryFromData()) {
            v1 = SuggestionsAdapter.getColumnString(arg3, "suggest_intent_data");
            if(v1 != null) {
                return ((CharSequence)v1);
            }
        }

        if(this.mSearchable.shouldRewriteQueryFromText()) {
            String v2 = SuggestionsAdapter.getColumnString(arg3, "suggest_text_1");
            if(v2 != null) {
                return ((CharSequence)v2);
            }
        }

        return v0;
    }

    private CharSequence formatUrl(CharSequence arg8) {
        if(this.mUrlColor == null) {
            TypedValue v0 = new TypedValue();
            this.mProviderContext.getTheme().resolveAttribute(attr.textColorSearchUrl, v0, true);
            this.mUrlColor = this.mProviderContext.getResources().getColorStateList(v0.resourceId);
        }

        SpannableString v0_1 = new SpannableString(arg8);
        v0_1.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, arg8.length(), 33);
        return ((CharSequence)v0_1);
    }

    private Drawable getActivityIcon(ComponentName arg6) {
        ActivityInfo v1_1;
        String v0 = "SuggestionsAdapter";
        PackageManager v5 = this.mProviderContext.getPackageManager();
        int v1 = 0x80;
        Drawable v2 = null;
        try {
            v1_1 = v5.getActivityInfo(arg6, v1);
        }
        catch(PackageManager$NameNotFoundException v5_1) {
            Log.w(v0, v5_1.toString());
            return v2;
        }

        int v3 = v1_1.getIconResource();
        if(v3 == 0) {
            return v2;
        }

        Drawable v5_2 = v5.getDrawable(arg6.getPackageName(), v3, v1_1.applicationInfo);
        if(v5_2 == null) {
            Log.w(v0, "Invalid icon resource " + v3 + " for " + arg6.flattenToShortString());
            return v2;
        }

        return v5_2;
    }

    private Drawable getActivityIconWithCache(ComponentName arg4) {
        String v0 = arg4.flattenToShortString();
        Drawable v2 = null;
        if(this.mOutsideDrawablesCache.containsKey(v0)) {
            Object v4 = this.mOutsideDrawablesCache.get(v0);
            if(v4 == null) {
                return v2;
            }

            return ((Drawable$ConstantState)v4).newDrawable(this.mProviderContext.getResources());
        }

        Drawable v4_1 = this.getActivityIcon(arg4);
        if(v4_1 == null) {
        }
        else {
            Drawable$ConstantState v2_1 = v4_1.getConstantState();
        }

        this.mOutsideDrawablesCache.put(v0, v2);
        return v4_1;
    }

    public static String getColumnString(Cursor arg0, String arg1) {
        return SuggestionsAdapter.getStringOrNull(arg0, arg0.getColumnIndex(arg1));
    }

    private Drawable getDefaultIcon1() {
        Drawable v0 = this.getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if(v0 != null) {
            return v0;
        }

        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri arg8) {
        Drawable v2_2;
        InputStream v7_1;
        String v0 = "SuggestionsAdapter";
        String v1 = "Error closing icon stream for ";
        String v2 = "Failed to open ";
        String v3 = "Resource does not exist: ";
        String v4 = null;
        try {
            if("android.resource".equals(arg8.getScheme())) {
                try {
                    return this.getDrawableFromResourceUri(arg8);
                }
                catch(Resources$NotFoundException ) {
                    throw new FileNotFoundException(v3 + arg8);
                }
            }

            v7_1 = this.mProviderContext.getContentResolver().openInputStream(arg8);
            if(v7_1 == null) {
                goto label_42;
            }
        }
        catch(FileNotFoundException v7) {
            goto label_59;
        }

        try {
            v2_2 = Drawable.createFromStream(v7_1, v4);
            goto label_23;
        }
        catch(Throwable v2_1) {
            try {
                v7_1.close();
                goto label_41;
            }
            catch(FileNotFoundException v7) {
            }
            catch(IOException v7_2) {
                try {
                    Log.e(v0, v1 + arg8, ((Throwable)v7_2));
                label_41:
                    throw v2_1;
                }
                catch(FileNotFoundException v7) {
                    goto label_59;
                }

                try {
                label_23:
                    v7_1.close();
                    return v2_2;
                }
                catch(FileNotFoundException v7) {
                }
                catch(IOException v7_2) {
                    try {
                        Log.e(v0, v1 + arg8, ((Throwable)v7_2));
                        return v2_2;
                    label_42:
                        throw new FileNotFoundException(v2 + arg8);
                    }
                    catch(FileNotFoundException v7) {
                    label_59:
                        Log.w(v0, "Icon not found: " + arg8 + ", " + v7.getMessage());
                        return ((Drawable)v4);
                    }
                }
            }
        }
    }

    Drawable getDrawableFromResourceUri(Uri arg7) throws FileNotFoundException {
        int v0_1;
        Resources v6;
        String v0 = arg7.getAuthority();
        if(TextUtils.isEmpty(((CharSequence)v0))) {
            goto label_63;
        }

        try {
            v6 = this.mProviderContext.getPackageManager().getResourcesForApplication(v0);
        }
        catch(PackageManager$NameNotFoundException ) {
            throw new FileNotFoundException("No package found for authority: " + arg7);
        }

        List v1 = arg7.getPathSegments();
        if(v1 == null) {
            goto label_47;
        }

        int v2 = v1.size();
        if(v2 == 1) {
            try {
                v0_1 = Integer.parseInt(v1.get(0));
            }
            catch(NumberFormatException ) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + arg7);
            }
        }
        else if(v2 == 2) {
            v0_1 = v6.getIdentifier(v1.get(1), v1.get(0), v0);
        }
        else {
            goto label_39;
        }

        if(v0_1 != 0) {
            return v6.getDrawable(v0_1);
        }

        throw new FileNotFoundException("No resource found for: " + arg7);
    label_39:
        throw new FileNotFoundException("More than two path segments: " + arg7);
    label_47:
        throw new FileNotFoundException("No path: " + arg7);
    label_63:
        throw new FileNotFoundException("No authority: " + arg7);
    }

    private Drawable getDrawableFromResourceValue(String arg5) {
        String v0 = "android.resource://";
        Drawable v1 = null;
        if(arg5 != null && !arg5.isEmpty()) {
            if("0".equals(arg5)) {
            }
            else {
                try {
                    int v2 = Integer.parseInt(arg5);
                    v0 = v0 + this.mProviderContext.getPackageName() + "/" + v2;
                    Drawable v3 = this.checkIconCache(v0);
                    if(v3 != null) {
                        return v3;
                    }
                    else {
                        Drawable v2_1 = ContextCompat.getDrawable(this.mProviderContext, v2);
                        this.storeInIconCache(v0, v2_1);
                        return v2_1;
                    }
                }
                catch(Resources$NotFoundException ) {
                    Log.w("SuggestionsAdapter", "Icon resource not found: " + arg5);
                    return v1;
                }
                catch(NumberFormatException ) {
                    Drawable v0_1 = this.checkIconCache(arg5);
                    if(v0_1 != null) {
                        return v0_1;
                    }
                    else {
                        v0_1 = this.getDrawable(Uri.parse(arg5));
                        this.storeInIconCache(arg5, v0_1);
                        return v0_1;
                    }
                }
            }
        }

        return v1;
    }

    public View getDropDownView(int arg2, View arg3, ViewGroup arg4) {
        View v1;
        try {
            v1 = super.getDropDownView(arg2, arg3, arg4);
            return v1;
        }
        catch(RuntimeException v2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", ((Throwable)v2));
            v1 = ((SuggestionsAdapter)v1).newDropDownView(((SuggestionsAdapter)v1).mProviderContext, ((SuggestionsAdapter)v1).getCursor(), arg4);
            if(v1 != null) {
                v1.getTag().mText1.setText(v2.toString());
            }

            return v1;
        }
    }

    private Drawable getIcon1(Cursor arg3) {
        int v0 = this.mIconName1Col;
        if(v0 == -1) {
            return null;
        }

        Drawable v3 = this.getDrawableFromResourceValue(arg3.getString(v0));
        if(v3 != null) {
            return v3;
        }

        return this.getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor arg3) {
        int v0 = this.mIconName2Col;
        if(v0 == -1) {
            return null;
        }

        return this.getDrawableFromResourceValue(arg3.getString(v0));
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    Cursor getSearchManagerSuggestions(SearchableInfo arg10, String arg11, int arg12) {
        String[] v0_1;
        Cursor v0 = null;
        if(arg10 == null) {
            return v0;
        }

        String v1 = arg10.getSuggestAuthority();
        if(v1 == null) {
            return v0;
        }

        Uri$Builder v1_1 = new Uri$Builder().scheme("content").authority(v1).query("").fragment("");
        String v2 = arg10.getSuggestPath();
        if(v2 != null) {
            v1_1.appendEncodedPath(v2);
        }

        v1_1.appendPath("search_suggest_query");
        String v6 = arg10.getSuggestSelection();
        if(v6 != null) {
            v0_1 = new String[]{arg11};
        }
        else {
            v1_1.appendPath(arg11);
        }

        String[] v7 = v0_1;
        if(arg12 > 0) {
            v1_1.appendQueryParameter("limit", String.valueOf(arg12));
        }

        return this.mProviderContext.getContentResolver().query(v1_1.build(), null, v6, v7, null);
    }

    private static String getStringOrNull(Cursor arg2, int arg3) {
        String v1 = null;
        if(arg3 == -1) {
            return v1;
        }

        try {
            return arg2.getString(arg3);
        }
        catch(Exception v2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", ((Throwable)v2));
            return v1;
        }
    }

    public View getView(int arg2, View arg3, ViewGroup arg4) {
        View v1;
        try {
            v1 = super.getView(arg2, arg3, arg4);
            return v1;
        }
        catch(RuntimeException v2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", ((Throwable)v2));
            v1 = ((SuggestionsAdapter)v1).newView(((SuggestionsAdapter)v1).mProviderContext, ((SuggestionsAdapter)v1).getCursor(), arg4);
            if(v1 != null) {
                v1.getTag().mText1.setText(v2.toString());
            }

            return v1;
        }
    }

    public boolean hasStableIds() {
        return 0;
    }

    public View newView(Context arg1, Cursor arg2, ViewGroup arg3) {
        View v1 = super.newView(arg1, arg2, arg3);
        v1.setTag(new ChildViewCache(v1));
        v1.findViewById(id.edit_query).setImageResource(this.mCommitIconResId);
        return v1;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.updateSpinnerState(this.getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.updateSpinnerState(this.getCursor());
    }

    public void onClick(View arg2) {
        Object v2 = arg2.getTag();
        if((v2 instanceof CharSequence)) {
            this.mSearchView.onQueryRefine(((CharSequence)v2));
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence arg4) {
        String v4 = arg4 == null ? "" : arg4.toString();
        Cursor v1 = null;
        if(this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
            try {
                Cursor v3_1 = this.getSearchManagerSuggestions(this.mSearchable, v4, 50);
                if(v3_1 == null) {
                    return v1;
                }

                v3_1.getCount();
                return v3_1;
            }
            catch(RuntimeException v3) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", ((Throwable)v3));
            }
        }

        return v1;
    }

    public void setQueryRefinement(int arg1) {
        this.mQueryRefinement = arg1;
    }

    private void setViewDrawable(ImageView arg1, Drawable arg2, int arg3) {
        arg1.setImageDrawable(arg2);
        if(arg2 == null) {
            arg1.setVisibility(arg3);
            return;
        }

        arg1.setVisibility(0);
        arg2.setVisible(false, false);
        arg2.setVisible(true, false);
    }

    private void setViewText(TextView arg1, CharSequence arg2) {
        arg1.setText(arg2);
        if(TextUtils.isEmpty(arg2)) {
            arg1.setVisibility(8);
            return;
        }

        arg1.setVisibility(0);
    }

    private void storeInIconCache(String arg1, Drawable arg2) {
        if(arg2 != null) {
            this.mOutsideDrawablesCache.put(arg1, arg2.getConstantState());
        }
    }

    private void updateSpinnerState(Cursor arg1) {
        Bundle v0 = arg1 != null ? arg1.getExtras() : null;
        if(v0 != null) {
            v0.getBoolean("in_progress");
        }
    }
}

