package ex01;

import java.util.UUID;

public class UserIdsGenerator {
    private int lastID = 0;
    private static UserIdsGenerator instance;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return lastID++;
    }
}
