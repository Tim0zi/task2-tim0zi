import java.io.File
import java.util.*

fun grep(
    file: File,
    regexString: String,
    invert: Boolean,
    ignoreCase: Boolean
): List<String> {
    val out: MutableList<String> = ArrayList()
    val regex = if (ignoreCase) Regex(regexString, RegexOption.IGNORE_CASE) else Regex(regexString)
    file.forEachLine { line -> if ( line.contains(regex) xor invert ) out.add(line) }
    return out
}