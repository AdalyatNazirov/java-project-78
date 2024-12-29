package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck(
                "required",
                (value) -> !isBlank(value));
        return this;
    }

    public StringSchema minLength(final int minLength) {
        addCheck(
                "minLength",
                (value) -> isBlank(value) || StringUtils.length(value) >= minLength);
        return this;
    }

    public StringSchema contains(final String searchSeq) {
        addCheck(
                "contains",
                (value) -> isBlank(value) || StringUtils.contains(value, searchSeq));
        return this;
    }

    @Override
    public boolean isBlank(String value) {
        return StringUtils.isBlank(value);
    }
}
