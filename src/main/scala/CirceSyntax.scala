import cats.Id
import cats.data.EitherT
import io.circe.parser.decode
import io.circe.{Decoder, Json}

import cats.Id
import cats.data.EitherT
import cats.effect.Async
import io.circe.{ Decoder, Encoder, HCursor, Json }
import io.circe.parser.decode
import org.http4s.circe.{ jsonEncoderOf, jsonOf }
import org.http4s.{ EntityDecoder, EntityEncoder }
trait CirceSyntax {
  implicit def circeSyntaxDecoderOps(s: String): DecoderOps = new DecoderOps(s)

  implicit def circeSyntaxJsonDecoderOps(json: Json): JsonDecoderOps = new JsonDecoderOps(json)

  implicit def deriveEntityEncoder[F[_]: Async, A: Encoder]: EntityEncoder[F, A] =
    jsonEncoderOf[F, A]

  implicit def deriveEntityDecoder[F[_]: Async, A: Decoder]: EntityDecoder[F, A] = jsonOf[F, A]

  implicit def mapEncoder[K: Encoder, V: Encoder]: Encoder[Map[K, V]] =
    (map: Map[K, V]) => Encoder[List[(K, V)]].apply(map.toList)

  implicit def mapDecoder[K: Decoder, V: Decoder]: Decoder[Map[K, V]] =
    (c: HCursor) => c.as[List[(K, V)]].map(_.toMap)
}
final class DecoderOps(private val s: String) {
  def as[A: Decoder]: A = decode[A](s).fold(throw _, json => json)
}

final class JsonDecoderOps(json: Json) {
  def decodeAs[A](implicit decoder: Decoder[A]): A =
    decoder.decodeJson(json).fold(throw _, json => json)
  def decodeAsEither[A, B](implicit decoderA: Decoder[A], decoderB: Decoder[B]): Either[B, A] =
    EitherT
      .fromEither[Id](decoderA.decodeJson(json))
      .leftMap { err =>
        println(s"error: $err")
        decodeAs[B]
      }
      .value
}
