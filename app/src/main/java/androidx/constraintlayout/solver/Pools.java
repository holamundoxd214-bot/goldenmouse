package androidx.constraintlayout.solver;

final class Pools {
    interface Pool {
        Object acquire();

        boolean release(Object arg1);

        void releaseAll(Object[] arg1, int arg2);
    }

    class SimplePool implements Pool {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int arg1) {
            super();
            if(arg1 > 0) {
                this.mPool = new Object[arg1];
                return;
            }

            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public Object acquire() {
            int v0 = this.mPoolSize;
            Object v1 = null;
            if(v0 > 0) {
                int v2 = v0 - 1;
                Object[] v3 = this.mPool;
                Object v4 = v3[v2];
                v3[v2] = v1;
                this.mPoolSize = v0 - 1;
                return v4;
            }

            return v1;
        }

        private boolean isInPool(Object arg4) {
            int v1;
            for(v1 = 0; v1 < this.mPoolSize; ++v1) {
                if(this.mPool[v1] == arg4) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean release(Object arg4) {
            int v0 = this.mPoolSize;
            Object[] v1 = this.mPool;
            if(v0 < v1.length) {
                v1[v0] = arg4;
                this.mPoolSize = v0 + 1;
                return 1;
            }

            return 0;
        }

        public void releaseAll(Object[] arg6, int arg7) {
            if(arg7 > arg6.length) {
                arg7 = arg6.length;
            }

            int v0;
            for(v0 = 0; v0 < arg7; ++v0) {
                Object v1 = arg6[v0];
                int v2 = this.mPoolSize;
                Object[] v3 = this.mPool;
                if(v2 < v3.length) {
                    v3[v2] = v1;
                    this.mPoolSize = v2 + 1;
                }
            }
        }
    }

    private static final boolean DEBUG = false;

    private Pools() {
        super();
    }
}

