import com.mongodb.casbah.Imports._
import play.api._
import libs.ws.WS
import models._
import se.radley.plugin.salat._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    if (User.count(DBObject(), Nil, Nil) == 0) {
      Logger.info("Loading Testdata")
      User.save(User(
        username = "lucian",
        password = "12345",
        address = Some(Address("Suceava", "123", "Romania"))
      ))

      User.save(User(
        username = "eliza",
        password = "1234",
        address = Some(Address("Botosani", "75000", "Romania"))
      ))
    }
  }

}