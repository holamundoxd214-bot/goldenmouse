package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff$Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
    class InflatedOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener {
        private static final Class[] PARAM_TYPES;
        private Method mMethod;
        private Object mRealOwner;

        static {
            InflatedOnMenuItemClickListener.PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object arg4, String arg5) {
            super();
            this.mRealOwner = arg4;
            Class v4 = arg4.getClass();
            try {
                this.mMethod = v4.getMethod(arg5, InflatedOnMenuItemClickListener.PARAM_TYPES);
                return;
            }
            catch(Exception v3) {
                InflateException v0 = new InflateException("Couldn\'t resolve menu item onClick handler " + arg5 + " in class " + v4.getName());
                v0.initCause(((Throwable)v3));
                throw v0;
            }
        }

        public boolean onMenuItemClick(MenuItem arg4) {
            try {
                Class v0 = this.mMethod.getReturnType();
                Class v1 = Boolean.TYPE;
            }
            catch(Exception v3) {
                goto label_18;
            }

            Method v2 = this.mMethod;
            if(v0 != v1) {
                goto label_10;
            }

            try {
                return v2.invoke(this.mRealOwner, arg4).booleanValue();
            label_10:
                v2.invoke(this.mRealOwner, arg4);
                return 1;
            }
            catch(Exception v3) {
            label_18:
                throw new RuntimeException(((Throwable)v3));
            }
        }
    }

    class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList;
        private PorterDuff$Mode itemIconTintMode;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(SupportMenuInflater arg1, Menu arg2) {
            SupportMenuInflater.this = arg1;
            super();
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = arg2;
            this.resetGroup();
        }

        public void addItem() {
            this.itemAdded = true;
            this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu v0 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            this.setItem(v0.getItem());
            return v0;
        }

        private char getShortcut(String arg1) {
            if(arg1 == null) {
                return 0;
            }

            return arg1.charAt(0);
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        private Object newInstance(String arg2, Class[] arg3, Object[] arg4) {
            try {
                Constructor v1_1 = Class.forName(arg2, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(arg3);
                v1_1.setAccessible(true);
                return v1_1.newInstance(arg4);
            }
            catch(Exception v1) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + arg2, ((Throwable)v1));
                return null;
            }
        }

        public void readGroup(AttributeSet arg3) {
            TypedArray v3 = SupportMenuInflater.this.mContext.obtainStyledAttributes(arg3, styleable.MenuGroup);
            this.groupId = v3.getResourceId(styleable.MenuGroup_android_id, 0);
            this.groupCategory = v3.getInt(styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = v3.getInt(styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = v3.getInt(styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = v3.getBoolean(styleable.MenuGroup_android_visible, true);
            this.groupEnabled = v3.getBoolean(styleable.MenuGroup_android_enabled, true);
            v3.recycle();
        }

        public void readItem(AttributeSet arg7) {
            TintTypedArray v7 = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.mContext, arg7, styleable.MenuItem);
            this.itemId = v7.getResourceId(styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = v7.getInt(styleable.MenuItem_android_menuCategory, this.groupCategory) & 0xFFFF0000 | v7.getInt(styleable.MenuItem_android_orderInCategory, this.groupOrder) & 0xFFFF;
            this.itemTitle = v7.getText(styleable.MenuItem_android_title);
            this.itemTitleCondensed = v7.getText(styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = v7.getResourceId(styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = this.getShortcut(v7.getString(styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = v7.getInt(styleable.MenuItem_alphabeticModifiers, 0x1000);
            this.itemNumericShortcut = this.getShortcut(v7.getString(styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = v7.getInt(styleable.MenuItem_numericModifiers, 0x1000);
            this.itemCheckable = v7.hasValue(styleable.MenuItem_android_checkable) ? v7.getBoolean(styleable.MenuItem_android_checkable, false) : this.groupCheckable;
            this.itemChecked = v7.getBoolean(styleable.MenuItem_android_checked, false);
            this.itemVisible = v7.getBoolean(styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = v7.getBoolean(styleable.MenuItem_android_enabled, this.groupEnabled);
            int v2 = -1;
            this.itemShowAsAction = v7.getInt(styleable.MenuItem_showAsAction, v2);
            this.itemListenerMethodName = v7.getString(styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = v7.getResourceId(styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = v7.getString(styleable.MenuItem_actionViewClass);
            String v0 = v7.getString(styleable.MenuItem_actionProviderClass);
            this.itemActionProviderClassName = v0;
            int v3 = v0 != null ? 1 : 0;
            ActionProvider v4 = null;
            if(v3 == 0 || this.itemActionViewLayout != 0 || this.itemActionViewClassName != null) {
                if(v3 != 0) {
                    Log.w("SupportMenuInflater", "Ignoring attribute \'actionProviderClass\'. Action view already specified.");
                }

                this.itemActionProvider = v4;
            }
            else {
                this.itemActionProvider = this.newInstance(v0, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
            }

            this.itemContentDescription = v7.getText(styleable.MenuItem_contentDescription);
            this.itemTooltipText = v7.getText(styleable.MenuItem_tooltipText);
            this.itemIconTintMode = v7.hasValue(styleable.MenuItem_iconTintMode) ? DrawableUtils.parseTintMode(v7.getInt(styleable.MenuItem_iconTintMode, v2), this.itemIconTintMode) : ((PorterDuff$Mode)v4);
            this.itemIconTintList = v7.hasValue(styleable.MenuItem_iconTint) ? v7.getColorStateList(styleable.MenuItem_iconTint) : ((ColorStateList)v4);
            v7.recycle();
            this.itemAdded = false;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }

        private void setItem(MenuItem arg6) {
            MenuItem v0 = arg6.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            int v2 = 0;
            boolean v1 = this.itemCheckable >= 1 ? true : false;
            v0.setCheckable(v1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int v0_1 = this.itemShowAsAction;
            if(v0_1 >= 0) {
                arg6.setShowAsAction(v0_1);
            }

            if(this.itemListenerMethodName != null) {
                if(!SupportMenuInflater.this.mContext.isRestricted()) {
                    arg6.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
                }
                else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }

            if(this.itemCheckable >= 2) {
                if((arg6 instanceof MenuItemImpl)) {
                    arg6.setExclusiveCheckable(true);
                }
                else if((arg6 instanceof MenuItemWrapperICS)) {
                    arg6.setExclusiveCheckable(true);
                }
            }

            String v0_2 = this.itemActionViewClassName;
            if(v0_2 != null) {
                arg6.setActionView(this.newInstance(v0_2, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
                v2 = 1;
            }

            v0_1 = this.itemActionViewLayout;
            if(v0_1 > 0) {
                if(v2 == 0) {
                    arg6.setActionView(v0_1);
                }
                else {
                    Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
                }
            }

            ActionProvider v0_3 = this.itemActionProvider;
            if(v0_3 != null) {
                MenuItemCompat.setActionProvider(arg6, v0_3);
            }

            MenuItemCompat.setContentDescription(arg6, this.itemContentDescription);
            MenuItemCompat.setTooltipText(arg6, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(arg6, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(arg6, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff$Mode v0_4 = this.itemIconTintMode;
            if(v0_4 != null) {
                MenuItemCompat.setIconTintMode(arg6, v0_4);
            }

            ColorStateList v5 = this.itemIconTintList;
            if(v5 != null) {
                MenuItemCompat.setIconTintList(arg6, v5);
            }
        }
    }

    static final Class[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = null;
    static final Class[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = null;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    static {
        Class[] v0 = new Class[]{Context.class};
        SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE = v0;
        SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = v0;
    }

    public SupportMenuInflater(Context arg1) {
        super(arg1);
        this.mContext = arg1;
        Object[] v1 = new Object[]{arg1};
        this.mActionViewConstructorArguments = v1;
        this.mActionProviderConstructorArguments = v1;
    }

    private Object findRealOwner(Object arg2) {
        if((arg2 instanceof Activity)) {
        }
        else if((arg2 instanceof ContextWrapper)) {
            return this.findRealOwner(((ContextWrapper)arg2).getBaseContext());
        }

        return arg2;
    }

    Object getRealOwner() {
        Object v0 = this.mRealOwner;
        if(v0 == null) {
            v0 = this.findRealOwner(this.mContext);
            this.mRealOwner = v0;
        }

        return v0;
    }

    public void inflate(int arg4, Menu arg5) {
        XmlResourceParser v1;
        String v0 = "Error inflating menu XML";
        if(!(arg5 instanceof SupportMenu)) {
            super.inflate(arg4, arg5);
            return;
        }

        try {
            v1 = this.mContext.getResources().getLayout(arg4);
            this.parseMenu(((XmlPullParser)v1), Xml.asAttributeSet(((XmlPullParser)v1)), arg5);
            if(v1 == null) {
                return;
            }
        }
        catch(Throwable v3) {
        }
        catch(IOException v3_1) {
            try {
                throw new InflateException(v0, ((Throwable)v3_1));
            }
            catch(Throwable v3) {
            label_24:
                if(v1 != null) {
                    v1.close();
                }

                throw v3;
            }
        }
        catch(XmlPullParserException v3_2) {
            try {
                throw new InflateException(v0, ((Throwable)v3_2));
            }
            catch(Throwable v3) {
                goto label_24;
            }
        }

        v1.close();
    }

    private void parseMenu(XmlPullParser arg13, AttributeSet arg14, Menu arg15) throws XmlPullParserException, IOException {
        MenuState v0 = new MenuState(this, arg15);
        int v15 = arg13.getEventType();
        do {
            int v1 = 2;
            String v2 = "menu";
            if(v15 != v1) {
                v15 = arg13.next();
                if(v15 != 1) {
                    continue;
                }
            }
            else {
                break;
            }

            goto label_22;
        }
        while(true);

        String v15_1 = arg13.getName();
        if(v15_1.equals(v2)) {
            v15 = arg13.next();
        }
        else {
            goto label_12;
        }

    label_22:
        Object v5 = null;
        int v6 = 0;
        int v7 = 0;
        Object v8 = v5;
        goto label_27;
    label_12:
        throw new RuntimeException("Expecting menu, got " + v15_1);
        while(true) {
        label_27:
            if(v6 != 0) {
                return;
            }

            if(v15 == 1) {
                break;
            }

            String v9 = "item";
            String v10 = "group";
            if(v15 == v1) {
                if(v7 != 0) {
                    goto label_81;
                }

                v15_1 = arg13.getName();
                if(v15_1.equals(v10)) {
                    v0.readGroup(arg14);
                    goto label_81;
                }

                if(v15_1.equals(v9)) {
                    v0.readItem(arg14);
                    goto label_81;
                }

                if(v15_1.equals(v2)) {
                    this.parseMenu(arg13, arg14, v0.addSubMenuItem());
                    goto label_81;
                }

                String v8_1 = v15_1;
                v7 = 1;
            }
            else if(v15 != 3) {
            }
            else {
                v15_1 = arg13.getName();
                if(v7 != 0 && (v15_1.equals(v8))) {
                    v7 = 0;
                    v8 = v5;
                    goto label_81;
                }

                if(v15_1.equals(v10)) {
                    v0.resetGroup();
                    goto label_81;
                }

                if(v15_1.equals(v9)) {
                    if(v0.hasAddedItem()) {
                        goto label_81;
                    }

                    if(v0.itemActionProvider != null && (v0.itemActionProvider.hasSubMenu())) {
                        v0.addSubMenuItem();
                        goto label_81;
                    }

                    v0.addItem();
                    goto label_81;
                }

                if(!v15_1.equals(v2)) {
                    goto label_81;
                }

                v6 = 1;
            }

        label_81:
            v15 = arg13.next();
        }

        throw new RuntimeException("Unexpected end of document");
    }
}

