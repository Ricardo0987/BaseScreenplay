package co.com.project.scp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateEquals implements Question<Boolean> {

    private String backString;
    private String dtoString;

    public ValidateEquals(String backString, String dtoString){
        this.backString = backString;
        this.dtoString = dtoString;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return backString.equals(dtoString);
    }

    public static ValidateEquals compare(String backString, String dtoString){
        return new ValidateEquals(backString,dtoString);
    }
}
