package com.palo_it.featureflags.models;

public class FeatureFlag {
    private String key;
    private int percentagePermitted;

    public FeatureFlag(String key) {
        this(key, 100);
    }
    public FeatureFlag(String key, int percentagePermitted) {
        this.key = key;
        this.percentagePermitted = percentagePermitted;
    }
}
