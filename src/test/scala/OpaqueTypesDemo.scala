import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import java.time.LocalDate

class OpaqueTypesDemo extends AnyWordSpec with Matchers {

  case class Book(title: String, pages: Int, published: Int)

  "Opaque Types" should {
    "work" in {
      val book = Book("Pippi Longstocking", 2010, 350)
      book.pages should be(350)
    }
  }
}

//region legacy

object legacy {
  def shouldBeRenovated(year: Int): Boolean = year < 1950
}

//endregion







