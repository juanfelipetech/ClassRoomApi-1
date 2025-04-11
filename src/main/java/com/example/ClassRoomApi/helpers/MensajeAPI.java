package com.example.ClassRoomApi.helpers;

public enum MensajeAPI {

    TEACHER_NOT_FOUND("El docente que buscas no se encuentra en BD");

    private String text;

    MensajeAPI(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
