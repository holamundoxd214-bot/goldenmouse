package androidx.core.app;

import android.app.PictureInPictureParams$Builder;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Rational;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\"#$%Bs\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010 \u001A\u00020!H\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0013R\u0013\u0010\f\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\r\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0015R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001E¨\u0006&"}, d2={"Landroidx/core/app/PictureInPictureParamsCompat;", "", "isEnabled", "", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "isSeamlessResizeEnabled", "closeAction", "expandedAspectRatio", "title", "", "subTitle", "<init>", "(ZLandroid/util/Rational;Ljava/util/List;Landroid/graphics/Rect;ZLandroid/app/RemoteAction;Landroid/util/Rational;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "()Z", "getAspectRatio", "()Landroid/util/Rational;", "getActions", "()Ljava/util/List;", "getSourceRectHint", "()Landroid/graphics/Rect;", "getCloseAction", "()Landroid/app/RemoteAction;", "getExpandedAspectRatio", "getTitle", "()Ljava/lang/CharSequence;", "getSubTitle", "toPictureInPictureParams", "Landroid/app/PictureInPictureParams;", "Builder", "Api26Impl", "Api31Impl", "Api33Impl", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PictureInPictureParamsCompat {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2={"Landroidx/core/app/PictureInPictureParamsCompat$Api26Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Api26Impl {
        public static final Api26Impl INSTANCE;

        static {
            Api26Impl.INSTANCE = new Api26Impl();
        }

        private Api26Impl() {
            super();
        }

        @JvmStatic public static final PictureInPictureParams create(Rational arg1, List arg2, Rect arg3) {
            Intrinsics.checkNotNullParameter(arg2, "actions");
            PictureInPictureParams v1 = new PictureInPictureParams$Builder().setAspectRatio(arg1).setActions(arg2).setSourceRectHint(arg3).build();
            Intrinsics.checkNotNullExpressionValue(v1, "build(...)");
            return v1;
        }
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¨\u0006\u0010"}, d2={"Landroidx/core/app/PictureInPictureParamsCompat$Api31Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "autoEnterEnabled", "", "seamlessResizeEnabled", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Api31Impl {
        public static final Api31Impl INSTANCE;

        static {
            Api31Impl.INSTANCE = new Api31Impl();
        }

        private Api31Impl() {
            super();
        }

        @JvmStatic public static final PictureInPictureParams create(Rational arg1, List arg2, Rect arg3, boolean arg4, boolean arg5) {
            Intrinsics.checkNotNullParameter(arg2, "actions");
            PictureInPictureParams v1 = new PictureInPictureParams$Builder().setAspectRatio(arg1).setActions(arg2).setSourceRectHint(arg3).setAutoEnterEnabled(arg4).setSeamlessResizeEnabled(arg5).build();
            Intrinsics.checkNotNullExpressionValue(v1, "build(...)");
            return v1;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00072\b\u0010\u0011\u001A\u0004\u0018\u00010\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007¨\u0006\u0015"}, d2={"Landroidx/core/app/PictureInPictureParamsCompat$Api33Impl;", "", "<init>", "()V", "create", "Landroid/app/PictureInPictureParams;", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "autoEnterEnabled", "", "seamlessResizeEnabled", "expandedAspectRatio", "closeAction", "title", "", "subTitle", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Api33Impl {
        public static final Api33Impl INSTANCE;

        static {
            Api33Impl.INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
            super();
        }

        @JvmStatic public static final PictureInPictureParams create(Rational arg1, List arg2, Rect arg3, boolean arg4, boolean arg5, Rational arg6, RemoteAction arg7, CharSequence arg8, CharSequence arg9) {
            Intrinsics.checkNotNullParameter(arg2, "actions");
            PictureInPictureParams v1 = new PictureInPictureParams$Builder().setAspectRatio(arg1).setActions(arg2).setSourceRectHint(arg3).setAutoEnterEnabled(arg4).setSeamlessResizeEnabled(arg5).setExpandedAspectRatio(arg6).setCloseAction(arg7).setTitle(arg8).setSubtitle(arg9).build();
            Intrinsics.checkNotNullExpressionValue(v1, "build(...)");
            return v1;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u0010\u0010\u0014\u001A\u00020\u00002\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007J\u0014\u0010\u0015\u001A\u00020\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u0016\u001A\u00020\u00002\b\u0010\u000B\u001A\u0004\u0018\u00010\fJ\u000E\u0010\u0017\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u0005J\u0010\u0010\u0018\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\nJ\u0010\u0010\u0019\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u0007J\u0010\u0010\u001A\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011J\u0010\u0010\u001B\u001A\u00020\u00002\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011J\u0006\u0010\u001C\u001A\u00020\u001DR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/core/app/PictureInPictureParamsCompat$Builder;", "", "<init>", "()V", "enabled", "", "aspectRatio", "Landroid/util/Rational;", "actions", "", "Landroid/app/RemoteAction;", "sourceRectHint", "Landroid/graphics/Rect;", "seamlessResizeEnabled", "closeAction", "expandedAspectRatio", "title", "", "subTitle", "setEnabled", "setAspectRatio", "setActions", "setSourceRectHint", "setSeamlessResizeEnabled", "setCloseAction", "setExpandedAspectRatio", "setTitle", "setSubTitle", "build", "Landroidx/core/app/PictureInPictureParamsCompat;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Builder {
        private List actions;
        private Rational aspectRatio;
        private RemoteAction closeAction;
        private boolean enabled;
        private Rational expandedAspectRatio;
        private boolean seamlessResizeEnabled;
        private Rect sourceRectHint;
        private CharSequence subTitle;
        private CharSequence title;

        public Builder() {
            super();
            this.enabled = true;
            this.actions = CollectionsKt.emptyList();
        }

        public final PictureInPictureParamsCompat build() {
            return new PictureInPictureParamsCompat(this.enabled, this.aspectRatio, this.actions, this.sourceRectHint, this.seamlessResizeEnabled, this.closeAction, this.expandedAspectRatio, this.title, this.subTitle);
        }

        public final Builder setActions(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "actions");
            this.actions = arg2;
            return this;
        }

        public final Builder setAspectRatio(Rational arg2) {
            this.aspectRatio = arg2;
            return this;
        }

        public final Builder setCloseAction(RemoteAction arg2) {
            this.closeAction = arg2;
            return this;
        }

        public final Builder setEnabled(boolean arg2) {
            this.enabled = arg2;
            return this;
        }

        public final Builder setExpandedAspectRatio(Rational arg2) {
            this.expandedAspectRatio = arg2;
            return this;
        }

        public final Builder setSeamlessResizeEnabled(boolean arg2) {
            this.seamlessResizeEnabled = arg2;
            return this;
        }

        public final Builder setSourceRectHint(Rect arg2) {
            this.sourceRectHint = arg2;
            return this;
        }

        public final Builder setSubTitle(CharSequence arg2) {
            this.subTitle = arg2;
            return this;
        }

        public final Builder setTitle(CharSequence arg2) {
            this.title = arg2;
            return this;
        }
    }

    private final List actions;
    private final Rational aspectRatio;
    private final RemoteAction closeAction;
    private final Rational expandedAspectRatio;
    private final boolean isEnabled;
    private final boolean isSeamlessResizeEnabled;
    private final Rect sourceRectHint;
    private final CharSequence subTitle;
    private final CharSequence title;

    public PictureInPictureParamsCompat() {
        this(false, null, null, null, false, null, null, null, null, 0x1FF, null);
    }

    public PictureInPictureParamsCompat(boolean arg2, Rational arg3, List arg4, Rect arg5, boolean arg6, RemoteAction arg7, Rational arg8, CharSequence arg9, CharSequence arg10, int arg11, DefaultConstructorMarker arg12) {
        PictureInPictureParamsCompat v3;
        Rational v5;
        boolean v4;
        Rect v7;
        List v6;
        RemoteAction v9;
        boolean v8;
        CharSequence v11;
        Rational v10;
        CharSequence v12;
        Rational v0 = null;
        if((arg11 & 2) != 0) {
            arg3 = v0;
        }

        if((arg11 & 4) != 0) {
            arg4 = CollectionsKt.emptyList();
        }

        if((arg11 & 8) != 0) {
            arg5 = ((Rect)v0);
        }

        if((arg11 & 0x20) != 0) {
            arg7 = ((RemoteAction)v0);
        }

        if((arg11 & 0x40) != 0) {
            arg8 = v0;
        }

        if((arg11 & 0x80) != 0) {
            arg9 = ((CharSequence)v0);
        }

        if((arg11 & 0x100) != 0) {
            v12 = ((CharSequence)v0);
            v10 = arg8;
            v11 = arg9;
            v8 = false;
            v9 = arg7;
            v6 = arg4;
            v7 = arg5;
            v4 = true;
            v5 = arg3;
            v3 = this;
        }
        else {
            v12 = arg10;
            v11 = arg9;
            v9 = arg7;
            v10 = arg8;
            v7 = arg5;
            v8 = false;
            v5 = arg3;
            v6 = arg4;
            v3 = this;
            v4 = true;
        }

        this(v4, v5, v6, v7, v8, v9, v10, v11, v12);
    }

    public PictureInPictureParamsCompat(boolean arg2, Rational arg3, List arg4, Rect arg5, boolean arg6, RemoteAction arg7, Rational arg8, CharSequence arg9, CharSequence arg10) {
        Intrinsics.checkNotNullParameter(arg4, "actions");
        super();
        this.isEnabled = arg2;
        this.aspectRatio = arg3;
        this.actions = arg4;
        this.sourceRectHint = arg5;
        this.isSeamlessResizeEnabled = arg6;
        this.closeAction = arg7;
        this.expandedAspectRatio = arg8;
        this.title = arg9;
        this.subTitle = arg10;
    }

    public final List getActions() {
        return this.actions;
    }

    public final Rational getAspectRatio() {
        return this.aspectRatio;
    }

    public final RemoteAction getCloseAction() {
        return this.closeAction;
    }

    public final Rational getExpandedAspectRatio() {
        return this.expandedAspectRatio;
    }

    public final Rect getSourceRectHint() {
        return this.sourceRectHint;
    }

    public final CharSequence getSubTitle() {
        return this.subTitle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isSeamlessResizeEnabled() {
        return this.isSeamlessResizeEnabled;
    }

    public final PictureInPictureParams toPictureInPictureParams() {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.create(this.aspectRatio, this.actions, this.sourceRectHint, this.isEnabled, this.isSeamlessResizeEnabled, this.expandedAspectRatio, this.closeAction, this.title, this.subTitle);
        }

        int v0 = Build$VERSION.SDK_INT;
        Rational v1 = this.aspectRatio;
        if(v0 >= 0x1F) {
            return Api31Impl.create(v1, this.actions, this.sourceRectHint, this.isEnabled, this.isSeamlessResizeEnabled);
        }

        return Api26Impl.create(v1, this.actions, this.sourceRectHint);
    }
}

