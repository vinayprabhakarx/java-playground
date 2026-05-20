package com.vinayprabhakarx.exceptions.upi;

import java.util.HashMap;
import java.util.Map;

public class UpiUserDatabase {

    private final Map<String, UpiUser> usersByUpi = new HashMap<>();
    private final Map<String, UpiUser> usersByUsername = new HashMap<>();

    public UpiUserDatabase() {
        addUser(new UpiUser("Vinay", "vinay@upi", 1234, 1000));
        addUser(new UpiUser("Kunal", "kunal@upi", 4321, 500));
        addUser(new UpiUser("Rahul", "rahul@upi", 5678, 750));
    }

    public UpiUser findByUpi(String upiId) {
        if (upiId == null) {
            return null;
        }

        return usersByUpi.get(upiId.trim().toLowerCase());
    }

    public UpiUser findByUsername(String username) {
        if (username == null) {
            return null;
        }

        return usersByUsername.get(username.trim().toLowerCase());
    }

    private void addUser(UpiUser user) {
        usersByUpi.put(user.getUpiId().toLowerCase(), user);
        usersByUsername.put(user.getUsername().toLowerCase(), user);
    }
}
