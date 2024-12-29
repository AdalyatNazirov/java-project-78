package hexlet.code.schemas;


public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", number -> number > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", number -> (number >= min && number <= max));
        return this;
    }

    @Override
    protected boolean isBlank(Integer value) {
        return value == null;
    }
}
