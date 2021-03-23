import books._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import java.time.LocalDate

object books {

  case class Book(title: String, pages: Pages, published: Year)

  opaque type Pages = Int

  object Pages {
    def of(value: Int): Pages = value
  }

  opaque type Year = Int

  object Year {
    def of(value: Int): Year = value
  }

}

class OpaqueTypesDemo extends AnyWordSpec with Matchers {
  "Opaque Types" should {
    "work" in {
      val book = Book("Pippi Longstocking", Pages.of(350), Year.of(2010))
      book.pages should be(350)
    }
  }
}

//region legacy

object legacy {
  def shouldBeRenovated(year: Int): Boolean = year < 1950
}

//endregion







