package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public class StringSchema implements Schema<String> {

    private boolean required;
    private int minLength;
    private String contains;

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    @Override
    public boolean isValid(String s) {
        if (required && StringUtils.isBlank(s)) {
            return false;
        }

        if (minLength > 0 && (StringUtils.isBlank(s) || s.length() < minLength)) {
            return false;
        }

        if (StringUtils.isNotBlank(contains) && StringUtils.containsNone(s, contains)) {
            return false;
        }

        return true;
    }
}