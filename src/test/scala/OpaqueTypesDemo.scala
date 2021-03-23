import books._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import java.time.LocalDate

object books {

  case class Book(title: String, pages: Pages, published: Year)

  opaque type Pages = Int

  object Pages {
    def apply(value: Int): Pages = value

    def safe(value: Int): Option[Pages] = if (value > 0) Some(value) else None
  }

  opaque type Year = Int

  object Year {
    def apply(value: Int): Year = value

    def safe(value: Int): Option[Year] = if (value > 1450 && value < 2021) Some(value) else None
  }

  extension (year: Year)
    def toAge(now: LocalDate): Int = now.getYear - year

}

class OpaqueTypesDemo extends AnyWordSpec with Matchers {
  "Opaque Types" should {
    "work" in {
      val book = Book("Pippi Longstocking", Pages(350), Year(2010))
      book.pages should be(350)

      book.published.toAge(LocalDate.now) shouldBe 11

      val invalid = for {
        pages <- Pages.safe(2010)
        year <- Year.safe(350)
      } yield Book("Calvin and Hobbes", pages, year)
      invalid shouldBe None

      val valid = for {
        pages <- Pages.safe(350)
        year <- Year.safe(2010)
      } yield Book("Calvin and Hobbes", pages, year)
      valid shouldBe defined
    }
  }
}

//region legacy

object legacy {
  def shouldBeRenovated(year: Int): Boolean = year < 1950
}

//endregion







