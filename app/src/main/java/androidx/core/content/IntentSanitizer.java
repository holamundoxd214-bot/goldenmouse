package androidx.core.content;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class IntentSanitizer {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static String getIdentifier(Intent arg0) {
            return arg0.getIdentifier();
        }

        static Intent setIdentifier(Intent arg0, String arg1) {
            return arg0.setIdentifier(arg1);
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static void checkOtherMembers(int arg2, ClipData$Item arg3, Consumer arg4) {
            if(arg3.getHtmlText() == null && arg3.getIntent() == null) {
                if(arg3.getTextLinks() != null) {
                }
                else {
                    return;
                }
            }

            arg4.accept("ClipData item at position " + arg2 + " contains htmlText, textLinks or intent: " + arg3);
        }
    }

    public final class Builder {
        private static final int HISTORY_STACK_FLAGS = 0x7DEBF000;
        private static final int RECEIVER_FLAGS = 0x78200000;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate mAllowedActions;
        private Predicate mAllowedCategories;
        private Predicate mAllowedClipData;
        private Predicate mAllowedClipDataUri;
        private Predicate mAllowedComponents;
        private Predicate mAllowedData;
        private Map mAllowedExtras;
        private int mAllowedFlags;
        private Predicate mAllowedPackages;
        private Predicate mAllowedTypes;

        public static boolean $r8$lambda$DvjTS4tHjUqRA2QfyccBu7fhDzE(String arg0, Object arg1) {
            return arg0.equals(arg1);
        }

        public static boolean $r8$lambda$HF7enmHP1Z3cPiyI1KCE8M8gPts(ComponentName arg0, Object arg1) {
            return arg0.equals(arg1);
        }

        public Builder() {
            super();
            this.mAllowedActions = new IntentSanitizer$Builder$$ExternalSyntheticLambda10();
            this.mAllowedData = new IntentSanitizer$Builder$$ExternalSyntheticLambda11();
            this.mAllowedTypes = new IntentSanitizer$Builder$$ExternalSyntheticLambda12();
            this.mAllowedCategories = new IntentSanitizer$Builder$$ExternalSyntheticLambda13();
            this.mAllowedPackages = new IntentSanitizer$Builder$$ExternalSyntheticLambda14();
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda15();
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = new IntentSanitizer$Builder$$ExternalSyntheticLambda16();
            this.mAllowedClipData = new IntentSanitizer$Builder$$ExternalSyntheticLambda17();
        }

        public Builder allowAction(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedActions = this.mAllowedActions.or(arg2);
            return this;
        }

        public Builder allowAction(String arg2) {
            Preconditions.checkNotNull(arg2);
            Objects.requireNonNull(arg2);
            this.allowAction(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(arg2));
            return this;
        }

        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new IntentSanitizer$Builder$$ExternalSyntheticLambda6();
            return this;
        }

        public Builder allowCategory(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedCategories = this.mAllowedCategories.or(arg2);
            return this;
        }

        public Builder allowCategory(String arg2) {
            Preconditions.checkNotNull(arg2);
            Objects.requireNonNull(arg2);
            return this.allowCategory(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(arg2));
        }

        public Builder allowClipData(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedClipData = this.mAllowedClipData.or(arg2);
            return this;
        }

        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public Builder allowClipDataUri(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(arg2);
            return this;
        }

        public Builder allowClipDataUriWithAuthority(String arg2) {
            Preconditions.checkNotNull(arg2);
            return this.allowClipDataUri(new IntentSanitizer$Builder$$ExternalSyntheticLambda7(arg2));
        }

        public Builder allowComponent(ComponentName arg2) {
            Preconditions.checkNotNull(arg2);
            Objects.requireNonNull(arg2);
            return this.allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda5(arg2));
        }

        public Builder allowComponent(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(arg2);
            return this;
        }

        public Builder allowComponentWithPackage(String arg2) {
            Preconditions.checkNotNull(arg2);
            return this.allowComponent(new IntentSanitizer$Builder$$ExternalSyntheticLambda2(arg2));
        }

        public Builder allowData(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedData = this.mAllowedData.or(arg2);
            return this;
        }

        public Builder allowDataWithAuthority(String arg2) {
            Preconditions.checkNotNull(arg2);
            this.allowData(new IntentSanitizer$Builder$$ExternalSyntheticLambda3(arg2));
            return this;
        }

        public Builder allowExtra(String arg2, Predicate arg3) {
            IntentSanitizer$Builder$$ExternalSyntheticLambda8 v0_1;
            Preconditions.checkNotNull(arg2);
            Preconditions.checkNotNull(arg3);
            Object v0 = this.mAllowedExtras.get(arg2);
            if(v0 == null) {
                v0_1 = new IntentSanitizer$Builder$$ExternalSyntheticLambda8();
            }

            this.mAllowedExtras.put(arg2, ((Predicate)v0_1).or(arg3));
            return this;
        }

        public Builder allowExtra(String arg2, Class arg3) {
            return this.allowExtra(arg2, arg3, new IntentSanitizer$Builder$$ExternalSyntheticLambda18());
        }

        public Builder allowExtra(String arg2, Class arg3, Predicate arg4) {
            Preconditions.checkNotNull(arg2);
            Preconditions.checkNotNull(arg3);
            Preconditions.checkNotNull(arg4);
            return this.allowExtra(arg2, new IntentSanitizer$Builder$$ExternalSyntheticLambda4(arg3, arg4));
        }

        public Builder allowExtraOutput(Predicate arg3) {
            this.allowExtra("output", Uri.class, arg3);
            return this;
        }

        public Builder allowExtraOutput(String arg3) {
            this.allowExtra("output", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda0(arg3));
            return this;
        }

        public Builder allowExtraStream(Predicate arg3) {
            this.allowExtra("android.intent.extra.STREAM", Uri.class, arg3);
            return this;
        }

        public Builder allowExtraStreamUriWithAuthority(String arg3) {
            Preconditions.checkNotNull(arg3);
            this.allowExtra("android.intent.extra.STREAM", Uri.class, new IntentSanitizer$Builder$$ExternalSyntheticLambda9(arg3));
            return this;
        }

        public Builder allowFlags(int arg2) {
            this.mAllowedFlags |= arg2;
            return this;
        }

        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= 0x7DEBF000;
            return this;
        }

        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public Builder allowPackage(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedPackages = this.mAllowedPackages.or(arg2);
            return this;
        }

        public Builder allowPackage(String arg2) {
            Preconditions.checkNotNull(arg2);
            Objects.requireNonNull(arg2);
            return this.allowPackage(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(arg2));
        }

        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= 0x78200000;
            return this;
        }

        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public Builder allowType(Predicate arg2) {
            Preconditions.checkNotNull(arg2);
            this.mAllowedTypes = this.mAllowedTypes.or(arg2);
            return this;
        }

        public Builder allowType(String arg2) {
            Preconditions.checkNotNull(arg2);
            Objects.requireNonNull(arg2);
            return this.allowType(new IntentSanitizer$Builder$$ExternalSyntheticLambda1(arg2));
        }

        public IntentSanitizer build() {
            boolean v0 = this.mAllowAnyComponent;
            if((v0) && (this.mAllowSomeComponents)) {
            label_8:
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            else if(!v0) {
                if(this.mAllowSomeComponents) {
                }
                else {
                    goto label_8;
                }
            }

            IntentSanitizer v0_1 = new IntentSanitizer(null);
            IntentSanitizer.-$$Nest$fputmAllowedFlags(v0_1, this.mAllowedFlags);
            IntentSanitizer.-$$Nest$fputmAllowedActions(v0_1, this.mAllowedActions);
            IntentSanitizer.-$$Nest$fputmAllowedData(v0_1, this.mAllowedData);
            IntentSanitizer.-$$Nest$fputmAllowedTypes(v0_1, this.mAllowedTypes);
            IntentSanitizer.-$$Nest$fputmAllowedCategories(v0_1, this.mAllowedCategories);
            IntentSanitizer.-$$Nest$fputmAllowedPackages(v0_1, this.mAllowedPackages);
            IntentSanitizer.-$$Nest$fputmAllowAnyComponent(v0_1, this.mAllowAnyComponent);
            IntentSanitizer.-$$Nest$fputmAllowedComponents(v0_1, this.mAllowedComponents);
            IntentSanitizer.-$$Nest$fputmAllowedExtras(v0_1, this.mAllowedExtras);
            IntentSanitizer.-$$Nest$fputmAllowClipDataText(v0_1, this.mAllowClipDataText);
            IntentSanitizer.-$$Nest$fputmAllowedClipDataUri(v0_1, this.mAllowedClipDataUri);
            IntentSanitizer.-$$Nest$fputmAllowedClipData(v0_1, this.mAllowedClipData);
            IntentSanitizer.-$$Nest$fputmAllowIdentifier(v0_1, this.mAllowIdentifier);
            IntentSanitizer.-$$Nest$fputmAllowSelector(v0_1, this.mAllowSelector);
            IntentSanitizer.-$$Nest$fputmAllowSourceBounds(v0_1, this.mAllowSourceBounds);
            return v0_1;
        }

        static boolean lambda$allowAnyComponent$10(ComponentName arg0) {
            return 1;
        }

        static boolean lambda$allowClipDataUriWithAuthority$11(String arg0, Uri arg1) {
            return arg0.equals(arg1.getAuthority());
        }

        static boolean lambda$allowComponentWithPackage$9(String arg0, ComponentName arg1) {
            return arg0.equals(arg1.getPackageName());
        }

        static boolean lambda$allowDataWithAuthority$8(String arg0, Uri arg1) {
            return arg0.equals(arg1.getAuthority());
        }

        static boolean lambda$allowExtra$12(Object arg0) {
            return 1;
        }

        static boolean lambda$allowExtra$13(Class arg1, Predicate arg2, Object arg3) {
            if((arg1.isInstance(arg3)) && (arg2.test(arg1.cast(arg3)))) {
                return 1;
            }

            return 0;
        }

        static boolean lambda$allowExtra$14(Object arg0) {
            return 0;
        }

        static boolean lambda$allowExtraOutput$16(String arg0, Uri arg1) {
            return arg0.equals(arg1.getAuthority());
        }

        static boolean lambda$allowExtraStreamUriWithAuthority$15(String arg0, Uri arg1) {
            return arg0.equals(arg1.getAuthority());
        }

        static boolean lambda$new$0(String arg0) {
            return 0;
        }

        static boolean lambda$new$1(Uri arg0) {
            return 0;
        }

        static boolean lambda$new$2(String arg0) {
            return 0;
        }

        static boolean lambda$new$3(String arg0) {
            return 0;
        }

        static boolean lambda$new$4(String arg0) {
            return 0;
        }

        static boolean lambda$new$5(ComponentName arg0) {
            return 0;
        }

        static boolean lambda$new$6(Uri arg0) {
            return 0;
        }

        static boolean lambda$new$7(ClipData arg0) {
            return 0;
        }
    }

    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate mAllowedActions;
    private Predicate mAllowedCategories;
    private Predicate mAllowedClipData;
    private Predicate mAllowedClipDataUri;
    private Predicate mAllowedComponents;
    private Predicate mAllowedData;
    private Map mAllowedExtras;
    private int mAllowedFlags;
    private Predicate mAllowedPackages;
    private Predicate mAllowedTypes;

    static void -$$Nest$fputmAllowAnyComponent(IntentSanitizer arg0, boolean arg1) {
        arg0.mAllowAnyComponent = arg1;
    }

    static void -$$Nest$fputmAllowClipDataText(IntentSanitizer arg0, boolean arg1) {
        arg0.mAllowClipDataText = arg1;
    }

    static void -$$Nest$fputmAllowIdentifier(IntentSanitizer arg0, boolean arg1) {
        arg0.mAllowIdentifier = arg1;
    }

    static void -$$Nest$fputmAllowSelector(IntentSanitizer arg0, boolean arg1) {
        arg0.mAllowSelector = arg1;
    }

    static void -$$Nest$fputmAllowSourceBounds(IntentSanitizer arg0, boolean arg1) {
        arg0.mAllowSourceBounds = arg1;
    }

    static void -$$Nest$fputmAllowedActions(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedActions = arg1;
    }

    static void -$$Nest$fputmAllowedCategories(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedCategories = arg1;
    }

    static void -$$Nest$fputmAllowedClipData(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedClipData = arg1;
    }

    static void -$$Nest$fputmAllowedClipDataUri(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedClipDataUri = arg1;
    }

    static void -$$Nest$fputmAllowedComponents(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedComponents = arg1;
    }

    static void -$$Nest$fputmAllowedData(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedData = arg1;
    }

    static void -$$Nest$fputmAllowedExtras(IntentSanitizer arg0, Map arg1) {
        arg0.mAllowedExtras = arg1;
    }

    static void -$$Nest$fputmAllowedFlags(IntentSanitizer arg0, int arg1) {
        arg0.mAllowedFlags = arg1;
    }

    static void -$$Nest$fputmAllowedPackages(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedPackages = arg1;
    }

    static void -$$Nest$fputmAllowedTypes(IntentSanitizer arg0, Predicate arg1) {
        arg0.mAllowedTypes = arg1;
    }

    private IntentSanitizer() {
        super();
    }

    IntentSanitizer(IntentSanitizer-IA arg1) {
        this();
    }

    private static void checkOtherMembers(int arg2, ClipData$Item arg3, Consumer arg4) {
        if(arg3.getHtmlText() == null) {
            if(arg3.getIntent() != null) {
            }
            else {
                return;
            }
        }

        arg4.accept("ClipData item at position " + arg2 + " contains htmlText, textLinks or intent: " + arg3);
    }

    static void lambda$sanitizeByFiltering$0(String arg0) {
    }

    static void lambda$sanitizeByThrowing$1(String arg1) {
        throw new SecurityException(arg1);
    }

    private void putExtra(Intent arg1, String arg2, Object arg3) {
        if(arg3 == null) {
            arg1.getExtras().putString(arg2, null);
            return;
        }

        if((arg3 instanceof Parcelable)) {
            arg1.putExtra(arg2, ((Parcelable)arg3));
            return;
        }

        if((arg3 instanceof Parcelable[])) {
            arg1.putExtra(arg2, ((Parcelable[])arg3));
            return;
        }

        if((arg3 instanceof Serializable)) {
            arg1.putExtra(arg2, ((Serializable)arg3));
            return;
        }

        throw new IllegalArgumentException("Unsupported type " + arg3.getClass());
    }

    public Intent sanitize(Intent arg8, Consumer arg9) {
        Intent v1 = new Intent();
        ComponentName v0 = arg8.getComponent();
        if((this.mAllowAnyComponent) && v0 == null || (this.mAllowedComponents.test(v0))) {
            v1.setComponent(v0);
        }
        else {
            arg9.accept("Component is not allowed: " + v0);
            v1.setComponent(new ComponentName("android", "java.lang.Void"));
        }

        String v0_1 = arg8.getPackage();
        if(v0_1 == null || (this.mAllowedPackages.test(v0_1))) {
            v1.setPackage(v0_1);
        }
        else {
            arg9.accept("Package is not allowed: " + v0_1);
        }

        int v0_2 = this.mAllowedFlags | arg8.getFlags();
        int v2 = this.mAllowedFlags;
        if(v0_2 == v2) {
            v1.setFlags(arg8.getFlags());
        }
        else {
            v1.setFlags(arg8.getFlags() & v2);
            arg9.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(arg8.getFlags() & ~this.mAllowedFlags));
        }

        v0_1 = arg8.getAction();
        if(v0_1 == null || (this.mAllowedActions.test(v0_1))) {
            v1.setAction(v0_1);
        }
        else {
            arg9.accept("Action is not allowed: " + v0_1);
        }

        Uri v0_3 = arg8.getData();
        if(v0_3 == null || (this.mAllowedData.test(v0_3))) {
            v1.setData(v0_3);
        }
        else {
            arg9.accept("Data is not allowed: " + v0_3);
        }

        v0_1 = arg8.getType();
        if(v0_1 == null || (this.mAllowedTypes.test(v0_1))) {
            v1.setDataAndType(v1.getData(), v0_1);
        }
        else {
            arg9.accept("Type is not allowed: " + v0_1);
        }

        Set v0_4 = arg8.getCategories();
        if(v0_4 != null) {
            Iterator v0_5 = v0_4.iterator();
            while(v0_5.hasNext()) {
                Object v2_1 = v0_5.next();
                if(this.mAllowedCategories.test(v2_1)) {
                    v1.addCategory(((String)v2_1));
                }
                else {
                    arg9.accept("Category is not allowed: " + (((String)v2_1)));
                }
            }
        }

        Bundle v0_6 = arg8.getExtras();
        if(v0_6 != null) {
            Iterator v2_2 = v0_6.keySet().iterator();
            while(v2_2.hasNext()) {
                Object v3 = v2_2.next();
                if((((String)v3).equals("android.intent.extra.STREAM")) && (this.mAllowedFlags & 1) == 0) {
                    arg9.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                    continue;
                }

                if((((String)v3).equals("output")) && (~this.mAllowedFlags & 3) != 0) {
                    arg9.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                    continue;
                }

                Object v4 = v0_6.get(((String)v3));
                Object v5 = this.mAllowedExtras.get(v3);
                if(v5 != null && (((Predicate)v5).test(v4))) {
                    this.putExtra(v1, ((String)v3), v4);
                    continue;
                }

                arg9.accept("Extra is not allowed. Key: " + (((String)v3)) + ". Value: " + v4);
            }
        }

        Intent v0_7 = arg8;
        Consumer v5_1 = arg9;
        IntentSanitizer.sanitizeClipData(v0_7, v1, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, v5_1);
        if(Build$VERSION.SDK_INT >= 29) {
            if(this.mAllowIdentifier) {
                Api29Impl.setIdentifier(v1, Api29Impl.getIdentifier(v0_7));
            }
            else if(Api29Impl.getIdentifier(v0_7) != null) {
                v5_1.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(v0_7));
            }
        }

        if(this.mAllowSelector) {
            v1.setSelector(v0_7.getSelector());
        }
        else if(v0_7.getSelector() != null) {
            v5_1.accept("Selector is not allowed: " + v0_7.getSelector());
        }

        if(this.mAllowSourceBounds) {
            v1.setSourceBounds(v0_7.getSourceBounds());
            return v1;
        }

        if(v0_7.getSourceBounds() != null) {
            v5_1.accept("SourceBounds is not allowed: " + v0_7.getSourceBounds());
        }

        return v1;
    }

    public Intent sanitizeByFiltering(Intent arg2) {
        return this.sanitize(arg2, new IntentSanitizer$$ExternalSyntheticLambda1());
    }

    public Intent sanitizeByThrowing(Intent arg2) {
        return this.sanitize(arg2, new IntentSanitizer$$ExternalSyntheticLambda0());
    }

    static void sanitizeClipData(Intent arg7, Intent arg8, Predicate arg9, boolean arg10, Predicate arg11, Consumer arg12) {
        Uri v2_1;
        CharSequence v3;
        ClipData v7 = arg7.getClipData();
        if(v7 == null) {
        }
        else {
            if(arg9 != null && (arg9.test(v7))) {
                arg8.setClipData(v7);
                return;
            }

            Intent v9 = null;
            int v0 = 0;
            ClipData v1 = ((ClipData)v9);
            while(v0 < v7.getItemCount()) {
                ClipData$Item v2 = v7.getItemAt(v0);
                if(Build$VERSION.SDK_INT >= 0x1F) {
                    Api31Impl.checkOtherMembers(v0, v2, arg12);
                }
                else {
                    IntentSanitizer.checkOtherMembers(v0, v2, arg12);
                }

                if(arg10) {
                    v3 = v2.getText();
                }
                else {
                    if(v2.getText() != null) {
                        arg12.accept("Item text cannot contain value. Item position: " + v0 + ". Text: " + v2.getText());
                    }

                    v3 = ((CharSequence)v9);
                }

                String v4 = ". URI: ";
                String v5 = "Item URI is not allowed. Item position: ";
                if(arg11 == null) {
                    if(v2.getUri() != null) {
                        arg12.accept(v5 + v0 + v4 + v2.getUri());
                    }
                    else {
                    }

                    goto label_64;
                }
                else {
                    if(v2.getUri() != null) {
                        if(arg11.test(v2.getUri())) {
                        }
                        else {
                            arg12.accept(v5 + v0 + v4 + v2.getUri());
                        label_64:
                            v2_1 = ((Uri)v9);
                            goto label_67;
                        }
                    }

                    v2_1 = v2.getUri();
                }

            label_67:
                if(v3 != null || v2_1 != null) {
                    if(v1 == null) {
                        v1 = new ClipData(v7.getDescription(), new ClipData$Item(v3, v9, v2_1));
                    }
                    else {
                        v1.addItem(new ClipData$Item(v3, v9, v2_1));
                    }
                }

                ++v0;
            }

            if(v1 == null) {
                return;
            }

            arg8.setClipData(v1);
        }
    }
}

