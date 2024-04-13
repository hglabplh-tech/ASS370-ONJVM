package hgp.utils;

import java.util.LinkedHashMap;

public class SizedLinkedMAP<A, B> extends LinkedHashMap<A, B> {

    private long elementCount = 0;

    private final long initSize;

    private final long maxSize;
    public SizedLinkedMAP(int initSize, int maxSize) {
        this.maxSize = maxSize;
        this.initSize = initSize;
    }
    @Override
    public B put(A key, B value) {
        B result = null;
        if (elementCount <= maxSize) {
            result = super.put(key, value);
            elementCount++;
        }

        return result;
    }

    @Override
    public B remove(Object key) {
        this.elementCount--;
        return super.remove(key);
    }
}
