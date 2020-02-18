package com.tosh.RabbitMq;

public class PracticalTipMessage {
    private final String text;
    private final int priority;
    private final boolean secret;

    public PracticalTipMessage(String text, int priority, boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "PracticalTipMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
}
