package validator;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DataValidator {
    public boolean isValidate(String commandStr, Enum[] commandsData) {
        for (Enum command : commandsData) {
            if (command.name().equals(commandStr)) {
                return true;
            }
        }
        return false;
    }
}
