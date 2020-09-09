package com.severell.core.drivers;

import java.util.HashMap;

public abstract class BaseMailDriver implements Mail {

    protected String[] to;
    protected String[] cc;
    protected String[] bcc;
    protected String from;
    protected String subject;
    protected String text;

    @Override
    public Mail to(String... to) {
        this.to = to;
        return this;
    }

    @Override
    public Mail cc(String... cc) {
        this.cc = cc;
        return this;
    }

    @Override
    public Mail bcc(String... bcc) {
        this.bcc = bcc;
        return this;
    }

    @Override
    public Mail from(String from) {
        this.from = from;
        return this;
    }

    @Override
    public Mail template(String template, HashMap<String, String> data) {
        return null;
    }

    @Override
    public Mail text(String message) {
        this.text = message;
        return this;
    }

    @Override
    public Mail subject(String subject) {
        this.subject = subject;
        return this;
    }

    public abstract void send();
}