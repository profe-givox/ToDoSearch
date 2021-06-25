package net.ivanvega.todosearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import net.ivanvega.todosearch.api.ToDoAPI;
import net.ivanvega.todosearch.cli.CLIArguments;
import net.ivanvega.todosearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static net.ivanvega.todosearch.CommanderFunctions.parseArguments;
import static net.ivanvega.todosearch.api.APIFuctiones.buildAPI;

public class ToDoSearch {

    public static void main(String[] args) {
        JCommander jCommander =
                CommanderFunctions
                        .buildCommanderWithName
                                ("todo",
                                CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
        parseArguments(jCommander,
                        args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream().map(item -> (CLIArguments)item);

          Optional<CLIArguments> cliArgumentsOptional =
                  streamOfCLI.filter(arg -> !arg.isHelp())
                .filter(arg -> arg.getCriterio()!=null)
                .findFirst();


        cliArgumentsOptional.map(CLIFunctions::toMap)

                .map(ToDoSearch::executeRequest)
                .orElse(Stream.empty())

                .forEach(System.out::println);


    }

    private static Stream<ToDo> executeRequest(Map<String, Object> options) {
        ToDoAPI api = buildAPI(ToDoAPI.class,
                "https://ivanvegatodo.azurewebsites.net");

        return Stream.of(options)
                .map(api::tareasBusqueda)
                .flatMap(Collection::stream);
    }

}
