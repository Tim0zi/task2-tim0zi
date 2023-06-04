import picocli.CommandLine.*
import picocli.CommandLine
import java.io.File

@Command(
    name = "grep",
    mixinStandardHelpOptions = true,
)
class Grep : Runnable {
    @Parameters(paramLabel = "regex", description = ["Word/regex to search for"])
    lateinit var regexString: String

    @Parameters(paramLabel = "file", description = ["File in which to search"])
    lateinit var file: File

    @Option(names = ["-r"], description = ["Does nothing (as required)"])
    var useRegex: Boolean = false

    @Option(names = ["-v"], description = ["Invert the sense of matching, to select non-matching lines."])
    var invert: Boolean = false

    @Option(names = ["-i"], description = ["Ignore case distinctions, so that characters that differ only in case match each other."])
    var ignoreCase: Boolean = false

    override fun run() {
        grep(file, regexString, invert, ignoreCase).forEach { println(it) }
    }
}


fun main(args: Array<String>) {
    CommandLine(Grep()).execute(*args)
}