package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

public interface AccessibilityViewCommand {
    public abstract class CommandArguments {
        Bundle mBundle;

        public CommandArguments() {
            super();
        }

        public void setBundle(Bundle arg1) {
            this.mBundle = arg1;
        }
    }

    public final class MoveAtGranularityArguments extends CommandArguments {
        public MoveAtGranularityArguments() {
            super();
        }

        public boolean getExtendSelection() {
            return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        }

        public int getGranularity() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        }
    }

    public final class MoveHtmlArguments extends CommandArguments {
        public MoveHtmlArguments() {
            super();
        }

        public String getHTMLElement() {
            return this.mBundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
        }
    }

    public final class MoveWindowArguments extends CommandArguments {
        public MoveWindowArguments() {
            super();
        }

        public int getX() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
        }

        public int getY() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
        }
    }

    public final class ScrollToPositionArguments extends CommandArguments {
        public ScrollToPositionArguments() {
            super();
        }

        public int getColumn() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
        }

        public int getRow() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
        }
    }

    public final class SetProgressArguments extends CommandArguments {
        public SetProgressArguments() {
            super();
        }

        public float getProgress() {
            return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
        }
    }

    public final class SetSelectionArguments extends CommandArguments {
        public SetSelectionArguments() {
            super();
        }

        public int getEnd() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
        }

        public int getStart() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
        }
    }

    public final class SetTextArguments extends CommandArguments {
        public SetTextArguments() {
            super();
        }

        public CharSequence getText() {
            return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        }
    }

    boolean perform(View arg1, CommandArguments arg2);
}

