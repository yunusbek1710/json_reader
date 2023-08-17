

import cats.data.EitherT
import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import io.circe._
import io.circe.generic.semiauto._
import io.circe.parser.decode

import scala.io.Source

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    implicit val nestedDecoder: Decoder[BillzProductResponse] = deriveDecoder[BillzProductResponse]
    val json = Source.fromFile("/home/scala/IdeaProjects/json_reader/src/main/resources/lufian_new2.json")

    EitherT.fromEither[IO](decode[BillzProductResponse](json.mkString)).semiflatMap { product =>
//            val res = product.result.filter(_.properties.BRAND.getOrElse("") == "LUFIAN").groupBy(d => (d.properties.SUB_CATEGORY, d.properties.CATEGORY)).toList
//            res.traverse { case (((s, b), p)) => IO.println(s + "/" + b).as(ExitCode.Success)}.as(ExitCode.Success)
            val res = product.result.filter(p =>
              p.properties.CATEGORY == "Мужская Сlassic" &&
                p.properties.SUB_CATEGORY == "GOMLEK"
            )
//      val res = product.result.filter(p =>
//        p.name == "Escabel Двойка футболка брюки кружево Д"
//      ).toJson
//      res.traverse(p => IO.println(p.name)).as(ExitCode.Success)
      IO.println(res).as(ExitCode.Success)
    }.getOrElseF(IO.unit.as(ExitCode.Success))
  }


}
