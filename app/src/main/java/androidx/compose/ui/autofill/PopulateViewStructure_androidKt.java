package androidx.compose.ui.autofill;

import android.os.Build$VERSION;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsInfoKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A.\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nH\u0001¨\u0006\u000B"}, d2={"populate", "", "Landroid/view/ViewStructure;", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "packageName", "", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PopulateViewStructure_androidKt {
    public static final void populate(ViewStructure arg38, SemanticsInfo arg39, AutofillId arg40, String arg41, RectManager arg42) {
        boolean v3_3;
        boolean v2_8;
        Integer v14_2;
        Object v8_1;
        boolean v6_1;
        SemanticsProperties v37;
        Object v6;
        Object v12;
        int v35;
        int v15;
        long v33;
        Object v31;
        boolean v30;
        int v29;
        Object v28;
        Object v27;
        Object v26;
        Object v25;
        Object v24;
        Object v23;
        int v22;
        Object v21;
        int v20;
        int v32;
        long v18;
        ViewStructure v1 = arg38;
        AutofillApi26Helper v0 = AutofillApi26Helper.INSTANCE;
        SemanticsProperties v2 = SemanticsProperties.INSTANCE;
        SemanticsActions v3 = SemanticsActions.INSTANCE;
        SemanticsConfiguration v4 = arg39.getSemanticsConfiguration();
        int v10 = 2;
        int v13 = 8;
        long v16 = 0x80;
        if(v4 != null) {
            MutableScatterMap v4_1 = v4.getProps$ui();
            if(v4_1 != null) {
                Object[] v5 = ((ScatterMap)v4_1).keys;
                v18 = 0xFF;
                Object[] v7 = ((ScatterMap)v4_1).values;
                long[] v4_2 = ((ScatterMap)v4_1).metadata;
                int v8 = v4_2.length - v10;
                if(v8 >= 0) {
                    v32 = v10;
                    int v9 = 0;
                    v20 = 7;
                    v21 = null;
                    v22 = 0;
                    v23 = null;
                    v24 = null;
                    v25 = null;
                    v26 = null;
                    v27 = null;
                    v28 = null;
                    v29 = 0;
                    v30 = true;
                    v31 = null;
                    v33 = -9187201950435737472L;
                    while(true) {
                        long v10_1 = v4_2[v9];
                        if((~v10_1 << v20 & v10_1 & v33) != v33) {
                            int v14 = 8 - (~(v9 - v8) >>> 0x1F);
                            v15 = 0;
                            while(v15 < v14) {
                                if((v10_1 & v18) < v16) {
                                    v35 = (v9 << 3) + v15;
                                    Object v36 = v5[v35];
                                    v12 = v7[v35];
                                    v35 = v13;
                                    Object v13_1 = v36;
                                    if(Intrinsics.areEqual(v13_1, v2.getContentDataType())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentDataType");
                                        v21 = v12;
                                    }
                                    else if(Intrinsics.areEqual(v13_1, v2.getContentDescription())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                        v6 = CollectionsKt.firstOrNull(((List)v12));
                                        if(v6 != null) {
                                            v0.setContentDescription(v1, ((CharSequence)v6));
                                        }
                                    }
                                    else if(Intrinsics.areEqual(v13_1, v2.getContentType())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentType");
                                        v26 = v12;
                                    }
                                    else if(Intrinsics.areEqual(v13_1, v2.getFillableData())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidFillableData");
                                        v25 = v12;
                                    }
                                    else if(Intrinsics.areEqual(v13_1, v2.getEditableText())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString");
                                        v24 = v12;
                                    }
                                    else {
                                        goto label_91;
                                    }

                                    v37 = v2;
                                    goto label_162;
                                label_91:
                                    v6_1 = Intrinsics.areEqual(v13_1, v2.getFocused());
                                    v37 = v2;
                                    String v2_1 = "null cannot be cast to non-null type kotlin.Boolean";
                                    if(v6_1) {
                                        Intrinsics.checkNotNull(v12, v2_1);
                                        v0.setFocused(v1, ((Boolean)v12).booleanValue());
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getMaxTextLength())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type kotlin.Int");
                                        v31 = v12;
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getPassword())) {
                                        v29 = 1;
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getIsSensitiveData())) {
                                        Intrinsics.checkNotNull(v12, v2_1);
                                        v30 = ((Boolean)v12).booleanValue();
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getRole())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.semantics.Role");
                                        v28 = v12;
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getSelected())) {
                                        Intrinsics.checkNotNull(v12, v2_1);
                                        v27 = v12;
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v37.getToggleableState())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type androidx.compose.ui.state.ToggleableState");
                                        v23 = v12;
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v3.getOnClick())) {
                                        v0.setClickable(v1, true);
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v3.getOnLongClick())) {
                                        v0.setLongClickable(v1, true);
                                        goto label_162;
                                    }

                                    if(Intrinsics.areEqual(v13_1, v3.getRequestFocus())) {
                                        v0.setFocusable(v1, true);
                                        goto label_162;
                                    }

                                    if(!Intrinsics.areEqual(v13_1, v3.getSetText())) {
                                        goto label_162;
                                    }

                                    v22 = 1;
                                }
                                else {
                                    v37 = v2;
                                    v35 = v13;
                                }

                            label_162:
                                v10_1 >>= v35;
                                ++v15;
                                v13 = v35;
                                v2 = v37;
                            }

                            v37 = v2;
                            if(v14 != v13) {
                                break;
                            }
                        }
                        else {
                            v37 = v2;
                        }

                        if(v9 == v8) {
                            break;
                        }

                        ++v9;
                        v2 = v37;
                        v13 = 8;
                    }
                }
                else {
                    v37 = v2;
                    v32 = v10;
                    v20 = 7;
                    v33 = -9187201950435737472L;
                    v21 = null;
                    v22 = 0;
                    v23 = null;
                    v24 = null;
                    v25 = null;
                    v26 = null;
                    v27 = null;
                    v28 = null;
                    v29 = 0;
                    v30 = true;
                    v31 = null;
                }

                v6 = v23;
            }
            else {
                goto label_194;
            }
        }
        else {
        label_194:
            v37 = v2;
            v32 = v10;
            v18 = 0xFF;
            v20 = 7;
            v33 = -9187201950435737472L;
            v6 = null;
            v21 = null;
            v22 = 0;
            v24 = null;
            v25 = null;
            v26 = null;
            v27 = null;
            v28 = null;
            v29 = 0;
            v30 = true;
            v31 = null;
        }

        SemanticsConfiguration v2_2 = SemanticsInfoKt.mergedSemanticsConfiguration(arg39);
        if(v2_2 != null) {
            MutableScatterMap v2_3 = v2_2.getProps$ui();
            if(v2_3 != null) {
                Object[] v3_1 = ((ScatterMap)v2_3).keys;
                Object[] v4_3 = ((ScatterMap)v2_3).values;
                long[] v2_4 = ((ScatterMap)v2_3).metadata;
                int v5_1 = v2_4.length - 2;
                if(v5_1 >= 0) {
                    int v7_1 = 0;
                    v8_1 = null;
                    while(true) {
                        long v9_1 = v2_4[v7_1];
                        if((~v9_1 << v20 & v9_1 & v33) != v33) {
                            v13 = 8 - (~(v7_1 - v5_1) >>> 0x1F);
                            int v11;
                            for(v11 = 0; v11 < v13; ++v11) {
                                if((v9_1 & v18) < v16) {
                                    int v12_1 = (v7_1 << 3) + v11;
                                    Object v14_1 = v3_1[v12_1];
                                    v12 = v4_3[v12_1];
                                    if(Intrinsics.areEqual(v14_1, v37.getDisabled())) {
                                        v0.setEnabled(v1, false);
                                    }
                                    else if(Intrinsics.areEqual(v14_1, v37.getText())) {
                                        Intrinsics.checkNotNull(v12, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString>");
                                        v8_1 = v12;
                                    }
                                }

                                v9_1 >>= 8;
                            }

                            if(v13 != 8) {
                                break;
                            }
                        }

                        if(v7_1 == v5_1) {
                            break;
                        }

                        ++v7_1;
                    }
                }
                else {
                    goto label_264;
                }
            }
            else {
                goto label_264;
            }
        }
        else {
        label_264:
            v8_1 = null;
        }

        Integer v2_5 = Integer.valueOf(arg39.getSemanticsId());
        v2_5.intValue();
        if(arg39.getParentInfo() == null) {
            v2_5 = null;
        }

        int v2_6 = v2_5 != null ? v2_5.intValue() : -1;
        v0.setAutofillId(v1, arg40, v2_6);
        v0.setId(v1, v2_6, arg41, null, null);
        if(v21 != null) {
            v14_2 = Integer.valueOf(ContentDataType_androidKt.getDataType(((ContentDataType)v21)));
        }
        else if(v22 != 0) {
            v14_2 = Integer.valueOf(1);
        }
        else if(v6 != null) {
            v14_2 = Integer.valueOf(v32);
        }
        else {
            v14_2 = null;
        }

        if(v14_2 != null) {
            v0.setAutofillType(v1, ((Number)v14_2).intValue());
        }

        if(v24 != null) {
            v0.setAutofillValue(v1, v0.getAutofillTextValue(((AnnotatedString)v24).getText()));
        }

        if(v25 != null) {
            v0.setAutofillValue(v1, ((AndroidFillableData)v25).getAutofillValue$ui());
        }

        if(v26 != null) {
            String[] v2_7 = ContentType_androidKt.getContentHints(((ContentType)v26));
            if(v2_7 != null) {
                v0.setAutofillHints(v1, v2_7);
            }
        }

        arg42.getRects().withRect(arg39.getSemanticsId(), new PopulateViewStructure_androidKt$populate$7(v0, v1));
        if(v27 != null) {
            v0.setSelected(v1, ((Boolean)v27).booleanValue());
        }

        if(v6 != null) {
            v0.setCheckable(v1, true);
            v2_8 = v6 == ToggleableState.On ? true : false;
            v0.setChecked(v1, v2_8);
        }
        else {
            if(v27 == null) {
                goto label_339;
            }

            v2_6 = Role.Companion.getTab-o7Vup1c();
            v2_8 = v28 == null ? false : Role.equals-impl0(((Role)v28).unbox-impl(), v2_6);
            if(v2_8) {
                goto label_339;
            }

            v0.setCheckable(v1, true);
            v0.setChecked(v1, ((Boolean)v27).booleanValue());
        }

    label_339:
        Object v2_9 = ArraysKt.first(ContentType_androidKt.getContentHints(ContentType.Companion.getPassword()));
        if(v26 != null) {
            String[] v3_2 = ContentType_androidKt.getContentHints(((ContentType)v26));
            if(v3_2 != null) {
                v2_8 = ArraysKt.contains(((Object[])v3_2), v2_9);
                v3_3 = true;
                if(v2_8) {
                    v2_6 = 1;
                }
                else {
                    goto label_352;
                }
            }
            else {
                goto label_351;
            }
        }
        else {
        label_351:
            v3_3 = true;
        label_352:
            v2_6 = 0;
        }

        if(v29 != 0 || v2_6 != 0) {
            v2_8 = v3_3;
        }
        else {
            v2_6 = 0;
        }

        v6_1 = (v2_8) || (v30) ? v3_3 : false;
        v0.setDataIsSensitive(v1, v6_1);
        int v3_4 = arg39.isTransparent() ? 4 : 0;
        v0.setVisibility(v1, v3_4);
        if(v8_1 != null) {
            v3_4 = v8_1.size();
            String v4_4 = "";
            for(v15 = 0; v15 < v3_4; ++v15) {
                v4_4 = v4_4 + ((List)v8_1).get(v15).getText() + '\n';
            }

            v0.setText(v1, ((CharSequence)v4_4));
            v0.setClassName(v1, "android.widget.TextView");
        }

        if((arg39.getChildrenInfo().isEmpty()) && v28 != null) {
            String v3_5 = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(((Role)v28).unbox-impl());
            if(v3_5 != null) {
                v0.setClassName(v1, v3_5);
            }
        }

        if(v22 != 0) {
            v0.setClassName(v1, "android.widget.EditText");
            if(Build$VERSION.SDK_INT >= 28 && v31 != null) {
                AutofillApi28Helper.INSTANCE.setMaxTextLength(v1, ((Number)v31).intValue());
            }

            if(!v2_8) {
                return;
            }

            v0.setInputType(v1, 0x81);
        }
    }
}

