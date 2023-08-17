
import BillzProductResponse.BillzProduct
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class BillzProductResponse(
                                 id: String,
                                 jsonrpc: String,
                                 result: List[BillzProduct],
                               )

object BillzProductResponse {
  case class BillzProduct(
                           ID: Int,
                           name: String,
                           sku: String,
                           barCode: Option[String] = None,
                           price: Int,
                           discountAmount: Int,
                           qty: Int,
                           properties: Properties,
                           offices: Option[List[Office]] = None,
//                           imageUrls: List[Url],
                         )

  implicit val nestedDecosdsdderddd: Decoder[BillzProduct] = deriveDecoder[BillzProduct]
  implicit val nestedDecosdsdsdderddd: Encoder[BillzProduct] = deriveEncoder[BillzProduct]


  case class Properties(
                         BRAND: Option[String] = None,
                         CATEGORY: String,
                         CLASS_CODE: Option[String] = None,
                         COLLECTION: Option[String] = None,
                         COLOR: Option[String] = None,
                         DESCRIPTION: Option[String] = None,
                         GENDER: Option[String] = None,
                         SEASON: Option[String] = None,
                         SIZE: Option[String] = None,
                         SUB_CATEGORY: String,
                         АВТОР: Option[String] = None,
                         UZS_МАРКЕТ: Option[String] = None,
                         ВЕС_С_УПАКОВКОЙ: Option[String] = None,
                         ВОЗРАСТНОЕ_ОГРАНИЧЕНИЕ: Option[String] = None,
                         ГОД_ВЫПУСКА: Option[String] = None,
                         ИЗДАТЕЛЬСТВО: Option[String] = None,
                         КОЛИЧЕСТВО_ЛИСТОВ: Option[String] = None,
                         СТРАНА_ПРОИЗВОДИТЕЛЬ: Option[String] = None,
                         ТИП_БУМАГИ: Option[String] = None,
                         ТИП_КНИГИ: Option[String] = None,
                         ВИД_ЗАСТЕЖКИ: Option[String] = None,
                         ВИД_КАБЛУКА: Option[String] = None,
                         ВИД_НОСОЧНОЙ_ЧАСТИ: Option[String] = None,
                         ДЕКОР: Option[String] = None,
                         МАТЕРИАЛ: Option[String] = None,
                         МАТЕРИАЛ_ПОДКЛАДКИ: Option[String] = None,
                         МАТЕРИАЛ_ПОДОШВЫ: Option[String] = None,
                         МАТЕРИАЛ_СТЕЛЬКИ: Option[String] = None,
                         ВЫСОТА_КАБЛУКА: Option[String] = None,
                         ВЫСОТА_ГОЛЕНИЩА: Option[String] = None,
                         ОБХВАТ_ГОЛЕНИЩА: Option[String] = None,
                         ТОЛЩИНА_ПОДОШВЫ: Option[String] = None,
                         ЦВЕТ_ВЕРХА_ДОПОЛНИТЕЛЬНЫЙ: Option[String] = None,
                         ВЕС: Option[String] = None,
                         СОСТАВ: Option[String] = None,
                         СТРАНА_ПРОИЗВОДИТЕЛЯ: Option[String] = None,
                       )

  implicit val nestedDecosdsdder: Decoder[Properties] = deriveDecoder[Properties]
  implicit val nestedDecosdfdsdder: Encoder[Properties] = deriveEncoder[Properties]

  case class Office(
                     officeID: Int,
                     officeName: String,
                     price: Int,
                     priceUSD: Double,
                     discountAmount: Int,
                     qty: Int,
                   )

  implicit val nestedDeacoder: Decoder[Office] = deriveDecoder[Office]
  implicit val nestedDeadfcoder: Encoder[Office] = deriveEncoder[Office]


  case class Url(url: String)

  implicit val nestedDeacodeasr: Decoder[Url] = deriveDecoder[Url]
  implicit val nestedDeacodfdeasr: Encoder[Url] = deriveEncoder[Url]

}
