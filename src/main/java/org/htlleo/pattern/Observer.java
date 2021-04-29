package org.htlleo.pattern;

public interface Observer {
    void notify(Observable sender, Object args);
}
