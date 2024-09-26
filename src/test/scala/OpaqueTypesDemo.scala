import books.*
import io.github.iltotore.iron.*
import io.github.iltotore.iron.constraint.all.Positive
import io.github.iltotore.iron.constraint.numeric.{Greater, Less}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.time.LocalDate

object books {

  case class Book(title: String, pages: Pages, published: Year)

  opaque type Pages = Int :| Positive

  object Pages extends RefinedTypeOps[Int, Positive, Pages]

  opaque type Year <: Int = Int :| (Greater[1450] & Less[2021])

  object Year extends RefinedTypeOps[Int, (Greater[1450] & Less[2021]), Year]

  extension (year: Year)
    def toAge(now: LocalDate): Int = now.getYear - year
}


class OpaqueTypesDemo extends AnyWordSpec with Matchers {
  "Opaque Types" should {
    "work" in {
      val book = Book("Pippi Longstocking", Pages(350), Year(2010))
      book.pages should be(350)

      book.published.toAge(LocalDate.now) shouldBe 14
      legacy.shouldBeRenovated(book.published) shouldBe false

      val invalid = for {
        pages <- Pages.option(2010)
        year <- Year.option(350)
      } yield Book("Calvin and Hobbes", pages, year)
      invalid `shouldBe` None

      val valid = for {
        pages <- Pages.option(350)
        year <- Year.option(2010)
      } yield Book("Calvin and Hobbes", pages, year)
      valid `shouldBe` defined
    }
  }
}

//region legacy

object legacy {
  def shouldBeRenovated(year: Int): Boolean = year < 1950
}

//endregion







