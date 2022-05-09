package com.palo_it.featureflags.service;

import com.palo_it.featureflags.models.FeatureFlag;

import java.util.List;

public interface FeatureFlagService {
    public void permitUser(String userId, FeatureFlag feature);

    boolean isUserPermitted(String userId, FeatureFlag feature);

    List<String> getPermittedUsers(FeatureFlag feature);
}
