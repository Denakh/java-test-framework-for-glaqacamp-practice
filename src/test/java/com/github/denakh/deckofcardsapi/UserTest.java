package com.github.denakh.deckofcardsapi;

import com.github.denakh.deckofcardsapi.models.users.Task;
import com.github.denakh.deckofcardsapi.models.users.User;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

public class UserTest {
    private static final String TEST_USER_NAME = TestUtilities.generateUniqueName("", 9);
    private static final UserRequester USER_REQUESTER = new UserRequester();
    private static final Task TEST_USER_TASK =
            new Task(TEST_USER_NAME + "task", TestUtilities.generateInteger(1000, 9999));
    private static final User TEST_USER =
            new User(TEST_USER_NAME, TEST_USER_NAME + "@somemailservice.com", Arrays.asList(TEST_USER_TASK));
    private static final File AVATAR_FILE = new File("src/test/java/resources/kote.jpg");

    @Test
    public void addingAndDeletingForNewUserIsSuccessful() {
        //given: created user
        User createdUser = USER_REQUESTER.createUserWithTasks(TEST_USER);

        //when: add avatar for the created user
        USER_REQUESTER.addAvatar(AVATAR_FILE, createdUser.getEmail());

        //and: delete the avatar
        Map<String, String> responseMap = USER_REQUESTER.deleteAvatar(createdUser.getEmail());

        //then: status of the last operation with avatar (delete) is "ok"
        Assert.assertEquals("Status of the last operation (delete) isn't 'ok'",
                "ok", responseMap.get("status"));
    }
}
