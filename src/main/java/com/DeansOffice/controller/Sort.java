package com.DeansOffice.controller;

import com.DeansOffice.model.Group;

import java.util.Comparator;

public class Sort implements Comparator<Group> {
    public int compare(Group group1, Group group2) {
        return Integer.compare(Math.toIntExact(group1.getGroupId()), Math.toIntExact(group2.getGroupId()));
    }
}
