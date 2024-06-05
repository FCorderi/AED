package com.ut6_pd7;

public class Alumno extends Object {
    private int ID;
    private String fullName;
    private String email;
    

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Alumno other = (Alumno) obj;
        if (ID != other.ID) {
            return false;
        }
        return true;
    }
}
