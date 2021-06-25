package net.ivanvega.todosearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface CommanderFunctions {

    static JCommander buildCommander(Object object){
       return JCommander.newBuilder()
               .addObject(object)
               .build();
    }

    static <T> JCommander buildCommanderWithName
            (String nombre, Supplier<T> argsSupplier){
        JCommander jCommander =
                buildCommander(argsSupplier.get());
        jCommander.setProgramName(nombre);
        return jCommander;
    }

    static Optional<List<Object>> parseArguments
            (JCommander jCommander, String [] args,
             OnCommandError onCommandError
            ){
        List<Object> result;
        try {
            jCommander.parse(args);

            return Optional.of(jCommander.getObjects());
        } catch (ParameterException exception) {
            onCommandError.onError(jCommander);
        }

        return Optional.empty();


    }

    @FunctionalInterface
    interface OnCommandError {
        void onError(JCommander jCommander);
    }

}
