import sbt._

object Dependencies {
  object Versions {
    lazy val cats = "2.8.0"
    lazy val `cats-effect` = "3.3.14"
    lazy val circe = "0.14.1"
    lazy val fs2 = "3.3.0"
    lazy val http4s = "0.23.11"
    lazy val log4cats = "2.5.0"
    lazy val skunk = "0.2.3"
    lazy val logback = "1.4.4"
    lazy val ciris = "2.3.2"
    lazy val refined = "0.10.1"
    lazy val tsec = "0.4.0"
    lazy val redis4cats = "1.1.1"
    lazy val monocle = "3.1.0"
    lazy val `cats-retry` = "3.1.0"
    lazy val newtype = "0.4.4"
    lazy val derevo = "0.13.0"
    lazy val sttp = "3.7.2"
    lazy val `cats-tagless` = "0.14.0"
    lazy val `mu-rpc` = "0.29.0"
    lazy val `http4s-jwt-auth` = "1.0.0"
    lazy val `meow-mtl` = "0.5.0"
    lazy val mailer = "1.4.7"
    lazy val izumi = "2.2.1"
    lazy val enumeratum = "1.7.0"
    lazy val flyway = "9.6.0"
    lazy val `organize-imports` = "0.6.0"
    lazy val `fs2-kafka` = "2.5.0"
    lazy val `mongo-db` = "4.7.1"
    lazy val `apache-common-codec` = "1.15"

    lazy val weaver = "0.8.0"
    lazy val `test-container` = "1.17.4"
    lazy val postgresql = "42.5.0"
  }

  trait LibGroup {
    def all: Seq[ModuleID]
  }

  object Libraries {
    object Circe extends LibGroup {
      private def circe(artifact: String): ModuleID =
        "io.circe" %% s"circe-$artifact" % Versions.circe

      lazy val core: ModuleID = circe("core")
      lazy val generic: ModuleID = circe("generic")
      lazy val parser: ModuleID = circe("parser")
      lazy val refined: ModuleID = circe("refined")
      override def all: Seq[ModuleID] = Seq(core, generic, parser, refined)
    }

    object Derevo extends LibGroup {
      private def derevo(artifact: String): ModuleID =
        "tf.tofu" %% s"derevo-$artifact" % Versions.derevo

      lazy val core: ModuleID = derevo("core")
      lazy val cats: ModuleID = derevo("cats")
      lazy val circe: ModuleID = derevo("circe-magnolia")

      override def all: Seq[ModuleID] = Seq(core, cats, circe)
    }

    object Http4s extends LibGroup {
      private def http4s(artifact: String): ModuleID =
        "org.http4s" %% s"http4s-$artifact" % Versions.http4s

      lazy val dsl: ModuleID = http4s("dsl")
      lazy val server: ModuleID = http4s("ember-server")
      lazy val client: ModuleID = http4s("ember-client")
      lazy val circe: ModuleID = http4s("circe")
      lazy val `blaze-server`: ModuleID = http4s("blaze-server")

      override def all: Seq[ModuleID] = Seq(dsl, server, client, circe)
    }

    object Cats extends LibGroup {
      lazy val retry = "com.github.cb372" %% "cats-retry" % Versions.`cats-retry`
      lazy val core = "org.typelevel" %% "cats-core" % Versions.cats
      lazy val effect = "org.typelevel" %% "cats-effect" % Versions.`cats-effect`

      def all: Seq[ModuleID] = Seq(core, retry, effect)
    }


  }
}
