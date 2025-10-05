package com.turkcell.library_cqrs.domain.member.model;

import java.util.Objects;

public class Member {

    private final MemberId id;
    private String name;
    private String surname;
    private String password;

    public Member(MemberId id, String name,String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname=surname;
        this.password = password;
    }

    public static Member create(String name,String surname,String password){
        validateNameSurname(name,surname);
        Objects.requireNonNull(password);

        return new Member(MemberId.generate(),name,surname,password);
    }

    public static void validateNameSurname(String name,String surname){
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");

        if (surname==null||surname.isEmpty())
            throw new IllegalArgumentException("Surname cannot be null or empty");

        if(name.length()>=255)
            throw new IllegalArgumentException("Name length must be less than 255 characters");

        if(surname.length()>=255)
            throw new IllegalArgumentException("Surname length must be less than 255 characters");
    }

    public MemberId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}


