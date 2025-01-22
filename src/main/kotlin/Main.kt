import org.jsoup.Jsoup

fun main() {
    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    try {
        val document = Jsoup.connect(url).get()

        val quotes = document.select("div.sc-2aegk7-2.bzpNIu")

        if (quotes.isNotEmpty()) {
            println("Цитаты из произведения \"Автостопом по галактике\":\n")

            for ((index, quote) in quotes.withIndex()) {
                println("${index + 1}. ${quote.text()}\n")
            }
        } else {
            println("Цитаты не найдены. Проверьте селектор.")
        }
    } catch (e: Exception) {
        println("Ошибка при подключении к странице: ${e.message}")
    }
}