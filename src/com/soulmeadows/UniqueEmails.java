package com.soulmeadows;

import java.util.HashSet;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        var set = new HashSet<String>();
        for(var email: emails){
            String[] parts = email.split("@");
            String[] locals = parts[0].split("\\+");
            String local = locals[0].replaceAll(".", "");
            set.add(local + "@" + parts[1]);
        }
        return set.size();
    }

    public static void main(String[] args){
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        new UniqueEmails().numUniqueEmails(emails);
    }

}
