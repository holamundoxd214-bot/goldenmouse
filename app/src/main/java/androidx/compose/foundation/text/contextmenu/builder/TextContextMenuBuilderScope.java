package androidx.compose.foundation.text.contextmenu.builder;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\fJ!\u0010\r\u001A\u00020\u000E2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0006H\u0000¢\u0006\u0002\b\u0013J\u0006\u0010\u0014\u001A\u00020\u000ER\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "<init>", "()V", "components", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "filters", "Lkotlin/Function1;", "", "build", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "build$foundation", "addFilter", "", "filter", "addFilter$foundation", "addComponent", "component", "addComponent$foundation", "separator", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuBuilderScope {
    public static final int $stable = 8;
    private final MutableObjectList components;
    private final MutableObjectList filters;

    static {
    }

    public TextContextMenuBuilderScope() {
        super();
        this.components = new MutableObjectList(0, 1, null);
        this.filters = new MutableObjectList(0, 1, null);
    }

    public final void addComponent$foundation(TextContextMenuComponent arg1) {
        this.components.add(arg1);
    }

    public final void addFilter$foundation(Function1 arg1) {
        this.filters.add(arg1);
    }

    public final TextContextMenuData build$foundation() {
        DefaultConstructorMarker v3 = null;
        MutableObjectList v0 = new MutableObjectList(0, 1, v3);
        MutableObjectList v4 = this.components;
        Object[] v5 = ((ObjectList)v4).content;
        int v4_1 = ((ObjectList)v4)._size;
        int v6 = 0;
        int v7 = 1;
        TextContextMenuComponent v8 = ((TextContextMenuComponent)v3);
        while(v6 < v4_1) {
            Object v9 = v5[v6];
            if(v7 == 0 || v9 != TextContextMenuSeparator.INSTANCE) {
                if((TextContextMenuBuilderScopeKt.isSeparator(((TextContextMenuComponent)v9))) && (TextContextMenuBuilderScopeKt.isSeparator(v8))) {
                label_31:
                    v7 = 0;
                    goto label_38;
                }
                else if(!TextContextMenuBuilderScopeKt.isSeparator(((TextContextMenuComponent)v9))) {
                    MutableObjectList v7_1 = this.filters;
                    Object[] v10 = ((ObjectList)v7_1).content;
                    v7 = ((ObjectList)v7_1)._size;
                    int v11 = 0;
                    while(v11 < v7) {
                        if(v10[v11].invoke(v9).booleanValue()) {
                            ++v11;
                            continue;
                        }
                        else {
                            goto label_31;
                        }
                    }
                }

                v0.add(v9);
                v7 = 0;
                Object v8_1 = v9;
            }

        label_38:
            ++v6;
        }

        MutableObjectList v13 = v0;
        if(((ObjectList)v13).isEmpty()) {
        }
        else {
            Object v3_1 = ((ObjectList)v13).content[((ObjectList)v13)._size - 1];
        }

        if(TextContextMenuBuilderScopeKt.isSeparator(((TextContextMenuComponent)v3))) {
            v0.removeAt(((ObjectList)v13)._size - 1);
        }

        return new TextContextMenuData(v0.asList());
    }

    public final void separator() {
        this.components.add(TextContextMenuSeparator.INSTANCE);
    }
}

