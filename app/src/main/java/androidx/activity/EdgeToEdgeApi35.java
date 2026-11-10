package androidx.activity;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.insets.ColorProtection;
import androidx.core.view.insets.ProtectionLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0017¨\u0006\u0010"}, d2={"Landroidx/activity/EdgeToEdgeApi35;", "Landroidx/activity/EdgeToEdgeApi30;", "<init>", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", "view", "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class EdgeToEdgeApi35 extends EdgeToEdgeApi30 {
    public EdgeToEdgeApi35() {
        super();
    }

    public void setUp(SystemBarStyle arg17, SystemBarStyle arg18, Window arg19, View arg20, boolean arg21, boolean arg22) {
        Object v9;
        Object v12;
        int v15;
        int v14;
        SystemBarStyle v1 = arg18;
        Window v2 = arg19;
        View v3 = arg20;
        boolean v4 = arg21;
        boolean v5 = arg22;
        Intrinsics.checkNotNullParameter(arg17, "statusBarStyle");
        Intrinsics.checkNotNullParameter(v1, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(v2, "window");
        Intrinsics.checkNotNullParameter(v3, "view");
        boolean v6 = false;
        WindowCompat.setDecorFitsSystemWindows(v2, false);
        v2.setStatusBarColor(0);
        v2.setNavigationBarColor(0);
        int v0 = arg17.getScrimWithEnforcedContrast$activity(v4);
        int v7 = v1.getScrimWithEnforcedContrast$activity(v5);
        View v8 = (v3 instanceof ViewGroup) ? v3 : null;
        if(v8 != null) {
            Iterator v11 = ViewGroupKt.getChildren(((ViewGroup)v8)).iterator();
            do {
                v14 = 2;
                v15 = 4;
                if(v11.hasNext()) {
                    v12 = v11.next().getTag();
                    if(!(v12 instanceof List)) {
                        continue;
                    }

                    v9 = v12;
                    if(((List)v9).size() != v15) {
                        continue;
                    }

                    if(!(((List)v9).get(0) instanceof ColorProtection)) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_68;
                }
            }
            while(true);

            Iterator v8_1 = ((Iterable)v12).iterator();
            goto label_44;
        label_68:
            if(v0 == 0 && v7 == 0) {
                goto label_92;
            }

            ColorProtection[] v9_1 = new ColorProtection[v15];
            v9_1[0] = new ColorProtection(v14, v0);
            v9_1[1] = new ColorProtection(1, v7);
            v9_1[v14] = new ColorProtection(v15, v7);
            v9_1[3] = new ColorProtection(8, v7);
            List v0_1 = CollectionsKt.listOf(((Object[])v9_1));
            ProtectionLayout v7_1 = new ProtectionLayout(v3.getContext(), v0_1);
            v7_1.setTag(v0_1);
            ((ViewGroup)v8).addView(((View)v7_1));
            goto label_92;
        label_44:
            while(v8_1.hasNext()) {
                v9 = v8_1.next();
                Object v11_1 = (v9 instanceof ColorProtection) ? v9 : null;
                if(v11_1 == null) {
                    continue;
                }

                int v11_2 = ((ColorProtection)v9).getSide();
                if(v11_2 != 1) {
                    if(v11_2 != v14) {
                        if(v11_2 != v15) {
                            if(v11_2 != 8) {
                                continue;
                            }

                            ((ColorProtection)v9).setColor(v7);
                            continue;
                        }

                        ((ColorProtection)v9).setColor(v7);
                        continue;
                    }

                    ((ColorProtection)v9).setColor(v0);
                    continue;
                }

                ((ColorProtection)v9).setColor(v7);
            }
        }

    label_92:
        if(v1.getNightMode$activity() == 0) {
            v6 = true;
        }

        v2.setNavigationBarContrastEnforced(v6);
        WindowInsetsControllerCompat v0_2 = new WindowInsetsControllerCompat(v2, v3);
        v0_2.setAppearanceLightStatusBars((((int)v4)) ^ 1);
        v0_2.setAppearanceLightNavigationBars((((int)v5)) ^ 1);
    }
}

