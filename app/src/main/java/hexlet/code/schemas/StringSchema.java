package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public class StringSchema implements Schema<String> {

    private boolean requiredField;
    private int minLengthField;
    private String containsField;

    public StringSchema required() {
        this.requiredField = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLengthField = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.containsField = contains;
        return this;
    }

    @Override
    public boolean isValid(String s) {
        if (requiredField && StringUtils.isBlank(s)) {
            return false;
        }

        if (minLengthField > 0 && (StringUtils.isBlank(s) || s.length() < minLengthField)) {
            return false;
        }

        if (StringUtils.isNotBlank(containsField) && StringUtils.containsNone(s, containsField)) {
            return false;
        }

        return true;
    }
}