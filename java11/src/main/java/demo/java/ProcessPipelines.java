package demo.java;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Arrays.asList;

public class ProcessPipelines {
    public static void main(String[] args) throws IOException {
        ProcessBuilder ls = new ProcessBuilder().command("tree", "-i").directory(Paths.get("/Users/diam/workspace/DemoJava").toFile());
//        ls.start();
        ProcessBuilder grepPdf = new ProcessBuilder().command("grep", "properties").redirectOutput(ProcessBuilder.Redirect.INHERIT);
        List<Process> lsThenGrep = ProcessBuilder.startPipeline(asList(ls, grepPdf));
        System.out.println("Started processes...");
        var lsThenGrepFutures = lsThenGrep.stream()
                // onExit returns a CompletableFuture<Process>
                .map(Process::onExit)
                .map(processFuture -> processFuture.thenAccept(
                        process -> System.out.println("Process " + process.pid() + " finished.")))
                .toArray(CompletableFuture[]::new);
        // wait until all processes are finished
        CompletableFuture.allOf(lsThenGrepFutures).join();

        System.out.println("Processes done");

        Runtime.Version version = Runtime.version();
        System.out.println(version.major() + "." + version.minor() + "." + version.security());
        System.out.println(version.feature() + "." + version.interim() + "." + version.update());
    }
}
