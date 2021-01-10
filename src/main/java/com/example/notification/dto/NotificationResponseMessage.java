package com.example.notification.dto;

import java.util.Objects;

public class NotificationResponseMessage  {

    public NotificationResponseMessage(){

    }

    public NotificationResponseMessage(Builder builder){
        setId(builder.id);
        setMessage(builder.message);
    }

    private String message;
    private Long id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Builder newNotificationResponseBuilder() {
        return new Builder();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationResponseMessage)) return false;
        NotificationResponseMessage that = (NotificationResponseMessage) o;
        return message.equals(that.message) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, id);
    }

    @Override
    public String toString() {
        return "NotificationResponseMessage{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }

    public static class Builder <T extends Builder> {

        private String message;
        private Long id;

        public Builder() {

        }

        public T withMessage(String message){
            this.message=message;
            return (T) this;
        }

        public T withId(Long id){
            this.id=id;
            return (T) this;
        }

        public NotificationResponseMessage build() {
            return new NotificationResponseMessage(this);
        }


    }


    }
