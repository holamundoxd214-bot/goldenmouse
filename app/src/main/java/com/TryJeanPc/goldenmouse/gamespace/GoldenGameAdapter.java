package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.TryJeanPc.goldenmouse.GameInfo;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$string;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001A\u001A\u0004\u0018\u00010\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\rJ\u0014\u0010\u001E\u001A\u00020\u00072\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010 \u001A\u00020\u0018H\u0016J\u0018\u0010!\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0018H\u0016J\u0018\u0010%\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u0018H\u0016R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameAdapter$Holder;", "context", "Landroid/content/Context;", "onAddGame", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getOnAddGame", "()Lkotlin/jvm/functions/Function0;", "addLabel", "", "leftLabel", "rightLabel", "leftArtwork", "Landroid/graphics/drawable/Drawable;", "rightArtwork", "games", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "gameAt", "position", "", "(Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/GameInfo;", "keyAt", "(Ljava/lang/Integer;)Ljava/lang/String;", "positionOf", "key", "submitGames", "value", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Holder", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGameAdapter extends Adapter {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "card", "Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameCardView;", "<init>", "(Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameCardView;)V", "getCard", "()Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGameCardView;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Holder extends ViewHolder {
        public static final int $stable = 8;
        private final GoldenGameCardView card;

        static {
        }

        public Holder(GoldenGameCardView arg2) {
            Intrinsics.checkNotNullParameter(arg2, "card");
            super(arg2);
            this.card = arg2;
        }

        public final GoldenGameCardView getCard() {
            return this.card;
        }
    }

    public static final int $stable = 8;
    private final String addLabel;
    private List games;
    private final Drawable leftArtwork;
    private final String leftLabel;
    private final Function0 onAddGame;
    private final Drawable rightArtwork;
    private final String rightLabel;

    static {
    }

    public GoldenGameAdapter(Context arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "onAddGame");
        super();
        this.onAddGame = arg3;
        String v3 = arg2.getString(string.gspace_add_game);
        Intrinsics.checkNotNullExpressionValue(v3, "getString(...)");
        this.addLabel = v3;
        v3 = arg2.getString(string.gspace_default_left);
        Intrinsics.checkNotNullExpressionValue(v3, "getString(...)");
        this.leftLabel = v3;
        v3 = arg2.getString(string.gspace_default_right);
        Intrinsics.checkNotNullExpressionValue(v3, "getString(...)");
        this.rightLabel = v3;
        Drawable v3_1 = arg2.getDrawable(drawable.gspace_default_left);
        String v0 = "Required value was null.";
        if(v3_1 != null) {
            this.leftArtwork = v3_1;
            Drawable v2 = arg2.getDrawable(drawable.gspace_default_right);
            if(v2 != null) {
                this.rightArtwork = v2;
                this.games = CollectionsKt.emptyList();
                return;
            }

            throw new IllegalArgumentException(v0.toString());
        }

        throw new IllegalArgumentException(v0.toString());
    }

    public GoldenGameAdapter(Context arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        GoldenGameAdapter$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new GoldenGameAdapter$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function0)v2));
    }

    static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public final GameInfo gameAt(Integer arg1) {
        if(arg1 != null) {
            return CollectionsKt.getOrNull(this.games, ((Number)arg1).intValue() - 2);
        }

        return null;
    }

    public int getItemCount() {
        return this.games.size() + 3;
    }

    public final Function0 getOnAddGame() {
        return this.onAddGame;
    }

    public final String keyAt(Integer arg4) {
        String v0 = null;
        if(arg4 == null) {
            return v0;
        }

        if(arg4.intValue() == 0) {
            return "@add";
        }

        if(arg4.intValue() == 1) {
            return "@right";
        }

        if(arg4.intValue() == this.getItemCount() - 1) {
            return "@left";
        }

        GameInfo v3 = this.gameAt(arg4);
        if(v3 != null) {
            return v3.getPackageName();
        }

        return v0;
    }

    public void onBindViewHolder(ViewHolder arg1, int arg2) {
        this.onBindViewHolder(((Holder)arg1), arg2);
    }

    public void onBindViewHolder(Holder arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg8, "holder");
        if(arg9 == 0) {
            GoldenGameCardView.bind$default(arg8.getCard(), this.addLabel, null, false, 4, null);
            return;
        }

        if(arg9 == 1) {
            arg8.getCard().bind(this.rightLabel, this.rightArtwork, true);
            return;
        }

        if(arg9 == this.getItemCount() - 1) {
            arg8.getCard().bind(this.leftLabel, this.leftArtwork, true);
            return;
        }

        Object v7 = this.games.get(arg9 - 2);
        GoldenGameCardView.bind$default(arg8.getCard(), ((GameInfo)v7).getName(), ((GameInfo)v7).getIcon(), false, 4, null);
    }

    public ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
        return this.onCreateViewHolder(arg1, arg2);
    }

    public Holder onCreateViewHolder(ViewGroup arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        Context v2 = arg2.getContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getContext(...)");
        return new Holder(new GoldenGameCardView(v2));
    }

    public final int positionOf(String arg5) {
        if(arg5 != null) {
            int v1 = arg5.hashCode();
            if(v1 == 2003041) {
                if(!arg5.equals("@add")) {
                    goto label_26;
                }

                return 0;
            }
            else if(v1 != 0x3B88047) {
                if(v1 != 1940777436) {
                }
                else if(!arg5.equals("@right")) {
                }
                else {
                    return 1;
                }
            }
            else if(!arg5.equals("@left")) {
            }
            else {
                return this.getItemCount() - 1;
            }

        label_26:
            Iterator v4 = this.games.iterator();
            v1 = 0;
            while(true) {
                if(!v4.hasNext()) {
                    break;
                }
                else if(Intrinsics.areEqual(v4.next().getPackageName(), arg5)) {
                }
                else {
                    ++v1;
                    continue;
                }

                goto label_39;
            }

            v1 = -1;
        label_39:
            if(v1 < 0) {
                return 0;
            }

            return v1 + 2;
        }

        return 0;
    }

    public final void submitGames(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.games = CollectionsKt.toList(((Iterable)arg2));
        this.notifyDataSetChanged();
    }
}

