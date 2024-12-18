import java.text.SimpleDateFormat
import java.util.Date

class Marit {

    fun isAbusing(s: String?) {
        if (s.isNullOrEmpty()) return
        val lines = s
            .split("\n")
            .dropLast(1)

        val sf = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val ips = lines
            .groupBy {
                val split = it.split(",")
                split[2] to (sf.format(Date(split[0].toLong())))
            }
            .filter { it.value.size == 2 }
            .map { it.key.first }

        lines
            .map { it.split(",")[2] }
            .forEach {
                println(if (ips.contains(it)) {
                    "1"
                } else {
                    "0"
                })
            }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Marit().isAbusing(
                "1728278981,/offers/63685,211.10.10.91\n" +
                "1728278981,/offers/63685,211.10.10.92\n" +
                "1728278981,/offers/63685,211.10.10.90\n" +
                "1728278981,/offers/63685,211.10.10.90\n" +
                "END"
            )
        }
    }
}