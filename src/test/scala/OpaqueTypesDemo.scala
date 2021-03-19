import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import java.time.LocalDate

class OpaqueTypesDemo extends AnyWordSpec with Matchers {

  "Opaque Types" should {
    "work" in {

    }
  }
}

//region legacy

object legacy {
  def shouldBeRenovated(year: Int): Boolean = year < 1950
}

//endregion







