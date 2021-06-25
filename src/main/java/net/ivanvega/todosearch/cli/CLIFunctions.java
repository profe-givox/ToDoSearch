package net.ivanvega.todosearch.cli;

import java.util.HashMap;
import java.util.Map;

public interface CLIFunctions {

    static Map<String, Object> toMap (CLIArguments cliArguments){
        Map<String, Object> args = new HashMap<>();
        args.put("tarea", cliArguments.getCriterio());
        args.put("realizada", cliArguments.isRealizada());

        return args;
    }

}
