package net.ivanvega.todosearch.cli;


//https://ivanvegatodo.azurewebsites.net/
// api/todoitems/Search?tarea=proy&hecho=true


import com.beust.jcommander.Parameter;

public final class CLIArguments {

    public String getCriterio() {
        return criterio;
    }

    public boolean isRealizada() {
        return realizada;
    }

    @Parameter(required = true,
    descriptionKey = "Critererio",
    validateWith = CLICriterioValidator.class,
    description = "Criterio de busqueda")
    private String criterio;

    @Parameter(
            names = {"--realizada", "-r"},
            description = "Agregar esta bandera si solo se quiere tareas realizadas"
    )
    private boolean realizada;

    @Parameter(
            names = {"--help","-h"},
            help = true,
            validateWith = CLIAyudaValidator.class,
            description = "Muestra esta ayuda")
    private boolean help;

    public boolean isHelp() {
        return help;
    }

    private CLIArguments() {
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "criterio='" + criterio + '\'' +
                ", realizada=" + realizada +
                '}';
    }
}
