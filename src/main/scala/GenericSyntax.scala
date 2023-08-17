import io.circe.syntax.EncoderOps
import io.circe.{ Encoder, Printer }

trait GenericSyntax {
  implicit def genericSyntaxGenericTypeOps[A](obj: A): GenericTypeOps[A] =
    new GenericTypeOps[A](obj)
}

final class GenericTypeOps[A](private val obj: A) {
  private val printer: Printer = Printer.noSpaces.copy(dropNullValues = true)

  def toJson(implicit encoder: Encoder[A]): String = obj.asJson.printWith(printer)
}
