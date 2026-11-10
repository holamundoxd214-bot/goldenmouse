package androidx.compose.ui.graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000B\u001A\u00020\fJ\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001E\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u0011J6\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u00152\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u0015J:\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u00152\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00112\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u0015J6\u0010\u0017\u001A\u00020\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0018\u0010\u0018\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0004\u0012\u00020\f0\u0019H\u0080\b¢\u0006\u0002\b\u001AJ:\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00112\u0018\u0010\u0018\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0004\u0012\u00020\f0\u0019H\u0080\b¢\u0006\u0002\b\u001AJ\u0011\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0011H\u0086\u0002J\u0017\u0010\u001B\u001A\u00020\u001C2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\u0002J\u0015\u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u001FH\u0086\u0002J\u0017\u0010 \u001A\u00020\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0086\u0002J%\u0010!\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\b\u0010\"\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010#J\u001A\u0010$\u001A\u00020\f2\u0010\u0010%\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001A\u0010&\u001A\u00020\f2\u0010\u0010\'\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001A\u0010(\u001A\u00020\f2\u0010\u0010\'\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001A\u0010)\u001A\u00020\f2\u0010\u0010\'\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001A\u0010\u0005\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R4\u0010\b\u001A&\u0012\u000E\u0012\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00000\tj\u0012\u0012\u000E\u0012\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000`\n8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2={"Landroidx/compose/ui/graphics/IntervalTree;", "T", "", "<init>", "()V", "terminator", "Landroidx/compose/ui/graphics/IntervalTree$Node;", "root", "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clear", "", "findFirstOverlap", "Landroidx/compose/ui/graphics/Interval;", "interval", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "end", "findOverlaps", "", "results", "forEach", "block", "Lkotlin/Function1;", "forEach$ui_graphics", "contains", "", "value", "iterator", "", "plusAssign", "addInterval", "data", "(FFLjava/lang/Object;)V", "rebalance", "target", "rotateLeft", "node", "rotateRight", "updateNodeData", "Node", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IntervalTree {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00018\u0000\u0012\n\u0010\u0006\u001A\u00060\u0007j\u0002`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010#\u001A\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0010\u0010$\u001A\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018R\u001E\u0010\u0006\u001A\u00060\u0007j\u0002`\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001A\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR$\u0010 \u001A\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u001A\"\u0004\b\"\u0010\u001C¨\u0006%"}, d2={"Landroidx/compose/ui/graphics/IntervalTree$Node;", "Landroidx/compose/ui/graphics/Interval;", "start", "", "end", "data", "color", "", "Landroidx/compose/ui/graphics/TreeColor;", "<init>", "(Landroidx/compose/ui/graphics/IntervalTree;FFLjava/lang/Object;I)V", "getColor", "()I", "setColor", "(I)V", "min", "getMin", "()F", "setMin", "(F)V", "max", "getMax", "setMax", "left", "Landroidx/compose/ui/graphics/IntervalTree;", "getLeft", "()Landroidx/compose/ui/graphics/IntervalTree$Node;", "setLeft", "(Landroidx/compose/ui/graphics/IntervalTree$Node;)V", "right", "getRight", "setRight", "parent", "getParent", "setParent", "lowestNode", "next", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Node extends Interval {
        private int color;
        private Node left;
        private float max;
        private float min;
        private Node parent;
        private Node right;

        public Node(IntervalTree arg1, float arg2, float arg3, Object arg4, int arg5) {
            IntervalTree.this = arg1;
            super(arg2, arg3, arg4);
            this.color = arg5;
            this.min = arg2;
            this.max = arg3;
            this.left = arg1.terminator;
            this.right = arg1.terminator;
            this.parent = arg1.terminator;
        }

        public final int getColor() {
            return this.color;
        }

        public final Node getLeft() {
            return this.left;
        }

        public final float getMax() {
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public final Node getParent() {
            return this.parent;
        }

        public final Node getRight() {
            return this.right;
        }

        public final Node lowestNode() {
            Node v0;
            for(v0 = this; v0.left != IntervalTree.this.terminator; v0 = v0.left) {
            }

            return v0;
        }

        public final Node next() {
            if(this.right != IntervalTree.this.terminator) {
                return this.right.lowestNode();
            }

            Node v0 = this.parent;
            Node v1 = this;
            while(v0 != IntervalTree.this.terminator) {
                if(v1 != v0.right) {
                    return v0;
                }

                v1 = v0;
                v0 = v0.parent;
            }

            return v0;
        }

        public final void setColor(int arg1) {
            this.color = arg1;
        }

        public final void setLeft(Node arg1) {
            this.left = arg1;
        }

        public final void setMax(float arg1) {
            this.max = arg1;
        }

        public final void setMin(float arg1) {
            this.min = arg1;
        }

        public final void setParent(Node arg1) {
            this.parent = arg1;
        }

        public final void setRight(Node arg1) {
            this.right = arg1;
        }
    }

    public static final int $stable = 8;
    public Node root;
    public final ArrayList stack;
    public final Node terminator;

    static {
    }

    public IntervalTree() {
        super();
        Node v0 = new Node(this, 3.402823E+38f, 1.401298E-45f, null, 1);
        this.terminator = v0;
        this.root = v0;
        this.stack = new ArrayList();
    }

    public final void addInterval(float arg8, float arg9, Object arg10) {
        IntervalTree v1 = this;
        Node v0 = new Node(v1, arg8, arg9, arg10, 0);
        Node v7 = v1.root;
        Node v8 = v1.terminator;
        while(v7 != v1.terminator) {
            v8 = v0.getStart() <= v7.getStart() ? v7.getLeft() : v7.getRight();
            Node v6 = v8;
            v8 = v7;
            v7 = v6;
        }

        v0.setParent(v8);
        if(v8 == v1.terminator) {
            v1.root = v0;
        }
        else if(v0.getStart() <= v8.getStart()) {
            v8.setLeft(v0);
        }
        else {
            v8.setRight(v0);
        }

        v1.updateNodeData(v0);
        v1.rebalance(v0);
    }

    public final void clear() {
        this.root = this.terminator;
    }

    public final boolean contains(float arg1) {
        if(this.findFirstOverlap(arg1, arg1) != IntervalTreeKt.getEmptyInterval()) {
            return 1;
        }

        return 0;
    }

    public final boolean contains(ClosedFloatingPointRange arg2) {
        if(this.findFirstOverlap(arg2.getStart().floatValue(), arg2.getEndInclusive().floatValue()) != IntervalTreeKt.getEmptyInterval()) {
            return 1;
        }

        return 0;
    }

    public final Interval findFirstOverlap(float arg5, float arg6) {
        Node v0 = this.root;
        Node v1 = this.terminator;
        if(v0 != v1 && v0 != v1) {
            ArrayList v1_1 = this.stack;
            v1_1.add(v0);
            while(true) {
                if(v1_1.size() > 0) {
                    Object v0_1 = v1_1.remove(v1_1.size() - 1);
                    if(((Node)v0_1).overlaps(arg5, arg6)) {
                        return ((Interval)v0_1);
                    }
                    else {
                        if(((Node)v0_1).getLeft() != this.terminator && ((Node)v0_1).getLeft().getMax() >= arg5) {
                            v1_1.add(((Node)v0_1).getLeft());
                        }

                        if(((Node)v0_1).getRight() == this.terminator) {
                            continue;
                        }

                        if(((Node)v0_1).getRight().getMin() > arg6) {
                            continue;
                        }

                        v1_1.add(((Node)v0_1).getRight());
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_32;
            }

            v1_1.clear();
        }

    label_32:
        Interval v4 = IntervalTreeKt.getEmptyInterval();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.ui.graphics.Interval<T of androidx.compose.ui.graphics.IntervalTree>");
        return v4;
    }

    public final Interval findFirstOverlap(ClosedFloatingPointRange arg2) {
        return this.findFirstOverlap(arg2.getStart().floatValue(), arg2.getEndInclusive().floatValue());
    }

    public static Interval findFirstOverlap$default(IntervalTree arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg1;
        }

        return arg0.findFirstOverlap(arg1, arg2);
    }

    public final List findOverlaps(float arg5, float arg6, List arg7) {
        Node v0 = this.root;
        if(v0 != this.terminator) {
            ArrayList v1 = this.stack;
            v1.add(v0);
            while(v1.size() > 0) {
                Object v0_1 = v1.remove(v1.size() - 1);
                if(((Node)v0_1).overlaps(arg5, arg6)) {
                    arg7.add(v0_1);
                }

                if(((Node)v0_1).getLeft() != this.terminator && ((Node)v0_1).getLeft().getMax() >= arg5) {
                    v1.add(((Node)v0_1).getLeft());
                }

                if(((Node)v0_1).getRight() == this.terminator) {
                    continue;
                }

                if(((Node)v0_1).getRight().getMin() > arg6) {
                    continue;
                }

                v1.add(((Node)v0_1).getRight());
            }

            v1.clear();
        }

        return arg7;
    }

    public final List findOverlaps(ClosedFloatingPointRange arg2, List arg3) {
        return this.findOverlaps(arg2.getStart().floatValue(), arg2.getEndInclusive().floatValue(), arg3);
    }

    public static List findOverlaps$default(IntervalTree arg0, float arg1, float arg2, List arg3, int arg4, Object arg5) {
        ArrayList v3;
        if((arg4 & 2) != 0) {
            arg2 = arg1;
        }

        if((arg4 & 4) != 0) {
            v3 = new ArrayList();
        }

        return arg0.findOverlaps(arg1, arg2, ((List)v3));
    }

    public static List findOverlaps$default(IntervalTree arg0, ClosedFloatingPointRange arg1, List arg2, int arg3, Object arg4) {
        ArrayList v2;
        if((arg3 & 2) != 0) {
            v2 = new ArrayList();
        }

        return arg0.findOverlaps(arg1, ((List)v2));
    }

    public final void forEach$ui_graphics(float arg5, float arg6, Function1 arg7) {
        Node v0 = this.root;
        if(v0 != this.terminator) {
            ArrayList v1 = this.stack;
            v1.add(v0);
            while(v1.size() > 0) {
                Object v0_1 = v1.remove(v1.size() - 1);
                if(((Node)v0_1).overlaps(arg5, arg6)) {
                    arg7.invoke(v0_1);
                }

                if(((Node)v0_1).getLeft() != this.terminator && ((Node)v0_1).getLeft().getMax() >= arg5) {
                    v1.add(((Node)v0_1).getLeft());
                }

                if(((Node)v0_1).getRight() == this.terminator) {
                    continue;
                }

                if(((Node)v0_1).getRight().getMin() > arg6) {
                    continue;
                }

                v1.add(((Node)v0_1).getRight());
            }

            v1.clear();
        }
    }

    public final void forEach$ui_graphics(ClosedFloatingPointRange arg6, Function1 arg7) {
        float v0 = arg6.getStart().floatValue();
        float v6 = arg6.getEndInclusive().floatValue();
        Node v1 = this.root;
        if(v1 != this.terminator) {
            ArrayList v2 = this.stack;
            v2.add(v1);
            while(v2.size() > 0) {
                Object v1_1 = v2.remove(v2.size() - 1);
                if(((Node)v1_1).overlaps(v0, v6)) {
                    arg7.invoke(v1_1);
                }

                if(((Node)v1_1).getLeft() != this.terminator && ((Node)v1_1).getLeft().getMax() >= v0) {
                    v2.add(((Node)v1_1).getLeft());
                }

                if(((Node)v1_1).getRight() == this.terminator) {
                    continue;
                }

                if(((Node)v1_1).getRight().getMin() > v6) {
                    continue;
                }

                v2.add(((Node)v1_1).getRight());
            }

            v2.clear();
        }
    }

    public static void forEach$ui_graphics$default(IntervalTree arg2, float arg3, float arg4, Function1 arg5, int arg6, Object arg7) {
        if((arg6 & 2) != 0) {
            arg4 = arg3;
        }

        Node v6 = arg2.root;
        if(v6 != arg2.terminator) {
            ArrayList v7 = arg2.stack;
            v7.add(v6);
            while(v7.size() > 0) {
                Object v6_1 = v7.remove(v7.size() - 1);
                if(((Node)v6_1).overlaps(arg3, arg4)) {
                    arg5.invoke(v6_1);
                }

                if(((Node)v6_1).getLeft() != arg2.terminator && ((Node)v6_1).getLeft().getMax() >= arg3) {
                    v7.add(((Node)v6_1).getLeft());
                }

                if(((Node)v6_1).getRight() == arg2.terminator) {
                    continue;
                }

                if(((Node)v6_1).getRight().getMin() > arg4) {
                    continue;
                }

                v7.add(((Node)v6_1).getRight());
            }

            v7.clear();
        }
    }

    public final Iterator iterator() {
        return new IntervalTree$iterator$1(this);
    }

    public final void plusAssign(Interval arg3) {
        this.addInterval(arg3.getStart(), arg3.getEnd(), arg3.getData());
    }

    private final void rebalance(Node arg6) {
        Node v2;
        while(arg6 != this.root) {
            if(arg6.getParent().getColor() != 0) {
                break;
            }

            Node v0 = arg6.getParent().getParent();
            if(arg6.getParent() == v0.getLeft()) {
                v2 = v0.getRight();
                if(v2.getColor() == 0) {
                    v2.setColor(1);
                    arg6.getParent().setColor(1);
                    v0.setColor(0);
                }
                else {
                    if(arg6 == arg6.getParent().getRight()) {
                        arg6 = arg6.getParent();
                        this.rotateLeft(arg6);
                    }

                    arg6.getParent().setColor(1);
                    v0.setColor(0);
                    this.rotateRight(v0);
                    continue;
                }
            }
            else {
                v2 = v0.getLeft();
                if(v2.getColor() != 0) {
                    goto label_39;
                }

                v2.setColor(1);
                arg6.getParent().setColor(1);
                v0.setColor(0);
            }

            arg6 = v0;
            continue;
        label_39:
            if(arg6 == arg6.getParent().getLeft()) {
                arg6 = arg6.getParent();
                this.rotateRight(arg6);
            }

            arg6.getParent().setColor(1);
            v0.setColor(0);
            this.rotateLeft(v0);
        }

        this.root.setColor(1);
    }

    private final void rotateLeft(Node arg4) {
        Node v0 = arg4.getRight();
        arg4.setRight(v0.getLeft());
        if(v0.getLeft() != this.terminator) {
            v0.getLeft().setParent(arg4);
        }

        v0.setParent(arg4.getParent());
        if(arg4.getParent() == this.terminator) {
            this.root = v0;
        }
        else if(arg4.getParent().getLeft() == arg4) {
            arg4.getParent().setLeft(v0);
        }
        else {
            arg4.getParent().setRight(v0);
        }

        v0.setLeft(arg4);
        arg4.setParent(v0);
        this.updateNodeData(arg4);
    }

    private final void rotateRight(Node arg4) {
        Node v0 = arg4.getLeft();
        arg4.setLeft(v0.getRight());
        if(v0.getRight() != this.terminator) {
            v0.getRight().setParent(arg4);
        }

        v0.setParent(arg4.getParent());
        if(arg4.getParent() == this.terminator) {
            this.root = v0;
        }
        else if(arg4.getParent().getRight() == arg4) {
            arg4.getParent().setRight(v0);
        }
        else {
            arg4.getParent().setLeft(v0);
        }

        v0.setRight(arg4);
        arg4.setParent(v0);
        this.updateNodeData(arg4);
    }

    private final void updateNodeData(Node arg4) {
        while(arg4 != this.terminator) {
            arg4.setMin(Math.min(arg4.getStart(), Math.min(arg4.getLeft().getMin(), arg4.getRight().getMin())));
            arg4.setMax(Math.max(arg4.getEnd(), Math.max(arg4.getLeft().getMax(), arg4.getRight().getMax())));
            arg4 = arg4.getParent();
        }
    }
}

