package org.htlleo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Message implements Serializable {
    private Date date;
    private String from;
    private String body;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                ", date='" + date + '\'' +
                ", from='" + from + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
