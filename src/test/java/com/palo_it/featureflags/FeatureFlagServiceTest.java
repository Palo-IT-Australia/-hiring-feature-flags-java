package com.palo_it.featureflags;

import com.palo_it.featureflags.models.FeatureFlag;
import com.palo_it.featureflags.service.FeatureFlagService;
import com.palo_it.featureflags.service.FeatureFlagServiceImpl;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeatureFlagServiceTest {

    @Test
    public void ShouldPermitUserForFeature() {
        String userId = "1";
        FeatureFlagService featureFlagService = new FeatureFlagServiceImpl();
        FeatureFlag newFlag = new FeatureFlag("TestFlag1");

        featureFlagService.permitUser(userId, newFlag);
        boolean isUserPermitted = featureFlagService.isUserPermitted(userId, newFlag);
        assertTrue(isUserPermitted);
    }

    @Test
    public void ShouldGetAllPermittedUsers() {
        String userId1 = "1";
        String userId2 = "2";

        FeatureFlagService featureFlagService = new FeatureFlagServiceImpl();
        FeatureFlag newFlag = new FeatureFlag("TestFlag1");

        featureFlagService.permitUser(userId1, newFlag);
        featureFlagService.permitUser(userId2, newFlag);

        List<String> permittedUsers = featureFlagService.getPermittedUsers(newFlag);
        assertEquals(2, permittedUsers.size());
    }

    @Test
    public void ShouldPermitUsersForZeroPercent() {
        String userId1 = "1";
        String userId2 = "2";
        String userId3 = "3";

        FeatureFlagService featureFlagService = new FeatureFlagServiceImpl();
        FeatureFlag newFlag = new FeatureFlag("TestFlag1", 0);

        featureFlagService.permitUser(userId1, newFlag);
        featureFlagService.permitUser(userId2, newFlag);
        featureFlagService.permitUser(userId3, newFlag);

        List<String> permittedUsers = featureFlagService.getPermittedUsers(newFlag);
        assertTrue(permittedUsers.isEmpty());
    }

    @Test
    public void ShouldPermitHalfOfUsers() {
        String userId1 = "1";
        String userId2 = "2";
        String userId3 = "3";
        String userId4 = "4";

        FeatureFlagService featureFlagService = new FeatureFlagServiceImpl();
        FeatureFlag newFlag = new FeatureFlag("TestFlag1", 50);

        featureFlagService.permitUser(userId1, newFlag);
        featureFlagService.permitUser(userId2, newFlag);
        featureFlagService.permitUser(userId3, newFlag);
        featureFlagService.permitUser(userId4, newFlag);

        List<String> permittedUsers = featureFlagService.getPermittedUsers(newFlag);
        assertEquals(2, permittedUsers.size());
    }
}
