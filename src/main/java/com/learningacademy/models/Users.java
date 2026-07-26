package com.learningacademy.models;
public final class Users {

    private Users() {
    }

    // Valid Users

    public static final User ADMIN =
            new User("manager", "moodle26", Role.ADMIN);

    public static final User STUDENT =
            new User("student", "moodle26", Role.STUDENT);

    public static final User LECTURER =
            new User("teacher", "moodle26", Role.LECTURER);

    public static final User PRIVACY_OFFICER =
            new User("privacyofficer", "moodle26", Role.PRIVACY_OFFICER);

    public static final User LEARNING_SUPPORT_TUTOR =
            new User("parent", "moodle26", Role.LEARNING_SUPPORT_TUTOR);


    // Invalid Users

    public static final User INVALID_PASSWORD =
            new User("manager", "123456", Role.UNKNOWN);

    public static final User INVALID_USERNAME =
            new User("invalidUser", "moodle26", Role.UNKNOWN);

    public static final User INVALID_CREDENTIALS =
            new User("invalidUser", "123456", Role.UNKNOWN);


    // Empty Credentials

    public static final User EMPTY_USERNAME =
            new User("", "moodle26", Role.UNKNOWN);

    public static final User EMPTY_PASSWORD =
            new User("manager", "", Role.UNKNOWN);

    public static final User EMPTY_CREDENTIALS =
            new User("", "", Role.UNKNOWN);

}