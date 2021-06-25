package net.ivanvega.todosearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLICriterioValidator
        implements IParameterValidator
{
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^[a-zA-Z]+[0-9]*$")) {
            System.err.println("El cfriterio de busqueda: " + value + " no es una cadena valida, El criterio debe ser una cadena alfanumericas.\n");
            throw new ParameterException("Solo se soporta texto alfanumerico");
        }
    }
}
