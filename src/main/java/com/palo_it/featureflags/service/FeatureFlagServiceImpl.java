package com.palo_it.featureflags.service;

import com.palo_it.featureflags.models.FeatureFlag;

import java.util.List;

public class FeatureFlagServiceImpl implements FeatureFlagService {
    //TODO: Change type any
    private Object featureFlags;

    @Override
    public void permitUser(String userId, FeatureFlag feature) {
        // TODO 1: permit user [userId] for the feature [feature]
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isUserPermitted(String userId, FeatureFlag feature) {
        //TODO 2: Return if user [userId] is permitted to access the feature [feature]
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getPermittedUsers(FeatureFlag feature) {
        // TODO 3: Get all permitted users [string[]] for the feature [feature]
        throw new UnsupportedOperationException();
    }
}
