package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationContext$Builder;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rJ\u0011\u0010\u000E\u001A\u00020\u000F*\u00020\u0010H\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/text/selection/TextClassifierHelperMethods;", "", "<init>", "()V", "createTextClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "toAndroidLocaleList", "Landroid/os/LocaleList;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "hasLegacyAssistItem", "", "Landroid/view/textclassifier/TextClassification;", "hasLegacyAssistItem$foundation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextClassifierHelperMethods {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SelectedTextType.values().length];
            try {
                v0[SelectedTextType.EditableText.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SelectedTextType.StaticText.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable;
    public static final TextClassifierHelperMethods INSTANCE;

    static {
        TextClassifierHelperMethods.INSTANCE = new TextClassifierHelperMethods();
    }

    private TextClassifierHelperMethods() {
        super();
    }

    public final TextClassifier createTextClassificationSession(Context arg2, SelectedTextType arg3) {
        String v3_1;
        Object v1 = arg2.getSystemService(TextClassificationManager.class);
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v3 == 1) {
            v3_1 = "edittext";
        }
        else if(v3 == 2) {
            v3_1 = "textview";
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        return ((TextClassificationManager)v1).createTextClassificationSession(new TextClassificationContext$Builder(arg2.getPackageName(), v3_1).build());
    }

    public final boolean hasLegacyAssistItem$foundation(TextClassification arg1) {
        if(arg1.getIcon() == null && (TextUtils.isEmpty(arg1.getLabel()))) {
            return 0;
        }
        else if(arg1.getIntent() == null) {
            if(arg1.getOnClickListener() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final LocaleList toAndroidLocaleList(androidx.compose.ui.text.intl.LocaleList arg2) {
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg2), 10));
        Iterator v2 = ((Iterable)arg2).iterator();
        while(v2.hasNext()) {
            ((Collection)v1).add(v2.next().getPlatformLocale());
        }

        Object[] v1_1 = ((Collection)v1).toArray(new Locale[0]);
        return new LocaleList(Arrays.copyOf(v1_1, v1_1.length));
    }
}

